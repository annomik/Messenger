package by.it_academy.jd2.Mk_JD2_95_22.controllers.web.ui;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.MessageDTO;
import by.it_academy.jd2.Mk_JD2_95_22.dao.fabrics.MessageDaoSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.servise.MessageService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IMessageService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics.UserServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChatsServletUi", urlPatterns = "/ui/user/chats")
public class ChatsServletUi extends HttpServlet {
    private static final String MY_LOGIN = "user";

    private final IMessageService messageService;

    public ChatsServletUi() {
        this.messageService = new MessageService(MessageDaoSingleton.getInstance(), UserServiceSingleton.getInstance());
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

       HttpSession session = req.getSession();
        String forUser = (String) session.getAttribute(MY_LOGIN);
        List <MessageDTO> myMessages = messageService.getMessageForUser(forUser);

        req.setAttribute("forUser", forUser);
        req.setAttribute("myMessages", myMessages);
        req.getRequestDispatcher("/views/chats.jsp").forward(req,resp);
    }
}

package by.it_academy.jd2.Mk_JD2_95_22.controllers.web.ui;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "ChatsServletUi", urlPatterns = "/ui/user/chats")
public class ChatsServletUi extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/chats.jsp");
        requestDispatcher.forward (req,resp);
    }
}


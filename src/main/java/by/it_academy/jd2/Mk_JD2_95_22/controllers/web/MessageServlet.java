package by.it_academy.jd2.Mk_JD2_95_22.controllers.web;

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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private static final String MY_LOGIN = "login";
    private static final String FOR_USER = "forUser";
    private static final String PASSWORD = "password";

    private HttpSession session;

    private final IMessageService messageService;

    public MessageServlet() {
        this.messageService = new MessageService(MessageDaoSingleton.getInstance(), UserServiceSingleton.getInstance());
    }

    public static String getParam(HttpServletRequest req, String param){
        String result = req.getParameter(param);
        if(result == null){
            HttpSession session = req.getSession();
            if(!session.isNew()){
                result = (String) session.getAttribute(param);
            }
        }
        if(result == null){
            throw new IllegalArgumentException("Один из параметров не передан в сессии!");
        }
        return result;
    }

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        session = req.getSession();
        String login = (String) session.getAttribute(getParam(req, MY_LOGIN));

        List<MessageDTO> myMessanges = messageService.getMessageForUser(login);

        if(myMessanges.size() > 0){
            writer.write("<p>Для пользователя " + login + " имеются следующие сообщения:</p>");
            for (MessageDTO myMessange : myMessanges) {
                writer.write("<p>><span style='color: red;'>" +
                        "Сообщение от пользователя:" + myMessange.getFromUser()
                        + " дата сообщения: " + myMessange.getDate() +  "!</span></p>");
                writer.write("<p>" + myMessange.getMessage() + "</p>");
            }
        }else {
            writer.write("<p>Для пользователя " + login + " нету сообщений!</p>");
        }
    }

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        session = req.getSession();

        String login = (String) session.getAttribute(getParam(req, MY_LOGIN));
        String forUser = req.getParameter(FOR_USER);
        String messange = req.getParameter("messange");

        if(forUser == null || messange == null){
            throw new IllegalArgumentException("Одно из обязательных полей сообщения не передано от пользователя!");
        }

        MessageDTO newMessage = new MessageDTO(login, forUser, messange);

        if(messageService.send(newMessage)){
            writer.write("<p>Вы отправили сообщение для пользователя " + newMessage.getForUser() + "!</p>");
            writer.write("<p>Дата отправления сообщения:  " + newMessage.getDate() + "</p>");
            writer.write("<p>Содержание сообщения:  " + newMessage.getMessage() + "</p>");
        }else {
            throw new IllegalArgumentException("Ошибка в отправке сообщения!");
        }
    }
}

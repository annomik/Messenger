package by.it_academy.jd2.Mk_JD2_95_22.controller.web;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.ResultDTO;
import by.it_academy.jd2.Mk_JD2_95_22.dao.MessageDao;
import by.it_academy.jd2.Mk_JD2_95_22.servise.MessageService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.StatisticAuthorizationService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.StatisticService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.UserService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IStaticticAuthorizationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "StatisticServlet", urlPatterns = "api/admin/statistics")
public class StatisticServlet extends HttpServlet {
    IStaticticAuthorizationService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String login = httpSession.getAttribute("login").toString();
        if(login==null||login.isBlank()){
            throw new IllegalArgumentException("Логин не введен!!!");
        }
        if(!login.equals("admin")){
            throw new IllegalArgumentException("Вы вошли не под администратором!!!");
        }

        ResultDTO resultDTO = service.login(login,0);
        if(resultDTO==null){
            throw new NullPointerException("Сообщении и пользователей не существует");
        }

        Writer writer = resp.getWriter();
        writer.write("<p>Колличество сообщений: "+resultDTO.getCountUser()+"</p>");
        writer.write("<p>Колличество зарегестрированных пользователей: "+resultDTO.getCountUser()+"</p>");
        writer.write("<p>Колличество активных пользователей: "+resultDTO.getCountActiveUser()+"</p>");
    }
}
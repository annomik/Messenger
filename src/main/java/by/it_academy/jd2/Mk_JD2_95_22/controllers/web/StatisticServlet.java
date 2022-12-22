package by.it_academy.jd2.Mk_JD2_95_22.controllers.web;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.ResultDTO;
import by.it_academy.jd2.Mk_JD2_95_22.servise.StatisticService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IStatisticService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics.ListenerServiceSingletone;
import by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics.MessageServiceSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics.StatisticSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics.UserServiceSingleton;

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
    IStatisticService service;

    public StatisticServlet(StatisticService service) {
        this.service = new StatisticService(
                UserServiceSingleton.getInstance(),
                MessageServiceSingleton.getInstance(),
                ListenerServiceSingletone.getInstance()
        );
    }

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

        ResultDTO resultDTO = service.getResult(login);
        if(resultDTO==null){
            throw new NullPointerException("Сообщении и пользователей не существует");
        }

        Writer writer = resp.getWriter();
        writer.write("<p>Колличество сообщений: "+resultDTO.getCountUser()+"</p>");
        writer.write("<p>Колличество зарегестрированных пользователей: "+resultDTO.getCountUser()+"</p>");
        writer.write("<p>Колличество активных пользователей: "+resultDTO.getCountActiveUser()+"</p>");
    }
}
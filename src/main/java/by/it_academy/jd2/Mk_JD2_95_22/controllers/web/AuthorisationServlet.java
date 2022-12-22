package by.it_academy.jd2.Mk_JD2_95_22.controllers.web;

import by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IUserService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics.UserServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles.ADMIN;

@WebServlet(name = "AuthorisationServlet", urlPatterns = "/api/login")
public class AuthorisationServlet extends HttpServlet {

    private final String LOGIN_PARAM_NAME = "login";
    private final String PASSWORD_PARAM_NAME = "password";

    private final IUserService userService;

    public AuthorisationServlet(IUserService userService) {
        this.userService = UserServiceSingleton.getInstance();
    }

    public String getValue(HttpServletRequest req, String key){
        String val = req.getParameter(key);

        if (val == null){
            HttpSession session = req.getSession();
            if (!session.isNew()){
                val = (String) session.getAttribute(key);
            }
        }
        if (val == null){
            throw new IllegalArgumentException("Не переданы параметры");
        }
        return val;
    }

    private void saveSession(HttpServletRequest req, String key, Object val){
        HttpSession session = req.getSession();
        session.setAttribute(key, val);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

    PrintWriter writer = resp.getWriter();

    String login = getValue(req, LOGIN_PARAM_NAME);
    String password = getValue(req, PASSWORD_PARAM_NAME);
    Roles roleUser = userService.authorization(login,password);
    if (login == null || password == null ){
        throw new IllegalArgumentException("Введите логин, пароль!");
        } else  if(roleUser.name().equals(Roles.NOT_LOGIN)) {
                    throw new IllegalArgumentException("Не верный логин или пароль!");
                    }else if(login.equals("admin")){
                                saveSession(req, "login", login);
                                saveSession(req, "role", roleUser);
                           } else {
                                saveSession(req, "login",  login);
                                saveSession(req, "user", "user");
                                }
    writer.write("<p> Привет, " + login + " !</p>");
    }

}



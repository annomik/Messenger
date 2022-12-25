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

@WebServlet(name = "AuthorisationServlet", urlPatterns = "/api/login")
public class AuthorisationServlet extends HttpServlet {

    private final String LOGIN_PARAM_NAME = "login";
    private final String PASSWORD_PARAM_NAME = "password";

    private final IUserService userService;

    public AuthorisationServlet() {
        this.userService = UserServiceSingleton.getInstance();
    }

    public static String getValue(HttpServletRequest req, String key){
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

    PrintWriter writer = resp.getWriter();
    HttpSession session = req.getSession();

    String login = getValue(req, LOGIN_PARAM_NAME);
    String loginLowerCase = login.toLowerCase().trim();
    String password = getValue(req, PASSWORD_PARAM_NAME);
    Roles roleUser = userService.authorization(loginLowerCase,password);

    if (loginLowerCase == null || password == null ){
        throw new IllegalArgumentException("Введите логин, пароль!");
        } else  if(roleUser.name().equals(Roles.NOT_LOGIN)) {
                    throw new IllegalArgumentException("Неверный логин или пароль!");
                    }else {
                           session.setAttribute("user", loginLowerCase);
                           session.setAttribute("role", roleUser);
                           }
    writer.write("<p> Привет, " + loginLowerCase + " !</p>");
    }
}



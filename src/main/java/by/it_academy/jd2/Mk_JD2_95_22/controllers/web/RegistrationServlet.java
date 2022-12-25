package by.it_academy.jd2.Mk_JD2_95_22.controllers.web;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.UserDTO;
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

@WebServlet(name = "RegistrationServlet", urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {

    private final String LOGIN_PARAM_NAME = "login";
    private final String PASSWORD_PARAM_NAME = "password";
    private final String FULLNAME_PARAM = "fullName";
    private final String BIRTHDAY_PARAM = "birthday";

    private final IUserService userService;

    public RegistrationServlet() {
        this.userService =  UserServiceSingleton.getInstance();
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

        String login = getValue(req, LOGIN_PARAM_NAME);
        String trimLogin = login.trim();
        String password = getValue(req, PASSWORD_PARAM_NAME);
        String fullName = getValue(req, FULLNAME_PARAM);
        String birthday = getValue(req, BIRTHDAY_PARAM);
        Roles roleUser;
        HttpSession session = req.getSession();

        if (trimLogin == null || password == null || fullName == null || birthday == null) {
            throw new IllegalArgumentException("Все поля должны быть заполнены!");
            }
        if(login.equals("admin")){
            roleUser = Roles.ADMIN;
        } else {
            roleUser = Roles.USER;
            }
            UserDTO userDTO = new UserDTO(trimLogin, password, fullName, birthday, roleUser);
            userService.saveNewUser(userDTO);
            session.setAttribute( "user", trimLogin);
            session.setAttribute( "role", roleUser);
            writer.write("<p>"+ trimLogin+ ", Вы успешно зарегистрированы !</p>");
    }
}

package by.it_academy.jd2.Mk_JD2_95_22.controllers;

import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/api/login")
public class AuthorisationServlet extends HttpServlet {

    private final String LOGIN_PARAM_NAME = "login";
    private final String PASSWORD__PARAM_NAME = "password";

    private final IUserService userService;

    public AuthorisationServlet(IUserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

    PrintWriter writer = resp.getWriter();

    Map<String, String[]> parameterMap = req.getParameterMap();

    }
}



package by.it_academy.jd2.Mk_JD2_95_22.controllers.web.ui;

import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IUserService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics.UserServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServletUi", urlPatterns = "/ui/reg")
public class RegistrationServletUi extends HttpServlet {

    private final IUserService userService;

    public RegistrationServletUi() {
        this.userService = UserServiceSingleton.getInstance();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/registration.jsp").forward(req,resp);
    }
}


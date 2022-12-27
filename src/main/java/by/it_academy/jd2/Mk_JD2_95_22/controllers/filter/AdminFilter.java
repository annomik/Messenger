package by.it_academy.jd2.Mk_JD2_95_22.controllers.filter;

import by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        boolean isOK = false;
        if((session!=null)&&(session.getAttribute("user")!=null)){
            Roles role = (Roles) session.getAttribute("role");
            if(role == Roles.ADMIN){
                filterChain.doFilter(servletRequest,servletResponse);
                isOK = true;
            }
            String admin = (String) session.getAttribute("user");

            if(admin.equals("admin")){
                filterChain.doFilter(servletRequest,servletResponse);
                isOK = true;
            }
        }
        if(!isOK){
            throw new IllegalArgumentException("Don't admin");
        }
    }

    @Override
    public void destroy() {

    }
}

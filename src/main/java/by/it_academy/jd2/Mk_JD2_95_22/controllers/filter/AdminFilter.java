package by.it_academy.jd2.Mk_JD2_95_22.controllers.filter;

import by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        String contextPath = req.getContextPath();
//        HttpSession session = req.getSession();
//        if((session!=null)&&(session.getAttribute("user")!=null)&&(session.getAttribute("role").equals(Roles.ADMIN))){
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
    }

    @Override
    public void destroy() {

    }
}

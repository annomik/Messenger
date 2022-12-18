package by.it_academy.jd2.Mk_JD2_95_22.controllers.listeners;

import by.it_academy.jd2.Mk_JD2_95_22.servise.ListenerService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IListener;
import by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics.ListenerServiceSingletone;

import javax.servlet.http.*;
//HttpSessionBindingListener
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {

    private final IListener service;
    public SessionListener() {
        service = ListenerServiceSingletone.getInstance();
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession httpSession = httpSessionBindingEvent.getSession();
        String nameSession = httpSession.getId();
        String nameParam = httpSessionBindingEvent.getName();
        if(nameParam.equals("user")) {
            String nameUser = httpSessionBindingEvent.getValue().toString();
            if (nameUser != null && !nameUser.isBlank()) {
                service.setAccountSession(nameSession, nameUser);
            }
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession httpSession = httpSessionEvent.getSession();
        String sessionName = httpSession.getId();
        service.removeSession(sessionName);
    }
}

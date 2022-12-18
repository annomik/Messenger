package by.it_academy.jd2.Mk_JD2_95_22.servise;

import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IListener;

import java.util.HashMap;
import java.util.Map;

public class ListenerService implements IListener {
    private Map<String,String> sessions;

    public ListenerService(Map<String, String> sessions) {
        this.sessions = sessions;
    }
    
    public ListenerService(){
        sessions = new HashMap<>();
    }

    @Override
    public int getCountSession() {
        return sessions.size();
    }

    @Override
    public void setAccountSession(String nameSession, String accountSession) {
        sessions.put(nameSession,accountSession);
    }

    @Override
    public void removeSession(String nameSession) {
        sessions.remove(nameSession);
    }


}

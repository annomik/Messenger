package by.it_academy.jd2.Mk_JD2_95_22.servise.api;

public interface IListener {
    int getCountSession();
    void setAccountSession(String nameSession, String accountSession);
    void removeSession(String nameSession);
}

package by.it_academy.jd2.Mk_JD2_95_22.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.models.User;

public interface IDaoUser {
    User getUser(String user);
    boolean exist(String user);
    boolean login(String user, String password);
}

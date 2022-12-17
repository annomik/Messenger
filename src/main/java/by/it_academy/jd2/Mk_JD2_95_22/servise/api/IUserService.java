package by.it_academy.jd2.Mk_JD2_95_22.servise.api;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.UserDTO;

public interface IUserService {
    boolean exist(String login);
    void saveNewUser(UserDTO newUser);
    boolean authorization(String login, String password);
    int countUsers();
}

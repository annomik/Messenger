package by.it_academy.jd2.Mk_JD2_95_22.servise.api;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles;

public interface IUserService {
    boolean exist(String login);
    boolean saveNewUser(UserDTO newUser);
    Roles authorization(String login, String password);
    int countUsers();
}
//
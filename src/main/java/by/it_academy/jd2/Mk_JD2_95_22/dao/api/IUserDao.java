package by.it_academy.jd2.Mk_JD2_95_22.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles;
//
public interface IUserDao {
    boolean exist(String login);
    Roles login(String user, String password);
    UserDTO getUser(String login);
    UserDTO saveNewUser(UserDTO userDTO);

    int countUser();
}

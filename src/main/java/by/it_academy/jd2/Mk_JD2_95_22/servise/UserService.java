package by.it_academy.jd2.Mk_JD2_95_22.servise;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IUserService;
//ходит в
public class UserService implements IUserService {

    @Override
    public boolean exist(String login) {
        return false;
    }

    @Override
    public boolean saveNewUser(UserDTO newUser) {
        return false;
    }

    @Override
    public Roles authorization(String login, String password) {
        return null;
    }

    @Override
    public int countUsers() {
        return 0;
    }
}

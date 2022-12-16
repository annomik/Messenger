package by.it_academy.jd2.Mk_JD2_95_22.dao;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles;
import by.it_academy.jd2.Mk_JD2_95_22.dao.api.IUserDao;
//
public class UserDao implements IUserDao {
    @Override
    public boolean exist(String user) {
        return false;
    }

    @Override
    public Roles login(String user, String password) {
        return null;
    }

    @Override
    public boolean newUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public int countUser() {
        return 0;
    }
    //хранение в мар, клич, тоже, что и логин
}

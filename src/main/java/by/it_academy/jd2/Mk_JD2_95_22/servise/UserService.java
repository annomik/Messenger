package by.it_academy.jd2.Mk_JD2_95_22.servise;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles;
import by.it_academy.jd2.Mk_JD2_95_22.dao.api.IUserDao;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IUserService;

public class UserService implements IUserService {

    private IUserDao dao;

    public UserService(IUserDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean exist(String login) {
        if (!dao.exist(login)){
            throw new IllegalArgumentException("Пользователя c логином " + login + " не существует!");
        }
        return this.dao.exist(login);
    }

    @Override
    public boolean saveNewUser(UserDTO newUser) {

        return   false;
    }

    @Override
    public Roles authorization(String login, String password) {
        return null;
    }

    @Override
    public int countUsers() {
        return this.dao.countUser();
    }
}

package by.it_academy.jd2.Mk_JD2_95_22.servise;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_95_22.dao.api.IUserDao;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IUserService;

public class UserService implements IUserService {

    private final IUserDao dao;

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
    public void saveNewUser(UserDTO newUser) {
        String login = newUser.getLogin();
        if (dao.exist(login)){
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        }
        this.dao.saveNewUser(newUser);
    }

  // проверка правильности введения логина и пароля
    @Override
    public boolean authorization(String login, String password) {
        return dao.authorization(login, password);
    }

    @Override
    public int countUsers() {
        return this.dao.countUser();
    }
}

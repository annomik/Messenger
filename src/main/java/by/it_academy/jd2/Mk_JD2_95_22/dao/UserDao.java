package by.it_academy.jd2.Mk_JD2_95_22.dao;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles;
import by.it_academy.jd2.Mk_JD2_95_22.dao.api.IUserDao;
import java.util.HashMap;
import java.util.Map;
import static by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles.ADMIN;


public class UserDao implements IUserDao {

    private Map<String, UserDTO> mapUsers = new HashMap<>();

    // блок инициализации для админа
    {
        UserDTO administrator = new UserDTO("admin", "admin",
                "2000-01-02", ADMIN);
        this.mapUsers.put("admin", administrator);
    }

    @Override
    public boolean exist(String login) {
        return this.mapUsers.containsKey(login);
    }

  // ???
    @Override
    public Roles login(String login, String password) {
        return null;
    }

// сохраняем нового пользователя в мапу
    @Override
    public UserDTO saveNewUser(UserDTO userDTO) {
        return this.mapUsers.put(userDTO.getLogin(), userDTO);
    }

   //возвращает значение объекта по ключу login
    @Override
    public UserDTO getUser(String login){
        return this.mapUsers.get(login);
    }

    @Override
    public int countUser() {
        return mapUsers.size();
    }

}

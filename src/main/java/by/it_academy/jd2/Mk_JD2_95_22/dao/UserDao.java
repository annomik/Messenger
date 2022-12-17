package by.it_academy.jd2.Mk_JD2_95_22.dao;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.UserDTO;
import by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles;
import by.it_academy.jd2.Mk_JD2_95_22.dao.api.IUserDao;
import java.util.HashMap;
import java.util.Map;

import static by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles.ADMIN;

public class UserDao implements IUserDao {

    UserDTO administrator = new UserDTO("admin", "admin",
            "2000-01-02", ADMIN);

    Map<String, UserDTO> mapUsers = new HashMap<String, UserDTO>();
    // mapUsers.put("admin", administrator);

    @Override
    public boolean exist(String login) {

        return this.mapUsers.containsKey(login);
    }

    @Override
    public Roles login(String user, String password) {
        return null;
    }

    @Override
    public boolean saveNewUser(UserDTO userDTO) {

//        for (Map.Entry<String, UserDTO> user : mapUsers.entrySet()) {
//            if (user.getKey() == userDTO.getLogin()){
//                return false;
//            }
//              //  mapUsers.put(userDTO.getLogin(), userDTO);
//        }
        return true;
    }

    @Override
    public int countUser() {
        return mapUsers.size();
    }
    //хранение в мар, клич, тоже, что и логин
}

package by.it_academy.jd2.Mk_JD2_95_22.core.dto;

import by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles;

import java.util.Date;
//Надо подеметь над сохранением пароля
public class UserDTO {
    private String login;
    private String password;
    private String birthday;

    private final long timeRegistration = setTime();
    private Roles role;

    public UserDTO(String login, String password, String birthday, Roles role) {
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        setTime();
        this.role = role;
    }

    private long setTime(){
        Date date = new Date();
        return date.getTime();
    }

    public String getLogin() {
        return login;
    }

    public String getBirthday() {
        return birthday;
    }

    public long getTimeRegistration() {
        return timeRegistration;
    }

    public Roles getRole() {
        return role;
    }
}
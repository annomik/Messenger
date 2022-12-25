package by.it_academy.jd2.Mk_JD2_95_22.core.dto;

import by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static by.it_academy.jd2.Mk_JD2_95_22.core.enums.Roles.USER;

//Надо подеметь над сохранением пароля/
public class UserDTO {
    private String login;
    private String password;
    private String birthday;
    private String fullName ;
    private final long dateRegistration = setDate();
    private Roles role;

    public UserDTO(String login, String password,  String fullName, String birthday,Roles role) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.birthday = birthday;
        this.birthday = birthday;
        setDate();
        this.role = role;
    }

    private long setDate(){
        Date date = new Date();
        return date.getTime();
    }

    public String getDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(dateRegistration));
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getBirthday() {
        return birthday;
    }

    public long getDateRegistration() {
        return dateRegistration;
    }

    public Roles getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return dateRegistration == userDTO.dateRegistration && Objects.equals(login, userDTO.login) && Objects.equals(password, userDTO.password) && Objects.equals(birthday, userDTO.birthday) && Objects.equals(fullName, userDTO.fullName) && role == userDTO.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, birthday, fullName, dateRegistration, role);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateRegistration=" + dateRegistration +
                ", role=" + role +
                '}';
    }
}
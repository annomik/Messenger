package by.it_academy.jd2.Mk_JD2_95_22.models;

import java.util.Objects;

public class User {
    private final String login;
    private String password;
    private String firstLastName;
    private String birthday;
    private long timeReg;

    public User(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public long getTimeReg() {
        return timeReg;
    }

    public void setTimeReg(long timeReg) {
        this.timeReg = timeReg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return timeReg == user.timeReg && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(firstLastName, user.firstLastName) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, firstLastName, birthday, timeReg);
    }
}

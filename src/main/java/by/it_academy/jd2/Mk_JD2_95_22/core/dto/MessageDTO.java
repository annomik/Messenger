package by.it_academy.jd2.Mk_JD2_95_22.core.dto;

import java.util.Objects;

public class MessageDTO {
    private final String fromUser;
    private final String forUser;
    private final String message;
    private final String date;

    public MessageDTO(String fromUser, String forUser, String message, String date) {
        this.fromUser = fromUser;
        this.forUser = forUser;
        this.message = message;
        this.date = date;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getForUser() {
        return forUser;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageDTO that = (MessageDTO) o;
        return Objects.equals(fromUser, that.fromUser) && Objects.equals(forUser, that.forUser) && Objects.equals(message, that.message) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromUser, forUser, message, date);
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "fromUser='" + fromUser + '\'' +
                ", forUser='" + forUser + '\'' +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

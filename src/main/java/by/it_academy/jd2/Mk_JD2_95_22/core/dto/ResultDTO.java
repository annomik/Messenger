package by.it_academy.jd2.Mk_JD2_95_22.core.dto;

import java.util.Objects;

public class ResultDTO {
    private long countMessage;
    private long countUser;
    private long countActiveUser;

    public ResultDTO(long countMessage, long countUser, long countActiveUser) {
        this.countMessage = countMessage;
        this.countUser = countUser;
        this.countActiveUser = countActiveUser;
    }

    public long getCountMessage() {
        return countMessage;
    }

    public void setCountMessage(long countMessage) {
        this.countMessage = countMessage;
    }

    public long getCountUser() {
        return countUser;
    }

    public void setCountUser(long countUser) {
        this.countUser = countUser;
    }

    public long getCountActiveUser() {
        return countActiveUser;
    }

    public void setCountActiveUser(long countActiveUser) {
        this.countActiveUser = countActiveUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultDTO resultDTO = (ResultDTO) o;
        return Objects.equals(countMessage, resultDTO.countMessage) && Objects.equals(countUser, resultDTO.countUser) && Objects.equals(countActiveUser, resultDTO.countActiveUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countMessage, countUser, countActiveUser);
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "countMessage=" + countMessage +
                ", countUser=" + countUser +
                ", countActiveUser=" + countActiveUser +
                '}';
    }
}

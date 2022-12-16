package by.it_academy.jd2.Mk_JD2_95_22.dao.api;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.MessageDTO;
//
import java.util.List;

public interface IMessageDao {
    List<MessageDTO> getMessage(String toUser);
    boolean setMessage(MessageDTO messageDTO);

    long countMassage();
}

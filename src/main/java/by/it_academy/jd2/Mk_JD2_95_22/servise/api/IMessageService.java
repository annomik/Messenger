package by.it_academy.jd2.Mk_JD2_95_22.servise.api;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.MessageDTO;

import java.util.List;
//
public interface IMessageService {
    boolean send(MessageDTO messageDTO);
    List<MessageDTO> getMessageForUser(String login);
    long countMassage();
}

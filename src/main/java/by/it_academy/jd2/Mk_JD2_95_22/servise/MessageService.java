package by.it_academy.jd2.Mk_JD2_95_22.servise;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.MessageDTO;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IMessageService;

import java.util.List;

public class MessageService implements IMessageService {
    @Override
    public boolean send(MessageDTO messageDTO) {
        return false;
    }

    @Override
    public List<MessageDTO> getMessageForUser(String login) {
        return null;
    }

    @Override
    public int countUsers() {
        return 0;
    }
}

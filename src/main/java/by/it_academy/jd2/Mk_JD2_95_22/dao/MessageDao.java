package by.it_academy.jd2.Mk_JD2_95_22.dao;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.MessageDTO;
import by.it_academy.jd2.Mk_JD2_95_22.dao.api.IMessageDao;
import java.util.ArrayList;
import java.util.List;

public class MessageDao implements IMessageDao {

    private  List<MessageDTO> messages = new ArrayList<>();

    @Override
    public List<MessageDTO> getMessage(String toUser) {
        List<MessageDTO> messagesForUser = new ArrayList<>();
        for (MessageDTO message : messages) {
            if(toUser.equalsIgnoreCase(message.getForUser())){
                messagesForUser.add(message);
            }
        }
        return messagesForUser;
    }

    @Override
    public boolean setMessage(MessageDTO messageDTO) {
        messages.add(messageDTO);
        return true;
    }

    @Override
    public long countMassage() {
        return messages.size();
    }
}

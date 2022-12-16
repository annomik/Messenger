package by.it_academy.jd2.Mk_JD2_95_22.servise;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.MessageDTO;
import by.it_academy.jd2.Mk_JD2_95_22.dao.api.IMessageDao;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IMessageService;
import java.util.List;

public class MessageService implements IMessageService {

    private IMessageDao dao;

    public MessageService(IMessageDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean send(MessageDTO messageDTO) {
        if(messageDTO == null){
            throw new IllegalArgumentException("Пользователь ни чего не передал в сообщении!");
        }
        return this.dao.setMessage(messageDTO);
    }

    @Override
    public List<MessageDTO> getMessageForUser(String login) {
        if(login == null){
            throw new IllegalArgumentException("Имя пользователя не передано!");
        }
        return this.dao.getMessage(login);
    }

    @Override
    public long countUsers() {
        return this.dao.countMassage();
    }
}
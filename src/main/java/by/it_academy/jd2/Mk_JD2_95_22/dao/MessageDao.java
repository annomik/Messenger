package by.it_academy.jd2.Mk_JD2_95_22.dao;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.MessageDTO;
import by.it_academy.jd2.Mk_JD2_95_22.dao.api.IMessageDao;
import by.it_academy.jd2.Mk_JD2_95_22.dao.api.IUserDao;
import java.util.ArrayList;
import java.util.List;

public class MessageDao implements IMessageDao {

    private  List<MessageDTO> messages = new ArrayList<>();

    private long count = 0;
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
        IUserDao userDao = new UserDao(); // возможно нужно взять из синглтона!
        if(!userDao.exist(messageDTO.getForUser())){
            throw new IllegalArgumentException("Такого пользователя " + messageDTO.getForUser() + " не существует");
        }
        count++;
        return true;
    }

    @Override
    public long countMassage() {
        return count;
    }
}

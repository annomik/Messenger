package by.it_academy.jd2.Mk_JD2_95_22.servise;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.MessageDTO;
import by.it_academy.jd2.Mk_JD2_95_22.dao.api.IMessageDao;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IMessageService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IUserService;

import java.util.List;

public class MessageService implements IMessageService {

    private final IMessageDao dao;
    private final IUserService userService;

    public MessageService(IMessageDao dao, IUserService userService) {
        this.dao = dao;
        this.userService = userService;
    }

    @Override
    public boolean send(MessageDTO messageDTO) {
        if(!userService.exist(messageDTO.getForUser())){
            throw new IllegalArgumentException("Пользователя " + messageDTO.getForUser() + " не существует!");
        }
        return this.dao.setMessage(messageDTO);
    }

    @Override
    public List<MessageDTO> getMessageForUser(String login) {
        if(!userService.exist(login)){
            throw new IllegalArgumentException("Пользователя " + login + " не существует!");
        }
        return this.dao.getMessage(login);
    }

    @Override
    public long countMassage() {
        return this.dao.countMassage();
    }
}
package by.it_academy.jd2.Mk_JD2_95_22.dao;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.MessageDTO;
import by.it_academy.jd2.Mk_JD2_95_22.dao.api.IMessageDao;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IMessageService;
//
import java.util.List;

public class MessageDao implements IMessageDao {
    @Override
    public List<MessageDTO> getMessage(String toUser) {
        return null;
    }

    @Override
    public boolean setMessage(MessageDTO messageDTO) {
        return false;
    }

    @Override
    public int countMassage() {
        return 0;
    }
}

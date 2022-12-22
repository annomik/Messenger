package by.it_academy.jd2.Mk_JD2_95_22.servise;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.ResultDTO;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IListener;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IMessageService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IStatisticService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IUserService;

public class StatisticService implements IStatisticService {
    //ходит на кнтроллеры сообщений и юзеров и просит ло-во, отдает в сервлет
    IUserService userService;
    IMessageService messageService;
    IListener listenerService;

    public StatisticService(IUserService userService, IMessageService messageService, IListener listenerService) {
        this.userService = userService;
        this.messageService = messageService;
        this.listenerService = listenerService;
    }

    @Override
    public ResultDTO getResult(String login) {
        if(login==null||!login.equals("admin")){
            throw new IllegalArgumentException("Не верный логин");
        }
        ResultDTO resultDTO = new ResultDTO(messageService.countMassage(),userService.countUsers(),listenerService.getCountSession());
        return resultDTO;
    }
}
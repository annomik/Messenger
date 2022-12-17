package by.it_academy.jd2.Mk_JD2_95_22.servise;

import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IMessageService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IStatisticService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IUserService;

public class StatisticService implements IStatisticService {
    //ходит на кнтроллеры сообщений и юзеров и просит ло-во, отдает в сервлет
    IUserService userService;
    IMessageService messageService;

    public StatisticService(IUserService userService, IMessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @Override
    public int getCountUser() {
        return userService.countUsers();
    }

    @Override
    public long getCountMassage() {
        return messageService.countMassage();
    }
}
//
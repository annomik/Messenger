package by.it_academy.jd2.Mk_JD2_95_22.servise;

import by.it_academy.jd2.Mk_JD2_95_22.core.dto.ResultDTO;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IListener;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IStaticticAuthorizationService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IStatisticService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IUserService;

public class StatisticAuthorizationService implements IStaticticAuthorizationService {

    IStatisticService statisticService;
    IUserService userService;

    IListener listenerService;

    public StatisticAuthorizationService(IStatisticService statisticService, IUserService userService,
                                         IListener listenerService){
        this.statisticService = statisticService;
        this.userService = userService;
        this.listenerService = listenerService;
    }
    @Override
    public ResultDTO login(String login) {
        if(userService.exist(login)){
            ResultDTO result = new ResultDTO(statisticService.getCountMassage(),statisticService.getCountUser(),
                    listenerService.getCountSession());
            return result;
        }
        return null;
    }
    //этот сервис служит только для того, чтобы сервлет не имел дотупа к админсому сервису. Он проверяет по лигину сессии
    // админ ли это, и, запускает Статистику. На сервлете такую проверку мы сделать по канонам Ильи не можем
}
//
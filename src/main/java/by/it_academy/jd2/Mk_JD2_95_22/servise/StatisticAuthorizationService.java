package by.it_academy.jd2.Mk_JD2_95_22.servise;

import by.it_academy.jd2.Mk_JD2_95_22.servise.api.IStaticticAuthorizationService;

public class StatisticAuthorizationService implements IStaticticAuthorizationService {
    //этот сервис служит только для того, чтобы сервлет не имел дотупа к админсому сервису. Он проверяет по лигину сессии
    // админ ли это, и, запускает Статистику. На сервлете такую проверку мы сделать по канонам Ильи не можем
    @Override
    public boolean login(String login) {
        return false;
    }
}
//
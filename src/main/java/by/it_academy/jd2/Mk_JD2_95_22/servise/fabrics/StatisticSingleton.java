package by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.servise.StatisticService;
import by.it_academy.jd2.Mk_JD2_95_22.servise.UserService;

public class StatisticSingleton {
    public volatile static StatisticService instance;

    private StatisticSingleton(){}

    public static StatisticService getInstance(){
        if(instance==null){
            synchronized (StatisticService.class){
                if(instance==null){
                    instance = new StatisticService(
                            UserServiceSingleton.getInstance(),
                            MessageServiceSingleton.getInstance()
                    );
                }
            }
        }
        return instance;
    }
}

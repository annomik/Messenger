package by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.servise.ListenerService;

public class ListenerServiceSingletone {
    private static volatile ListenerService instance;

    private ListenerServiceSingletone() {}

    public static ListenerService getInstance(){
        if(instance==null){
            synchronized (ListenerService.class){
                if(instance==null){
                    instance = new ListenerService();
                }
            }
        }
        return instance;
    }
}

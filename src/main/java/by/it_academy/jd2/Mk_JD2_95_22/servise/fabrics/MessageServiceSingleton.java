package by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics;


import by.it_academy.jd2.Mk_JD2_95_22.dao.fabrics.MessageDaoSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.servise.MessageService;

public class MessageServiceSingleton {

    private volatile static MessageService instance;

    private MessageServiceSingleton(){}
    public static MessageService getInstance(){
        if(instance == null){
            synchronized (MessageServiceSingleton.class){
                if(instance == null){
                    instance = new MessageService(MessageDaoSingleton.getInstance());
                }
            }
        } return instance;
    }
}

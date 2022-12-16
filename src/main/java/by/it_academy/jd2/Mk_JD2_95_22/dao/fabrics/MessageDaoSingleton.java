package by.it_academy.jd2.Mk_JD2_95_22.dao.fabrics;

import by.it_academy.jd2.Mk_JD2_95_22.dao.MessageDao;

public class MessageDaoSingleton {

    private volatile static MessageDao instance;

    private MessageDaoSingleton(){}
    public static MessageDao getInstance(){
        if(instance == null){
            synchronized (MessageDaoSingleton.class){
                if(instance == null){
                    instance = new MessageDao();
                }
            }
        } return instance;
    }
}

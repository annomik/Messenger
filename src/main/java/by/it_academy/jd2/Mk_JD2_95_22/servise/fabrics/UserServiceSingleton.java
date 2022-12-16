package by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics;


import by.it_academy.jd2.Mk_JD2_95_22.dao.fabrics.UserDaoSingleton;
import by.it_academy.jd2.Mk_JD2_95_22.servise.UserService;

public class UserServiceSingleton {

    private volatile static UserService instance;

    private UserServiceSingleton(){}
    public static UserService getInstance(){
        if(instance == null){
            synchronized (UserServiceSingleton.class){
                if(instance == null){
                    instance = new UserService(UserDaoSingleton.getInstance());
                }
            }
        } return instance;
    }
}

package by.it_academy.jd2.Mk_JD2_95_22.dao.fabrics;


import by.it_academy.jd2.Mk_JD2_95_22.dao.UserDao;

public class UserDaoSingleton {

    private volatile static UserDao instance;

    private UserDaoSingleton(){}
    public static UserDao getInstance(){
        if(instance == null){
            synchronized (UserDaoSingleton.class){
                if(instance == null){
                    instance = new UserDao();
                }
            }
        } return instance;
    }
}

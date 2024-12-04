package services;

import models.User;

public class ChangePassService {
    public User findUser(String userName){
        LoginService lgsv = new LoginService();
        User user = lgsv.getUserByUserName(userName);
        if (user != null){
            return user;
        }
        return null;
    }


}

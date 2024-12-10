package services;

import database.UserDAO;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.UserDAO.connect;

public class LoginService {
    private UserDAO userDAO;
    private UserService userService;

    public LoginService() {
        userDAO = new UserDAO();
        userService = new UserService();
    }


    public boolean authenticate(String username, String password) {
        User user = userService.getUserByUserName(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}

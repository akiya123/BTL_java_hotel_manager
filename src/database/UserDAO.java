package database;

import models.User;

import java.sql.*;

public class UserDAO {
    public static Connection connect() {
        String url = "jdbc:mysql://localhost:3306/userdb";
        String user = "root";
        String password = "khuong123";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

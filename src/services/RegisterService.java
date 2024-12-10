package services;

import database.UserDAO;
import models.User;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

import static database.UserDAO.connect;

public class RegisterService {
    private UserDAO userDAO;
    private static User user;

    public RegisterService(){
        userDAO = new UserDAO();
        user = new User();
    }


    public static boolean addUser(String username, String password, String email, String phoneNumber) {
        String sql = "INSERT INTO user (username, password, email, phoneNumber) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, phoneNumber);
            pstmt.executeUpdate();

            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);

            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm người dùng.");
            e.printStackTrace();
            return false;
        }

    }
}

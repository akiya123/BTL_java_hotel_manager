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
        String sql = "INSERT INTO user (userId ,username, password, email, phoneNumber, role) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "00");
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setString(4, email);
            pstmt.setString(5, phoneNumber);
            pstmt.setString(6, "User");
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

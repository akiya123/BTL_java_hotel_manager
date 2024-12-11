package services;

import models.User;
import view.first_screen.ForgotPassScreen;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static database.UserDAO.connect;

public class ChangePassService extends JFrame {
    public User findUser(String userName) {
        UserService userService = new UserService();
        User user = userService.getUserByUserName(userName);
        if (user != null) {
            return user;
        }
        return null;
    }

    public boolean changePassword(User user, String oldPassword, String newPassword) {

        if (user != null) {
            if (!oldPassword.equals(user.getPassword())) {
                System.out.println("check");
                return false;
            }
            if (newPassword.isEmpty() || oldPassword.isEmpty()) {
                System.out.println("check2");
                return false;
            }
            user.setPassword(newPassword);
            String query = "UPDATE user SET password = ? WHERE username = ?";
            try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, newPassword); // Gán mật khẩu mới
                stmt.setString(2, user.getUsername()); // Gán tên người dùng

                int rowsAffected = stmt.executeUpdate(); // Thực thi câu lệnh UPDATE
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(ChangePassService.this, "Change Successfully!");
                    return true; // Mật khẩu đã được cập nhật
                } else {
                    System.out.println("No user found with the specified username.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return false;
    }

    public boolean forgotPassword(String newPassword, String confirmPassword, String username) {
        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
            return false;
        }
        if (!newPassword.equals(confirmPassword)) {
            return false;
        }
        String query = "UPDATE user SET password = ? WHERE username = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newPassword);
            stmt.setString(2, username);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(ChangePassService.this, "Đổi thành công!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}

package services;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.UserDAO.connect;

public class ChangePassService {
    public User findUser(String userName) {
        LoginService lgsv = new LoginService();
        User user = lgsv.getUserByUserName(userName);
        if (user != null) {
            return user;
        }
        return null;
    }

    public boolean changePassword(User user, String oldPassword, String newPassword) {

        if (user == null) {
            if (oldPassword != user.getPassword()) {
                System.out.println("check");
                return false;
            }
            if (newPassword.isEmpty() || oldPassword.isEmpty()) {
                System.out.println("check2");
                return false;
            }
            user.setPassword(newPassword);
            String query = "UPDATE users SET password = ? WHERE username = ?";
            try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, newPassword);
                stmt.setString(2, user.getUsername());
                int rowsUpdated = stmt.executeUpdate();
                return rowsUpdated > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
        System.out.println("check3");
        return false;
    }

}

package services;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.UserDAO.connect;

public class UserService {
    public User getUserByUserName(String userName) {
        String query = "SELECT * FROM user WHERE username = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                return new User(userName, password, email, phoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getRoleByUserName(String userName) {
        String query = "SELECT role FROM user WHERE username = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                return role;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User";
    }
}

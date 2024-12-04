package services;

import java.sql.*;
import java.util.Scanner;

public class RegisterService {

    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/mydatabase";
        String user = "postgres";
        String password = "khuong123";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        if (username == null || password == null){
            System.out.println("Tên đăng nhập hoặc mật khẩu không được để trống.");
            return false;
        }

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("Người dùng đã được đăng ký thành công!");
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm người dùng.");
            e.printStackTrace();
            return false;
        }

    }
}

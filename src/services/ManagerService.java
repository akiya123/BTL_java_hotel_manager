package services;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.UserDAO.connect;

public class ManagerService {
    UserService userService;


    public ManagerService(){
        userService = new UserService();
    }

    public void loadDataFromDatabaseForManager(DefaultTableModel tableModel) {
        String query = """
                SELECT u.username, u.phoneNumber, r.roomName, r.roomType,r.checkInDate, r.checkOutDate, r.price
                FROM room r 
                LEFT JOIN user u ON r.userId = u.userId 
                WHERE r.status = 'Unavailable'
                """;
        tableModel.setRowCount(0);
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {

            int stt = 1; // Đánh số thứ tự
            while (rs.next()) {
                String username = rs.getString("username");
                String phoneNumber = rs.getString("phoneNumber");
                String roomName = rs.getString("roomName");
                String roomType = rs.getString("roomType");
                String checkinDate = rs.getString("checkinDate");
                String checkoutDate = rs.getString("checkOutDate");
                String price = rs.getString("price");

                // Thêm hàng vào TableModel
                tableModel.addRow(new Object[]{username, phoneNumber, roomName, roomType, checkinDate, checkoutDate, price});
                stt++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu hoặc cập nhật từ cơ sở dữ liệu: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadDataByUserName(DefaultTableModel tableModel, String userName){
        String query = """
                SELECT u.username, u.phoneNumber, r.roomName, r.roomType,r.checkInDate, r.checkOutDate, r.price
                FROM room r 
                LEFT JOIN user u ON r.userId = u.userId 
                WHERE r.status = 'Unavailable' AND u.username = ?
                """;
        tableModel.setRowCount(0);
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userName);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    // Lấy dữ liệu từ ResultSet
                    String username = rs.getString("username");
                    String phoneNumber = rs.getString("phoneNumber");
                    String roomName = rs.getString("roomName");
                    String roomType = rs.getString("roomType");
                    String checkinDate = rs.getString("checkInDate"); // Viết đúng tên cột
                    String checkoutDate = rs.getString("checkOutDate");
                    String price = rs.getString("price");

                    // Thêm dữ liệu vào TableModel, bao gồm số thứ tự
                    tableModel.addRow(new Object[]{username, phoneNumber, roomName, roomType, checkinDate, checkoutDate, price});
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu hoặc cập nhật từ cơ sở dữ liệu: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

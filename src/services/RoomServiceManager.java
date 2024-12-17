package services;

import database.UserDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import static database.UserDAO.connect;
import static java.lang.Integer.parseInt;

public class RoomServiceManager {
    private UserDAO userDAO;
    private UserService userService;

    public RoomServiceManager() {
        userDAO = new UserDAO();
        userService = new UserService();
    }

    public void loadDataFromDatabase(DefaultTableModel tableModel, String type, String day) {
        // Truy vấn SQL để tải dữ liệu
        String query = "SELECT roomName, roomType, checkOutDate, price FROM room WHERE roomType = ? and status = ?";

        // Xóa dữ liệu cũ trong bảng
        tableModel.setRowCount(0);

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            // Cập nhật checkoutDate thành ngày hiện tại + day
            String updateQuery = """
                    UPDATE room 
                    SET checkOutDate = DATE_ADD(CURDATE(), INTERVAL ? DAY)
                    WHERE roomType = ?
                    """;

            try (PreparedStatement pstmtUpdate = conn.prepareStatement(updateQuery)) {
                pstmtUpdate.setInt(1, parseInt(day)); // Số ngày thêm vào ngày hiện tại
                pstmtUpdate.setString(2, type); // Loại phòng để lọc
                pstmtUpdate.executeUpdate();
            }

            // Thiết lập tham số cho truy vấn
            pstmt.setString(1, type);
            pstmt.setString(2, "Available"); // Trạng thái phòng trống

            // Thực hiện truy vấn để lấy dữ liệu
            try (ResultSet rs = pstmt.executeQuery()) {
                int stt = 1; // Đánh số thứ tự
                while (rs.next()) {
                    String roomName = rs.getString("roomName");
                    String roomType = rs.getString("roomType");
                    String checkoutDate = rs.getString("checkOutDate");
                    int price = rs.getInt("price");

                    // Thêm hàng vào TableModel
                    tableModel.addRow(new Object[]{stt, roomName, roomType, checkoutDate, price});
                    stt++;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu hoặc cập nhật từ cơ sở dữ liệu: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void bookingRoom(DefaultTableModel tableModel, String roomName, int id) {
        String query = "SELECT * FROM room WHERE roomName = ?";
//        tableModel.setRowCount(0);
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            String updateQuery = """
                    UPDATE room 
                    SET status = ?, userId = ?, checkInDate = CURDATE()
                    WHERE roomName = ?
                    """;

            try (PreparedStatement pstmtUpdate = conn.prepareStatement(updateQuery)) {
                pstmtUpdate.setString(1, "Unavailable"); // Đã được đặt
                pstmtUpdate.setInt(2, id);
                pstmtUpdate.setString(3, roomName);
                pstmtUpdate.executeUpdate();
            }
            pstmt.setString(1, roomName);
            try (ResultSet rs = pstmt.executeQuery()) {
                int stt = tableModel.getRowCount() + 1;
                while (rs.next()) {
                    String name = rs.getString("roomName");
                    String roomType = rs.getString("roomType");
                    String checkoutDate = rs.getString("checkOutDate");
                    int price = rs.getInt("price");

                    // Thêm hàng vào TableModel
                    tableModel.addRow(new Object[]{stt, name, roomType, checkoutDate, price});
                    stt++;

                    JOptionPane.showMessageDialog(null, "Thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu hoặc cập nhật từ cơ sở dữ liệu: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cancelBookingRoom(DefaultTableModel tableModel, String stt) {
        boolean found = false;
        int Stt = parseInt(stt);
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int currentSTT = (int) tableModel.getValueAt(i, 0);
            if (currentSTT == Stt) {
                String roomName = (String) tableModel.getValueAt(i, 1);
                try (Connection conn = connect()) {
                    String updateQuery = """
                            UPDATE room 
                            SET status = 'Available', userId = null, checkInDate = null, checkOutDate = null
                            WHERE roomName = ?
                            """;

                    try (PreparedStatement pstmtUpdate = conn.prepareStatement(updateQuery)) {
                        pstmtUpdate.setString(1, roomName);
                        pstmtUpdate.executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu hoặc cập nhật từ cơ sở dữ liệu: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                }

                tableModel.removeRow(i);
                found = true;
                break;
            }
        }

        if (found) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                tableModel.setValueAt(i + 1, i, 0);
            }
            JOptionPane.showMessageDialog(null, "Thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy hàng có STT: " + Stt, "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void bookedRoom(DefaultTableModel tableModel, int userId){
        // Truy vấn SQL để tải dữ liệu
        String query = "SELECT roomName, roomType, checkOutDate, price FROM room WHERE userId = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            // Thực hiện truy vấn để lấy dữ liệu
            try (ResultSet rs = pstmt.executeQuery()) {
                int stt = tableModel.getRowCount() + 1; // Đánh số thứ tự
                while (rs.next()) {
                    String roomName = rs.getString("roomName");
                    String roomType = rs.getString("roomType");
                    String checkoutDate = rs.getString("checkOutDate");
                    int price = rs.getInt("price");

                    // Thêm hàng vào TableModel
                    tableModel.addRow(new Object[]{stt, roomName, roomType, checkoutDate, price});
                    stt++;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu hoặc cập nhật từ cơ sở dữ liệu: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

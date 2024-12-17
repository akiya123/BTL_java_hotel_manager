package services;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static database.UserDAO.connect;

public class ManagerService extends JFrame {
    UserService userService;


    public ManagerService() {
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

    public void loadDataByUserName(DefaultTableModel tableModel, String userName) {
        String query = """
                SELECT r.roomName, r.roomType, r.checkInDate, r.price
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
                    String roomName = rs.getString("roomName");
                    String roomType = rs.getString("roomType");
                    String checkinDate = rs.getString("checkInDate"); // Viết đúng tên cột
                    String price = rs.getString("price");

                    // Thêm dữ liệu vào TableModel, bao gồm số thứ tự
                    tableModel.addRow(new Object[]{roomName, roomType, checkinDate, price});
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu hoặc cập nhật từ cơ sở dữ liệu: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void checkUserBooking(DefaultTableModel tableModel, String userName) {
        String query = """
                SELECT r.roomName, r.roomType, r.status
                FROM room r
                LEFT JOIN user u ON r.userId = u.userId 
                WHERE u.username = ?
                """;
        tableModel.setRowCount(0);
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userName);

            try (ResultSet rs = pstmt.executeQuery()) {
                int stt = 1;
                while (rs.next()) {
                    // Lấy dữ liệu từ ResultSet
                    String roomName = rs.getString("roomName");
                    String roomType = rs.getString("roomType");
                    String status = rs.getString("status"); // Viết đúng tên cột

                    // Thêm dữ liệu vào TableModel, bao gồm số thứ tự
                    tableModel.addRow(new Object[]{stt, roomName, roomType, status});
                    stt++;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu hoặc cập nhật từ cơ sở dữ liệu: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void fetchUserByStt(DefaultTableModel tableModel, int stt, JLabel name, JLabel type, JLabel checkIn, JLabel checkOut) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int currentSTT = (int) tableModel.getValueAt(i, 0);
            if (currentSTT == stt) {
                String roomName = (String) tableModel.getValueAt(i, 1);
                try (Connection conn = connect()) {
                    String query = """
                            SELECT roomName, roomType, checkInDate, checkOutDate
                            FROM room
                            WHERE roomName = ?
                            """;

                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                        pstmt.setString(1, roomName);
                        try (ResultSet rs = pstmt.executeQuery()) {
                            if (rs.next()) {
                                // Lấy dữ liệu từ ResultSet
                                String fetchedName = rs.getString("roomName");
                                String fetchedType = rs.getString("roomType");
                                String fetchedCheckIn = rs.getString("checkInDate");
                                String fetchedCheckOut = rs.getString("checkOutDate");

                                // Set text cho JLabel
                                name.setText(fetchedName);
                                type.setText(fetchedType);
                                checkIn.setText(fetchedCheckIn);
                                checkOut.setText(fetchedCheckOut);
                            } else {
                                JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin phòng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu hoặc cập nhật từ cơ sở dữ liệu: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void checkOutRoom(String roomName) {
        // nhận room name ở trong lbSetRoomNameManagerUserFalse
        // set status, checkin, checkout, userid
        String query = """
                    UPDATE room
                    SET status = 'Available', checkInDate = null, checkOutDate = null, userId = null
                    WHERE roomName = ?;
                """;
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, roomName);
            int check = pstmt.executeUpdate();
            if (check > 0) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu hoặc cập nhật từ cơ sở dữ liệu: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadDataForBill(DefaultTableModel tableModel, String userName) {
        String query = """
                SELECT r.roomName, r.checkInDate, r.price
                FROM room r
                LEFT JOIN user u ON r.userId = u.userId 
                WHERE u.username = ?
                """;
        tableModel.setRowCount(0);
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, userName);
            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    // Lấy dữ liệu từ ResultSet
                    String roomName = rs.getString("roomName");
                    String checkinDate = rs.getString("checkInDate");
                    String price = rs.getString("price");

                    LocalDate currentDate = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String formattedDate = currentDate.format(formatter);

                    tableModel.addRow(new Object[]{roomName, checkinDate, formattedDate, price});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu hoặc cập nhật từ cơ sở dữ liệu: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

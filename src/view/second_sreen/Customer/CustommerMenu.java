package view.second_sreen.Customer;

import models.User;
import services.ChangePassService;
import services.LoginService;
import services.RoomServiceManager;
import services.UserService;
import view.first_screen.LoginScreen;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustommerMenu extends JFrame {
    private UserService userService;
    public String curUserName;
    private RoomServiceManager roomServiceManager;
    // Biến sử dụng
    // tab Profile

    // Thông tin khách hàng
    private JLabel lbMailProfile;
    public JLabel lbNameProfile;
    private JLabel lbPhoneProfile;

    private JButton buttonLogOut; // nút đăng xuất
    private JButton buttonChangePassProfile;

    //tab Booked
    //Thông tin hủy phòng
    private JTextField txtSTTCancelbooked; // STT của phòng muốn hủy

    //Nút chức năng
    private JButton buttonCancelBooked; // Nút hủy đặt phòng

    //Bảng
    private JTable tableRoomBooked;// Bảng hiện danh sách của tab Booked
    private DefaultTableModel tableModel2;


    //tab Booking
    //Thông tin khách hàng nhập
    private JTextField txtYourName; // Tên
    private JTextField txtYourPhone; // SĐT
    private JTextField txtBookingDate; // Ngày đặt phòng
    private JComboBox<String> boxTypeTRoomBooking;// Loại phòng muốn đặt
    private JTextField txtSTTBooking; // STT phòng muốn đặt

    //Nút chức năng
    private JButton buttonBackToFindBoking; // Nút back - quay trở lại phần tìm phòng
    private JButton buttonFindBooking; // Nút tìm phòng
    private JButton buttonRoomBoking; // Nút đặt phòng

    //Bảng
    private JTable tableRoomBooking; // Bảng hiện danh sách của tab Booking
    private DefaultTableModel tableModel1;

    //ENVENT
    //Tab profile
    private void buttonLogOutActionPerformed(ActionEvent evt) {
        // Nút đăng xuất
        setVisible(false);
        LoginScreen login = new LoginScreen();
        login.setVisible(true);
    }

    // tab Booked
    private void boxTypeTRoomBookingActionPerformed(ActionEvent evt) {
        // Chọn của combo box / xóa đoạn này = lỗi
    }

    private void buttonBackToFindBokingActionPerformed(ActionEvent evt) {
        //Nút back
        //hiện những txt và label của find
        Ban_la_dont_use_this.setVisible(true);
        txtYourName.setVisible(true);
        sdt_dont_use_this.setVisible(true);
        txtYourPhone.setVisible(true);
        dateRoom_dont_use_this.setVisible(true);
        txtBookingDate.setVisible(true);
        roomTye_dont_use_this.setVisible(true);
        boxTypeTRoomBooking.setVisible(true);
        buttonFindBooking.setVisible(true);

        //Ẩn của phần đặt phòng
        bmdpstt_dont_use_this.setVisible(false);
        txtSTTBooking.setVisible(false);
        buttonBackToFindBoking.setVisible(false);
        buttonRoomBoking.setVisible(false);
    }

    public void setProfile(String userName) {
        User curUser = userService.getUserByUserName(userName);
        lbNameProfile.setText(curUser.getUsername());
        lbMailProfile.setText(curUser.getEmail());
        lbPhoneProfile.setText(curUser.getPhoneNumber());
        roomServiceManager.bookedRoom(tableModel2, curUser.getId());

    }

    //Khởi tạo đầu
    public CustommerMenu() {
        userService = new UserService();
        roomServiceManager = new RoomServiceManager();

        initComponents();
        //Căn giữa màn hình
        setLocationRelativeTo(null);

        //Ẩn đặt phòng của tab booking
        bmdpstt_dont_use_this.setVisible(false);
        txtSTTBooking.setVisible(false);
        buttonBackToFindBoking.setVisible(false);
        buttonRoomBoking.setVisible(false);

        buttonFindBooking.addActionListener(this::findBookingEvent);
        buttonRoomBoking.addActionListener(this::bookingEvent);
        buttonCancelBooked.addActionListener(this::cancelBookingEvent);
        buttonChangePassProfile.addActionListener(this::changePasswordEvent);
    }


    // Find Event
    public void setCurUserName(String curUserName) {
        this.curUserName = curUserName;
    }

    private void findBookingEvent(ActionEvent actionEvent) {
        UserService userService = new UserService();
        String username = txtYourName.getText();
        String sdt = txtYourPhone.getText();
        String day = txtBookingDate.getText();
        String type = (String) boxTypeTRoomBooking.getSelectedItem();

        if (!username.equals(curUserName)){
            JOptionPane.showMessageDialog(this, "Tên không trùng khớp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập tên của bạn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập số điện thoại của bạn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (day.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập số ngày bạn muốn ở tại phòng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }


        User user = userService.getUserByUserName(username);
        if (user != null) {

            if (!sdt.equals(user.getPhoneNumber())){
                JOptionPane.showMessageDialog(this, "Số điện thoại không trùng khớp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Ban_la_dont_use_this.setVisible(false);
            txtYourName.setVisible(false);
            sdt_dont_use_this.setVisible(false);
            txtYourPhone.setVisible(false);
            dateRoom_dont_use_this.setVisible(false);
            txtBookingDate.setVisible(false);
            roomTye_dont_use_this.setVisible(false);
            boxTypeTRoomBooking.setVisible(false);
            buttonFindBooking.setVisible(false);

            //Hiện của phần đặt phòng
            bmdpstt_dont_use_this.setVisible(true);
            txtSTTBooking.setVisible(true);
            buttonBackToFindBoking.setVisible(true);
            buttonRoomBoking.setVisible(true);

            // Hiện dữ liệu lên bảng
            roomServiceManager.loadDataFromDatabase(tableModel1, type, day);

        } else {
            JOptionPane.showMessageDialog(this, "Lỗi", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        return;
    }

    // Book Event
    private void bookingEvent(ActionEvent actionEvent) {
        String roomName = "";
        String userName = txtYourName.getText();
        User curUser = userService.getUserByUserName(userName);
        int userId = curUser.getId();
        String day = txtBookingDate.getText();
        String type = (String) boxTypeTRoomBooking.getSelectedItem();
        try {
            int stt = Integer.parseInt(txtSTTBooking.getText());
            if (stt > 0 && stt <= tableRoomBooking.getRowCount()) {
                roomName = tableRoomBooking.getValueAt(stt - 1, 1).toString();
            } else {
                JOptionPane.showMessageDialog(this,
                        "STT không hợp lệ!",
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Vui lòng nhập một số STT hợp lệ!",
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        roomServiceManager.bookingRoom(tableModel2, roomName, userId);
        roomServiceManager.loadDataFromDatabase(tableModel1, type, day);
    }

    private void cancelBookingEvent(ActionEvent actionEvent) {
        String day = txtBookingDate.getText();
        String type = (String) boxTypeTRoomBooking.getSelectedItem();
        String stt = txtSTTCancelbooked.getText();
        if (stt.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nhập số thứ tự bạn muốn hủy phòng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        roomServiceManager.cancelBookingRoom(tableModel2 ,stt);
        roomServiceManager.loadDataFromDatabase(tableModel1, type, day);
    }

    private void changePasswordEvent(ActionEvent actionEvent) {
        ChangePassScreen changePassScreen = new ChangePassScreen();
        changePassScreen.setUserName(lbNameProfile.getText());
        changePassScreen.setVisible(true);
        this.setVisible(false);
    }
    // Các biến

    private JLabel Ban_la_dont_use_this;
    private JLabel bmdpstt_dont_use_this;
    private JLabel dateRoom_dont_use_this;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel13;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTabbedPane jTabbedPane1;
    private JTextArea jTextArea1;
    private JLabel roomTye_dont_use_this;
    private JLabel sdt_dont_use_this;


    //Thiết kế giao diện
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Ban_la_dont_use_this = new javax.swing.JLabel();
        buttonFindBooking = new javax.swing.JButton();
        txtSTTBooking = new javax.swing.JTextField();
        txtYourPhone = new javax.swing.JTextField();
        sdt_dont_use_this = new javax.swing.JLabel();
        dateRoom_dont_use_this = new javax.swing.JLabel();
        txtBookingDate = new javax.swing.JTextField();
        bmdpstt_dont_use_this = new javax.swing.JLabel();
        boxTypeTRoomBooking = new javax.swing.JComboBox<>();
        buttonRoomBoking = new javax.swing.JButton();
        buttonBackToFindBoking = new javax.swing.JButton();
        roomTye_dont_use_this = new javax.swing.JLabel();
        txtYourName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRoomBooking = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableRoomBooked = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSTTCancelbooked = new javax.swing.JTextField();
        buttonCancelBooked = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        buttonLogOut = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lbNameProfile = new javax.swing.JLabel();
        lbPhoneProfile = new javax.swing.JLabel();
        lbMailProfile = new javax.swing.JLabel();
        buttonChangePassProfile = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(900, 465));

        jPanel2.setPreferredSize(new java.awt.Dimension(900, 465));

        jPanel6.setBackground(new java.awt.Color(0, 255, 255));
        jPanel6.setForeground(new java.awt.Color(0, 204, 255));
        jPanel6.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rage Italic", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Room");
        jPanel6.add(jLabel1);
        jLabel1.setBounds(86, 11, 102, 61);

        Ban_la_dont_use_this.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Ban_la_dont_use_this.setText("Bạn là :");
        jPanel6.add(Ban_la_dont_use_this);
        Ban_la_dont_use_this.setBounds(17, 78, 54, 34);

        buttonFindBooking.setFont(new java.awt.Font("Segoe Script", 0, 18)); // NOI18N
        buttonFindBooking.setText("Tìm kiếm");
        jPanel6.add(buttonFindBooking);
        buttonFindBooking.setBounds(80, 270, 107, 36);

        txtSTTBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel6.add(txtSTTBooking);
        txtSTTBooking.setBounds(90, 140, 110, 30);
        jPanel6.add(txtYourPhone);
        txtYourPhone.setBounds(75, 125, 164, 22);

        sdt_dont_use_this.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        sdt_dont_use_this.setText("SĐT:");
        jPanel6.add(sdt_dont_use_this);
        sdt_dont_use_this.setBounds(35, 124, 34, 22);

        dateRoom_dont_use_this.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        dateRoom_dont_use_this.setText("Số ngày đặt phòng:");
        jPanel6.add(dateRoom_dont_use_this);
        dateRoom_dont_use_this.setBounds(17, 165, 142, 22);
        jPanel6.add(txtBookingDate);
        txtBookingDate.setBounds(175, 166, 64, 22);

        bmdpstt_dont_use_this.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        bmdpstt_dont_use_this.setText("Bạn muốn đặt phòng có STT:");
        jPanel6.add(bmdpstt_dont_use_this);
        bmdpstt_dont_use_this.setBounds(30, 100, 220, 22);

        boxTypeTRoomBooking.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng đơn", "Phòng đôi" }));
        boxTypeTRoomBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTypeTRoomBookingActionPerformed(evt);
            }
        });
        jPanel6.add(boxTypeTRoomBooking);
        boxTypeTRoomBooking.setBounds(120, 210, 93, 22);

        buttonRoomBoking.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        buttonRoomBoking.setText("Đặt phòng");
        jPanel6.add(buttonRoomBoking);
        buttonRoomBoking.setBounds(140, 350, 110, 36);

        buttonBackToFindBoking.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        buttonBackToFindBoking.setText("Trở lại");
        buttonBackToFindBoking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackToFindBokingActionPerformed(evt);
            }
        });
        jPanel6.add(buttonBackToFindBoking);
        buttonBackToFindBoking.setBounds(17, 350, 100, 36);

        roomTye_dont_use_this.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        roomTye_dont_use_this.setText("Loại phòng:");
        jPanel6.add(roomTye_dont_use_this);
        roomTye_dont_use_this.setBounds(25, 206, 86, 22);
        jPanel6.add(txtYourName);
        txtYourName.setBounds(73, 85, 170, 22);

        // Set database
        tableModel1 = new DefaultTableModel(
                new Object[][]{}, // Dữ liệu khởi tạo (ban đầu rỗng)
                new String[]{"STT", "Tên phòng", "Loại phòng", "Ngày trả", "Giá"} // Tiêu đề cột
        ) {
            // Xác định cột không thể chỉnh sửa
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tableRoomBooking.setModel(tableModel1);
        tableRoomBooking.setAutoCreateRowSorter(true);

        jScrollPane1.setViewportView(tableRoomBooking);
        if (tableRoomBooking.getColumnModel().getColumnCount() > 0) {
            tableRoomBooking.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableRoomBooking.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableRoomBooking.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableRoomBooking.getColumnModel().getColumn(3).setPreferredWidth(120);
            tableRoomBooking.getColumnModel().getColumn(4).setPreferredWidth(120);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Booking", jPanel2);

        jPanel3.setBackground(new java.awt.Color(51, 255, 255));
        jPanel3.setForeground(new java.awt.Color(51, 255, 255));
        jPanel3.setToolTipText("");
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 500));

        tableModel2 = new DefaultTableModel(
                new Object[][]{}, // Dữ liệu khởi tạo (ban đầu rỗng)
                new String[]{"STT", "Tên phòng", "Loại phòng", "Ngày trả", "Giá"} // Tiêu đề cột
        ) {
            // Xác định cột không thể chỉnh sửa
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tableRoomBooked.setModel(tableModel2);
        tableRoomBooked.setAutoCreateRowSorter(true);

        jScrollPane4.setViewportView(tableRoomBooked);
        if (tableRoomBooked.getColumnModel().getColumnCount() > 0) {
            tableRoomBooked.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableRoomBooked.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableRoomBooked.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableRoomBooked.getColumnModel().getColumn(3).setPreferredWidth(120);
            tableRoomBooked.getColumnModel().getColumn(4).setPreferredWidth(120);
        }

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hủy đặt phòng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Bạn muốn hủy phòng có STT:");

        txtSTTCancelbooked.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        buttonCancelBooked.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonCancelBooked.setForeground(new java.awt.Color(255, 0, 0));
        buttonCancelBooked.setText("Hủy đặt");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(269, 269, 269)
                                                .addComponent(jLabel6))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(136, 136, 136)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtSTTCancelbooked, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58)
                                                .addComponent(buttonCancelBooked, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtSTTCancelbooked, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonCancelBooked, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(77, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Booked", jPanel3);

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tên:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("SĐT:");

        buttonLogOut.setBackground(new java.awt.Color(0, 0, 0));
        buttonLogOut.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buttonLogOut.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogOut.setText("Đăng xuất");
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mail:");

        lbNameProfile.setBackground(new java.awt.Color(255, 255, 255));
        lbNameProfile.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbNameProfile.setForeground(new java.awt.Color(255, 255, 255));
        lbNameProfile.setText(" ");
        lbNameProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbPhoneProfile.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbPhoneProfile.setForeground(new java.awt.Color(255, 255, 255));
        lbPhoneProfile.setText(" ");
        lbPhoneProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbMailProfile.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbMailProfile.setForeground(new java.awt.Color(255, 255, 255));
        lbMailProfile.setText(" ");
        lbMailProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonChangePassProfile.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        buttonChangePassProfile.setText("Đổi mật khẩu");
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonChangePassProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonLogOut)
                                .addGap(24, 24, 24))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel5))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbMailProfile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                                        .addComponent(lbPhoneProfile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNameProfile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(251, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbNameProfile)
                                        .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbPhoneProfile)
                                        .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbMailProfile)
                                        .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonLogOut)
                                        .addComponent(buttonChangePassProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Profile", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }
}

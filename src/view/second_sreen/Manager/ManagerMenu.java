
package view.second_sreen.Manager;

import models.User;
import services.ManagerService;
import services.RoomServiceManager;
import services.UserService;
import view.first_screen.LoginScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class ManagerMenu extends javax.swing.JFrame {


        private javax.swing.JButton buttonBillDetailFalse; // Nút xuất đơn
        private javax.swing.JButton buttonReportCustommerDetail; // Nút tìm Khách

        // Chú thích
        private javax.swing.JLabel lbCustommerInforDetailFalse; // tiêu đề
        private javax.swing.JLabel lbMailDetailFalse; 
        private javax.swing.JLabel lbNameDetailFalse;
        private javax.swing.JLabel lbPhoneDetailFalse;

        // lb Hiện thông tin
        private javax.swing.JLabel lbSetMailDetailFalse;
        private javax.swing.JLabel lbSetNameDetailFalse;
        private javax.swing.JLabel lbSetPhoneDetailFalse;

        // bảng
        private javax.swing.JTable tableRoomInforDetailFalse;
        
        private javax.swing.JTextField txtUsernameCustommerDetail;

        // Biến panel thiết kế
        private javax.swing.JLabel jLabel13;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanelMain;
        private javax.swing.JScrollPane jScrollPane3;

       

// Hoàn
   //Biến có sự để tâm thấp
    private javax.swing.JPanel panelManageUser;//Panel chính
    private javax.swing.JScrollPane jScrollPane1; // Tạo đinh dạng cho bảng

    private javax.swing.JLabel lbPhoneManagerUser; // Chữ "SĐT"
    private javax.swing.JLabel lbCustommerNameManagerUser;// Chữ "Tên"
    private javax.swing.JLabel lbTitleManagerUser; // Chữ "Thông tin khách hàng"
    
    //Biến cần để tâm
        // Những biến khởi tạo sẽ ẩn đi - Hiện khi nhấn sự kiện ButtonFindManageUser
                //Mail
                private javax.swing.JLabel lbSetMailManageUser;
                private javax.swing.JLabel lbMailManageUserFlase;

        /*Để trả nhận ý tưởng là tạo 1 biến để kiểm tra trạng thái nhận phòng của phòng
         tạo 1 ArrayList<pair<"Tên phòng","Một biến boollen">> - arrBooking lưu trạng thái nhận trả phòng
         nếu True = đã nhận phòng || false = đã trả phòng -> xóa phòng khỏi bảng
         lấy dữ liệu của list từ database
         - tìm trên database xem Username nào gắn với phòng nào để hiện vào bảng
         - Username từ txtCustommerNameManageUser
         */


        private javax.swing.JButton ButtonCheckOutManageUserFlase; // Nút Trả phòng
        private javax.swing.JButton ButtonClearManageUserFalse; /*Nút làm mới -
        ý tưởng dùng để ẩn tất cả biến có False ở cuối tên và setText txtCustommerNameManageUser và txtCustommerPhoneManageUser */ 

        private javax.swing.JButton ButtonDateInExpiredManageUserFlase; /*  Nút phòng hết hạn - 
        ý tưởng là nếu hết hạn nhận phòng thì sẽ để trạng thái phòng là phòng trống rồi xóa phòng khỏi bảng */

        //Thông tin đặt phòng - ý tưởng là khi nhấn vào hàng nào thông tin của hàng đấy sẽ hiện trên những biến lbSet

        private javax.swing.JLabel lbBookingInformationManageUserFlase; // Chữ "thông tin đặt phòng"

        private javax.swing.JTable tableBookingInformationManageUserFalse;// bảng Chứa thông tin

                private javax.swing.JLabel lbRoomInformationManageUserFalse; // Chữ "thông tin phòng"
                //Label để hiện chữ
                
                private javax.swing.JLabel lbRoomNameManagerUserFalse;
                private javax.swing.JLabel lbRoomTypeManagerUserFalse;
                private javax.swing.JLabel lbDateInManagerUserFalse;
                private javax.swing.JLabel lbDateOutManagerUserFalse;
                //Label để hiện thông tin
                private javax.swing.JLabel lbSetDateInManagerUserFalse;
                private javax.swing.JLabel lbSetDateOutManagerUserFalse;
                private javax.swing.JLabel lbSetRoomNameManagerUserFalse;
                private javax.swing.JLabel lbSetRoomTypeManagerUserFalse;

    
        //Những biến sẽ hiện
        private javax.swing.JButton buttonFindManageUser; // Nút tìm
        
                //txt nhập thông tin tìm
                private javax.swing.JTextField txtCustommerNameManageUser; // tên
                private javax.swing.JTextField txtCustommerPhoneManageUser; // SĐT


//Hoàn - end
    private ManagerService managerService;
    private UserService userService;

    private javax.swing.JButton butonLogOut;

    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2; // ko
    private javax.swing.JTabbedPane jTabbedPane1;


    private javax.swing.JTable tableCustommerDetailFalse;
    private javax.swing.JTable tableListManageRoom;

    private javax.swing.JTextField txtDateCustommerDetail;


    // KhuongPham EDIT
    private DefaultTableModel tableModel1;
    private DefaultTableModel tableModel2;


    public ManagerMenu() {
        initComponents();
        setLocationRelativeTo(null);
        managerService = new ManagerService();
        userService = new UserService();


        butonLogOut.addActionListener(this::logOutEvent);
        buttonReportCustommerDetail.addActionListener(this::reportEvent);
    }

    private void reportEvent(ActionEvent actionEvent) {
        String userName = txtDateCustommerDetail.getText();
        if (userName.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nhập tên khách hàng bạn muốn xem thông tin!");
            return;
        }

        User user = userService.getUserByUserName(userName);
        if (user != null){
            managerService.loadDataByUserName(tableModel2, userName);
            tableCustommerDetailFalse.setVisible(true);
        }
        else {
            // Quán triệt hơn nên chỉ tìm role User, sửa cả find bên Customer
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng có tên như trên!");
        }
    }

    public void logOutEvent(ActionEvent event) {
        setVisible(false);
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
    }


    //Tao bang
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane(); // ko
        tableListManageRoom = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDateCustommerDetail = new javax.swing.JTextField();
        buttonReportCustommerDetail = new javax.swing.JButton();
        tableCustommerDetailFalse = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        butonLogOut = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        //Hoàn
        panelManageUser = new javax.swing.JPanel();
        lbPhoneManagerUser = new javax.swing.JLabel();
        lbTitleManagerUser = new javax.swing.JLabel();
        lbCustommerNameManagerUser = new javax.swing.JLabel();
        txtCustommerPhoneManageUser = new javax.swing.JTextField();
        txtCustommerNameManageUser = new javax.swing.JTextField();
        buttonFindManageUser = new javax.swing.JButton();
        lbMailManageUserFlase = new javax.swing.JLabel();
        lbSetMailManageUser = new javax.swing.JLabel();
        ButtonCheckOutManageUserFlase = new javax.swing.JButton();
        ButtonClearManageUserFalse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBookingInformationManageUserFalse = new javax.swing.JTable();
        lbBookingInformationManageUserFlase = new javax.swing.JLabel();
        lbRoomInformationManageUserFalse = new javax.swing.JLabel();
        lbDateInManagerUserFalse = new javax.swing.JLabel();
        lbRoomNameManagerUserFalse = new javax.swing.JLabel();
        lbRoomTypeManagerUserFalse = new javax.swing.JLabel();
        lbDateOutManagerUserFalse = new javax.swing.JLabel();
        ButtonDateInExpiredManageUserFlase = new javax.swing.JButton();
        lbSetDateOutManagerUserFalse = new javax.swing.JLabel();
        lbSetRoomNameManagerUserFalse = new javax.swing.JLabel();
        lbSetRoomTypeManagerUserFalse = new javax.swing.JLabel();
        lbSetDateInManagerUserFalse = new javax.swing.JLabel();
        //Hoàn - end

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel management system");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        // Thông tin bảng checkIn
        tableModel1 = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Tên khách hàng", "Số điện thoại", "Tên Phòng", "Loại phòng", "Ngày nhận phòng", "Ngày trả phòng", "Giá"}
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        tableListManageRoom.setModel(tableModel1);
        tableListManageRoom.setAutoCreateRowSorter(true);

        managerService.loadDataFromDatabaseForManager(tableModel1); 

        jScrollPane2.setViewportView(tableListManageRoom); // ko
        if (tableListManageRoom.getColumnModel().getColumnCount() > 0) {
            tableListManageRoom.getColumnModel().getColumn(0).setMinWidth(150);
            tableListManageRoom.getColumnModel().getColumn(0).setPreferredWidth(150);
            tableListManageRoom.getColumnModel().getColumn(0).setMaxWidth(150);
            tableListManageRoom.getColumnModel().getColumn(1).setMinWidth(150);
            tableListManageRoom.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableListManageRoom.getColumnModel().getColumn(1).setMaxWidth(150);
            tableListManageRoom.getColumnModel().getColumn(2).setMinWidth(150);
            tableListManageRoom.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableListManageRoom.getColumnModel().getColumn(2).setMaxWidth(150);
            tableListManageRoom.getColumnModel().getColumn(3).setMinWidth(100);
            tableListManageRoom.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableListManageRoom.getColumnModel().getColumn(3).setMaxWidth(100);
            tableListManageRoom.getColumnModel().getColumn(4).setMinWidth(150);
            tableListManageRoom.getColumnModel().getColumn(4).setPreferredWidth(150);
            tableListManageRoom.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        jPanel7.setBackground(new java.awt.Color(255, 0, 0));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        // jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("assets/icon/icon_list.png"))); // NOI18N
        jLabel2.setText("List room");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addContainerGap(368, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(353, 353, 353))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2)
                                .addContainerGap()) // ko
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)) // ko
        );

        jTabbedPane1.addTab("Manage room", jPanel1);


        //Detail
        jPanelMain = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtUsernameCustommerDetail = new javax.swing.JTextField();
        lbNameDetailFalse = new javax.swing.JLabel();
        lbCustommerInforDetailFalse = new javax.swing.JLabel();
        lbMailDetailFalse = new javax.swing.JLabel();
        lbPhoneDetailFalse = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRoomInforDetailFalse = new javax.swing.JTable();
        buttonBillDetailFalse = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lbSetPhoneDetailFalse = new javax.swing.JLabel();
        lbSetNameDetailFalse = new javax.swing.JLabel();
        lbSetMailDetailFalse = new javax.swing.JLabel();


        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setPreferredSize(new java.awt.Dimension(952, 540));
        jPanelMain.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(952, 540));

        jLabel8.setBackground(new java.awt.Color(102, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setText("Trung tâm chứng từ:");

        txtUsernameCustommerDetail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbNameDetailFalse.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbNameDetailFalse.setText("Tên:");

        buttonReportCustommerDetail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonReportCustommerDetail.setText("Báo cáo");

        lbCustommerInforDetailFalse.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbCustommerInforDetailFalse.setText("Thông tin khách hàng");

        lbMailDetailFalse.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbMailDetailFalse.setText("Mail:");

        lbPhoneDetailFalse.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbPhoneDetailFalse.setText("SĐT:");

        tableRoomInforDetailFalse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "Tên phòng", "Loại", "Ngày nhận phòng", "Giá phòng"
            }
        ));
        jScrollPane3.setViewportView(tableRoomInforDetailFalse);

        buttonBillDetailFalse.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buttonBillDetailFalse.setText("Xuất hóa đơn");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("Tên khách hàng:");

        lbSetPhoneDetailFalse.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbSetPhoneDetailFalse.setText(" ");

        lbSetNameDetailFalse.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbSetNameDetailFalse.setText(" ");

        lbSetMailDetailFalse.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbSetMailDetailFalse.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUsernameCustommerDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonReportCustommerDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(lbCustommerInforDetailFalse))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMailDetailFalse)
                            .addComponent(lbNameDetailFalse)
                            .addComponent(lbPhoneDetailFalse))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbSetNameDetailFalse, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(lbSetPhoneDetailFalse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbSetMailDetailFalse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(buttonBillDetailFalse, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(jLabel13)
                    .addContainerGap(614, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsernameCustommerDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonReportCustommerDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(lbCustommerInforDetailFalse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbNameDetailFalse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbPhoneDetailFalse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbMailDetailFalse))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbSetNameDetailFalse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbSetPhoneDetailFalse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbSetMailDetailFalse)))
                        .addGap(82, 82, 82)
                        .addComponent(buttonBillDetailFalse, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(111, 111, 111))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addComponent(jLabel13)
                    .addContainerGap(431, Short.MAX_VALUE)))
        );

        jPanelMain.add(jPanel4);
        jPanel4.setBounds(6, -4, 950, 550);

        jTabbedPane1.addTab("Custommer detail", jPanelMain);
        //Deatil

        // // Hoàn
        // thêm tab mới ở đây
        panelManageUser.setBackground(new java.awt.Color(204, 255, 255));
        panelManageUser.setPreferredSize(new java.awt.Dimension(952, 540));
        panelManageUser.setLayout(null);

        lbPhoneManagerUser.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbPhoneManagerUser.setText("SĐT:");
        panelManageUser.add(lbPhoneManagerUser);
        lbPhoneManagerUser.setBounds(101, 119, 48, 32);

        lbTitleManagerUser.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbTitleManagerUser.setText("Thông tin khách hàng");
        panelManageUser.add(lbTitleManagerUser);
        lbTitleManagerUser.setBounds(33, 19, 235, 32);

        lbCustommerNameManagerUser.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbCustommerNameManagerUser.setText("Tên:");
        panelManageUser.add(lbCustommerNameManagerUser);
        lbCustommerNameManagerUser.setBounds(105, 79, 45, 32);
        panelManageUser.add(txtCustommerPhoneManageUser);
        txtCustommerPhoneManageUser.setBounds(167, 125, 190, 30);
        panelManageUser.add(txtCustommerNameManageUser);
        txtCustommerNameManageUser.setBounds(167, 77, 190, 30);

        buttonFindManageUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonFindManageUser.setText("Tìm");
        panelManageUser.add(buttonFindManageUser);
        buttonFindManageUser.setBounds(413, 77, 127, 29);

        lbMailManageUserFlase.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbMailManageUserFlase.setText("mail:");
        panelManageUser.add(lbMailManageUserFlase);
        lbMailManageUserFlase.setBounds(110, 170, 50, 32);
        panelManageUser.add(lbSetMailManageUser);
        lbSetMailManageUser.setBounds(170, 170, 190, 32);

        ButtonCheckOutManageUserFlase.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ButtonCheckOutManageUserFlase.setText("Trả phòng");
        panelManageUser.add(ButtonCheckOutManageUserFlase);
        ButtonCheckOutManageUserFlase.setBounds(410, 130, 127, 29);

        ButtonClearManageUserFalse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ButtonClearManageUserFalse.setText("Làm mới");
        panelManageUser.add(ButtonClearManageUserFalse);
        ButtonClearManageUserFalse.setBounds(550, 80, 127, 27);

        //Thông tin bảng đặt phòng
        tableBookingInformationManageUserFalse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "STT", "Tên phòng", "Loại phòng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableBookingInformationManageUserFalse);
        if (tableBookingInformationManageUserFalse.getColumnModel().getColumnCount() > 0) {
            tableBookingInformationManageUserFalse.getColumnModel().getColumn(0).setMinWidth(50);
            tableBookingInformationManageUserFalse.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableBookingInformationManageUserFalse.getColumnModel().getColumn(0).setMaxWidth(50);
            tableBookingInformationManageUserFalse.getColumnModel().getColumn(1).setMinWidth(125);
            tableBookingInformationManageUserFalse.getColumnModel().getColumn(1).setPreferredWidth(125);
            tableBookingInformationManageUserFalse.getColumnModel().getColumn(1).setMaxWidth(125);
            tableBookingInformationManageUserFalse.getColumnModel().getColumn(2).setMinWidth(125);
            tableBookingInformationManageUserFalse.getColumnModel().getColumn(2).setPreferredWidth(125);
            tableBookingInformationManageUserFalse.getColumnModel().getColumn(2).setMaxWidth(125);
            tableBookingInformationManageUserFalse.getColumnModel().getColumn(3).setMinWidth(100);
            tableBookingInformationManageUserFalse.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableBookingInformationManageUserFalse.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        panelManageUser.add(jScrollPane1);
        jScrollPane1.setBounds(90, 260, 400, 272);

        lbBookingInformationManageUserFlase.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbBookingInformationManageUserFlase.setText("Thông tin đặt phòng");
        panelManageUser.add(lbBookingInformationManageUserFlase);
        lbBookingInformationManageUserFlase.setBounds(90, 220, 200, 32);

        lbRoomInformationManageUserFalse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbRoomInformationManageUserFalse.setText("Thông tin phòng");
        panelManageUser.add(lbRoomInformationManageUserFalse);
        lbRoomInformationManageUserFalse.setBounds(660, 220, 160, 30);

        lbDateInManagerUserFalse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbDateInManagerUserFalse.setText("Thời gian nhận:");
        panelManageUser.add(lbDateInManagerUserFalse);
        lbDateInManagerUserFalse.setBounds(530, 380, 130, 30);

        lbRoomNameManagerUserFalse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbRoomNameManagerUserFalse.setText("Tên:");
        panelManageUser.add(lbRoomNameManagerUserFalse);
        lbRoomNameManagerUserFalse.setBounds(620, 280, 40, 30);

        lbRoomTypeManagerUserFalse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbRoomTypeManagerUserFalse.setText("Loại :");
        panelManageUser.add(lbRoomTypeManagerUserFalse);
        lbRoomTypeManagerUserFalse.setBounds(610, 330, 50, 30);

        lbDateOutManagerUserFalse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbDateOutManagerUserFalse.setText("Thời gian trả:");
        panelManageUser.add(lbDateOutManagerUserFalse);
        lbDateOutManagerUserFalse.setBounds(550, 430, 110, 30);

        ButtonDateInExpiredManageUserFlase.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ButtonDateInExpiredManageUserFlase.setText("Phòng quá hạn Nhận");
        panelManageUser.add(ButtonDateInExpiredManageUserFlase);
        ButtonDateInExpiredManageUserFlase.setBounds(550, 130, 180, 29);

        lbSetDateOutManagerUserFalse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSetDateOutManagerUserFalse.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelManageUser.add(lbSetDateOutManagerUserFalse);
        lbSetDateOutManagerUserFalse.setBounds(670, 430, 190, 30);

        lbSetRoomNameManagerUserFalse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSetRoomNameManagerUserFalse.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelManageUser.add(lbSetRoomNameManagerUserFalse);
        lbSetRoomNameManagerUserFalse.setBounds(670, 280, 190, 30);

        lbSetRoomTypeManagerUserFalse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSetRoomTypeManagerUserFalse.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelManageUser.add(lbSetRoomTypeManagerUserFalse);
        lbSetRoomTypeManagerUserFalse.setBounds(670, 330, 190, 30);

        lbSetDateInManagerUserFalse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSetDateInManagerUserFalse.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelManageUser.add(lbSetDateInManagerUserFalse);
        lbSetDateInManagerUserFalse.setBounds(670, 380, 190, 30);

        jTabbedPane1.addTab("Manger user", panelManageUser);
        //Hoàn - end

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        butonLogOut.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        //     butonLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hotel_manager/Custommer_interface/Icon/log_out_icon.png"))); // NOI18N
        butonLogOut.setText("Log Out");

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        // jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hotel_manager/Custommer_interface/Icon/key_log_out.png"))); // NOI18N
        jLabel10.setText("Log Out");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap(381, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(butonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(377, 377, 377))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(369, 369, 369))))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel10)
                                .addGap(155, 155, 155)
                                .addComponent(butonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(255, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Log Out", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );

        pack();
    }

}


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
    private ManagerService managerService;
    private UserService userService;

    private javax.swing.JButton butonLogOut;

    private javax.swing.JButton buttonReportCustommerDetail;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;


    private javax.swing.JTable tableCustommerDetailFalse;
    private javax.swing.JTable tableListManageRoom;

    private javax.swing.JTextField txtDateCustommerDetail;

    // KhuongPham EDIT
    private DefaultTableModel tableModel1;
    private DefaultTableModel tableModel2;


    public ManagerMenu() {
        managerService = new ManagerService();
        userService = new UserService();
        setLocationRelativeTo(null);
        initComponents();

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
        jScrollPane2 = new javax.swing.JScrollPane();
        tableListManageRoom = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtDateCustommerDetail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        buttonReportCustommerDetail = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCustommerDetailFalse = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        butonLogOut = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

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

        jScrollPane2.setViewportView(tableListManageRoom);
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
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("Manage room", jPanel1);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        jLabel8.setBackground(new java.awt.Color(102, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setText("Trung tâm chứng từ:");

        txtDateCustommerDetail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Nhập tên khách hàng:");

        buttonReportCustommerDetail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonReportCustommerDetail.setText("Báo cáo");

        // Thông tin bảng Detail

        tableModel2 = new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Tên khách hàng", "Số điện thoại", "Tên Phòng", "Loại Phòng", "Ngày nhận phòng", "Ngày trả phòng", "Tổng tiền"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tableCustommerDetailFalse.setModel(tableModel2);
        jScrollPane3.setViewportView(tableCustommerDetailFalse);
        tableCustommerDetailFalse.setVisible(false);
        if (tableCustommerDetailFalse.getColumnModel().getColumnCount() > 0) {
            tableCustommerDetailFalse.getColumnModel().getColumn(0).setMinWidth(175);
            tableCustommerDetailFalse.getColumnModel().getColumn(0).setPreferredWidth(175);
            tableCustommerDetailFalse.getColumnModel().getColumn(0).setMaxWidth(175);
            tableCustommerDetailFalse.getColumnModel().getColumn(1).setMinWidth(125);
            tableCustommerDetailFalse.getColumnModel().getColumn(1).setPreferredWidth(125);
            tableCustommerDetailFalse.getColumnModel().getColumn(1).setMaxWidth(125);
            tableCustommerDetailFalse.getColumnModel().getColumn(2).setMinWidth(100);
            tableCustommerDetailFalse.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableCustommerDetailFalse.getColumnModel().getColumn(2).setMaxWidth(100);
            tableCustommerDetailFalse.getColumnModel().getColumn(3).setMinWidth(150);
            tableCustommerDetailFalse.getColumnModel().getColumn(3).setPreferredWidth(150);
            tableCustommerDetailFalse.getColumnModel().getColumn(3).setMaxWidth(150);
            tableCustommerDetailFalse.getColumnModel().getColumn(4).setMinWidth(150);
            tableCustommerDetailFalse.getColumnModel().getColumn(4).setPreferredWidth(150);
            tableCustommerDetailFalse.getColumnModel().getColumn(4).setMaxWidth(150);
            tableCustommerDetailFalse.getColumnModel().getColumn(5).setMinWidth(100);
            tableCustommerDetailFalse.getColumnModel().getColumn(5).setPreferredWidth(100);
            tableCustommerDetailFalse.getColumnModel().getColumn(5).setMaxWidth(100);
            tableCustommerDetailFalse.getColumnModel().getColumn(6).setMinWidth(150);
            tableCustommerDetailFalse.getColumnModel().getColumn(6).setPreferredWidth(150);
            tableCustommerDetailFalse.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9)
                                                .addGap(21, 21, 21)
                                                .addComponent(txtDateCustommerDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonReportCustommerDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel8)
                                                .addGap(65, 65, 65))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(txtDateCustommerDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(buttonReportCustommerDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(36, 36, 36)))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Custommer detail bill", jPanel4);

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

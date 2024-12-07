

package view.first_screen;

public class Custommer_menu extends javax.swing.JFrame {

    // tab User
    private javax.swing.JTextField txtAgeOfUser;
    private javax.swing.JTextField txtNameOfUser;
    private javax.swing.JTextField txtPhoneOfUser;

    private javax.swing.JButton buttonLogOut; // Nút đăng xuất

    // tab Booked
    private javax.swing.JTextField txtRoomNameBooked;
    private javax.swing.JTextField txtRoomPriceBooked;
    private javax.swing.JTextField txtRoomTypeBooked;

        // Loại phòng
    private javax.swing.JCheckBox checkBoxNormalRoomTypeBooked; // Thường
    private javax.swing.JCheckBox checkBoxVIPRoomTypeBooked; // VIP

    private javax.swing.JTable tableRoomBooked; // Bảng phòng đã đặt

    private javax.swing.JButton buttonRoomCancel; // Nút hủy đặt phòng

    // tab Booking
    private javax.swing.JTextField txtRoomNameBooking;
    private javax.swing.JTextField txtRoomPriceBooking;
    private javax.swing.JTextField txtRoomTypeBooking;

        // Check box 
            // trạng thái
    private javax.swing.JCheckBox checkBoxBookedRoomBooking; //  đã đc đặt
    private javax.swing.JCheckBox checkBoxFreeRoomBooking; // chưa đc đặt

            // Loại phòng
    private javax.swing.JCheckBox checkBoxNormalRoomTypeBooking; // thường
    private javax.swing.JCheckBox checkBoxVIPRoomTypeBooking; // VIP

    private javax.swing.JTable tableRoomBooking; // bảng hiện thị các phòng 

    private javax.swing.JButton buttonRoomBoking; // Nút đặt phòng


    // EVENT
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // Đăng xuất và về màn hình đăng nhập
        LoginScreen lg = new LoginScreen();
        lg.setVisible(true);
        setVisible(false);
    }                                            

    private void checkBoxNormalRoomTypeBookingActionPerformed(java.awt.event.ActionEvent evt) {                                                              
        // TODO add your handling code here:
    }                                                             

    private void checkBoxNormalRoomTypeBookedActionPerformed(java.awt.event.ActionEvent evt) {                                                             
        // TODO add your handling code here:
    }     


    // Khởi tạo đầu
    public Custommer_menu() {
        initComponents();
        buttonRoomCancel.setVisible(false);
    }

     
    // Thiết đề - đừng quan tâm - tôi đang fix lại định dạng của Tab booked
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtRoomNameBooking = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRoomTypeBooking = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRoomPriceBooking = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buttonRoomBoking = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRoomBooking = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        checkBoxVIPRoomTypeBooking = new javax.swing.JCheckBox();
        checkBoxNormalRoomTypeBooking = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        checkBoxFreeRoomBooking = new javax.swing.JCheckBox();
        checkBoxBookedRoomBooking = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtRoomNameBooked = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtRoomTypeBooked = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtRoomPriceBooked = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        buttonRoomCancel = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRoomBooked = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        checkBoxVIPRoomTypeBooked = new javax.swing.JCheckBox();
        checkBoxNormalRoomTypeBooked = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNameOfUser = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPhoneOfUser = new javax.swing.JTextField();
        txtAgeOfUser = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        buttonLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(900, 465));

        jPanel2.setPreferredSize(new java.awt.Dimension(900, 465));

        jPanel6.setBackground(new java.awt.Color(0, 255, 255));
        jPanel6.setForeground(new java.awt.Color(0, 204, 255));

        txtRoomNameBooking.setEditable(false);
        txtRoomNameBooking.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rage Italic", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Room");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("Name:");

        txtRoomTypeBooking.setEditable(false);
        txtRoomTypeBooking.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setText("Type:");

        txtRoomPriceBooking.setEditable(false);
        txtRoomPriceBooking.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setText("Price:");

        buttonRoomBoking.setFont(new java.awt.Font("Segoe Script", 0, 18)); // NOI18N
        buttonRoomBoking.setText("Booking");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtRoomNameBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRoomTypeBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRoomPriceBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(buttonRoomBoking)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRoomNameBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRoomTypeBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRoomPriceBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRoomBoking)
                .addGap(93, 93, 93))
        );

        // Booking tab
        tableRoomBooking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Room's name", "Type", "Stastus", "Price"
            }
        ));
        jScrollPane1.setViewportView(tableRoomBooking);
        if (tableRoomBooking.getColumnModel().getColumnCount() > 0) {
            tableRoomBooking.getColumnModel().getColumn(0).setMinWidth(30);
            tableRoomBooking.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Room's type:");

        checkBoxVIPRoomTypeBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxVIPRoomTypeBooking.setText("VIP");

        checkBoxNormalRoomTypeBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxNormalRoomTypeBooking.setText("Normal");
        checkBoxNormalRoomTypeBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxNormalRoomTypeBookingActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Room's stastus:");

        checkBoxFreeRoomBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxFreeRoomBooking.setText("Free");

        checkBoxBookedRoomBooking.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxBookedRoomBooking.setText("Booked");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(checkBoxVIPRoomTypeBooking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkBoxNormalRoomTypeBooking)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxFreeRoomBooking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxBookedRoomBooking)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(checkBoxFreeRoomBooking)
                    .addComponent(checkBoxBookedRoomBooking)
                    .addComponent(checkBoxVIPRoomTypeBooking)
                    .addComponent(jLabel12)
                    .addComponent(checkBoxNormalRoomTypeBooking))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Booking", jPanel2);

        // Booking tab

        // booked tab

        jPanel3.setPreferredSize(new java.awt.Dimension(900, 500));

        jPanel7.setBackground(new java.awt.Color(0, 255, 255));
        jPanel7.setForeground(new java.awt.Color(0, 204, 255));
        jPanel7.setMinimumSize(new java.awt.Dimension(281, 375));
        jPanel7.setPreferredSize(new java.awt.Dimension(275, 465));
        // jPanel7.setLayout(null);

        txtRoomNameBooked.setEditable(false);
        txtRoomNameBooked.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.add(txtRoomNameBooked, null);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Rage Italic", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Room");
        jPanel7.add(jLabel6, null);

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setText("Name:");
        jPanel7.add(jLabel7, null);

        txtRoomTypeBooked.setEditable(false);
        txtRoomTypeBooked.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.add(txtRoomTypeBooked, null);

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel8.setText("Type:");
        jPanel7.add(jLabel8, null);

        txtRoomPriceBooked.setEditable(false);
        txtRoomPriceBooked.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.add(txtRoomPriceBooked, null);

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel9.setText("Price:");
        jPanel7.add(jLabel9, null);

        buttonRoomCancel.setFont(new java.awt.Font("Segoe Script", 0, 18)); // NOI18N
        buttonRoomCancel.setText("Cancel");
        jPanel7.add(buttonRoomCancel, null);

        tableRoomBooked.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Room's name", "Type", "Stastus", "Price"
            }
        ));
        jScrollPane3.setViewportView(tableRoomBooked);
        if (tableRoomBooked.getColumnModel().getColumnCount() > 0) {
            tableRoomBooked.getColumnModel().getColumn(0).setMinWidth(30);
            tableRoomBooked.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Room's type:");

        checkBoxVIPRoomTypeBooked.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxVIPRoomTypeBooked.setText("VIP");

        checkBoxNormalRoomTypeBooked.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxNormalRoomTypeBooked.setText("Normal");
        checkBoxNormalRoomTypeBooked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxNormalRoomTypeBookedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(checkBoxVIPRoomTypeBooked)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkBoxNormalRoomTypeBooked)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxVIPRoomTypeBooked)
                    .addComponent(jLabel14)
                    .addComponent(checkBoxNormalRoomTypeBooked))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );


        jTabbedPane1.addTab("Room booked", jPanel3);

        // booked tab

        // User tab
        jPanel5.setBackground(new java.awt.Color(0, 204, 255));
        
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name: ");
      

        txtNameOfUser.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Phone:");

        txtPhoneOfUser.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        txtAgeOfUser.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Age:");

        buttonLogOut.setBackground(new java.awt.Color(0, 0, 0));
        buttonLogOut.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buttonLogOut.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogOut.setText("Log out");
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNameOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18)
                            .addComponent(txtAgeOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(277, 277, 277))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPhoneOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(243, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonLogOut)
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNameOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPhoneOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtAgeOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(buttonLogOut)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("User", jPanel5);

        // User tab

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

                                                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Custommer_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Custommer_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Custommer_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Custommer_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Custommer_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;

    // End of variables declaration                   
}

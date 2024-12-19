package view.second_sreen.Manager;

import services.ManagerService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BillScreen extends javax.swing.JFrame {
    private DefaultTableModel tableModel1;

    JPanel panelQR = new JPanel() {
        private Image backgroundImage = new ImageIcon("assets/qr.png").getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Vẽ hình nền
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    };


    public BillScreen() {
        initComponents();
        setLocationRelativeTo(null);
        panelQR.setVisible(false);


        buttonBack.addActionListener(this::backEvent);
        ButtonConfirm.addActionListener(this::submitBillEvent);
    }

    private void backEvent(ActionEvent actionEvent) {
        ManagerMenu managerMenu = new ManagerMenu();
        managerMenu.setVisible(true);
        this.setVisible(false);
    }

    public void setProfile(String name, String sdt, String mail){
        ManagerService managerService = new ManagerService();
        lbSetCustommerName.setText(name);
        lbSetCustommerPhone.setText(sdt);
        lbSetCustommerMail.setText(mail);

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        lbSetDateBill.setText(formattedDate);
        managerService.loadDataForBill(tableModel1, name);

        double total = 0;
        for (int i = 0; i < tableRoomInfor.getRowCount(); i++) {
            Object value = tableRoomInfor.getValueAt(i, 3);
            if (value instanceof Number) {
                total += ((Number) value).doubleValue();
            } else {
                try {
                    total += Double.parseDouble(value.toString());
                } catch (NumberFormatException ex) {
                    System.err.println("Giá trị không hợp lệ: " + value);
                }
            }
        }
        String tt = Double.toString(total);
        lbSetTotal.setText(tt);
    }

    public void submitBillEvent(ActionEvent event) {
        String type = (String) BoxSetPayment.getSelectedItem();
        if(type.equals("Tiền mặt")){
            backEvent(event);
            return;
        }
        panelQR.setVisible(true);

        lbText.setVisible(false);
        lbPayment.setVisible(false);
        lbSetTotal.setVisible(false);
        lbTotal.setVisible(false);
        BoxSetPayment.setVisible(false);
        jScrollPane1.setVisible(false);
    }

    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbTitleBill = new javax.swing.JLabel();
        lbHotelName = new javax.swing.JLabel();

        lbCustommerPhone = new javax.swing.JLabel();
        lbCustommerMail = new javax.swing.JLabel();
        lbSetBillID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRoomInfor = new javax.swing.JTable();
        lbCustommerName = new javax.swing.JLabel();
        lbDateBill = new javax.swing.JLabel();
        lbText = new javax.swing.JLabel();
        lbPayment = new javax.swing.JLabel();
        BoxSetPayment = new javax.swing.JComboBox<>();
        ButtonConfirm = new javax.swing.JButton();
        buttonBack = new javax.swing.JButton();
        lbBillID = new javax.swing.JLabel();
        lbSetCustommerName = new javax.swing.JLabel();
        lbSetCustommerPhone = new javax.swing.JLabel();
        lbSetCustommerMail = new javax.swing.JLabel();
        lbSetDateBill = new javax.swing.JLabel();
        lbSetTotal = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        lbTitleBill.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbTitleBill.setText("Hóa đơn");
        jPanel2.add(lbTitleBill);
        lbTitleBill.setBounds(140, 10, 138, 48);

        lbHotelName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHotelName.setText("Khách sạn HAUI");
        jPanel2.add(lbHotelName);
        lbHotelName.setBounds(30, 60, 110, 20);

        lbCustommerPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCustommerPhone.setText("SĐT:");
        jPanel2.add(lbCustommerPhone);
        lbCustommerPhone.setBounds(30, 150, 35, 20);

        lbCustommerMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCustommerMail.setText("Mail:");
        jPanel2.add(lbCustommerMail);
        lbCustommerMail.setBounds(30, 180, 35, 20);

        lbSetBillID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSetBillID.setText("INV001121");
        jPanel2.add(lbSetBillID);
        lbSetBillID.setBounds(170, 90, 100, 20);

        tableModel1 = new DefaultTableModel(new Object[][]{}, new String[]{"Tên phòng", "Ngày nhận", "Ngày trả", "Giá"}) {
            boolean[] canEdit = new boolean[]{false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        tableRoomInfor.setModel(tableModel1);
        tableRoomInfor.setAutoCreateRowSorter(true);

        jScrollPane1.setViewportView(tableRoomInfor);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 280, 380, 150);

        lbCustommerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCustommerName.setText("Tên khách hàng:");
        jPanel2.add(lbCustommerName);
        lbCustommerName.setBounds(30, 120, 120, 20);

        lbDateBill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDateBill.setText("Ngày lập hóa đơn:");
        jPanel2.add(lbDateBill);
        lbDateBill.setBounds(30, 210, 120, 20);

        lbText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbText.setText("Thông tin chi tiết:");
        jPanel2.add(lbText);
        lbText.setBounds(40, 250, 120, 20);

        lbPayment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPayment.setText("Phương thức thanh toán:");
        jPanel2.add(lbPayment);
        lbPayment.setBounds(10, 490, 160, 30);

        BoxSetPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Tiền mặt", "Chuyển khoản"}));
        BoxSetPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxSetPaymentActionPerformed(evt);
            }
        });
        jPanel2.add(BoxSetPayment);
        BoxSetPayment.setBounds(180, 500, 111, 22);

        ButtonConfirm.setText("Xác nhận");
        jPanel2.add(ButtonConfirm);
        ButtonConfirm.setBounds(220, 560, 110, 40);

        buttonBack.setText("Trở lại");
        jPanel2.add(buttonBack);
        buttonBack.setBounds(60, 560, 110, 40);

        lbBillID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbBillID.setText("Mã hóa đơn:");
        jPanel2.add(lbBillID);
        lbBillID.setBounds(30, 90, 100, 20);

        lbSetCustommerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSetCustommerName.setText(" ");
        jPanel2.add(lbSetCustommerName);
        lbSetCustommerName.setBounds(170, 120, 170, 20);

        lbSetCustommerPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSetCustommerPhone.setText(" ");
        jPanel2.add(lbSetCustommerPhone);
        lbSetCustommerPhone.setBounds(170, 150, 170, 20);

        lbSetCustommerMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSetCustommerMail.setText(" ");
        jPanel2.add(lbSetCustommerMail);
        lbSetCustommerMail.setBounds(170, 180, 160, 20);

        lbSetDateBill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSetDateBill.setText(" ");
        jPanel2.add(lbSetDateBill);
        lbSetDateBill.setBounds(170, 210, 160, 20);

        lbSetTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSetTotal.setText(" ");
        jPanel2.add(lbSetTotal);
        lbSetTotal.setBounds(290, 460, 100, 20);

        lbTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTotal.setText("Tổng:");
        jPanel2.add(lbTotal);
        lbTotal.setBounds(240, 460, 50, 20);

        panelQR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelQR.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout panelQRLayout = new javax.swing.GroupLayout(panelQR);
        panelQR.setLayout(panelQRLayout);
        panelQRLayout.setHorizontalGroup(
                panelQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 298, Short.MAX_VALUE)
        );
        panelQRLayout.setVerticalGroup(
                panelQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 298, Short.MAX_VALUE)
        );

        jPanel2.add(panelQR);
        panelQR.setBounds(50, 240, 300, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoxSetPaymentActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private javax.swing.JComboBox<String> BoxSetPayment;
    private javax.swing.JButton ButtonConfirm;
    private javax.swing.JButton buttonBack;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBillID;
    private javax.swing.JLabel lbCustommerMail;
    private javax.swing.JLabel lbCustommerName;
    private javax.swing.JLabel lbCustommerPhone;
    private javax.swing.JLabel lbDateBill;
    private javax.swing.JLabel lbHotelName;
    private javax.swing.JLabel lbPayment;
    private javax.swing.JLabel lbSetBillID;
    private javax.swing.JLabel lbSetCustommerMail;
    private javax.swing.JLabel lbSetCustommerName;
    private javax.swing.JLabel lbSetCustommerPhone;
    private javax.swing.JLabel lbSetDateBill;
    private javax.swing.JLabel lbSetTotal;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lbTitleBill;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tableRoomInfor;
}

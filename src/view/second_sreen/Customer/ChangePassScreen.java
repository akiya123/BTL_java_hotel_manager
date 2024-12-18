
package view.second_sreen.Customer;

import javax.swing.*;

import models.User;
import services.ChangePassService;
import services.UserService;
import view.first_screen.ForgotPassScreen;
import view.first_screen.LoginScreen;

import java.awt.event.ActionEvent;

public class ChangePassScreen extends javax.swing.JFrame {
    private javax.swing.JPasswordField txtConfrimPass;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JTextField txtOldPass;

    private javax.swing.JButton buttonBackCustommerScreen = new JButton();
    private javax.swing.JButton buttonChangepass = new JButton();

    private CustommerMenu cs;

    private String username;

    public void setUserName(String username) {
        this.username = username;
    }
    public ChangePassScreen() {
        cs = new CustommerMenu();
        buttonChangepass.addActionListener(this::changePassEvent);
        buttonBackCustommerScreen.addActionListener(this::backEvent);
        initComponents();
        //Căn giữa màn hình
        setLocationRelativeTo(null);
    }

    private void backEvent(ActionEvent actionEvent) {
        cs.setProfile(username);
        cs.setVisible(true);
        ChangePassScreen.this.setVisible(false);
    }

    //ENVENT
    private void changePassEvent(ActionEvent e) {
        // Đổi mk
        ChangePassService changePassService = new ChangePassService();
        cs.setProfile(username);
        UserService userService = new UserService();
        String oldPassword = txtOldPass.getText() ;
        String newPassword = txtNewPass.getText();
        String confirmPassword = txtConfrimPass.getText();

        if (oldPassword.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nhập mật khẩu cũ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (newPassword.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nhập mật khẩu mới!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (confirmPassword.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nhập lại mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User curUser = userService.getUserByUserName(username);
        if (changePassService.changePassword(curUser, oldPassword, newPassword, confirmPassword)){
            JOptionPane.showMessageDialog(this, "Đổi thành công!", "", JOptionPane.INFORMATION_MESSAGE);
            cs.setVisible(true);
            ChangePassScreen.this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(this, "Đổi không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtNewPass.setText("");
            txtConfrimPass.setText("");
            txtOldPass.setText("");
        }
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNewPass = new javax.swing.JPasswordField();
        txtConfrimPass = new javax.swing.JPasswordField();
        txtOldPass = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Đổi mật khẩu");

        buttonChangepass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonChangepass.setText("Đổi");

        buttonBackCustommerScreen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonBackCustommerScreen.setText("Quay lại");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Mật khẩu hiện tại: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Xác nhận mật khẩu: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Mật khẩu mới: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonChangepass, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addGap(0, 74, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtConfrimPass, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(buttonBackCustommerScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(256, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(25, 25, 25)
                .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfrimPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(buttonChangepass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(439, Short.MAX_VALUE)
                    .addComponent(buttonBackCustommerScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

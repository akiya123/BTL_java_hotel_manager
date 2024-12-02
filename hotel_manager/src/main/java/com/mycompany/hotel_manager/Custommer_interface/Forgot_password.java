/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hotel_manager.Custommer_interface;

import com.mycompany.hotel_manager.Custommer_interface.Report_Invalid_Case.Invalid_username;
import com.mycompany.hotel_manager.Custommer_interface.Report_Invalid_Case.Password_dont_match;
import com.mycompany.hotel_manager.Custommer_interface.Report_Invalid_Case.successful;

/**
 *
 * @author Administrator
 */
public class Forgot_password extends javax.swing.JFrame {

    public Forgot_password() {
        initComponents();
        buttonChangePasswordCustommer.setVisible(false);
        txtChangePasswordCustommer.setVisible(false);
        txtConfirmChangePasswordCustommer.setVisible(false);
        confirmPassword_dont_use_this.setVisible(false);
        changePassword_dont_use_this.setVisible(false);
        iconChangePassword_dont_use_this.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu_forgotPassword = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        iconUsername_dont_use_this = new javax.swing.JLabel();
        txtFindUsernameCustommer = new javax.swing.JTextField();
        buttonChangePasswordCustommer = new javax.swing.JButton();
        Username_dont_use_this = new javax.swing.JLabel();
        txtChangePasswordCustommer = new javax.swing.JPasswordField();
        txtConfirmChangePasswordCustommer = new javax.swing.JPasswordField();
        confirmPassword_dont_use_this = new javax.swing.JLabel();
        changePassword_dont_use_this = new javax.swing.JLabel();
        iconChangePassword_dont_use_this = new javax.swing.JLabel();
        buttonFindUsernameCustommer = new javax.swing.JButton();
        buttonBackToLogInCustommer = new javax.swing.JButton();
        backGroud = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Forgot password");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu_forgotPassword.setBackground(new java.awt.Color(255, 255, 255));
        Menu_forgotPassword.setForeground(new java.awt.Color(255, 255, 255));
        Menu_forgotPassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText("Password");
        Menu_forgotPassword.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jLabel.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel.setForeground(new java.awt.Color(0, 102, 204));
        jLabel.setText("~");
        Menu_forgotPassword.add(jLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 31));

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Forgot ");
        Menu_forgotPassword.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("~");
        Menu_forgotPassword.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, 18));

        iconUsername_dont_use_this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hotel_manager/image/user_name.png"))); // NOI18N
        Menu_forgotPassword.add(iconUsername_dont_use_this, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 31));

        txtFindUsernameCustommer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindUsernameCustommerActionPerformed(evt);
            }
        });
        Menu_forgotPassword.add(txtFindUsernameCustommer, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 185, 31));

        buttonChangePasswordCustommer.setBackground(new java.awt.Color(51, 204, 255));
        buttonChangePasswordCustommer.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        buttonChangePasswordCustommer.setForeground(new java.awt.Color(255, 255, 255));
        buttonChangePasswordCustommer.setText("Change");
        buttonChangePasswordCustommer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangePasswordCustommerActionPerformed(evt);
            }
        });
        Menu_forgotPassword.add(buttonChangePasswordCustommer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        Username_dont_use_this.setText("Username");
        Menu_forgotPassword.add(Username_dont_use_this, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));
        Menu_forgotPassword.add(txtChangePasswordCustommer, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 190, 30));

        txtConfirmChangePasswordCustommer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmChangePasswordCustommerActionPerformed(evt);
            }
        });
        Menu_forgotPassword.add(txtConfirmChangePasswordCustommer, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 190, 30));

        confirmPassword_dont_use_this.setText("Confirm password");
        Menu_forgotPassword.add(confirmPassword_dont_use_this, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        changePassword_dont_use_this.setText("Change password");
        Menu_forgotPassword.add(changePassword_dont_use_this, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        iconChangePassword_dont_use_this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hotel_manager/image/password_icon.png"))); // NOI18N
        Menu_forgotPassword.add(iconChangePassword_dont_use_this, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        buttonFindUsernameCustommer.setBackground(new java.awt.Color(51, 204, 255));
        buttonFindUsernameCustommer.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        buttonFindUsernameCustommer.setForeground(new java.awt.Color(255, 255, 255));
        buttonFindUsernameCustommer.setText("Find ");
        buttonFindUsernameCustommer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFindUsernameCustommerActionPerformed(evt);
            }
        });
        Menu_forgotPassword.add(buttonFindUsernameCustommer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        buttonBackToLogInCustommer.setBackground(new java.awt.Color(51, 204, 255));
        buttonBackToLogInCustommer.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        buttonBackToLogInCustommer.setForeground(new java.awt.Color(255, 255, 255));
        buttonBackToLogInCustommer.setText("Back");
        buttonBackToLogInCustommer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackToLogInCustommerActionPerformed(evt);
            }
        });
        Menu_forgotPassword.add(buttonBackToLogInCustommer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        getContentPane().add(Menu_forgotPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 290, 360));

        backGroud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hotel_manager/image/back_groud.jpg"))); // NOI18N
        backGroud.setToolTipText("");
        getContentPane().add(backGroud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtConfirmChangePasswordCustommerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmChangePasswordCustommerActionPerformed
        
    }//GEN-LAST:event_txtConfirmChangePasswordCustommerActionPerformed

    private void buttonFindUsernameCustommerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFindUsernameCustommerActionPerformed
        
        // Lấy thông tin Username
        String username = txtFindUsernameCustommer.getText();

  
        
        //So sách với cơ sở dữ liệu xem có Username tương ứng k và xem usnername có rỗng không
        if(username.equals("")){
            Invalid_username iu = new Invalid_username();
            iu.setVisible(true);
        }else{
        // nếu username có trong cơ sở dữ liệu hiện bộ đổi mật khẩu và ẩn bộ tìm username
        buttonChangePasswordCustommer.setVisible(true);
        txtChangePasswordCustommer.setVisible(true);
        txtConfirmChangePasswordCustommer.setVisible(true);
        confirmPassword_dont_use_this.setVisible(true);
        changePassword_dont_use_this.setVisible(true);
        iconChangePassword_dont_use_this.setVisible(true);
        
        txtFindUsernameCustommer.setVisible(false);
        iconUsername_dont_use_this.setVisible(false);
        Username_dont_use_this.setVisible(false);
        buttonFindUsernameCustommer.setVisible(false);
        }
        
        
    }//GEN-LAST:event_buttonFindUsernameCustommerActionPerformed

    private void txtFindUsernameCustommerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindUsernameCustommerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindUsernameCustommerActionPerformed

    private void buttonChangePasswordCustommerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangePasswordCustommerActionPerformed
        // TODO add your handling code here:
        String password = txtChangePasswordCustommer.getText();
        String confirmPassword = txtConfirmChangePasswordCustommer.getText();
        
       
        // Kiểm tra mật khẩu đã trùng khớp hoặc rông không
        if(!password.equals(confirmPassword) || password.equals("") || confirmPassword.equals("")){ 
            txtChangePasswordCustommer.setText("");
            txtConfirmChangePasswordCustommer.setText("");
            Password_dont_match pdm = new Password_dont_match();
            pdm.setVisible(true);
        }else{
            // Nhập tài khoản vào cơ sở dữ liệu
            
            
            
            // Đóng cửa quên mk và thông báo thành công
            setVisible(false);
            successful RS = new successful();
            RS.setVisible(true);
        }
    }//GEN-LAST:event_buttonChangePasswordCustommerActionPerformed

    private void buttonBackToLogInCustommerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackToLogInCustommerActionPerformed
        // đóng cửa sổ Quên mk để về đăng nhập
        setVisible(false);
        Log_in login = new Log_in();
        login.setVisible(true);
    }//GEN-LAST:event_buttonBackToLogInCustommerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Forgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forgot_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forgot_password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu_forgotPassword;
    private javax.swing.JLabel Username_dont_use_this;
    private javax.swing.JLabel backGroud;
    private javax.swing.JButton buttonBackToLogInCustommer;
    private javax.swing.JButton buttonChangePasswordCustommer;
    private javax.swing.JButton buttonFindUsernameCustommer;
    private javax.swing.JLabel changePassword_dont_use_this;
    private javax.swing.JLabel confirmPassword_dont_use_this;
    private javax.swing.JLabel iconChangePassword_dont_use_this;
    private javax.swing.JLabel iconUsername_dont_use_this;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txtChangePasswordCustommer;
    private javax.swing.JPasswordField txtConfirmChangePasswordCustommer;
    private javax.swing.JTextField txtFindUsernameCustommer;
    // End of variables declaration//GEN-END:variables
}

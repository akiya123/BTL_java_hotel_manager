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
public class Sign_up extends javax.swing.JFrame {

    /**
     * Creates new form Sign_up
     */
    public Sign_up() {
        initComponents();
        txtToSignUpUsernameCustommer.setText("");
        txtToSignUpPasswordCustommer.setText("");
        txtConfirmPasswordCustommer.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu_SignUp = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtToSignUpUsernameCustommer = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtToSignUpPasswordCustommer = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonCompleteSignUpCustommer = new javax.swing.JButton();
        txtConfirmPasswordCustommer = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        buttonBackToLogInCustommer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign up");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu_SignUp.setBackground(new java.awt.Color(255, 255, 255));
        Menu_SignUp.setForeground(new java.awt.Color(255, 255, 255));
        Menu_SignUp.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Segoe Script", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText("Sign Up");

        jLabel4.setText("Username");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hotel_manager/image/user_name.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hotel_manager/image/password_icon.png"))); // NOI18N

        jLabel5.setText("Password");

        buttonCompleteSignUpCustommer.setBackground(new java.awt.Color(0, 204, 204));
        buttonCompleteSignUpCustommer.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        buttonCompleteSignUpCustommer.setForeground(new java.awt.Color(255, 255, 255));
        buttonCompleteSignUpCustommer.setText("Sign up");
        buttonCompleteSignUpCustommer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCompleteSignUpCustommerActionPerformed(evt);
            }
        });

        txtConfirmPasswordCustommer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmPasswordCustommerActionPerformed(evt);
            }
        });

        jLabel7.setText("Confirm password");

        buttonBackToLogInCustommer.setBackground(new java.awt.Color(51, 204, 255));
        buttonBackToLogInCustommer.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        buttonBackToLogInCustommer.setForeground(new java.awt.Color(255, 255, 255));
        buttonBackToLogInCustommer.setText("Back");
        buttonBackToLogInCustommer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackToLogInCustommerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Menu_SignUpLayout = new javax.swing.GroupLayout(Menu_SignUp);
        Menu_SignUp.setLayout(Menu_SignUpLayout);
        Menu_SignUpLayout.setHorizontalGroup(
            Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu_SignUpLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu_SignUpLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu_SignUpLayout.createSequentialGroup()
                        .addGroup(Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Menu_SignUpLayout.createSequentialGroup()
                                .addComponent(buttonBackToLogInCustommer)
                                .addGap(27, 27, 27)
                                .addComponent(buttonCompleteSignUpCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtConfirmPasswordCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addGap(36, 36, 36))))
            .addGroup(Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Menu_SignUpLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Menu_SignUpLayout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)))
                        .addGroup(Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtToSignUpUsernameCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Menu_SignUpLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtToSignUpPasswordCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(38, Short.MAX_VALUE)))
        );
        Menu_SignUpLayout.setVerticalGroup(
            Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu_SignUpLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmPasswordCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCompleteSignUpCustommer)
                    .addComponent(buttonBackToLogInCustommer))
                .addGap(30, 30, 30))
            .addGroup(Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Menu_SignUpLayout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtToSignUpUsernameCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(5, 5, 5)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(Menu_SignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtToSignUpPasswordCustommer, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                    .addContainerGap(159, Short.MAX_VALUE)))
        );

        getContentPane().add(Menu_SignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 290, 360));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hotel_manager/image/back_groud.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtConfirmPasswordCustommerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmPasswordCustommerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmPasswordCustommerActionPerformed

    private void buttonCompleteSignUpCustommerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCompleteSignUpCustommerActionPerformed
        // Lấy thông tin đăng ký;
        
        String username = txtToSignUpUsernameCustommer.getText();
        String password = txtToSignUpPasswordCustommer.getText();
        String confirmPassword = txtConfirmPasswordCustommer.getText();
        
        // Kiểm tra Username đã tồn tại hoặc tỗng không
        
        if(username.equals("")){
            Invalid_username iu = new Invalid_username();
            iu.setVisible(true);
        }else{
            
        // Kiểm tra mật khẩu đã trùng khớp hoặc rỗng ko
            if(!password.equals(confirmPassword) || password.equals("") || confirmPassword.equals("") ){ 
                txtToSignUpPasswordCustommer.setText("");
                txtConfirmPasswordCustommer.setText("");
                Password_dont_match pdm = new Password_dont_match();
                pdm.setVisible(true);
            }else{
                // Nhập tài khoản vào cơ sở dữ liệu



                // Đóng cửa sổ đăng ký và thông báo đăng ký thành công
                setVisible(false);
                Custommer_information CI = new Custommer_information();
                CI.setVisible(true);
            }
        }
    }//GEN-LAST:event_buttonCompleteSignUpCustommerActionPerformed

    private void buttonBackToLogInCustommerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackToLogInCustommerActionPerformed
        // đóng cửa sổ đăng ký để về đăng nhập
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
            java.util.logging.Logger.getLogger(Sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sign_up().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu_SignUp;
    private javax.swing.JButton buttonBackToLogInCustommer;
    private javax.swing.JButton buttonCompleteSignUpCustommer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField txtConfirmPasswordCustommer;
    private javax.swing.JPasswordField txtToSignUpPasswordCustommer;
    private javax.swing.JTextField txtToSignUpUsernameCustommer;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admintor
 */
public class Custommer_login_interface extends javax.swing.JFrame {

    /**
     * Creates new form Custommer_login_interface
     */
    public Custommer_login_interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundCustommer = new javax.swing.JPanel();
        logInBackground = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        txtUnsernameCustommer = new javax.swing.JTextField();
        txtPasswordCustommer = new javax.swing.JPasswordField();
        buttonLogInCustommer = new javax.swing.JButton();
        buttonSingUpCustommer = new javax.swing.JButton();
        buttonForgotPasswordCustommer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundCustommer.setBackground(new java.awt.Color(0, 153, 255));

        logInBackground.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));

        jScrollPane1.setBorder(null);
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jTextPane1.setText("Log in");
        jTextPane1.setToolTipText("2");
        jScrollPane1.setViewportView(jTextPane1);

        txtUnsernameCustommer.setText("Username");
        txtUnsernameCustommer.setFocusable(false);

        txtPasswordCustommer.setText("jPasswordField1");
        txtPasswordCustommer.setFocusable(false);

        buttonLogInCustommer.setBackground(new java.awt.Color(204, 204, 204));
        buttonLogInCustommer.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        buttonLogInCustommer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_login.png"))); // NOI18N
        buttonLogInCustommer.setText("Log in");

        buttonSingUpCustommer.setBackground(new java.awt.Color(0, 153, 204));
        buttonSingUpCustommer.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        buttonSingUpCustommer.setForeground(new java.awt.Color(255, 255, 255));
        buttonSingUpCustommer.setText("Sign up");

        buttonForgotPasswordCustommer.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        buttonForgotPasswordCustommer.setForeground(new java.awt.Color(51, 51, 51));
        buttonForgotPasswordCustommer.setText("Forgot password?");

        javax.swing.GroupLayout logInBackgroundLayout = new javax.swing.GroupLayout(logInBackground);
        logInBackground.setLayout(logInBackgroundLayout);
        logInBackgroundLayout.setHorizontalGroup(
            logInBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logInBackgroundLayout.createSequentialGroup()
                .addGroup(logInBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(logInBackgroundLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(logInBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buttonForgotPasswordCustommer)
                            .addComponent(txtUnsernameCustommer, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPasswordCustommer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, logInBackgroundLayout.createSequentialGroup()
                                .addComponent(buttonSingUpCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonLogInCustommer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(logInBackgroundLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        logInBackgroundLayout.setVerticalGroup(
            logInBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logInBackgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(txtUnsernameCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPasswordCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonForgotPasswordCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(logInBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSingUpCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLogInCustommer))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundCustommerLayout = new javax.swing.GroupLayout(backgroundCustommer);
        backgroundCustommer.setLayout(backgroundCustommerLayout);
        backgroundCustommerLayout.setHorizontalGroup(
            backgroundCustommerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundCustommerLayout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(logInBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        backgroundCustommerLayout.setVerticalGroup(
            backgroundCustommerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundCustommerLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(logInBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundCustommer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundCustommer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Custommer_login_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Custommer_login_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Custommer_login_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Custommer_login_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Custommer_login_interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundCustommer;
    private javax.swing.JButton buttonForgotPasswordCustommer;
    private javax.swing.JButton buttonLogInCustommer;
    private javax.swing.JButton buttonSingUpCustommer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JPanel logInBackground;
    private javax.swing.JPasswordField txtPasswordCustommer;
    private javax.swing.JTextField txtUnsernameCustommer;
    // End of variables declaration//GEN-END:variables
}

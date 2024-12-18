package view.first_screen;

import models.User;
import services.ChangePassService;
import services.RegisterService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ForgotPassScreen extends JFrame {
    private JLabel usernameLabel;
    private JLabel usernameIcon;
    private JTextField usernameField;

    private JLabel confirmPasswordLabel;
    private JLabel confirmPasswordIcon;
    private JPasswordField confirmPasswordField;

    private JLabel newPasswordLabel;
    private JLabel newPasswordIcon;
    private JPasswordField newPasswordField;

    private JButton findUserButton;
    private JButton changeButton;
    private JButton backButton;

    private ChangePassService changePassService;


    public ForgotPassScreen() {
        // Tiêu đề chính
        setTitle("Quên mật khẩu");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo panel chính
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Vẽ background
                ImageIcon backgroundImage = new ImageIcon("assets/background.jpg");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(new BorderLayout());

        // Tiêu đề
        JLabel titleLabel = new JLabel("Quên mật khẩu");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa

        // Tạo panel trung tâm chứa các field
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout()); // Dùng GridBagLayout để kiểm soát vị trí chính xác của các thành phần
        formPanel.setOpaque(false); // Đặt trong suốt để hiện thị thằng dưới
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username
        usernameIcon = new JLabel(new ImageIcon("assets/username_icon.png")); // Icon
        usernameLabel = new JLabel("Tài khoản"); // Label
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameField = new JTextField(20); // Text Field
        usernameField.setPreferredSize(new Dimension(180, 30));
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));

        // Hàng 1 cột 0 - Icon
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;  // Chỉ chiếm 1 ô ngang
        usernameIcon.setPreferredSize(new Dimension(20, 20)); // Kích thước icon
        formPanel.add(usernameIcon, gbc);

        // Hàng 0 cột 1 - Label
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Chiếm cả
        formPanel.add(usernameLabel, gbc);

        // Hàng 1 cột 1 - Textfield
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Chỉ chiếm 2 ô ngang để làm rộng cho textField
        formPanel.add(usernameField, gbc);

        // Old Password
        newPasswordIcon = new JLabel(new ImageIcon("assets/password_icon.png")); // Icon
        newPasswordLabel = new JLabel("Mật khẩu mới");
        newPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        newPasswordField = new JPasswordField(20);
        newPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        newPasswordField.setPreferredSize(new Dimension(180, 30));

        // Hàng 3 cột 0
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;  // Chỉ chiếm 1 ô ngang
        newPasswordIcon.setPreferredSize(new Dimension(20, 20)); // Kích thước icon
        formPanel.add(newPasswordIcon, gbc);
        newPasswordIcon.setVisible(false);

        // Hàng 2 cột 1 - Label Password
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        formPanel.add(newPasswordLabel, gbc);
        newPasswordLabel.setVisible(false);

        // Hàng 3 cột 1 - Textfield Password
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Làm rộng textfield password
        formPanel.add(newPasswordField, gbc);
        newPasswordField.setVisible(false);


        // New Password
        confirmPasswordIcon = new JLabel(new ImageIcon("assets/password_icon.png")); // Icon
        confirmPasswordLabel = new JLabel("Xác nhận mật khẩu");
        confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmPasswordField.setPreferredSize(new Dimension(180, 30));

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        formPanel.add(confirmPasswordIcon, gbc);
        confirmPasswordIcon.setVisible(false);

        // Hàng 4 cột 1
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        formPanel.add(confirmPasswordLabel, gbc);
        confirmPasswordLabel.setVisible(false);

        // Hàng 5 cột 1
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        formPanel.add(confirmPasswordField, gbc);
        confirmPasswordField.setVisible(false);

        // Nút Find, back và Change
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout()); // Dùng GridBagLayout để kiểm soát vị trí chính xác của các thành phần
        buttonPanel.setOpaque(false); // Đặt trong suốt để hiện thị thằng dưới
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // margin Ngang 20, dọc 10

        findUserButton = new JButton("Tìm kiếm");
        findUserButton.setBackground(new Color(0, 204, 204));
        findUserButton.setForeground(Color.WHITE);
        findUserButton.setFont(new Font("Arial", Font.BOLD, 14));
        findUserButton.setFocusPainted(false);

        backButton = new JButton("Trở lại");
        backButton.setBackground(Color.green);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setSize(100, 50);
        backButton.setFocusPainted(false);

        changeButton = new JButton("Thay đổi");
        changeButton.setBackground(new Color(0, 204, 204));
        changeButton.setForeground(Color.WHITE);
        changeButton.setFont(new Font("Arial", Font.BOLD, 14));
        changeButton.setSize(100, 50);
        changeButton.setFocusPainted(false);

        buttonPanel.add(findUserButton);
        buttonPanel.add(changeButton);
        buttonPanel.add(backButton);


        changeButton.setVisible(false);

        findUserButton.addActionListener(this::findEvent);
        changeButton.addActionListener(this::forgotPasswordEvent);
        backButton.addActionListener(this::backEvent);


        // Add các thành phần vào mainPanel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add mainPanel vào JFrame
        add(mainPanel);
    }

    private void backEvent(ActionEvent e) {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        ForgotPassScreen.this.setVisible(false);
    }

    User curUser = new User();
    ChangePassService change = new ChangePassService();


    private void findEvent(ActionEvent e) {

        if (change.findUser(usernameField.getText()) != null) {
            usernameIcon.setVisible(false);
            usernameLabel.setVisible(false);
            usernameField.setVisible(false);

            confirmPasswordLabel.setVisible(true);
            confirmPasswordIcon.setVisible(true);
            confirmPasswordField.setVisible(true);

            newPasswordIcon.setVisible(true);
            newPasswordLabel.setVisible(true);
            newPasswordField.setVisible(true);

            changeButton.setVisible(true);
            findUserButton.setVisible(false);

            curUser = change.findUser(usernameField.getText());
        } else JOptionPane.showMessageDialog(ForgotPassScreen.this, "Not Found", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    private void forgotPasswordEvent(ActionEvent e) {
        String confirmPassword = new String(confirmPasswordField.getPassword());
        String newPassword = new String(newPasswordField.getPassword());

        if (confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(ForgotPassScreen.this, "Please enter confirm password.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (newPassword.isEmpty()) {
            JOptionPane.showMessageDialog(ForgotPassScreen.this, "Please enter new password.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (change.forgotPassword(newPassword, confirmPassword, curUser.getUsername())) {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.setVisible(true);
            ForgotPassScreen.this.setVisible(false);
        } else JOptionPane.showMessageDialog(ForgotPassScreen.this, "Error", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}

package view;

import services.LoginService;
import services.RegisterService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpScreen extends JFrame {
    private JLabel usernameLabel;
    private JLabel usernameIcon;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JLabel passwordIcon;
    private JPasswordField passwordField;
    private JLabel confirmPasswordLabel;
    private JPasswordField confirmPasswordField;
    private JButton signUpButton;
    private JButton backButton;
    private RegisterService signUpService;

    public SignUpScreen() {
        signUpService = new RegisterService();
        // Tiêu đề chính
        setTitle("Sign Up");
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
        JLabel titleLabel = new JLabel("Sign up");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
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
        usernameLabel = new JLabel("Username"); // Label
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

        // Password
        passwordIcon = new JLabel(new ImageIcon("assets/password_icon.png")); // Icon
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setPreferredSize(new Dimension(180, 30));

        // Hàng 3 cột 0
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;  // Chỉ chiếm 1 ô ngang
        passwordIcon.setPreferredSize(new Dimension(20, 20)); // Kích thước icon
        formPanel.add(passwordIcon, gbc);

        // Hàng 2 cột 1 - Label Password
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        formPanel.add(passwordLabel, gbc);

        // Hàng 3 cột 1 - Textfield Password
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Làm rộng textfield password
        formPanel.add(passwordField, gbc);


        // Forgot password
        confirmPasswordLabel = new JLabel("Password");
        confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmPasswordField.setPreferredSize(new Dimension(180, 30));

        // Hàng 4 cột 1
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        formPanel.add(confirmPasswordLabel, gbc);

        // Hàng 5 cột 1
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        formPanel.add(confirmPasswordField, gbc);

        // Nút đăng nhập và đăng ký
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout()); // Dùng GridBagLayout để kiểm soát vị trí chính xác của các thành phần
        buttonPanel.setOpaque(false); // Đặt trong suốt để hiện thị thằng dưới
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // margin Ngang 20, dọc 10

        signUpButton = new JButton("Register");
        signUpButton.setBackground(new Color(0, 204, 204));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 14));
        signUpButton.setFocusPainted(false);

        backButton = new JButton("Back");
        backButton.setBackground(Color.green);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setFocusPainted(false);

        buttonPanel.add(signUpButton);
        buttonPanel.add(backButton);

        signUpButton.addActionListener(this::signUpEvent);
        backButton.addActionListener(this::backEvent);

        // Add các thành phần vào mainPanel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add mainPanel vào JFrame
        add(mainPanel);
    }
    private void signUpEvent(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        // Kiểm tra nếu mật khẩu và xác nhận mật khẩu khớp
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(SignUpScreen.this, "Passwords do not match.");
            return;
        }

        // Nếu đăng ký thành công
        if (RegisterService.addUser(username, password)) {
            JOptionPane.showMessageDialog(SignUpScreen.this, "Register Successful!");
            // Quay lại trang đăng nhập
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.setVisible(true);
            SignUpScreen.this.setVisible(false);  // Ẩn màn hình đăng ký
        } else {
            JOptionPane.showMessageDialog(SignUpScreen.this, "Register Failure");
        }
    }

    private void backEvent(ActionEvent e){
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        SignUpScreen.this.setVisible(false);
    }
}

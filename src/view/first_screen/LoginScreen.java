package view.first_screen;

import models.User;
import services.LoginService;
import services.UserService;
import view.second_sreen.CustommerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;
    private LoginService loginService;
    private UserService userService;

    public LoginScreen() {
        loginService = new LoginService();
        userService = new UserService();
        // Tiêu đề chính
        setTitle("Log In");
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
        JLabel titleLabel = new JLabel("Log In");
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
        JLabel usernameIcon = new JLabel(new ImageIcon("assets/username_icon.png")); // Icon
        JLabel usernameLabel = new JLabel("Username"); // Label
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
        JLabel passwordIcon = new JLabel(new ImageIcon("assets/password_icon.png")); // Icon
        JLabel passwordLabel = new JLabel("Password");
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
        JButton forgotPasswordButton = new JButton("Forgot password?");
        forgotPasswordButton.setFont(new Font("Arial", Font.ITALIC, 12));
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setForeground(Color.BLUE);
        // Sự kiện khi di chuột vaào
        forgotPasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        formPanel.add(forgotPasswordButton, gbc);

        // Nút đăng nhập và đăng ký
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout()); // Dùng GridBagLayout để kiểm soát vị trí chính xác của các thành phần
        buttonPanel.setOpaque(false); // Đặt trong suốt để hiện thị thằng dưới
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // margin Ngang 20, dọc 10

        signUpButton = new JButton("Sign up");
        signUpButton.setBackground(new Color(0, 204, 204));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 14));
        signUpButton.setFocusPainted(false);

        loginButton = new JButton("Log in");
        loginButton.setBackground(Color.GRAY);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setFocusPainted(false);

        buttonPanel.add(signUpButton);
        buttonPanel.add(loginButton);

        loginButton.addActionListener(this::loginEvent);
        signUpButton.addActionListener(this::signUpEvent);
        forgotPasswordButton.addActionListener(this::forgotPassEvent);

        // Add các thành phần vào mainPanel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add mainPanel vào JFrame
        add(mainPanel);
    }

    // Sự kiện khi người dùng click vào nút đăng nhập
    private void loginEvent(ActionEvent e) {
        CustommerMenu cs = new CustommerMenu();

        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if (loginService.authenticate(username, password)) {
            cs.setProfile(username);
            if (userService.getRoleByUserName(username).equals("User")) {
                cs.setVisible(true);
                LoginScreen.this.setVisible(false);
            }
            else {
                System.out.println("cehck");
            }
        } else {
            JOptionPane.showMessageDialog(LoginScreen.this, "Invalid username or password.");
        }
    }


    private void signUpEvent(ActionEvent e) {
        SignUpScreen signUpScreen = new SignUpScreen();
        signUpScreen.setVisible(true);
        LoginScreen.this.setVisible(false);
    }

    private void forgotPassEvent(ActionEvent e) {
        ForgotPassScreen forgotPassScreen = new ForgotPassScreen();
        forgotPassScreen.setVisible(true);
        LoginScreen.this.setVisible(false);
    }

}

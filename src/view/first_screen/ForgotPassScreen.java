package view.first_screen;

import services.ChangePassService;
import services.RegisterService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ForgotPassScreen extends JFrame {
    private JLabel usernameLabel;
    private JLabel usernameIcon;
    private JTextField usernameField;

    private JLabel oldPasswordLabel;
    private JLabel oldPasswordIcon;
    private JPasswordField oldPasswordField;

    private JLabel newPasswordLabel;
    private JLabel newPasswordIcon;
    private JPasswordField newPasswordField;

    private JButton findUserButton;
    private JButton changeButton;
    private JButton backButton;

    private ChangePassService changePassService;

    public ForgotPassScreen() {
        // Tiêu đề chính
        setTitle("Forget Password");
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
        JLabel titleLabel = new JLabel("Forgot Password");
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

        // Old Password
        oldPasswordIcon = new JLabel(new ImageIcon("assets/password_icon.png")); // Icon
        oldPasswordLabel = new JLabel("Old Password");
        oldPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        oldPasswordField = new JPasswordField(20);
        oldPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        oldPasswordField.setPreferredSize(new Dimension(180, 30));

        // Hàng 3 cột 0
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;  // Chỉ chiếm 1 ô ngang
        oldPasswordIcon.setPreferredSize(new Dimension(20, 20)); // Kích thước icon
        formPanel.add(oldPasswordIcon, gbc);
        oldPasswordIcon.setVisible(false);

        // Hàng 2 cột 1 - Label Password
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        formPanel.add(oldPasswordLabel, gbc);
        oldPasswordLabel.setVisible(false);

        // Hàng 3 cột 1 - Textfield Password
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Làm rộng textfield password
        formPanel.add(oldPasswordField, gbc);
        oldPasswordField.setVisible(false);


        // New Password
        newPasswordIcon = new JLabel(new ImageIcon("assets/password_icon.png")); // Icon
        newPasswordLabel = new JLabel("New Password");
        newPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        newPasswordField = new JPasswordField(20);
        newPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        newPasswordField.setPreferredSize(new Dimension(180, 30));

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        formPanel.add(newPasswordIcon, gbc);
        newPasswordIcon.setVisible(false);

        // Hàng 4 cột 1
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        formPanel.add(newPasswordLabel, gbc);
        newPasswordLabel.setVisible(false);

        // Hàng 5 cột 1
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        formPanel.add(newPasswordField, gbc);
        newPasswordField.setVisible(false);

        // Nút Find, back và Change
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout()); // Dùng GridBagLayout để kiểm soát vị trí chính xác của các thành phần
        buttonPanel.setOpaque(false); // Đặt trong suốt để hiện thị thằng dưới
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // margin Ngang 20, dọc 10

        findUserButton = new JButton("Find");
        findUserButton.setBackground(new Color(0, 204, 204));
        findUserButton.setForeground(Color.WHITE);
        findUserButton.setFont(new Font("Arial", Font.BOLD, 14));
        findUserButton.setFocusPainted(false);

        backButton = new JButton("Back");
        backButton.setBackground(Color.green);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setFocusPainted(false);

        buttonPanel.add(findUserButton);
        buttonPanel.add(backButton);

        findUserButton.addActionListener(this::findEvent);
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

    private void findEvent(ActionEvent e) {
        ChangePassService change = new ChangePassService();
        if (change.findUser(usernameField.getText()) != null){
            usernameIcon.setVisible(false);
            usernameLabel.setVisible(false);
            usernameField.setVisible(false);

            oldPasswordIcon.setVisible(true);
            oldPasswordLabel.setVisible(true);
            oldPasswordField.setVisible(true);

            newPasswordIcon.setVisible(true);
            newPasswordLabel.setVisible(true);
            newPasswordField.setVisible(true);
        }
        else  JOptionPane.showMessageDialog(ForgotPassScreen.this, "Not Found");
    }
}

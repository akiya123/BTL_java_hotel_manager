
package view.second_sreen.Manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CheckinDisplay extends JFrame {
     private JLabel nameJLabel, mobileNumberJLabel, emailJLabel, checkInDateJLabel,
            roomTypeJLabel;
    private JButton checkJButton;
    private JTextField nameJTextField, mobileNumberJTextField, emailJTextField, checkInDateJTextField,reNameJTextField,reMobileNumberJTextField;
    private JComboBox<String> roomTypeJComboBox;
    private JPanel mainJPanel;

    public JPanel inforJPanel() {
        JPanel inforJPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        reNameJTextField= new JTextField(nameJTextField.getText());
        reNameJTextField.setColumns(15);
        reMobileNumberJTextField= new JTextField(mobileNumberJTextField.getText());
        reMobileNumberJTextField.setColumns(15);
        gbc.gridx = 0; gbc.gridy = 0; // Vị trí hàng 0 cột 0
            inforJPanel.add(new JLabel("Name: "), gbc);
        gbc.gridx = 1; gbc.gridy = 0; // Hàng 0 cột 1
            inforJPanel.add(reNameJTextField, gbc);
            gbc.gridx = 0; gbc.gridy = 1; // Hàng 1 cột 1
            inforJPanel.add(new JLabel("Mobile Number: "), gbc);
            gbc.gridx = 1; gbc.gridy = 1; // Hàng 0 cột 1
            inforJPanel.add(reMobileNumberJTextField, gbc);
        emailJLabel= new JLabel("Email: ");
        emailJTextField= new JTextField(15);
            gbc.gridx = 2; gbc.gridy = 0; // Hàng 2 cột 0
            inforJPanel.add(emailJLabel, gbc);
            gbc.gridx = 3; gbc.gridy = 0; // Hàng 3 cột 1
            inforJPanel.add(emailJTextField, gbc);
        checkInDateJLabel= new JLabel("Date Check In: ");
        checkInDateJTextField= new JTextField(15);
            gbc.gridx = 2; gbc.gridy = 1; // Hàng 2 cột 1
            inforJPanel.add(checkInDateJLabel, gbc);
            gbc.gridx = 3; gbc.gridy = 1; // Hàng 3 cột 1
            inforJPanel.add(checkInDateJTextField, gbc);
        roomTypeJLabel= new JLabel("Room Type: ");
        roomTypeJComboBox= new JComboBox<>(new String []{"VIP","Nomal"});
            gbc.gridx = 4; gbc.gridy = 0; // Hàng 4 cột 0
            inforJPanel.add(roomTypeJLabel, gbc);
            gbc.gridx = 5; gbc.gridy = 0; // Hàng 5 cột 0
            inforJPanel.add(roomTypeJComboBox, gbc);

        return inforJPanel;
    }

    public JPanel createCheckInPanel() {
       mainJPanel= new JPanel();
       mainJPanel.setBackground(new Color(173, 216, 230)); // Light blue background

        // Header Label with Icon
        JLabel lbCheckOutIcon = new JLabel("Customer Check In", new ImageIcon("D:\\path_to_icon\\checkout_icon.png"), JLabel.LEFT);
        lbCheckOutIcon.setBounds(10, 10, 250, 40);
        lbCheckOutIcon.setFont(new Font("Arial", Font.BOLD, 18));
        mainJPanel.add(lbCheckOutIcon);
        mainJPanel.setLayout(new BorderLayout());
        
        
        JPanel northJPanel= new JPanel(new GridBagLayout());
        northJPanel.setBackground(new Color(173, 216, 230)); // Light blue background
         GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Name Customer
        nameJLabel = new JLabel("Name Customer: ");
        nameJTextField = new JTextField(15);
                gbc.gridx = 0; gbc.gridy = 0;
        northJPanel.add(nameJLabel, gbc);
                gbc.gridx = 1; gbc.gridy = 0;
        northJPanel.add(nameJTextField, gbc);

        // Mobile Phone Number
        mobileNumberJLabel = new JLabel("Mobile Phone Number: ");
        mobileNumberJTextField = new JTextField(15);
            gbc.gridx = 0; gbc.gridy = 1;
        northJPanel.add(mobileNumberJLabel, gbc);
            gbc.gridx = 1; gbc.gridy = 1;
        northJPanel.add(mobileNumberJTextField, gbc);

        // Check Button
        checkJButton = new JButton("Check");
            gbc.gridx = 2; gbc.gridy = 0;
            gbc.gridwidth = 2; // Chiếm 2 cột
        northJPanel.add(checkJButton, gbc);
            checkJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                mainJPanel.add(inforJPanel(),BorderLayout.CENTER);
                // Cập nhật giao diện
                mainJPanel.revalidate();
                mainJPanel.repaint();
            }
        });
        

        mainJPanel.add(northJPanel,BorderLayout.NORTH);
//        mainJPanel.add(inforJPanel(),BorderLayout.CENTER);
        //------------------------------------------------
       
        
        return mainJPanel;
    }
    
        
}

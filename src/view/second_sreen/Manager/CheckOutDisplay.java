
package view.second_sreen.Manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CheckOutDisplay {
    
    private JTextField nameJTextField, mobileNumberJTextField,reNameJTextField,reMobileNumberJTextField,
            totalJTextField,checkInDateJTextField,numberDayStayJTextField,checkOutJTextField,
            pricePerDayJTextField,emailJTextField;
    private JButton checkJButton,checkOutJButton,clearJButton;
    private JPanel mainJPanel;
    private DefaultTableModel tableModel1;
    
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
        gbc.gridx = 0; gbc.gridy = 1; // Hàng 0 cột 1
            inforJPanel.add(reNameJTextField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; // Hàng 0 cột 3
            inforJPanel.add(new JLabel("Mobile Number: "), gbc);
        gbc.gridx = 0; gbc.gridy = 3; // Hàng 0 cột 1
            inforJPanel.add(reMobileNumberJTextField, gbc);
        gbc.gridx = 0; gbc.gridy = 4; // Hàng 2 cột 0
            inforJPanel.add(new JLabel("Total: "), gbc);
        gbc.gridx = 0; gbc.gridy = 5; // Hàng 0 cột 6
            totalJTextField= new JTextField(15);
            inforJPanel.add(totalJTextField, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
            inforJPanel.add(new JLabel("Check In Date: "), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
            checkInDateJTextField= new JTextField(15);
            inforJPanel.add(checkInDateJTextField, gbc); 
        gbc.gridx = 1; gbc.gridy = 2;
            inforJPanel.add(new JLabel("Number Of Day Stays: "), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
            numberDayStayJTextField= new JTextField(15);
            inforJPanel.add(numberDayStayJTextField, gbc);
        gbc.gridx = 1; gbc.gridy = 4;
            inforJPanel.add(new JLabel("Check Out Date: "), gbc);
        gbc.gridx = 1; gbc.gridy = 5;
            checkOutJTextField= new JTextField(15);
            inforJPanel.add(checkOutJTextField, gbc);
        gbc.gridx = 2; gbc.gridy = 0;
            inforJPanel.add(new JLabel("Price Per day:  "), gbc);
        gbc.gridx = 2; gbc.gridy = 1;
            pricePerDayJTextField= new JTextField(15);
            inforJPanel.add(pricePerDayJTextField, gbc);
        gbc.gridx = 2; gbc.gridy = 2;
            inforJPanel.add(new JLabel("Email: "), gbc);
        gbc.gridx = 2; gbc.gridy = 3;
            emailJTextField= new JTextField(15);
            inforJPanel.add(emailJTextField, gbc);
        gbc.gridx = 2; gbc.gridy = 4;
            checkOutJButton= new JButton("Check Out");
            inforJPanel.add(checkOutJButton, gbc);
        gbc.gridx = 2; gbc.gridy = 5;
            clearJButton= new JButton("Clear");
            inforJPanel.add(clearJButton, gbc);
        // Tạo dữ liệu bảng
         tableModel1= new DefaultTableModel(
            new Object[][]{},
            new String[]{ "Tên khách hàng","Số điện thoại","Email","Tên Phòng","Ngày Check In","Ngày Check Out" ,"Loại phòng", "Tổng Tiền"}
         ){
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false,false, false, false, false, false
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
         };
         
        
        //Tao bang
        JTable table= new JTable(tableModel1);
        JScrollPane scrollpane = new JScrollPane(table);
        table.setAutoCreateRowSorter(true);
         gbc.gridx = 0; // Cột 0
        gbc.gridy = 6; // Hàng 0
        gbc.gridwidth = 5; // Chiếm 2 cột
        gbc.gridheight = 1; // Chiếm 1 hàng
        gbc.fill = GridBagConstraints.BOTH; // Kéo giãn cả chiều rộng và chiều cao
        gbc.weightx = 1; // Trọng số theo chiều ngang
        gbc.weighty = 1; // Trọng số theo chiều dọc
        gbc.insets = new Insets(2, 2, 2, 2); // Khoảng cách giữa các thành phần
            inforJPanel.add(scrollpane, gbc);
        return inforJPanel;
    }
    public JPanel createCustomerCheckOutPanel() {
        

      mainJPanel= new JPanel();
       mainJPanel.setBackground(new Color(173, 216, 230)); // Light blue background

        // Header Label with Icon
        JLabel lbCheckOutIcon = new JLabel("Customer Check Out", new ImageIcon("D:\\path_to_icon\\checkout_icon.png"), JLabel.LEFT);
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
        nameJTextField = new JTextField(15);
                gbc.gridx = 0; gbc.gridy = 0;
        northJPanel.add(new JLabel("Name Customer: "), gbc);
                gbc.gridx = 1; gbc.gridy = 0;
        northJPanel.add(nameJTextField, gbc);

        // Mobile Phone Number
        mobileNumberJTextField = new JTextField(15);
            gbc.gridx = 0; gbc.gridy = 1;
        northJPanel.add(new JLabel("Mobile Phone Number: "), gbc);
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

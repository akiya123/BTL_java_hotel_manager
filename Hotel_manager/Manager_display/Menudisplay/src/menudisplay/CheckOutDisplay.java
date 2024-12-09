/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menudisplay;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author datvi
 */
public class CheckOutDisplay {
    private int y=10;
    public void setBoundsForComponents(JLabel label, JComponent component, int x) {
        label.setBounds(x, y, 100, 30);
        component.setBounds(x + 120, y, 100, 30);
        y += 50;
    }

    public JPanel createCustomerCheckOutPanel() {
        

        // Customer Check Out Panel
        JPanel checkOutPanel = new JPanel(null); // Absolute layout
        checkOutPanel.setBackground(new Color(173, 216, 230)); // Light blue background

        // Header Label with Icon
        JLabel lbCheckOutIcon = new JLabel("Customer Check Out", new ImageIcon("D:\\path_to_icon\\checkout_icon.png"), JLabel.LEFT);
        lbCheckOutIcon.setBounds(10, 10, 250, 40);
        lbCheckOutIcon.setFont(new Font("Arial", Font.BOLD, 18));
        checkOutPanel.add(lbCheckOutIcon);

        // Input Fields
        y = 50; // Reset y position
        int x = 70;

        JLabel lbRoom = new JLabel("Room:");
        JTextField tfRoom = new JTextField();
        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(x + 330, y, 80, 30);
        lbRoom.setBounds(x, y, 150, 30);
        tfRoom.setBounds(x + 170, y, 150, 30);
        y += 50;

        checkOutPanel.add(lbRoom);
        checkOutPanel.add(tfRoom);
        checkOutPanel.add(btnSearch);

        // More Input Fields
        x=30;
        y=100;
        JLabel lbCustomerName = new JLabel("Customer Name:");
        JTextField tfCustomerName = new JTextField();
        setBoundsForComponents(lbCustomerName, tfCustomerName, x);

        JLabel lbCheckInDate = new JLabel("Check In Date:");
        JTextField tfCheckInDate = new JTextField();
        setBoundsForComponents(lbCheckInDate, tfCheckInDate, x);
        
        
        JLabel lbPricePerDay = new JLabel("Price Per Day:");
        JTextField tfPricePerDay = new JTextField();
        setBoundsForComponents(lbPricePerDay, tfPricePerDay, x );
        
//-----------------------------------------------------------------------------
        x=260;
        y=100;
        JLabel lbCustomerMobile = new JLabel("Customer Mobile Number:");
        JTextField tfCustomerMobile = new JTextField();
        setBoundsForComponents(lbCustomerMobile, tfCustomerMobile, x);

        JLabel lbDaysStay = new JLabel("Number of Day Stay:");
        JTextField tfDaysStay = new JTextField();
        setBoundsForComponents(lbDaysStay, tfDaysStay, x );

        JLabel lbEmail = new JLabel("Email:");
        JTextField tfEmail = new JTextField();
        setBoundsForComponents(lbEmail, tfEmail, x);
//--------------------------------------------------------------------------------

        x=490;
        y=100;
        JLabel lbTotal = new JLabel("Total:");
        JTextField tfTotal = new JTextField();
        setBoundsForComponents(lbTotal, tfTotal, x );

        JLabel lbCheckOutDate = new JLabel("Check Out Date:");
        JTextField tfCheckOutDate = new JTextField();
        setBoundsForComponents(lbCheckOutDate, tfCheckOutDate, x);

        // Buttons
        JButton btnCheckOut = new JButton("Check Out");
        btnCheckOut.setBounds(490, y, 100, 30);
        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(600, y, 100, 30);

        checkOutPanel.add(btnCheckOut);
        checkOutPanel.add(btnClear);
        checkOutPanel.add(lbCustomerName);
        checkOutPanel.add(tfCustomerName);
        checkOutPanel.add(lbCheckInDate);
        checkOutPanel.add(tfCheckInDate);
        checkOutPanel.add(lbPricePerDay);
        checkOutPanel.add(tfPricePerDay);
        checkOutPanel.add(lbCustomerMobile);
        checkOutPanel.add(tfCustomerMobile);
        checkOutPanel.add(lbDaysStay);
        checkOutPanel.add(tfDaysStay);
        checkOutPanel.add(lbTotal);
        checkOutPanel.add(tfTotal);
        checkOutPanel.add(lbEmail);
        checkOutPanel.add(tfEmail);
        checkOutPanel.add(lbCheckOutDate);
        checkOutPanel.add(tfCheckOutDate);

        // Bottom Table (White Area)
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBounds(20, y + 50, 750, 200);
        JTable table = new JTable(new DefaultTableModel(new Object[][]{}, new Object[]{"Room", "Customer", "Check In", "Check Out", "Total"}));
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        checkOutPanel.add(tablePanel);

        // Add Panels to Frame
        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.add(checkOutPanel);

        return mainPanel;
    }

}

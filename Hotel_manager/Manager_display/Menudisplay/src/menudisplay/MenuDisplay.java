/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menudisplay;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author datvi
 */
public class MenuDisplay extends JFrame {
        public MenuDisplay() {
        setTitle("Hotel Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        
        JPanel manageRoomPanel = new ManageDisplay().pnManagerDisplay();
        tabbedPane.addTab("Manage Room", manageRoomPanel);
        // Thêm panel vào tab
        JPanel customerCheckInPanel= new CheckinDisplay().CreatCheckInPanel();
        tabbedPane.addTab("Customer Check In", customerCheckInPanel);

        // Các tab khác (ví dụ: Manage Room)
       
        

        JPanel customerCheckOutPanel = new CheckOutDisplay().createCustomerCheckOutPanel();
        tabbedPane.addTab("Customer Check Out", customerCheckOutPanel);

        JPanel customerDetailBillPanel = new JPanel();
        customerDetailBillPanel.add(new JLabel("Customer Detail Bill Content Here"));
        tabbedPane.addTab("Customer Detail Bill", customerDetailBillPanel);

        JPanel roomServicePanel = new ServiceDisplay().createRoomServicePanel();
        
        tabbedPane.addTab("Room Service", roomServicePanel);

        // Thêm TabbedPane vào JFrame
        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuDisplay::new);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menudisplay;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author datvi
 */
public class ServiceDisplay extends JFrame{
     private int y = 70;

    public void setBoundsForComponents(JLabel label, JComponent component, int x) {
        label.setBounds(x, y, 100, 30);
        component.setBounds(x + 110, y, 150, 30);
        y += 50;
    }

    public JPanel createRoomServicePanel() {
        setLayout(new BorderLayout());


        // Room Service Panel
        JPanel roomServicePanel = new JPanel(null); // Absolute layout
        roomServicePanel.setBackground(new Color(173, 216, 230));

        JLabel lbRoomServiceIcon = new JLabel("Room Service", new ImageIcon("D:\\path_to_icon\\room_service.png"), JLabel.LEFT);
        lbRoomServiceIcon.setBounds(10, 10, 200, 40);
        lbRoomServiceIcon.setFont(new Font("Arial", Font.BOLD, 18));
        roomServicePanel.add(lbRoomServiceIcon);

        // Input Fields
        y = 70;
        int x = 50;

        JLabel lbRoom = new JLabel("Room:");
        JComboBox<String> cbRoom = new JComboBox<>(new String[]{"Room 1", "Room 2", "Room 3"});
        setBoundsForComponents(lbRoom, cbRoom, x);

        JLabel lbService = new JLabel("Service:");
        JComboBox<String> cbService = new JComboBox<>(new String[]{"Cleaning", "Food", "Laundry"});
        setBoundsForComponents(lbService, cbService, x);
        
        JLabel lbStatus = new JLabel("Room Status:");
        JTextField tfStatus = new JTextField();
        setBoundsForComponents(lbStatus, tfStatus, x);
        
        y=70;
        JLabel lbPrice = new JLabel("Price Per Service:");
        JTextField tfPrice = new JTextField();
        setBoundsForComponents(lbPrice, tfPrice, x +300);

        

        JLabel lbQuantity = new JLabel("Quantity:");
        JComboBox<Integer> cbQuantity = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        setBoundsForComponents(lbQuantity, cbQuantity, x + 300);

        JLabel lbTotal = new JLabel("Total:");
        JTextField tfTotal = new JTextField();
        setBoundsForComponents(lbTotal, tfTotal, x + 300);

        roomServicePanel.add(lbRoom);
        roomServicePanel.add(cbRoom);
        roomServicePanel.add(lbService);
        roomServicePanel.add(cbService);
        roomServicePanel.add(lbPrice);
        roomServicePanel.add(tfPrice);
        roomServicePanel.add(lbStatus);
        roomServicePanel.add(tfStatus);
        roomServicePanel.add(lbQuantity);
        roomServicePanel.add(cbQuantity);
        roomServicePanel.add(lbTotal);
        roomServicePanel.add(tfTotal);

        // Buttons
        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(200, 250, 80, 30);
        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(300, 250, 80, 30);

        roomServicePanel.add(btnConfirm);
        roomServicePanel.add(btnClear);

        // Bottom Table (White Area)
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBounds(20, 300, 700, 200);
        JTable table = new JTable(new DefaultTableModel(new Object[][]{}, new Object[]{"Room", "Service", "Quantity", "Total"}));
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        roomServicePanel.add(tablePanel);

        // Add to main frame
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(roomServicePanel, BorderLayout.CENTER);

        return mainPanel;
    }

    public ServiceDisplay() throws HeadlessException {
        setTitle("Room Service Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(createRoomServicePanel());
        setLocationRelativeTo(null);
    }
    
  
}

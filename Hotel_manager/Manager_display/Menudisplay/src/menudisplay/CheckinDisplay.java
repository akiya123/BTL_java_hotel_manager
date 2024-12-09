/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menudisplay;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author datvi
 */
public class CheckinDisplay extends JFrame {
    private JLabel lbCustomerID, lbName,lbMobileNumber,lbEmail,lbCheckInDate,lbCheckOutDate,
            lbRoomNumber,lbRoomType,lbLocation,lbStatus;
    int y= 10;
    public void setBoundsForComponents(JLabel label, JComponent component, int x) {
        label.setBounds(x, y, 100, 30);
        component.setBounds(x + 110, y, 150, 30);
        y += 50;
    }
    
    public JPanel CreatCheckInPanel(){
        JPanel mainPanel= new JPanel();
        mainPanel.setLayout(null);
        int x=50;
        //-----------------------------------
        lbCustomerID= new JLabel("Customer ID: ");
        JTextField tfCustomerID= new JTextField();
        setBoundsForComponents(lbCustomerID, tfCustomerID, x);
        //---------------------------------------
        lbName= new JLabel("Name Customer: ");
        JTextField tfName= new JTextField();
        setBoundsForComponents(lbName, tfName, x);
        //--------------------------------------------
        lbMobileNumber= new JLabel("Mobile Phone Number: ");
        JTextField tfMobileNumber= new JTextField();
        setBoundsForComponents(lbMobileNumber, tfMobileNumber, x);
        //------------------------------------------------
        lbEmail= new JLabel("Email: ");
        JTextField tfEmail= new JTextField();
        setBoundsForComponents(lbEmail, tfEmail, x);
        x+=300;
        y=10;
        //-------------------------------------------------------
        lbCheckInDate= new JLabel("Check In Date: ");
        JTextField tfCheckInDate= new JTextField();
        setBoundsForComponents(lbCheckInDate, tfCheckInDate, x);
        //-------------------------------------------------
        lbCheckOutDate= new JLabel("Check Out Date: ");
        JTextField tfCheckOutDate= new JTextField();
        setBoundsForComponents(lbCheckOutDate, tfCheckOutDate, x);
        //--------------------------------------
        lbRoomNumber= new JLabel("RoomNumber: ");
        JTextField tfRoomNumber= new JTextField();
        setBoundsForComponents(lbRoomNumber, tfRoomNumber, x);
        //-----------------------------------------------------------
        lbRoomType= new JLabel("Room Type: ");
        JComboBox<String> cbRoomType= new JComboBox<>(new String []{"1 bed","2 bed","3 bed"});
        setBoundsForComponents(lbRoomType, cbRoomType, x);
        //-----------------------------------------
        lbLocation= new JLabel("Location Room: ");
        JComboBox<String> cbLocationRoom = new JComboBox<>(new String[]{"Hall A","Hall B","Hall C"});
        setBoundsForComponents(lbLocation, cbLocationRoom, x);
        //------------------------------------------
        lbStatus = new JLabel("Status: ");
        JTextField tfStatus= new JTextField();
        setBoundsForComponents(lbStatus, tfStatus, x);
        
        JButton btAllocate= new JButton("Allocate ");
        btAllocate.setBounds(280, 350, 150, 40);
        
        JButton btClear= new JButton("Clear");
        btClear.setBounds(450, 350, 150, 40);
        
        mainPanel.add(lbCustomerID);
        mainPanel.add(tfCustomerID);
        mainPanel.add(lbName);
        mainPanel.add(tfName);
        mainPanel.add(lbEmail);
        mainPanel.add(tfEmail);
        mainPanel.add(lbMobileNumber);
        mainPanel.add(tfMobileNumber);
        mainPanel.add(lbCheckInDate);
        mainPanel.add(tfCheckInDate);
        mainPanel.add(lbCheckOutDate);
        mainPanel.add(tfCheckOutDate);
        mainPanel.add(lbRoomNumber);
        mainPanel.add(tfRoomNumber);
        mainPanel.add(lbRoomType);
        mainPanel.add(cbRoomType);
        mainPanel.add(lbLocation);
        mainPanel.add(cbLocationRoom);
        mainPanel.add(lbStatus);
        mainPanel.add(tfStatus);
        mainPanel.add(btAllocate);
        mainPanel.add(btClear);
        
        return mainPanel;
    }
    
        public static void main(String[] args) {
        CheckinDisplay ck= new CheckinDisplay();
    }
}

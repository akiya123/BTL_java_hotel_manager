/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menudisplay;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author datvi
 */
public class Menu {
    private JButton btManage,btCheckIn, btCheckOut, btDetaillBill, btService;

     private JButton creatButton(String name, String URL, int x) {
        JButton bt = new JButton(name, new ImageIcon(URL));
        bt.setBounds(x, 150, 170, 50);
        return bt;
    }
     
    public JPanel creatMenu() {
        JPanel menu = new JPanel();
        btManage=creatButton( "Manage", "D:\\\\oopnam1\\\\Menudisplay\\\\src\\\\images\\\\manage room.png",50);
        btCheckIn=creatButton( "Check In", "D:\\\\oopnam1\\\\Menudisplay\\\\src\\\\images\\\\Customer Check Out.png",230);
        btCheckOut=creatButton( "Check OUT", "D:\\\\oopnam1\\\\Menudisplay\\\\src\\\\images\\\\Customer Details Bill.png",410);
        btDetaillBill= creatButton("Details Bill", "D:\\\\oopnam1\\\\Menudisplay\\\\src\\\\images\\\\Customer Details Bill.png", 590);
        btService=creatButton("Service","D:\\\\oopnam1\\\\Menudisplay\\\\src\\\\images\\\\Customer Check Out.png" , 770);
        menu.add(btManage);
        menu.add(btCheckIn);
        menu.add(btCheckOut);
        menu.add(btDetaillBill);
        menu.add(btService);
        menu.setBackground(Color.BLUE);
        return menu;
    }

    public void setBtManage(JButton btManage) {
        this.btManage = btManage;
    }

    public void setBtCheckIn(JButton btCheckIn) {
        this.btCheckIn = btCheckIn;
    }

    public void setBtCheckOut(JButton btCheckOut) {
        this.btCheckOut = btCheckOut;
    }

    public void setBtDetaillBill(JButton btDetaillBill) {
        this.btDetaillBill = btDetaillBill;
    }

    public void setBtService(JButton btService) {
        this.btService = btService;
    }

    public JButton getBtManage() {
        return btManage;
    }

    public JButton getBtCheckIn() {
        return btCheckIn;
    }

    public JButton getBtCheckOut() {
        return btCheckOut;
    }

    public JButton getBtDetaillBill() {
        return btDetaillBill;
    }

    public JButton getBtService() {
        return btService;
    }
    
    
   public void setColor(JButton bt){
       bt.setBackground(Color.red);
   }
    
}

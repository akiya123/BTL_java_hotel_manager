/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menudisplay;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author datvi
 */


public class ManageDisplay extends JFrame {
    private Menu menu= new Menu();
    private int y;
    
    public void setBoundstgt(JLabel label,JTextField textField,int x){
        label.setBounds(x, y, 100, 50);
        textField.setBounds(x+120, y+10, 150, 30);
        this.y+=70;
    }

    public JPanel pnManagerDisplay(){
         setLayout(new BorderLayout());
        //--------------------------set cac nut menu--------------------
        //-------------------------set phan chinh---------------------------
        JPanel pnMain= new JPanel();
         // Tạo dữ liệu bảng
        Object[][] rows = {
                {"phòng 01", "Nguyễn Anh Đạt", "Phòng đơn", "Unavailable"},
                {"phòng 02", "Khương Phạm", "Phòng đôi", "Available"},
                {"phòng 03", "Nguyễn Minh", "Phòng đơn", "Unavailable"},
                {"phòng 04", "Lê Văn A", "Phòng đôi", "Available"},
                {"phòng 01", "Nguyễn Anh Đạt", "Phòng đơn", "Unavailable"},
                {"phòng 02", "Khương Phạm", "Phòng đôi", "Available"},
                {"phòng 03", "Nguyễn Minh", "Phòng đơn", "Unavailable"},
                {"phòng 04", "Lê Văn A", "Phòng đôi", "Available"},
                {"phòng 01", "Nguyễn Anh Đạt", "Phòng đơn", "Unavailable"},
                {"phòng 02", "Khương Phạm", "Phòng đôi", "Available"},
                {"phòng 03", "Nguyễn Minh", "Phòng đơn", "Unavailable"},
                {"phòng 04", "Lê Văn A", "Phòng đôi", "Available"},
                {"phòng 01", "Nguyễn Anh Đạt", "Phòng đơn", "Unavailable"},
                {"phòng 02", "Khương Phạm", "Phòng đôi", "Available"},
                {"phòng 03", "Nguyễn Minh", "Phòng đơn", "Unavailable"},
                {"phòng 04", "Lê Văn A", "Phòng đôi", "Available"}
        };
        Object[] cols = {"Số phòng", "Tên khách hàng", "Loại phòng", "Trạng thái phòng"};
        //Tao bang
        JTable table= new JTable(new DefaultTableModel(rows, cols));
        JScrollPane scrollpane = new JScrollPane(table);
        table.setAutoCreateRowSorter(true);
         //tạo dong chu phia tren
        ImageIcon manage = new ImageIcon("D:\\oopnam1\\Menudisplay\\src\\images\\manage room.png");
        JLabel lbManage = new JLabel("List Room", manage, JLabel.CENTER);
        lbManage.setFont(new Font("Stencil", Font.BOLD, 25));
        
        //--------------set vi tri bang------------------
        JPanel pnTable= new JPanel(new BorderLayout());
        pnTable.add(lbManage,BorderLayout.NORTH);
        pnTable.add(scrollpane,BorderLayout.CENTER);
        pnTable.setBackground(Color.red);
        pnMain.setLayout(new BorderLayout());
      
        pnMain.add(pnTable,BorderLayout.CENTER);
        
        //--------------------xu ly event tren bang-----------------------------------
      
//        //--------------panel lay thong tin--------------------------------------
//        JPanel pnInfor = new JPanel();
//        pnInfor.setBackground(Color.PINK);
//        
//        JLabel lbNumberRoom = new JLabel("Number Room: ");
//        JTextField tfNumberRoom = new JTextField();
//        JLabel lbNameClient = new JLabel("Name Client: ");
//        JTextField tfNameClient = new JTextField();
//        JLabel lbRoomType = new JLabel("Room Type: ");
//        JTextField tfRoomType = new JTextField();
//        JLabel lbStatus = new JLabel("Status: ");
//        JTextField tfStatus = new JTextField();
////------------------- 
//        y= 60;
//        int x=450;
//        setBoundstgt(lbNumberRoom,tfNumberRoom,x);
//        setBoundstgt(lbNameClient, tfNameClient, x);
//        setBoundstgt(lbRoomType, tfRoomType, x);
//        setBoundstgt(lbStatus, tfStatus, x);
//
//        
//        pnMain.add(lbNumberRoom);
//        pnMain.add(tfNumberRoom);
//        pnMain.add(lbNameClient);
//        pnMain.add(tfNameClient);
//        pnMain.add(lbRoomType);
//        pnMain.add(tfRoomType);
//        pnMain.add(lbStatus);
//        pnMain.add(tfStatus);
        return pnMain;
    };
    public ManageDisplay() throws HeadlessException {
        

//        setLayout(new BorderLayout());
//        //--------------------------set cac nut menu--------------------
//        //-------------------------set phan chinh---------------------------
//        Panel pnMain= new Panel();
//         // Tạo dữ liệu bảng
//        Object[][] rows = {
//                {"phòng 01", "Nguyễn Anh Đạt", "Phòng đơn", "Unavailable"},
//                {"phòng 02", "Khương Phạm", "Phòng đôi", "Available"},
//                {"phòng 03", "Nguyễn Minh", "Phòng đơn", "Unavailable"},
//                {"phòng 04", "Lê Văn A", "Phòng đôi", "Available"},
//                {"phòng 01", "Nguyễn Anh Đạt", "Phòng đơn", "Unavailable"},
//                {"phòng 02", "Khương Phạm", "Phòng đôi", "Available"},
//                {"phòng 03", "Nguyễn Minh", "Phòng đơn", "Unavailable"},
//                {"phòng 04", "Lê Văn A", "Phòng đôi", "Available"},
//                {"phòng 01", "Nguyễn Anh Đạt", "Phòng đơn", "Unavailable"},
//                {"phòng 02", "Khương Phạm", "Phòng đôi", "Available"},
//                {"phòng 03", "Nguyễn Minh", "Phòng đơn", "Unavailable"},
//                {"phòng 04", "Lê Văn A", "Phòng đôi", "Available"},
//                {"phòng 01", "Nguyễn Anh Đạt", "Phòng đơn", "Unavailable"},
//                {"phòng 02", "Khương Phạm", "Phòng đôi", "Available"},
//                {"phòng 03", "Nguyễn Minh", "Phòng đơn", "Unavailable"},
//                {"phòng 04", "Lê Văn A", "Phòng đôi", "Available"}
//        };
//        Object[] cols = {"Số phòng", "Tên khách hàng", "Loại phòng", "Trạng thái phòng"};
//        //Tao bang
//        JTable table= new JTable(new DefaultTableModel(rows, cols));
//        JScrollPane scrollpane = new JScrollPane(table);
//        table.setAutoCreateRowSorter(true);
//         //tạo dong chu phia tren
//        ImageIcon manage = new ImageIcon("D:\\oopnam1\\Menudisplay\\src\\images\\manage room.png");
//        JLabel lbManage = new JLabel("List Room", manage, JLabel.CENTER);
//        lbManage.setFont(new Font("Stencil", Font.BOLD, 25));
//        
//        //--------------set vi tri bang------------------
//        JPanel pnTable= new JPanel(new BorderLayout());
//        pnTable.add(lbManage,BorderLayout.NORTH);
//        pnTable.add(scrollpane,BorderLayout.CENTER);
//        pnTable.setBackground(Color.red);
//        pnTable. setBounds(40, 50, 400, 300);
//        pnMain.setLayout(null);
//      
//        pnMain.add(pnTable);
//        
//        add(pnMain, BorderLayout.CENTER);
//        //--------------------xu ly event tren bang-----------------------------------
//      
//        //--------------panel lay thong tin--------------------------------------
//        JPanel pnInfor = new JPanel();
//        pnInfor.setBackground(Color.PINK);
//        
//        JLabel lbNumberRoom = new JLabel("Number Room: ");
//        JTextField tfNumberRoom = new JTextField();
//        JLabel lbNameClient = new JLabel("Name Client: ");
//        JTextField tfNameClient = new JTextField();
//        JLabel lbRoomType = new JLabel("Room Type: ");
//        JTextField tfRoomType = new JTextField();
//        JLabel lbStatus = new JLabel("Status: ");
//        JTextField tfStatus = new JTextField();
////------------------- 
//        y= 60;
//        int x=450;
//        setBoundstgt(lbNumberRoom,tfNumberRoom,x);
//        setBoundstgt(lbNameClient, tfNameClient, x);
//        setBoundstgt(lbRoomType, tfRoomType, x);
//        setBoundstgt(lbStatus, tfStatus, x);
//
//        
//        pnMain.add(lbNumberRoom);
//        pnMain.add(tfNumberRoom);
//        pnMain.add(lbNameClient);
//        pnMain.add(tfNameClient);
//        pnMain.add(lbRoomType);
//        pnMain.add(tfRoomType);
//        pnMain.add(lbStatus);
//        pnMain.add(tfStatus);
//        setVisible(true);
//        setTitle("Check IN");
//        setLocationRelativeTo(null);
//        setSize(780, 500);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        ManageDisplay mn=new ManageDisplay();
    }
}

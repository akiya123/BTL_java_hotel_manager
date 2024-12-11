
package view.second_sreen.Manager;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ManageDisplay extends JFrame {
    private Menu menu= new Menu();
    private int y;
    private DefaultTableModel tableModel1;
    
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
         tableModel1= new DefaultTableModel(
            new Object[][]{},
            new String[]{ "Tên khách hàng","Số điện thoại","Tên Phòng", "Loại phòng", "Trạng thái phòng"}
         ){
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
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
        
        
        return pnMain;
    };
    public ManageDisplay() throws HeadlessException {
        

    }

}


package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

// Importing the package, we can use it to simplify working with the JDBC ResultSet data in Swing applications:
import net.proteanit.sql.DbUtils;



/**
 *
 * @author afraa
 */
public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
    Room(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bedroom.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel pic = new JLabel(i3);
        pic.setBounds(500, 0, 600, 600);
        add(pic);
        
        // Creating the headings for each column
        JLabel roomlabel = new JLabel("Room Number");
        roomlabel.setBounds(10, 10, 100, 20);
        add(roomlabel);
        
        JLabel availlabel = new JLabel("Availability");
        availlabel.setBounds(120, 10, 100, 20);
        add(availlabel);
        
        JLabel cleanstatus = new JLabel("Status");
        cleanstatus.setBounds(230, 10, 100, 20);
        add(cleanstatus);
        
        JLabel price = new JLabel("Price");
        price.setBounds(330, 10, 100, 20);
        add(price);
        
        JLabel bedtype = new JLabel("Bed Type");
        bedtype.setBounds(410, 10, 100, 20);
        add(bedtype);
        
        // Creating a table
        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        // We want to get the room table we have in our database and make it visible in table form within the GUI
        try {
            Conn c = new Conn();
            
            // Note that executeQuery returns ResultSet, whilst executeUpdate returns int 
            ResultSet rs = c.s.executeQuery("select * from room");
            
            // Using the rs2xml package will help us get the data into the JTable
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        // back button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200, 500, 120, 30);
        add(back);
        
        setBounds(300, 300, 1050, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new Room();
    }
}


package hotel.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

// Importing the package, we can use it to simplify working with the JDBC ResultSet data in Swing applications:
import net.proteanit.sql.DbUtils;



/**
 *
 * @author afraa
 */
public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
    CustomerInfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Creating the headings for each column
        JLabel roomlabel = new JLabel("Document Type");
        roomlabel.setBounds(10, 10, 100, 20);
        add(roomlabel);
        
        JLabel availlabel = new JLabel("Number");
        availlabel.setBounds(160, 10, 100, 20);
        add(availlabel);
        
        JLabel cleanstatus = new JLabel("Name");
        cleanstatus.setBounds(290, 10, 100, 20);
        add(cleanstatus);
        
        JLabel price = new JLabel("Gender");
        price.setBounds(410, 10, 100, 20);
        add(price);
        
        JLabel bedtype = new JLabel("Country");
        bedtype.setBounds(540, 10, 100, 20);
        add(bedtype);
        
        JLabel phone = new JLabel("Room Number");
        phone.setBounds(640, 10, 100, 20);
        add(phone);
        
        JLabel email = new JLabel("Checkin Time");
        email.setBounds(760, 10, 100, 20);
        add(email);
        
        JLabel idemployee = new JLabel("Deposit");
        idemployee.setBounds(910, 10, 100, 20);
        add(idemployee);
        
        // Creating a table
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        // We want to get the room table we have in our database and make it visible in table form within the GUI
        try {
            Conn c = new Conn();
            
            // Note that executeQuery returns ResultSet, whilst executeUpdate returns int 
            ResultSet rs = c.s.executeQuery("select * from customer");
            
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
        back.setBounds(420, 500, 120, 30);
        add(back);
        
        setBounds(300, 300, 1000, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new CustomerInfo();
    }
}


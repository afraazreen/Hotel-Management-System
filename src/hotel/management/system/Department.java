
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
public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
    Department(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        
        // Creating the labels for each column
        JLabel departmentlabel = new JLabel("Department");
        departmentlabel.setBounds(180, 10, 100, 20);
        add(departmentlabel);
        
        JLabel budgetlabel = new JLabel("Budget");
        budgetlabel.setBounds(420, 10, 100, 20);
        add(budgetlabel);
        
        
        
        // Creating a table
        table = new JTable();
        table.setBounds(0, 50, 700, 350);
        add(table);
        
        // We want to get the room table we have in our database and make it visible in table form within the GUI
        try {
            Conn c = new Conn();
            
            // Note that executeQuery returns ResultSet, whilst executeUpdate returns int 
            ResultSet rs = c.s.executeQuery("select * from department");
            
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
        back.setBounds(280, 400, 120, 30);
        add(back);
        
        setBounds(400, 200, 700, 480);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new Department();
    }
}

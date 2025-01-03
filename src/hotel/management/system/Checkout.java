
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;


/**
 *
 * @author afraa
 */
public class Checkout extends JFrame implements ActionListener {
    Choice customer;
    JLabel roomNum, checkintime, checkout;
    JButton checkoutbutton, back;
    
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel header = new JLabel("Checkout");
        header.setBounds(100, 20, 100, 30);
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(header);
        
        // Finding which customer wants to checkout via ID:
        JLabel labelid = new JLabel("Checkout");
        labelid.setBounds(30, 80, 100, 30);
        add(labelid);
        
        customer = new Choice();
        customer.setBounds(150, 80, 150, 25);
        add(customer);
        
        
        JLabel labelroom = new JLabel("Room Number");
        labelroom.setBounds(30, 130, 100, 30);
        add(labelroom);
        
        roomNum = new JLabel();
        roomNum.setBounds(150, 130, 100, 30);
        add(roomNum);
        
        JLabel labelcheck = new JLabel("Checkin Time");
        labelcheck.setBounds(30, 180, 100, 30);
        add(labelcheck);
        
        checkintime = new JLabel();
        checkintime.setBounds(150, 180, 100, 30);
        add(checkintime);
        
        // Checkout Time:
        JLabel checkoutlabel = new JLabel("Checkout Time");
        checkoutlabel.setBounds(30, 230, 100, 30);
        add(checkoutlabel);
        
        
        // Extracting the checkout time directly from the system with the help of the Date obj
        Date date = new Date();
        
        // Converting the date obj to string
        checkout = new JLabel(""+ date);
        checkout.setBounds(150, 230, 160, 30);
        add(checkout);
        
        // Creating the buttons.
        checkoutbutton = new JButton("Checkout");
        checkoutbutton.setForeground(Color.WHITE);
        checkoutbutton.setBackground(Color.BLACK);
        checkoutbutton.setBounds(30, 280, 120, 30);
        checkoutbutton.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);
        
          try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while(rs.next()){
                
                // Then filling the fields with the values we extracted.
                customer.add(rs.getString("number"));
                roomNum.setText(rs.getString("room"));
                checkintime.setText(rs.getString("checkintime"));
           
            }
            
            
            
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        
        
        
      
        
        setBounds(300, 200, 800, 400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== checkoutbutton){
            
            // Since the customer is checking out, delete them from the customer table, and set their room to available 
            String query = "delete from customer where number = '"+customer.getSelectedItem()+"'";
            String query2 = "update room set availablity = 'Available' where roomnumber = '"+roomNum.getText()+"'";
            
            try {
                Conn conn = new Conn();
                conn.s.executeQuery(query);
                conn.s.executeQuery(query2);
                
                JOptionPane.showMessageDialog(null, "Checkout Successful");
                setVisible(false);
                new Reception();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            
        }
        else {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new Checkout();
    }
}

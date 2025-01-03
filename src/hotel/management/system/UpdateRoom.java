package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice customer;
    JTextField tfroom, tfavailable, tfclean;
    JButton check, back, update;
    
    UpdateRoom() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Update Room Status");
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        heading.setForeground(Color.BLUE);
        heading.setBounds(30, 20, 250, 25);
        add(heading);
        
        // Customer ID
        JLabel labelid = new JLabel("Customer ID");
        labelid.setBounds(30, 80, 150, 20);
        add(labelid);
        
        customer = new Choice();
        customer.setBounds(200, 80, 150, 25);
        add(customer);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                customer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Room Number
        JLabel labelroom = new JLabel("Room Number");
        labelroom.setBounds(30, 120, 150, 20);
        add(labelroom);  
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        add(tfroom);
        
        // Availability
        JLabel labelavailable = new JLabel("Availability");
        labelavailable.setBounds(30, 160, 150, 20);
        add(labelavailable);  
        
        tfavailable = new JTextField();
        tfavailable.setBounds(200, 160, 150, 25);
        add(tfavailable);
        
        // Cleaning Status
        JLabel labelclean = new JLabel("Cleaning Status");
        labelclean.setBounds(30, 200, 150, 20);
        add(labelclean);  
        
        tfclean = new JTextField();
        tfclean.setBounds(200, 200, 150, 25);
        add(tfclean);
        
        // Buttons
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 260, 100, 30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 260, 100, 30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 260, 100, 30);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 500, 400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = customer.getSelectedItem();
            String query = "select * from customer where number = '" + id + "'";

            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                
                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));
                }
                
                ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber = " + tfroom.getText());
                while (rs2.next()) {
                    tfavailable.setText(rs2.getString("availability"));
                    tfclean.setText(rs2.getString("cleaning_status"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String num = customer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String clean = tfclean.getText();
            
            try {
                Conn conn = new Conn();
                conn.s.executeUpdate("update room set availability = '" + available + "', cleaning_status = '" + clean + "' where roomnumber = '" + room + "'"); 
                
                JOptionPane.showMessageDialog(null, "Data updated successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateRoom();
    }
}

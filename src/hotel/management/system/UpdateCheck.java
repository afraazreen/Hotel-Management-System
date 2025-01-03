/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author afraa
 */
public class UpdateCheck extends JFrame implements ActionListener {
    
    Choice customer;
    JTextField tfroom, tfname, tfcheck, tfpaid, tfpending;
    JButton check, back, update;
    
    UpdateCheck(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Update Status");
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        heading.setForeground(Color.BLUE);
        heading.setBounds(90, 20, 200, 30);
        add(heading);
        
        JLabel labelid = new JLabel("Customer ID");
        labelid.setBounds(30, 80, 150, 20);
        add(labelid);
        
        customer = new Choice();
        customer.setBounds(200, 80, 150, 25);
        add(customer);
        
        try {
            // Querying to store it in the dropdown menu
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                customer.add(rs.getString("number"));
            }
            
        JLabel labelroom = new JLabel("Room Number");
        labelroom.setBounds(30, 120, 100, 20);
        add(labelroom);  
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        add(tfroom);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(30, 160, 100, 20);
        add(labelname);  
        
        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);
        
        JLabel labelcheck = new JLabel("Check-in time");
        labelcheck.setBounds(30, 200, 100, 20);
        add(labelcheck);  
        
        tfcheck = new JTextField();
        tfcheck.setBounds(200, 200, 150, 25);
        add(tfcheck);
        
        JLabel labelpaid = new JLabel("Amount Paid");
        labelpaid.setBounds(30, 240, 100, 20);
        add(labelpaid);  
        
        tfpaid = new JTextField();
        tfpaid.setBounds(200, 240, 150, 25);
        add(tfpaid);
        
        JLabel labelpending = new JLabel("Amount Pending");
        labelpending.setBounds(30, 280, 100, 20);
        add(labelpending); 
        
        tfpending = new JTextField();
        tfpending.setBounds(200, 280, 150, 25);
        add(tfpending);
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 340, 100, 30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 340, 100, 30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("BaCK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 340, 100, 30);
        back.addActionListener(this);
        add(back);
        
        
            
            
      
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        setBounds(300, 200, 980, 500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            // Check the database
            String id = customer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";

            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheck.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                }
                
                // To get the pending amount, we need the price of the room from the room table.
                ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber = "+tfroom.getText());
                
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                    tfpending.setText(""+amountPaid);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        
        else if (ae.getSource()== update){
            String num = customer.getSelectedItem();
            String room = tfroom.getText();
            String checkin = tfcheck.getText();
            String name = tfname.getText();
            String deposit = tfpaid.getText();
            
            try {
                Conn conn = new Conn();
                conn.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+checkin+"', deposit = '"+deposit+"' where number = '"+num+"'"); 
                
                JOptionPane.showMessageDialog(null, "Data updated successfully");
            }
            
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new UpdateCheck();
    }
}

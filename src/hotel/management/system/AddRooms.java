
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author afraa
 */
public class AddRooms extends JFrame implements ActionListener {
   
    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox availablecombo, typecombo, cleancombo;
    
    AddRooms(){
        
        // Creating the addRooms panel
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel labelRoomNum = new JLabel("Room Number");
        labelRoomNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelRoomNum.setBounds(60, 80, 120, 20);
        add(labelRoomNum);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);
        
        // A label to see whether the room is available or not
        JLabel labelAvailable = new JLabel("Available");
        labelAvailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelAvailable.setBounds(60, 130, 120, 20);
        add(labelAvailable);
        
        // Creating a String to represent the available options
        String availableOptions[] = {"Available", "Occupied"};
        
        // To create the dropdown menu
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
         // To identify the cleaning status
        JLabel labelClean = new JLabel("Cleaning Status");
        labelClean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelClean.setBounds(60, 180, 120, 20);
        add(labelClean);
        
        // Creating a String to represent the available options
        String cleanOptions[] = {"Cleaned", "Awaiting Cleaning"};
        
        // To create the dropdown menu
        cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        
        // Now for prices. 
        JLabel labelPrice = new JLabel("Price");
        labelPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelPrice.setBounds(60, 230, 120, 20);
        add(labelPrice);
        
        // Creating a textfield for the price
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);
        
        
        // Creating a dropdown menu for the bed type
        JLabel labelBed = new JLabel("Bed Type");
        labelBed.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelBed.setBounds(60, 280, 120, 20);
        add(labelBed);
        
        // Creating a String to represent the available options
        String bedOptions[] = {"Single", "Double"};
        
        // To create the dropdown menu
        typecombo = new JComboBox(bedOptions);
        typecombo.setBounds(200, 280, 150, 30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);
        
        // Creating the buttons 
        add = new JButton("Add Rooms");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon bedimage = new ImageIcon(ClassLoader.getSystemResource("icons/bed.png"));
        Image image2 = bedimage.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel bedroomimage = new JLabel(image3);
        bedroomimage.setBounds(400, 30, 200, 300);
        add(bedroomimage);
        
        
        
        
        setBounds(330, 200, 940, 470);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        // Checking which button was pressed
        if(ae.getSource() == add) {
            String roomNum = tfroom.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String cleaningStatus = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String bedtype = (String) typecombo.getSelectedItem();
            
            
            // Now to create a table for this in our mySQL database:
            try {
                Conn conn = new Conn();
                
                String query = "insert into room values( '"+roomNum+"', '"+availability+"', '"+cleaningStatus+"','"+price+"', '"+bedtype+"')";
                
                // Now to execute the query
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Room added successfully.");
            }
            
            
            catch (Exception e){
                e.printStackTrace();
            }
            
        }
        
        // Cancel option
        else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
    new AddRooms();
    
    }






}


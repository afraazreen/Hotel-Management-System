
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author afraa
 */
public class AddCustomer extends JFrame implements ActionListener {
    
    // Creating a textfield
    JTextField tfphone, tfcustomername, tfcountry, tfdeposit, tfage;
    
    // Creating a global value for the combobox
    JComboBox customerid;
    
    // RadioButtons for the gender
    JRadioButton rmale, rfemale;
    
    // We can make dropdowns a bit more dynamic using the choice class:
    Choice croom;
    
    // Not editable checkin time label
    JLabel time;
    
    // Buttons
    JButton add, back;
    
    AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Creating a header:
        JLabel headertext = new JLabel("NEW CUSTOMER FORM");
        headertext.setBounds(100, 20, 300, 30);
        headertext.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(headertext);
        
        // Create A label for the ID
        JLabel labelCustID = new JLabel("ID");
        labelCustID.setBounds(35, 80, 100, 20);
        labelCustID.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(labelCustID);
        
        String idoptions[] = {"Driver's License", "Passport", "Emirates ID / Government Issued ID"};
        customerid = new JComboBox(idoptions);
        customerid.setBounds(200, 80, 150, 25);
        customerid.setBackground(Color.WHITE);
        add(customerid);
        
        // Create A label for the phone
        JLabel labelNum = new JLabel("Number");
        labelNum.setBounds(35, 120, 100, 20);
        labelNum.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(labelNum);
        
        // Textfield for the number:
        tfphone = new JTextField();
        tfphone.setBounds(200, 120, 150, 25);
        add(tfphone);
        
        // Create A label for the name
        JLabel customerName = new JLabel("Name");
        customerName.setBounds(35, 160, 100, 20);
        customerName.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(customerName);
        
        // Textfield for the name:
        tfcustomername = new JTextField();
        tfcustomername.setBounds(200, 160, 150, 25);
        add(tfcustomername);
        
        // Create A label for the name
        JLabel customerAge = new JLabel("Age");
        customerAge.setBounds(35, 200, 100, 20);
        customerAge.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(customerAge);
        
        // Textfield for the name:
        tfage = new JTextField();
        tfage.setBounds(200, 200, 150, 25);
        add(tfage);
        
        // Create A label for the gender
        JLabel customergender = new JLabel("Gender");
        customergender.setBounds(35, 240, 100, 20);
        customergender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(customergender);
        
        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200, 240, 60, 25);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270, 240, 100, 25);
        add(rfemale);
        
        // Create A label for the country
        JLabel country = new JLabel("Country");
        country.setBounds(35, 280, 100, 25);
        country.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(country);
        
        // Textfield for the country:
        tfcountry = new JTextField();
        tfcountry.setBounds(200, 280, 150, 25);
        add(tfcountry);
        
        // Create A label for the allocated room no.
        JLabel labelRoomNum = new JLabel("Room Number");
        labelRoomNum.setBounds(35, 320, 150, 20);
        labelRoomNum.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(labelRoomNum);
        
        
        // Creating the dynamic dropdown - we want the values from the room table inside this drop down. 
        croom = new Choice();
        
        // Creating a query to get the room numbers 
        try{
            Conn conn = new Conn();
            
            // To get the data from the room table, where rooms are available.
            String query = "select * from room where availability = 'Available'";
        
            // To execute the query, we use our object and statement and then store it in the ResultSet class:
            ResultSet rs = conn.s.executeQuery(query);
            
            // Now we can create a loop to populate the dropdown menu with the results we get from the query:
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        
        }
        
        catch (Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200, 320, 150, 25);
        add(croom);
        
        
        // Create A label for checkin time.
        JLabel labelTime = new JLabel("Check-in Time");
        labelTime.setBounds(35, 360, 150, 20);
        labelTime.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(labelTime);
        
        // Date object:
        Date date = new Date();
        
        // Now we must make a check-in time label, but it is non-editable by the user, reflects current time of checking in.
        // We add a String to have the date object be promoted to a String, as we cannot pass a Date object into JLabel
        time = new JLabel(""+date);
        time.setBounds(200, 360, 120, 25);
        time.setFont(new Font("Raleway", Font.PLAIN, 10));
        add(time);
        
        // Deposit Field - Advance for the room booking 
        JLabel depositlabel = new JLabel("Deposit");
        depositlabel.setBounds(35, 400, 100, 25);
        depositlabel.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(depositlabel);
        
        // Textfield for the deposit:
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 400, 150, 25);
        add(tfdeposit);
        
        // Add button logic
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50, 450, 120, 30);
        add.addActionListener(this);
        add(add);
        
        // back button logic
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 450, 120, 30);
        back.addActionListener(this);
        add(back);
        
        
        
        setBounds(350, 200, 800, 550);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String idvalue = (String) customerid.getSelectedItem();
            String number = tfphone.getText();
            String name = tfcustomername.getText();
            String age = tfage.getText();
            
            String gender = null;
            
            if(rmale.isSelected()){
                gender = "Male";
            }
            else {
                gender = "Female";
            }
            
            String custCountry = tfcountry.getText();
            String roomNum = croom.getSelectedItem();
            String deposit = tfdeposit.getText();
            String checkintime = time.getText();
            
            
            // Sending the info to SQL:
            try {
                // Run a query to insert into database
                String query1 = "insert into customer values('"+idvalue+"','"+number+"','"+name+"','"+age+"','"+gender+"','"+custCountry+"','"+roomNum+"','"+checkintime+"','"+deposit+"')";

                // Run a query to make that room's status go from available to occupied
                String query2 = "update room set availability = 'Occupied' where roomnumber = '"+roomNum+"'";
                
                Conn conn = new Conn();
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                
                setVisible(false);
                // Open up the reception tab after closing.
                new Reception();
                
            }
            
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Reception();
            
        }
    }
    
  public static void main(String[] args){
      new AddCustomer();
  }
  
  
}


package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author afraa
 */
public class AddDriver extends JFrame implements ActionListener {
   
    JButton add, cancel;
    JTextField tfname, tfage, tfmodel, tfcomp, tfloc;
    JComboBox gendercombo;
    
    AddDriver(){
        
        // Creating the addRooms panel
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Driver");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel labelName = new JLabel("Name");
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelName.setBounds(60, 70, 120, 20);
        add(labelName);
        
        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);
        
        // A label to see the drive's age 
        JLabel labelAge = new JLabel("Age");
        labelAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelAge.setBounds(60, 120, 120, 20);
        add(labelAge);
        
        tfage = new JTextField();
        tfage.setBounds(200, 120, 150, 30);
        add(tfage);
        
        
         // To identify the gender of the driver 
        JLabel labelGender = new JLabel("Gender");
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelGender.setBounds(60, 170, 120, 20);
        add(labelGender);
        
        String genderOptions[] = {"Male", "Female"};
        
        // To create the dropdown menu
        gendercombo = new JComboBox(genderOptions);
        gendercombo.setBounds(200, 170, 150, 30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
  
        // Now for Car Model. 
        JLabel labelCompany = new JLabel("Car Company");
        labelCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelCompany.setBounds(60, 220, 120, 20);
        add(labelCompany);
        
        // Creating a textfield for the company
        tfcomp = new JTextField();
        tfcomp.setBounds(200, 220, 150, 30);
        add(tfcomp);
        
        // Now for Car Company 
        JLabel labelmodel = new JLabel("Car Model");
        labelmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelmodel.setBounds(60, 270, 120, 20);
        add(labelmodel);
        
        // Creating a textfield for the model
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 270, 150, 30);
        add(tfmodel);
        
        // Now for Car Company 
        JLabel labelloc = new JLabel("Pickup Location");
        labelloc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelloc.setBounds(60, 320, 120, 20);
        add(labelloc);
        
        // Creating a textfield for the model
        tfloc = new JTextField();
        tfloc.setBounds(200, 320, 150, 30);
        add(tfloc);
        
        
        
        
   
        // Creating the buttons 
        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 370, 130, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 370, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon bedimage = new ImageIcon(ClassLoader.getSystemResource("icons/driverpic.png"));
        Image image2 = bedimage.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel bedroomimage = new JLabel(image3);
        bedroomimage.setBounds(400, 30, 500, 300);
        add(bedroomimage);
        
        
        
        
        setBounds(300, 200, 980, 470);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        // Checking which button was pressed
        if(ae.getSource() == add) {
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcomp.getText();
            String model = tfmodel.getText();
            String location = tfloc.getText();
            
            
            // Now to create a table for this in our mySQL database:
            try {
                Conn conn = new Conn();
                
                String query = "insert into driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+model+"', '"+location+"')";
                
                // Now to execute the query
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Driver added successfully.");
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
    new AddDriver();
    
    }






}


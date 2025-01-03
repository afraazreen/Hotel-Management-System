
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener {
    
    // Declaring ll textfields globally:
    JTextField tfname, tfemail, tfphone, tfage, tfsalary, tfID;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    
    
    // Constructor
    AddEmployee() {
        
        // Creating the frame for the class 
        setLayout(null);
        
        // Creating a new label for the name
        JLabel labelname = new JLabel("NAME");
        labelname.setBounds(60, 30, 120, 30);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelname);
        
        // Creating a textfield for name:
        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);
        
        // Now repeat for age:
        JLabel labelage = new JLabel("AGE");
        labelage.setBounds(60, 80, 120, 30);
        labelage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelage);
        
        // Creating a textfield for name:
        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
        
        // Now for gender, we use the radio buttons:
        JLabel labelgender = new JLabel("GENDER");
        labelgender.setBounds(60, 130, 120, 30);
        labelgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        rbmale.setFocusable(false);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 130, 90, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setFocusable(false);
        add(rbfemale);
        
        revalidate();
        repaint();
        
        // Grouping the buttons together, so we can see which of the values was selected later on, so that only one of them is selected not both
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        
        // Now job
        JLabel labeljob = new JLabel("JOB");
        labeljob.setBounds(60, 180, 120, 30);
        labeljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labeljob);
        
        // Using the JComboBox to create the dropdown menu:
        // Pass in the contents of the dropdown menu as an array of strings to the method
        String str[] = { "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiters/Waitress", "Managers", "Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150, 30);
        
        // Setting the background color of the dropdown
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        // Salary 
        JLabel labelsalary = new JLabel("SALARY");
        labelsalary.setBounds(60, 230, 120, 30);
        labelsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);
        
        // Phone
        JLabel labelphone = new JLabel("PHONE");
        labelphone.setBounds(60, 280, 120, 30);
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);
        
        // Email
        JLabel labelemail = new JLabel("EMAIL");
        labelemail.setBounds(60, 330, 120, 30);
        labelemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
        
        // ID
        // Email
        JLabel labelID = new JLabel("ID");
        labelID.setBounds(60, 380, 120, 30);
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelID);
        
        tfID = new JTextField();
        tfID.setBounds(200, 380, 150, 30);
        add(tfID);
        
        // Now we create the buttons for the submission:
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        
        add(submit);
        
        // Adding an icon - SCALE_SMOOTH provides better quality for resized images
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/employee.png"));
        Image image2 = image1.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel employeeimage = new JLabel(image3);
        employeeimage.setBounds(450, 130, 250, 250);
        add(employeeimage);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String ID = tfID.getText();
        
        // Creating a default null string for the gender:
        String gender = null;
        
        if (rbmale.isSelected()){
            gender = "Male";
        }
        else if (rbfemale.isSelected()){
            gender = "Female";
        }
        
        // Tells us which job is returned, which is returned as an object so we cast it.
        String job = (String) cbjob.getSelectedItem();
        
        
        // Now we make the SQL Query:
        
        // First, creating a table in mySQL for the employees.
        try {
            // Creating connection object to initate connection
            Conn conn = new Conn();
            
            String query = "insert into employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+email+"', '"+ID+"')";
            
            // Now to execute the query we use our Conn class' statement, so this doesn't return something to us
            conn.s.executeUpdate(query);
            
            // Message displaying that it was added successfully.
            JOptionPane.showMessageDialog(null, "Employee added successfully.");
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        new AddEmployee();
    }
}

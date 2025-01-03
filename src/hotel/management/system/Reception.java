
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Reception extends JFrame implements ActionListener {
    
    JButton logout, newCustomer,updateStatus,updateRStatus, newRooms, department, allEmployees, managerInfo, checkout, pickup, roomSearch, custInfo;
    
    Reception() {
      setLayout(null);
      getContentPane().setBackground(Color.WHITE);
       
      // Creating a button for the new customer
      newCustomer = new JButton("New Customer Form");
      newCustomer.setBounds(10, 30, 200, 30);
      newCustomer.setBackground(Color.BLACK);
      newCustomer.setForeground(Color.WHITE);
      newCustomer.addActionListener(this);
      add(newCustomer);
      
      // Creating a button for the rooms
      newRooms = new JButton("Rooms");
      newRooms.setBounds(10, 70, 200, 30);
      newRooms.setBackground(Color.BLACK);
      newRooms.setForeground(Color.WHITE);
      newRooms.addActionListener(this);
      add(newRooms);
      
      // Creating a button for the departments in the hotel
      department = new JButton("Department");
      department.setBounds(10, 110, 200, 30);
      department.setBackground(Color.BLACK);
      department.setForeground(Color.WHITE);
      department.addActionListener(this);
      add(department);
      
      // Creating a button for all employees
      allEmployees = new JButton("All Employees");
      allEmployees.setBounds(10, 150, 200, 30);
      allEmployees.setBackground(Color.BLACK);
      allEmployees.setForeground(Color.WHITE);
      allEmployees.addActionListener(this);
      add(allEmployees);
      
      // Creating a button to extract the customer info:
      custInfo = new JButton("Customer Info");
      custInfo.setBounds(10, 190, 200, 30);
      custInfo.setBackground(Color.BLACK);
      custInfo.setForeground(Color.WHITE);
      custInfo.addActionListener(this);
      add(custInfo);
      
      // Creating a button to get the manager information
      managerInfo = new JButton("Manager Info");
      managerInfo.setBounds(10, 230, 200, 30);
      managerInfo.setBackground(Color.BLACK);
      managerInfo.setForeground(Color.WHITE);
      managerInfo.addActionListener(this);
      add(managerInfo);
      
      // Creating a button to get the manager information
      checkout = new JButton("Checkout");
      checkout.setBounds(10, 270, 200, 30);
      checkout.setBackground(Color.BLACK);
      checkout.setForeground(Color.WHITE);
      checkout.addActionListener(this);
      add(checkout);
      
      // Creating a button to update the status
      updateStatus = new JButton("Update Status");
      updateStatus.setBounds(10, 310, 200, 30);
      updateStatus.setBackground(Color.BLACK);
      updateStatus.setForeground(Color.WHITE);
      updateStatus.addActionListener(this);
      add(updateStatus);
      
      // Creating a button to update the status specific to rooms
      updateRStatus = new JButton("Update Room Status");
      updateRStatus.setBounds(10, 350, 200, 30);
      updateRStatus.setBackground(Color.BLACK);
      updateRStatus.setForeground(Color.WHITE);
      updateRStatus.addActionListener(this);
      add(updateRStatus);
      
      // Creating a button for pickup service
      pickup = new JButton("Pickup Service");
      pickup.setBounds(10, 390, 200, 30);
      pickup.setBackground(Color.BLACK);
      pickup.setForeground(Color.WHITE);
      pickup.addActionListener(this);
      add(pickup);
      
      // Creating a button to search for the rooms:
      roomSearch = new JButton("Search for a room");
      roomSearch.setBounds(10, 430, 200, 30);
      roomSearch.setBackground(Color.BLACK);
      roomSearch.setForeground(Color.WHITE);
      roomSearch.addActionListener(this);
      add(roomSearch);
      
      // Creating a button to logout
      logout = new JButton("Logout");
      logout.setBounds(10, 470, 200, 30);
      logout.setBackground(Color.BLACK);
      logout.setForeground(Color.WHITE);
      logout.addActionListener(this);
      add(logout);
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/reception.png"));
      JLabel receptionimage = new JLabel(i1);
      receptionimage.setBounds(250, 30, 500, 470);
      add(receptionimage);
      
      setBounds(350, 200, 500, 470);
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        // Opening this frame when this specific button is clicked.
        if (ae.getSource()== newCustomer){
            
            //Closing current frame
            setVisible(false);
            new AddCustomer();
        }
        
        else if (ae.getSource()==newRooms){
            setVisible(false);
            new Room();
        }
        
        else if(ae.getSource()==department){
            setVisible(false);
            new Department();
            
        }
        
        else if(ae.getSource()==allEmployees){
            setVisible(false);
            new EmployeeInfo();
        }
        
        else if(ae.getSource()==managerInfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource()==pickup){
            setVisible(false);
            new Pickup();
        }
        
        else if(ae.getSource()==custInfo){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource()==updateStatus){
            setVisible(false);
            new UpdateCheck();
        }
        
        else if(ae.getSource()==updateRStatus){
            setVisible(false);
            new UpdateRoom();
        }
        
        else if(ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }
        
        else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
        
        else if(ae.getSource()==roomSearch){
            setVisible(false);
            try {
                new SearchRoom();
            } catch (SQLException ex) {
                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
  public static void main(String[] args){
      new Reception();
  }
}

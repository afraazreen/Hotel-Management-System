/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// JFrame allows us to make the frame and comes from the Swing Package.
public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem() {
        //setSize(1366, 565);
        // 100 away from top and origin
       // setLocation(100, 100);
        
        // Setting Bounds
        setBounds(100, 100, 1366, 565);
        
        // Choosing my own layout instead of default
        setLayout(null);
        
        // Getting the image of introductory screen
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/whitelotus.png"));
        
        // JLabel allows us to put the icon on the frame.
       JLabel image = new JLabel(image1);
       
       // Setting image bounds
       image.setBounds(0, 0, 1366, 565);
        
       add(image);
       
       
       // Adding the next button
       JButton next = new JButton("Next");
       next.setBounds(1110, 450, 150, 50);
       next.setBackground(new Color(0, 0, 0, 0));
       next.setForeground(Color.WHITE);
       next.addActionListener(this);
       next.setFont(new Font("Times New Roman", Font.PLAIN, 24));
       image.add(next);
        
        // By default, visbility is set to false so hidden from the user, so set to true
        setVisible(true);
        
        
         
    }
    
    
    
    
    
    public static void main(String[] args) {
      new HotelManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Login();
    }
    
}

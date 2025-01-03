
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;


public class Dashboard extends JFrame  implements ActionListener {
    
    Dashboard() {
        setBounds(0, 0, 1500, 1500);
        setLayout(null);
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.jpg"));
        Image i2 = image1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);
        
        
        JLabel welcometext = new JLabel("The White Lotus welcomes you...");
        welcometext.setBounds(400, 80, 1000, 50);
        welcometext.setFont(new Font("Times New Roman", Font.BOLD, 46));
        image.add(welcometext);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLACK);
        mb.add(hotel);
        
        JMenu reception = new JMenu("RECEPTION");
        reception.addActionListener(this);
        mb.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLACK);
        admin.addActionListener(this);
        mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }
        
        else if (ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }
        
        else if (ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
        }
        else if (ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
        
    }
    public static void main(String[] args){
        new Dashboard();
    }
}

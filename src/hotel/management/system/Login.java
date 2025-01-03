
package hotel.management.system;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    // Defining both textfields globally so we can use them within the actionPerformed
    JTextField username;
    
    // This hides the password as we enter it.
    JPasswordField password;
    JButton login, cancel;
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(500, 200, 600, 300);
        
        setLayout(null);
        
        // setBounds(x - left, y - down...)
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);
        
        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);
        
        
        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);
        
        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(40, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        // Adding icon to the frame
        ImageIcon loginicon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = loginicon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel loginimage = new JLabel(i3);
        loginimage.setBounds(350, 10, 200, 200);
        add(loginimage);
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        // getSource tells us which button was clicked
        if (ae.getSource() == login){
            String user = username.getText();
            String pass = password.getText();
            
            // Now we check if those values are in the database using a query
            // Exception Handling must be done, checked exception:
            try {
                
                // Creating a new connection
                Conn c = new Conn();
                
                //  Now we write our query:
                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                
                // We can execute the queries using the statement we created in the Conn class.
                // We use our Conn class' object to access this:
                // We pass our query to it. 
                ResultSet rs = c.s.executeQuery(query);
                
                // If the query was successful, open the dashboard.
                if(rs.next()) {
                    setVisible(false);
                    new Dashboard();
                }
                else {
                    // Show message of invalid username if query was unsucessful.
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
            }
            
            
            catch (Exception e){
                e.printStackTrace();
            }
        }
        
        else if (ae.getSource() == cancel){
            // If cancel is clicked then we just get rid of the frame by making it invisible
            setVisible(false);
        }
        
  
    }
  
    public static void main(String[] args){
     new Login();
    }
}


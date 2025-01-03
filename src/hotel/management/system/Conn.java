
package hotel.management.system;

import java.sql.*;

// Step 1:
// Step 2:
// Step 3:
public class Conn {
    
    Connection c;
    
    // Statement allows us to execute mySQL queries
    Statement s;
    Conn(){
        
        // Here we have to put it in a try or catch otherwise it will show an error.
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // We need a connection string, so we can use the driver manager class for this:
        // We create an object of the driver manager class and then pass in the connection string as a parameter:
        // We have jdbc, then the name of the database and also the port. 
        
        
        // Then, inside mySQL workbench, you can create a new database.
        // Then we establish the connection to it.
        // Two other args are username and pass of mySQL
        
        c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem", "root", "Sarder@9851");
        s = c.createStatement();
        }
        catch (Exception e) {
            
        }
      }
        
}

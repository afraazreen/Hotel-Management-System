package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener {
    JTable table;
    JButton back, submit;
    Choice carType;
    JCheckBox available;
    
    Pickup() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Header
        JLabel header = new JLabel("Pickup Service");
        header.setFont(new Font("Tahoma", Font.PLAIN, 20));
        header.setBounds(400, 30, 200, 30);
        add(header);
        
        // Car Type Label and Dropdown
        JLabel labelbed = new JLabel("Car Type");
        labelbed.setBounds(50, 100, 100, 20);
        add(labelbed);
        
        carType = new Choice();
        carType.setBounds(150, 100, 200, 25);
        add(carType);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");
            while (rs.next()) {
                carType.add(rs.getString("company"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Table Column Labels
        JLabel label1 = new JLabel("Name");
        label1.setBounds(30, 160, 100, 20);
        add(label1);
        
        JLabel label2 = new JLabel("Age");
        label2.setBounds(200, 160, 100, 20);
        add(label2);
        
        JLabel label3 = new JLabel("Gender");
        label3.setBounds(330, 160, 100, 20);
        add(label3);
        
        JLabel label4 = new JLabel("Company");
        label4.setBounds(460, 160, 100, 20);
        add(label4);
        
        JLabel label5 = new JLabel("Model");
        label5.setBounds(630, 160, 100, 20);
        add(label5);
        
        JLabel label6 = new JLabel("Location");
        label6.setBounds(740, 160, 100, 20);
        add(label6);
        
        // Table
        table = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(30, 200, 900, 300); // Proper alignment under column labels
        add(tableScrollPane);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Submit Button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(400, 520, 120, 30);
        submit.addActionListener(this);
        add(submit);
        
        // Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(550, 520, 120, 30);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String query = "select * from driver where company = '" + carType.getSelectedItem() + "'";
            
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new Pickup();
    }
}

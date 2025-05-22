/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{

     JTable table;
    JButton back;
    public Department() {
         getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel l1=new JLabel("Department");
        l1.setBounds(100,10,100,20);
        add(l1);
               
        JLabel l2=new JLabel("Budget");
        l2.setBounds(420,10,100,20);
        add(l2);

        table =new JTable();
        table.setBounds(0,50,700,350);
        add(table);
        
        try {
             GetConnection conn=new GetConnection();
             String query="Select department,budget from department";
             ResultSet rs=conn.s.executeQuery(query);
             
             table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBounds(280,400,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setBounds(400,200,700,480);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new Department();
    }
    
}

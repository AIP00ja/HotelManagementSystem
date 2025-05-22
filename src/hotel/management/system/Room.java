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

public class Room extends JFrame implements ActionListener{
    JTable table;
    JButton back;

    public Room(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(500,0,600,600);
        add(image);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(10,10,100,20);
        add(l1);
               
        JLabel l2=new JLabel("Availibility");
        l2.setBounds(120,10,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Status");
        l3.setBounds(230,10,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(330,10,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(430,10,100,20);
        add(l5);
        
        
        
        table =new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        try {
             GetConnection conn=new GetConnection();
             String query="Select roomno, availability,cleaning_status,price,bed_type from rooms";
             ResultSet rs=conn.s.executeQuery(query);
             table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setBounds(300,200,1050,600);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new Room();
    }
    
}

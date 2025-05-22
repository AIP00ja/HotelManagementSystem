/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class CustomerInfo extends JFrame implements ActionListener{

    JTable table;
    JButton back;
    public CustomerInfo() {
         getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel l1=new JLabel("Document");
        l1.setBounds(40,10,100,20);
        add(l1);
               
        JLabel l2=new JLabel("Number");
        l2.setBounds(170,10,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Name");
        l3.setBounds(290,10,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Gender");
        l4.setBounds(400,10,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Country");
        l5.setBounds(540,10,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Room");
        l6.setBounds(670,10,100,20);
        add(l6);
        
        JLabel l7=new JLabel("CheckIn Time");
        l7.setBounds(790,10,100,20);
        add(l7);
        
        JLabel l8=new JLabel("Deposit");
        l8.setBounds(910,10,100,20);
        add(l8);
        
        
        
        
        table =new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        
        try {
             GetConnection conn=new GetConnection();
             String query="Select document, number, name, gender, country, room, checkintime, deposit from customer";
             ResultSet rs=conn.s.executeQuery(query);
             table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back=new JButton("Back");
        back.setBounds(420,500,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
          }
    
    
    public static void main(String[] args) {
        new CustomerInfo();
    }
    
}

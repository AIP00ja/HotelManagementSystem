/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class UpdateRoom extends JFrame implements ActionListener{

     Choice customer;
    JTextField tfroom,tfAvailability,tfCleaning,tfAmount,tfPending;
    JButton check,update,back;
    public UpdateRoom() {
        
        getContentPane().setBackground(Color.white);
       setLayout(null);
       
       JLabel text=new JLabel("Update Room Status");
       text.setFont(new Font("Tahoma",Font.PLAIN,25));
       text.setBounds(30,32,250,30);
       text.setForeground(Color.blue);
       add(text);
       
       JLabel lblid=new JLabel("Customer Id");   
       lblid.setBounds(30,80,100,20);       
       add(lblid);
       
       customer=new Choice();
       customer.setBounds(200,80,150,25);
       add(customer);
        try {
            GetConnection conn=new GetConnection();
             ResultSet rs=conn.s.executeQuery("Select document, number, name, gender, country, room, checkintime, deposit from customer");
             while (rs.next()) {
             customer.add(rs.getString("number")); 
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       JLabel lblroom=new JLabel("Room Number");   
       lblroom.setBounds(30,130,100,20);       
       add(lblroom);      
       tfroom=new JTextField();
       tfroom.setBounds(200,130,150,25);
       add(tfroom);
       
       JLabel lblAvailability=new JLabel("Availability");   
       lblAvailability.setBounds(30,180,100,20);       
       add(lblAvailability);      
       tfAvailability=new JTextField();
       tfAvailability.setBounds(200,180,150,25);
       add(tfAvailability);

       JLabel lblCleaning=new JLabel("Cleaning Status");   
      lblCleaning.setBounds(30,230,100,20);       
       add(lblCleaning);      
       tfCleaning=new JTextField();
       tfCleaning.setBounds(200,230,150,25);
       add(tfCleaning);
       
       
       
        check=new JButton("Check");
        check.setBounds(30,300,100,30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);
        
        update=new JButton("Update");
        update.setBounds(150,300,100,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBounds(270,300,100,30);  
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);

       
       
        
        setBounds(300,200,980,450);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getSource()==check){
            String id=customer.getSelectedItem();
            String query="Select document, number, name, gender, country, room, checkintime, deposit from customer where number='"+id+"'";
            try {
                GetConnection conn=new GetConnection();
                ResultSet rs=conn.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));                 
                }
                ResultSet rs2=conn.s.executeQuery("select * from rooms where roomno='"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfAvailability.setText(rs2.getString("availability"));
                    tfCleaning.setText(rs2.getString("cleaning_status"));
                }
            } catch (Exception ec) {
            }
        
        }else if(e.getSource()==update){
            String number=customer.getSelectedItem();
            String room=tfroom.getText();
           String available=tfAvailability.getText();
            String status=tfCleaning.getText();
            
            try {
                GetConnection conn=new GetConnection();
                conn.s.executeUpdate("update rooms set availability='"+available+"',cleaning_status='"+status+"' where roomno='"+room+"'");
                JOptionPane.showMessageDialog(null, "Date update Successfully");
                 setVisible(false);
                 new Reception(); 
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }else{
             setVisible(false);
             new Reception(); 
        }
    }
    
    public static void main(String[] args) {
        new UpdateRoom();
    }
    
}

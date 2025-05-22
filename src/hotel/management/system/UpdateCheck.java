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

public class UpdateCheck extends JFrame implements ActionListener{

    Choice customer;
    JTextField tfroom,tfname,tfcheckin,tfAmount,tfPending;
    JButton check,update,back;
    public UpdateCheck() {
        
       getContentPane().setBackground(Color.white);
       setLayout(null);
       
       JLabel text=new JLabel("Update Status");
       text.setFont(new Font("Tahoma",Font.PLAIN,20));
       text.setBounds(90,30,200,30);
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
       lblroom.setBounds(30,120,100,20);       
       add(lblroom);      
       tfroom=new JTextField();
       tfroom.setBounds(200,120,150,25);
       add(tfroom);
       
       JLabel lblname=new JLabel("Name");   
       lblname.setBounds(30,160,100,20);       
       add(lblname);      
       tfname=new JTextField();
       tfname.setBounds(200,160,150,25);
       add(tfname);

       JLabel lblcheckin=new JLabel("CheckIn Time");   
      lblcheckin.setBounds(30,200,100,20);       
       add(lblcheckin);      
       tfcheckin=new JTextField();
       tfcheckin.setBounds(200,200,150,25);
       add(tfcheckin);
       
       JLabel lblAmount=new JLabel("Amount Paid");   
      lblAmount.setBounds(30,240,100,20);       
       add(lblAmount);      
       tfAmount=new JTextField();
       tfAmount.setBounds(200,240,150,25);
       add(tfAmount);
       
        JLabel lblPending=new JLabel("Pending Amount");   
      lblPending.setBounds(30,280,100,20);       
       add(lblPending);      
       tfPending=new JTextField();
       tfPending.setBounds(200,280,150,25);
       add(tfPending);
       
        check=new JButton("Check");
        check.setBounds(30,340,100,30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);
        
        update=new JButton("Update");
        update.setBounds(150,340,100,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBounds(270,340,100,30);  
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);


       
       
        
        setBounds(300,200,980,600);
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
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfAmount.setText(rs.getString("deposit"));
                }
                ResultSet rs2=conn.s.executeQuery("select * from rooms where roomno='"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price=rs2.getString("price");
                    int amountPaid=Integer.parseInt(price)-Integer.parseInt(tfAmount.getText());
                    tfPending.setText(""+amountPaid);
                }
            } catch (Exception ec) {
            }
        
        }else if(e.getSource()==update){
            String number=customer.getSelectedItem();
            String room=tfroom.getText();
           String name=tfname.getText();
            String checkin=tfcheckin.getText();
            String deposit=tfAmount.getText();
            try {
                GetConnection conn=new GetConnection();
                conn.s.executeUpdate("update customer set room='"+room+"',name='"+name+"',checkintime='"+checkin+"',deposit='"+deposit+"'where number='"+number+"'");
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
     new UpdateCheck();
    }
    
}

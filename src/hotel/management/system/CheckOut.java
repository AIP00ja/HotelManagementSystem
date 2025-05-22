/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;
import net.proteanit.sql.DbUtils;

public class CheckOut extends JFrame implements ActionListener{

    Choice customerId;
    JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
    Date date;
    JButton checkOut,back;
    public CheckOut() {
         
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
       JLabel text=new JLabel("CheckOut");
       text.setFont(new Font("Tahoma",Font.PLAIN,20));
       text.setBounds(100,20,100,30);
       text.setForeground(Color.blue);
       add(text);
       
       JLabel lblbed=new JLabel("Customer Id");
       lblbed.setBounds(30,80,100,30);
       add(lblbed);
       customerId=new Choice();
       customerId.setBounds(150,80,150,25);
        add(customerId);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel tick=new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);
        
      JLabel lblroom=new JLabel("Room Number");
      lblroom.setBounds(30,130,100,30);
       add(lblroom);
       
      lblroomnumber=new JLabel();
      lblroomnumber.setBounds(150,130,100,30);
      add(lblroomnumber);
      
      JLabel lblcheckin=new JLabel("CheckIn Time");
      lblcheckin.setBounds(30,180,100,30);
      add(lblcheckin);       
      lblcheckintime=new JLabel();
      lblcheckintime.setBounds(150,180,100,30);
       add(lblcheckintime);
       
      JLabel lblcheckout=new JLabel("CheckOut Time");
      lblcheckout.setBounds(30,230,100,30);
      add(lblcheckout);    
      date=new Date();
      lblcheckouttime=new JLabel(""+date);
      lblcheckouttime.setBounds(150,230,200,30);
       add(lblcheckouttime);
       
        checkOut=new JButton("CheckOut");
        checkOut.setBounds(30,280,120,30);  
       checkOut.setBackground(Color.black);
        checkOut.setForeground(Color.white);
        checkOut.addActionListener(this);
        add(checkOut);
       
        back=new JButton("Back");
        back.setBounds(170,280,120,30);  
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
         try {
            GetConnection conn=new GetConnection();
             
             ResultSet rs=conn.s.executeQuery("select * from customer");
             while(rs.next()){
                 customerId.add(rs.getString("number"));  
                 lblroomnumber.setText(rs.getString("room"));
                 lblcheckintime.setText(rs.getString("checkintime"));
             }
             
        } catch (Exception e) {
        }
        
        
       
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);

       
        
        setBounds(300,200,800,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==checkOut){
           
             String query1="delete from customer where number='"+customerId.getSelectedItem()+"'";     
             String query2="update rooms set availability='Available' where roomno='"+lblroomnumber.getText()+"'";
             try {
             GetConnection conn=new GetConnection();
             conn.s.executeUpdate(query1);
             conn.s.executeUpdate(query2);
             JOptionPane.showMessageDialog(null, "CheckOut done");
            
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
        new CheckOut();
    }
    
}

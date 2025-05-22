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


public class PickupService extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,Submit;
    Choice typeofcar;
    JCheckBox available;
    public PickupService() {
         getContentPane().setBackground(Color.white);
        setLayout(null);
       JLabel text=new JLabel("PickUp Service");
       text.setFont(new Font("Tahoma",Font.PLAIN,20));
       text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed=new JLabel("Type Of Car");
       //lblbed.setFont(new Font("Tahoma",Font.PLAIN,20));
       lblbed.setBounds(50,100,100,20);
       add(lblbed);
       
       typeofcar=new Choice();
       typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        try {
            GetConnection conn=new GetConnection();
             
             ResultSet rs=conn.s.executeQuery("select * from drivers");
             while(rs.next()){
                 typeofcar.add(rs.getString("branch"));
             
             }
             //table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
        }

        JLabel l1=new JLabel("Name");
        l1.setBounds(30,160,100,20);
        add(l1);
               
        JLabel l2=new JLabel("Age");
        l2.setBounds(200,160,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(330,160,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Company");
        l4.setBounds(460,160,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Brand");
        l5.setBounds(630,160,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Available");
        l6.setBounds(740,160,100,20);
        add(l6);
         
        JLabel l7=new JLabel("Location");
        l7.setBounds(890,160,100,20);
        add(l7);
        
        

        table =new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try {
             GetConnection conn=new GetConnection();
             String query="Select name,age,gender,company,branch,available,location from drivers";
             ResultSet rs=conn.s.executeQuery(query);
             table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Submit=new JButton("Submit");
        Submit.setBounds(300,520,120,30);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        add(Submit);
        
        back=new JButton("Back");
        back.setBounds(500,520,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getSource()==Submit){
            try {
             GetConnection conn=new GetConnection();
             String query1="Select name,age,gender,company,branch,available,location from drivers where branch='"+typeofcar.getSelectedItem()+"'";        
             ResultSet rs;
             
             rs=conn.s.executeQuery(query1); 
             
             table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception ee) {
                ee.printStackTrace();
            }
           
        }else{
            setVisible(false);
            new Reception(); 
        }
    }
    
    public static void main(String[] args) {
        new PickupService();
    }
    
}

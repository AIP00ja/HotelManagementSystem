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


public class SearchRoom extends JFrame implements ActionListener{

    JTable table;
    JButton back,Submit;
    JComboBox bedtype;
    JCheckBox available;
    public SearchRoom() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
       JLabel text=new JLabel("Search for Room");
       text.setFont(new Font("Tahoma",Font.PLAIN,20));
       text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed=new JLabel("Bed Type");
       //lblbed.setFont(new Font("Tahoma",Font.PLAIN,20));
       lblbed.setBounds(50,100,100,20);
       add(lblbed);
       
       bedtype=new JComboBox(new String[]{"Single Bed","Double Bed"});
       bedtype.setBounds(150,100,150,25);
       bedtype.setBackground(Color.white);
       add(bedtype);
       
      
      available=new JCheckBox("Only display Available");
       available.setBounds(650,100,150,25);
       available.setBackground(Color.white);
       add(available);
       
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(50,160,100,20);
        add(l1);
               
        JLabel l2=new JLabel("Availibility");
        l2.setBounds(270,160,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(450,160,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(670,160,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(870,160,100,20);
        add(l5);
        
        
        
        table =new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try {
             GetConnection conn=new GetConnection();
             String query="Select roomno, availability,cleaning_status,price,bed_type from rooms";
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
             String query1="Select roomno, availability,cleaning_status,price,bed_type from rooms where bed_type='"+bedtype.getSelectedItem()+"'";
             String query2="Select roomno, availability,cleaning_status,price,bed_type from rooms where availability='Available' and bed_type='"+bedtype.getSelectedItem()+"'";
           
             ResultSet rs;
             if(available.isSelected()){
                rs=conn.s.executeQuery(query2); 
             }else{
                 rs=conn.s.executeQuery(query1);
             
             }
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
        new SearchRoom();
    }
    
}

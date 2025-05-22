/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import com.mysql.cj.protocol.Resultset;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class AddCustomer extends JFrame implements ActionListener{

    JTextField tfnumber, tfname,tfcountry,tfdeposit;
    JRadioButton rbmale,rbfemale;
    JComboBox comboid;
    Choice croom;
    JButton  add,back;
    JLabel lbltime,checkintime;
    public AddCustomer() {
        
         setLayout(null);
         
        JLabel lbltext=new JLabel("New Customer Form");
        lbltext.setBounds(100,20,300,30);
        lbltext.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltext); 
        
        JLabel lblId=new JLabel("ID");
        lblId.setBounds(35,80,100,20);
        lblId.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblId);   
        String str[]={"Aadhar Card","Passport","Driving License","Voter-id Card"};
        comboid=new JComboBox(str);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.white);
        add(comboid);
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblnumber);    
        tfnumber=new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
         
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);    
        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgender);
        
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,200,60,25);      
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(270,200,100,25);
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblcountry);    
        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);    
        croom=new Choice();
        croom.setBounds(200,280,150,25);
        add(croom);
        try {
             GetConnection conn=new GetConnection();
             String query="Select * from rooms where availability='Available'";
             ResultSet rs=conn.s.executeQuery(query);
             while(rs.next()){
                 croom.add(rs.getString("roomno"));
             }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        lbltime=new JLabel("Checkin Time");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime); 
        
        Date date=new Date();

        checkintime=new JLabel(""+date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,11));
        add(checkintime); 
        
        
        JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setBounds(35,360,100,20);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);    
        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        

        add=new JButton("Add");
         add.setBounds(50,410,120,30);
         add.setBackground(Color.black);
         add.setForeground(Color.white);
         add.addActionListener(this);
        add(add);
        
        back=new JButton("back");
        back.setBounds(200,410,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        
        
        getContentPane().setBackground(Color.white);
        setBounds(350,200,800,550);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
           String id=(String)comboid.getSelectedItem();
           String number=tfnumber.getText();
           String name=tfname.getText();
           String gender=null;
           if(rbmale.isSelected()){
              gender="Male";
           }else{
                gender="Female";
           }
           String country=tfcountry.getText();
           String room = (String) croom.getSelectedItem();
           String time=checkintime.getText();
           String deposit=tfdeposit.getText();
           
            try {
            GetConnection conn=new GetConnection();
          String query = "INSERT INTO customer (document, number, name, gender, country, room, checkintime, deposit) " +
          "VALUES ('" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + room + "', '" + time + "', '" + deposit + "')";
            String query2="Update rooms set availability='Occupied' where roomno='"+room+"'";
            
            conn.s.executeUpdate(query);
            conn.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
            setVisible(false);
            new Reception();
            
        } catch (Exception ee) {
            ee.printStackTrace();
        }
           
        }else if(e.getSource()==back){
             setVisible(false);
            new Reception();
        }
        
    }
    
    
    public static void main(String[] args) {
        new AddCustomer();
    }
    
}

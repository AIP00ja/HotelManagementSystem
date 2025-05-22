/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{

    JButton add, cancel;
    JTextField tfname,tfage,tfcar,tfcarmodel,tflocation;
    JComboBox gendercombo,availablecombo;
    public AddDriver() {
        
        getContentPane().setBackground(Color.white);
        setBounds(300,200,980,470);
        
        JLabel heading=new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);
        
        JLabel lblname=new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setBounds(60,70,120,20);
        add(lblname);
        tfname=new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);
        
        JLabel lblage=new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblage.setBounds(60,110,120,20);
        add(lblage);
        tfage=new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblgender.setBounds(60,150,120,20);
        add(lblgender);
        String genderOpt[]={"Male","Female"};
        gendercombo=new JComboBox(genderOpt);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.white);
        add(gendercombo);
        
        JLabel lblcar=new JLabel("Car Campany");
        lblcar.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblcar.setBounds(60,190,120,20);
        add(lblcar);
        tfcar=new JTextField();
        tfcar.setBounds(200,190,150,30);
        add(tfcar);
        
        JLabel lblcarmodel=new JLabel("Car Model");
        lblcarmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblcarmodel.setBounds(60,230,120,20);
        add(lblcarmodel);
        tfcarmodel=new JTextField();
        tfcarmodel.setBounds(200,230,150,30);
        add(tfcarmodel);
        
        JLabel lblavailable=new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds(60,270,120,20);
        add(lblavailable);
        String availableOpt[]={"Available","Busy"};
        availablecombo=new JComboBox(availableOpt);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);
        
        JLabel lbllocation=new JLabel("Car Location");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbllocation.setBounds(60,310,120,20);
        add(lbllocation);
        tflocation=new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);
        
        
        add=new JButton("Add Driver");
        add.setBounds(60,370,130,30);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add(add);
        add.addActionListener(this);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(220,370,130,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        
        setLayout(null);
        setVisible(true);
        
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String) gendercombo.getSelectedItem();
            String company=tfcar.getText();
            String brand=tfcarmodel.getText();
            String available=(String) availablecombo.getSelectedItem();
            String location=tflocation.getText();
            
               try {
                GetConnection conn=new GetConnection();
            String query = "insert into drivers(name,age,gender,company,branch,available,location) " +
                   "values('" +name+ "','" +age+ "','" +gender+ "','" +company + "','" +brand + "','"+available+"','"+location+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Drivers added Successfully");
            setVisible(false);
                
            } catch (Exception ce) {
                ce.printStackTrace();
            }
               
            
        
        }else{
            setVisible(false);
        }
        
    }
   
   
    
    public static void main(String[] args) {
        new AddDriver();
        
    }
    
}

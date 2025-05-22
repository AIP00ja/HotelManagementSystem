/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{

    JButton add, cancel;
    JTextField tfroom,tfprice;
    JComboBox typecombo,cleancombo,availablecombo;
            
            
           
    public AddRooms() {
        getContentPane().setBackground(Color.white);
        setBounds(330,200,940,470);
        
        JLabel heading=new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel lblroomno=new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,20);
        add(lblroomno);
        tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        JLabel lblavailable=new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds(60,130,120,20);
        add(lblavailable);
        String availableOpt[]={"Available","Occupied"};
        availablecombo=new JComboBox(availableOpt);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);
        
        JLabel lblclean=new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,20);
        add(lblclean);
        String cleanOpt[]={"Cleaned","Dirty"};
        cleancombo=new JComboBox(cleanOpt);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);
        
        JLabel lblprice=new JLabel("Room Price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,20);
        add(lblprice);
        tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        JLabel lbltype=new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds(60,280,120,20);
        add(lbltype);
        String typeOpt[]={"Single Bed","Double Bed"};
        typecombo=new JComboBox(typeOpt);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.white);
        add(typecombo);
        
        add=new JButton("Add Room");
        add.setBounds(60,350,130,30);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add(add);
        add.addActionListener(this);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(220,350,130,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        
        setLayout(null);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String roomno=tfroom.getText();
            String availability=(String)availablecombo.getSelectedItem();
             String status=(String)cleancombo.getSelectedItem();
              String price=tfprice.getText();
               String type=(String)typecombo.getSelectedItem();
               try {
                GetConnection conn=new GetConnection();
            String query = "insert into rooms(roomno, availability,cleaning_status,price,bed_type) " +
                   "values('" +roomno+ "','" +availability+ "','" +status+ "','" +price + "','" +type + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee added Successfully");
            setVisible(false);
                
            } catch (Exception ce) {
                ce.printStackTrace();
            }
            
        
        }else{
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }
    
}


package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    public Dashboard() {
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JLabel text=new JLabel("The POJO Group Welcomes You !!");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        text.setForeground(Color.white);
        image.add(text);
        
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel=new JMenu("Hotel Management");
        hotel.setForeground(Color.red);
        mb.add(hotel);
        
        JMenuItem reception=new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin=new JMenu("Admin");
        hotel.setForeground(Color.red);
        mb.add(admin);
        
        JMenuItem addemployee=new JMenuItem("Add Employee");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms=new JMenuItem("Add Rooms");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddriver=new JMenuItem("Add Drivers");
        adddriver.addActionListener(this);
        admin.add(adddriver);
              
        setBounds(0,0,1550,1000);
        setVisible(true);      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand().equals("Add Employee")){
           new AddEmployee();
      }else if(e.getActionCommand().equals("Add Rooms")){
          new AddRooms();
      }
      else if(e.getActionCommand().equals("Add Drivers")){
          new AddDriver();
      }
      else if(e.getActionCommand().equals("Reception")){
          new Reception();
      }
          
    }     
    public static void main(String[] args) {
        new Dashboard();
    }
    
}

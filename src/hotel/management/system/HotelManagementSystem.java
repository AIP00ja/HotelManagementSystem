package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

    public HotelManagementSystem() {
        
        setBounds(100,100,1366,565);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel1.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1366,565);       
        add(image);
        JLabel text=new JLabel("Hotel Management System");
        text.setBounds(20,430,1000,90);
        
        text.setFont(new Font("serif", Font.PLAIN, 50));
        text.setForeground(Color.black);
        image.add(text);
        
        JButton next =new JButton("Next");
        next.setBounds(1150,450,150,50);
        image.add(next);
        next.addActionListener(this);
       // next.setBackground(Color.white);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        next.setForeground(Color.magenta);
        setVisible(true);
        while (true) {            
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
             try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    } 
    @Override
    public void actionPerformed(ActionEvent e) {      
         setVisible(false);
         new Login();
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
        
    }
    
}

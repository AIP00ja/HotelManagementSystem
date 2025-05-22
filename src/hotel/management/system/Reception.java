/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{

    JButton newCustomer,rooms,department,allEmployee,customers,managerInfo,checkout,searchroom,update,roomstatus,pickUp,logout;
    public Reception() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        newCustomer=new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.black);
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        
        rooms=new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);
        
        department=new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.addActionListener(this);
        add(department);
        
        allEmployee=new JButton("All Employee");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setBackground(Color.black);
        allEmployee.setForeground(Color.white);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        customers=new JButton("Customers Info");
        customers.setBounds(10,190,200,30);
        customers.setBackground(Color.black);
        customers.setForeground(Color.white);
        customers.addActionListener(this);
        add(customers);
        
        managerInfo=new JButton("Manager Info");
        managerInfo.setBounds(10,230,200,30);
        managerInfo.setBackground(Color.black);
        managerInfo.setForeground(Color.white);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        checkout=new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);
        
        update=new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        roomstatus=new JButton("Update Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.black);
        roomstatus.setForeground(Color.white);
        roomstatus.addActionListener(this);
        add(roomstatus);
        
        pickUp=new JButton("Pickup Service");
        pickUp.setBounds(10,390,200,30);
        pickUp.setBackground(Color.black);
        pickUp.setForeground(Color.white);
        pickUp.addActionListener(this);
        add(pickUp);
        
        searchroom=new JButton("Search Room");
        searchroom.setBounds(10,430,200,30);
        searchroom.setBackground(Color.black);
        searchroom.setForeground(Color.white);
        searchroom.addActionListener(this);
        add(searchroom);
        
        logout=new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        setBounds(350,200,800,570);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==newCustomer) {
            setVisible(false);
            new AddCustomer();
        }else if(e.getSource()==rooms){
            setVisible(false);
            new Room();
        }else if(e.getSource()==department){
            setVisible(false);
            new Department();
        }else if(e.getSource()==allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }else if(e.getSource()==managerInfo){
            setVisible(false);
            new ManagerInfo();
        }else if(e.getSource()==customers){
            setVisible(false);
            new CustomerInfo();
        }else if(e.getSource()==searchroom){
            setVisible(false);
            new SearchRoom();
        }else if(e.getSource()==update){
            setVisible(false);
            new UpdateCheck();
        }else if(e.getSource()==roomstatus){
            setVisible(false);
            new UpdateRoom();
        }else if(e.getSource()==pickUp){
            setVisible(false);
            new PickupService();
        }else if(e.getSource()==checkout){
            setVisible(false);
            new CheckOut();
        }else if(e.getSource()==logout){
            setVisible(false);
            System.exit(0);
        
        }
        
    }
    
    public static void main(String[] args) {
        new Reception();
    }
    
}

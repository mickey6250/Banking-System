/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
JButton deposit , cash , pin ,transfer,withdrawl,ministatement,balance,exit;
String pinnumber;   
Fastcash(String pinnumber){
        this.pinnumber=pinnumber;
    setLayout(null);
     
   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
   Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
                   
   JLabel image = new JLabel(i3);
   image.setBounds(0,0,900,800);
   add(image);
    
   JLabel text=new JLabel("SELECT WITHDRWAL AMOUNT  ");
   text.setBounds(330,330,700,35);
   text.setForeground(Color.WHITE);
   text.setFont(new Font("system",Font.BOLD,16));
   image.add(text);
   
   //deposit
   deposit=new JButton("Rs 100");
   deposit.setBounds(290,382,140,30);
   deposit.addActionListener(this);
   image.add(deposit);
   
   //cash
   cash=new JButton("Rs 500");
   cash.setBounds(290,412,140,30);
   cash.addActionListener(this);
   image.add(cash);
   
   //pin
   pin=new JButton("Rs 1000");
   pin.setBounds(290,442,140,30);
   pin.addActionListener(this);
   image.add(pin );
    
   //withdrawl
   withdrawl =new JButton("Rs 2000");
   withdrawl.setBounds(470,380,140,30);   
   withdrawl.addActionListener(this);
   image.add(withdrawl);
   
   //ministatement
   ministatement=new JButton("Rs 5000");
   ministatement.setBounds(470,410,140,30);
   ministatement.addActionListener(this);
   image.add(ministatement);
   
   //balance
   balance=new JButton("Rs 10000");
   balance.setBounds(470,440,140,30);
   balance.addActionListener(this);
   image.add(balance);
   
   //exit
   exit=new JButton("Back");
   exit.setBounds(470,470,140,30);
   exit .addActionListener(this);
   image.add(exit);
   
   setSize(900,900);
   setLocation(300,0);
   setUndecorated(true);
   setVisible(true);
    
}
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==exit){
setVisible(false);
           new Transactions(pinnumber).setVisible(true);
       }else{
           String amount = ((JButton )ae.getSource()).getText().substring(3);
       Conn c = new Conn();
       
       try{
           ResultSet rs = c.s.executeQuery("select*from bank where pin = '"+pinnumber+"'");
           int balance1 =0;
        while(rs.next()){
        
            if(rs.getString("type").equals("Deposit")){
                   balance1 += Integer.parseInt(rs.getString("number"));
               }
            else{
                   balance1 -=Integer.parseInt(rs.getString("number"));
               }
           }
        
        if(ae.getSource() !=exit&&balance1<Integer.parseInt(amount)){
               JOptionPane.showMessageDialog(null,"Insufficient Balance ");
            return ;
           }
        
           Date date = new Date();
           String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')" ;
           c.s.execute(query);
           JOptionPane.showMessageDialog(null,"Withdrawl Successfull");
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);

       }
       catch(Exception e){
           System.out.println(e);
       }      
       }
   }
    public static void main(String[] args) {
    new Fastcash("");
    }

}


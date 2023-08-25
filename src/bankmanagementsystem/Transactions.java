package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
JButton deposit , Fastcash , pinchange ,withdrawl,MiniStatement,BalanceEnquiry,exit;

String pin;  

Transactions(String pin){
        this.pin=pin;
        
    setLayout(null);
    //Image
    
   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
   Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel image = new JLabel(i3);
   image.setBounds(0,0,900,800);
   add(image);
  
   
   JLabel text=new JLabel("Please select your Transaction ");
   text.setBounds(330,330,700,35);
   text.setForeground(Color.WHITE);
   text.setFont(new Font("system",Font.BOLD,16));
   image.add(text);
   
   //deposit
   deposit=new JButton("Deposit");
   deposit.setBounds(290,382,140,30);
   deposit.addActionListener(this);
   image.add(deposit);
  
   //Fastcash
   Fastcash=new JButton("Fast Cash");
   Fastcash.setBounds(290,412,140,30);
   Fastcash.addActionListener(this);
   image.add(Fastcash);
   
   // pinchange
   pinchange=new JButton("Pin Generation");
   pinchange.setBounds(290,442,140,30);
   pinchange.addActionListener(this);
   image.add(pinchange );

   // withdrawl
   withdrawl =new JButton("Cash Withdraw");
   withdrawl.setBounds(470,380,140,30);   
   withdrawl.addActionListener(this);
   image.add(withdrawl);
   
   //MiniStatement
   MiniStatement=new JButton("Mini Statement");
   MiniStatement.setBounds(470,410,140,30);
   MiniStatement.addActionListener(this);
   image.add(MiniStatement);
   
   //BalanceEnquiry
   BalanceEnquiry=new JButton("Balance Enquiry");
   BalanceEnquiry.setBounds(470,440,140,30);
   BalanceEnquiry.addActionListener(this);
   image.add(BalanceEnquiry);
   
   //exit
   exit=new JButton("Exit");
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
           System.exit(0);
       }else if(ae.getSource()==deposit){
           setVisible(false);
           new Deposit(pin).setVisible(true);
       }else if(ae.getSource()==withdrawl){
           setVisible(false);
           new Withdrawl(pin).setVisible(true);
       }else if(ae.getSource()==Fastcash){
           setVisible(false);
           new Fastcash(pin).setVisible(true);
       }else if(ae.getSource()==pinchange){
           setVisible(false);
           new pinchange(pin).setVisible(true);
       }else if(ae.getSource()==BalanceEnquiry){
           setVisible(false);
           new BalanceEnquiry(pin).setVisible(true);
       }else if(ae.getSource()==MiniStatement){
           setVisible(false);
           new MiniStatement(pin).setVisible(true);
       }
   }
    public static void main(String[] args) {
    new Transactions("");
    }
 }
    


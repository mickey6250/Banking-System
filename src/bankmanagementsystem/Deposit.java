package bankmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
   JTextField amount;
   JButton deposit,back;
   String pin;
   Deposit(String pin){
        this.pin=pin;
    
    setLayout(null);
           
    //Image      
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
    Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,800);
    add(image);
           
    //text
    JLabel text = new JLabel("Enter the amount you want to deposit ");
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System",Font.BOLD,16));
    text.setBounds(310,310,400,20);
    image.add(text);
    amount = new JTextField();
    amount.setFont(new Font("Raleway",Font.BOLD,22));
    amount.setBounds(300,350,300,25);
    image.add(amount);
                 
    //deposit
    deposit=new JButton("Deposit");
    deposit.setBounds(490,440,120,30);
    deposit.addActionListener(this);
    image.add(deposit);
                  
    //back
    back=new JButton("Back");
    back.setBounds(490,470,120,30);
    back.addActionListener(this);
    image.add(back);
                 
    setSize(900,900);
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
          String number = amount.getText();
          Date date = new Date();
        
        if(number.equals("")){
          JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            
        }else{
             try{
             Conn conn = new Conn();
             String query = "insert into bank values('"+pin+"','"+date+"','Deposit','"+number+"')" ;
             conn.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Rs. "+number+ " Deposited Successfully");
             setVisible(false);
             
             new Login().setVisible(true);
                }
             catch (Exception e){
                System.out.println(e);
            }}
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
    new Deposit("");
}
}
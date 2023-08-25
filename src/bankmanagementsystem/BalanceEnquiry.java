
package bankmanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;   
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));           
    Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);                  
    JLabel image = new JLabel(i3);    
    image.setBounds(0,0,900,800);    
    add(image);
                   
    //back
    back = new JButton("Back");                  
    back.setBounds(455,520,150,30);   
    back.addActionListener(this);    
    image.add(back);
                
    Conn c = new Conn();
    int balance =0;
try{
    ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
    while(rs.next()){
    if(rs.getString("type").equals("Deposit")){
        balance += Integer.parseInt(rs.getString("number"));
        }
    else{
        balance -=Integer.parseInt(rs.getString("number"));
               }
           }}
        catch(Exception e){
           System.out.println(e);
       }
    JLabel text = new JLabel("Available account balance is  Rs " + balance);
    text.setForeground(Color.white);
    text.setBounds(340,360,400,30);
    image.add(text);   
    setSize(900,900);
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
public static void main(String args[]){   
new BalanceEnquiry("");
}
}
package bankmanagementsystem;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class pinchange extends JFrame implements ActionListener {
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;   

    pinchange(String pinnumber){
                this.pinnumber=pinnumber;
    setLayout(null);
         
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));   
    Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);                  
    image.setBounds(0,0,900,800);
    add(image);
                      
    JLabel text = new JLabel("CHANGE YOUR PIN");   
    text.setForeground(Color.WHITE);    
    text.setFont(new Font("system",Font.BOLD,16));   
    text.setBounds(380,310,700,35);   
    image.add(text);
    
    
    
    JLabel pintext = new JLabel("NEW PIN:");
    pintext.setForeground(Color.WHITE);                  
    pintext.setFont(new Font("system",Font.BOLD,12));                 
    pintext.setBounds(300,350,180,25);                    
    image.add(pintext);                  
                   
    //pin
    pin = new JPasswordField();                 
    pin.setFont(new Font("Raleway",Font.BOLD,25));   
    pin.setBounds(423,348,150,20);                  
    image.add(pin);

    //repin               
    JLabel repintext = new JLabel("RE-ENTER NEW PIN:");
    repintext.setForeground(Color.WHITE);   
    repintext.setFont(new Font("system",Font.BOLD,12));    
    repintext.setBounds(300,372,180,25);    
    image.add(repintext);
                   
    
    repin = new JPasswordField();    
    repin.setFont(new Font("Raleway",Font.BOLD,25));   
    repin.setBounds(423,375,150,20);   
    image.add(repin);
              
     //change               
    change = new JButton("CHANGE");                   
    change.setBounds(455,445,150,30);   
    change.addActionListener(this);                  
    image.add(change);
    
    
    //back
    back = new JButton("BACK");   
    back.setBounds(455,470,150,30);   
    back.addActionListener(this);   
    image.add(back);
    
    setSize(900,900);
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin = pin.getText();
            String rpin = repin.getText();
        if(!npin.equals(rpin)){
            JOptionPane.showMessageDialog(null,"Entered PIN does not match ");
            return ;
            }
        if(npin.equals("")){
                 JOptionPane.showMessageDialog(null,"Please enter new PIN  ");
            return ;
            }
        if(rpin.equals("")){
                 JOptionPane.showMessageDialog(null,"Please re-enter PIN  ");
            return ;
            }
            Conn conn = new Conn();
            String query1 ="update bank set pin = '"+rpin+"'  where pin= '"+pinnumber+"' " ;
            String query2 ="update login set pin = '"+rpin+"'  where pin= '"+pinnumber+"' " ;
            String query3 ="update signupthree set pin = '"+rpin+"'  where pin= '"+pinnumber+"' " ;
            conn.s.execute(query1);
            conn.s.execute(query2);
            conn.s.execute(query2);
            JOptionPane.showMessageDialog(null,"PIN changed successfully ");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
        }else{
            setVisible(false);
                       new Transactions(pinnumber).setVisible(true);

        }
    }
    public static void main(String args[]){
        new pinchange("").setVisible(true);
    }
}

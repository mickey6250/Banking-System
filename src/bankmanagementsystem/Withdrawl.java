package bankmanagementsystem;
import java.util.Date;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Withdrawl extends JFrame implements ActionListener{
   
JTextField t1;
JButton withdrawl,back;
String pin;

Withdrawl(String pin){
        this.pin=pin;
    
    setLayout(null);
        
    //Image
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
    Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,800);
    add(image);
                   
    JLabel text = new JLabel("Enter the amount you want to withdraw ");
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System",Font.BOLD,16));
    text.setBounds(310,310,400,20);
    image.add(text);
    
    //amount
    t1 = new JTextField();
    t1.setFont(new Font("Raleway",Font.BOLD,22));
    t1.setBounds(300,350,300,25);
    image.add(t1);
                 
    //withdrawl
    withdrawl=new JButton("Withdraw");
    withdrawl.setBounds(490,440,120,30);
    withdrawl.addActionListener(this);
    image.add(withdrawl);
                  
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
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==withdrawl){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("number"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("number"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
    public static void main(String[] args) {
 new Withdrawl("");
}
}
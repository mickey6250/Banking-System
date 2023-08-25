package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, clear, newAcc;
    JTextField cardTF;
    JPasswordField pinTF;
    
    Login(){
        
        setLayout(null);
        
        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/loginLogo.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(140,10,100,100);
        add(l1);
        
        //Title and frame visibility
        setTitle("Automated Teller Machine");
        setSize(800, 480);
        setVisible(true);
        setLocation(400,200);
        
        //frame background color
        getContentPane().setBackground(Color.white);
        
        
        //text in front of logo
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(270, 40, 400,40);
        add(text);
        
        
        //card number
        JLabel card = new JLabel("Enter card:");
        card.setFont(new Font("Raleway", Font.BOLD, 28));
        card.setBounds(120, 150, 150,30);
        add(card);
        
        cardTF = new JTextField();
        cardTF.setBounds(300, 150, 250, 30);
        add(cardTF);
               
        //pin
        JLabel pin = new JLabel("Enter pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 200, 150,30);
        add(pin);
        
        pinTF = new JPasswordField();
        pinTF.setBounds(300, 200, 250, 30);
        add(pinTF);
           
        
        //login button
        login = new JButton("Sign in");
        login.setFont(new Font("Ariel", Font.BOLD, 14));
        login.setBounds(310, 250, 100, 30);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        
        
        //singup button
        clear = new JButton("Clear");
        clear.setFont(new Font("Ariel", Font.BOLD, 14));
        clear.setBounds(430, 250, 100, 30);
        clear.addActionListener(this);
        add(clear);
        clear.setBackground(Color.blue);
        clear.setForeground(Color.white);
        
        
        //new account      
        newAcc = new JButton("New user");
        newAcc.setFont(new Font("Ariel", Font.BOLD, 14));
        newAcc.setBounds(370, 300, 100, 30);
        newAcc.addActionListener(this);
        add(newAcc);
        newAcc.setBackground(Color.blue);
        newAcc.setForeground(Color.white);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == login){
                Conn c1 = new Conn();
                    String cardno  = cardTF.getText();
                    String pin  = pinTF.getText();
                    String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                    ResultSet rs = c1.s.executeQuery(q);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    }
            }else if(e.getSource() == clear){
                cardTF.setText("");
                pinTF.setText("");

            }else if(e.getSource()==newAcc){
                    setVisible(false);
                    new signupone().setVisible(true);
            }
        }catch(HeadlessException | SQLException ae){
}
    }
    
    public static void main(String args[]){
        new Login().setVisible(true);
    }
    
}

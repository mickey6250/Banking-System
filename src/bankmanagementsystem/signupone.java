package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;


public class signupone extends JFrame implements ActionListener { 
    
    
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField, aadharTextField;
     
    JRadioButton male,female,other,married,unmarried;
    JButton next;
    JDateChooser dateChooser;
        Random ran = new Random();
        long random =Math.abs((ran.nextLong()%9000L)+1000L);
        String first = "" + Math.abs(random);
    
    signupone(){ 
        
        setLayout(null);
        
        
        
        
        JLabel formno = new JLabel("Application Form No. : " + random);
        formno.setFont(new Font("Times New Roman",Font.BOLD,38));
        formno.setBounds(190,20,600,40);
        add(formno);
        
        JLabel Personaldetail = new JLabel("Page 1 : Personal Detail");
        Personaldetail.setFont(new Font("Times New Roman",Font.BOLD,22));
        Personaldetail.setBounds(290,80,400,30);
        add(Personaldetail);
        
        JLabel Name = new JLabel("Name:");
        Name.setFont(new Font("Times New Roman",Font.BOLD,22));
        Name.setBounds(100,140,100,30);
        add(Name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Times New Roman",Font.BOLD,20));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father Name:");
        fname.setFont(new Font("Times New Roman",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTextField =new JTextField();
        fnameTextField.setFont(new Font("Times New Roman",Font.BOLD,20));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Times New Roman",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,200,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser); 
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Times New Roman",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);   
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(400,290,80,30);
        add(female);
        
        other= new JRadioButton("Other");
        other.setBounds(520,290,80,30);
        add(other);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Times New Roman",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField =new JTextField();
        emailTextField.setFont(new Font("Times New Roman",Font.BOLD,20));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status:");
        marital .setFont(new Font("Times New Roman",Font.BOLD,22));
        marital .setBounds(100,390,200,30);
        add(marital);
        
        married= new JRadioButton("Married");
        married.setBounds(300,390,100,30); 
       // married.setBackground(Color.gray);
      //  married.setForeground(Color.black);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
      //  unmarried.setBackground(Color.gray);
       // unmarried.setForeground(Color.black);
        add(unmarried);
        
        
        
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Times New Roman",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTextField =new JTextField();
        addressTextField.setFont(new Font("Times New Roman",Font.BOLD,20));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city .setFont(new Font("Times New Roman",Font.BOLD,22));
        city .setBounds(100,490,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Times New Roman",Font.BOLD,20));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state= new JLabel("State:");
        state.setFont(new Font("Times New Roman",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField =new JTextField();
        stateTextField.setFont(new Font("Times New Roman",Font.BOLD,20));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Times New Roman",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pinTextField =new JTextField();
        pinTextField.setFont(new Font("Times New Roman",Font.BOLD,20));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.gray);
        next.setForeground(Color.black);
        next.setFont(new Font("Times New Roman",Font.BOLD,18));
        next.setBounds(620,700,80,40);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.CYAN);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
      String formno =""+random;
      String name = nameTextField.getText();
      String fname = fnameTextField.getText();
      String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
      String gender =null;
      if (male.isSelected()){
          gender = "male";
      }else if (female.isSelected()){
          gender ="female";
      }
      
      String email =emailTextField.getText();
      
      String marital =null;
      if (married.isSelected()){
          marital ="Married"; 
      } else if (unmarried.isSelected()){
          marital ="Unmarried";
      } else if (other.isSelected()){
          marital ="Other";
      }
      
      String address = addressTextField.getText();
      String city = cityTextField.getText();
      String state = stateTextField.getText();
      String pin = pinTextField.getText();
     
       try {
           
           Conn c1 = new Conn();
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else {
                String q1 = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c1.s.executeUpdate(q1);
                
                 new signuptwo(first).setVisible(true);
                setVisible(false);
            }    
        } catch (Exception e){
            System.out.println(e);
        }
  }

  public static void main(String args[]) {
        new signupone();
       } 
  
}

package bankmanagementsystem;

/**
 *
 * @author yash2
 */

   

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class signuptwo  extends JFrame implements ActionListener { 
    
    long random;
    JTextField pan , aadhar;
     
    JRadioButton syes ,sno ,eyes, eno;
    JComboBox religion, category, occupation, education, income;
    JButton next;
    
    signuptwo(String formno){ 
        
        setLayout(null);
       
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel AdditionalDetail = new JLabel("page2: Additional Detail");
        AdditionalDetail.setFont(new Font("Times New Roman",Font.BOLD,22));
        AdditionalDetail.setBounds(290,80,400,30);
        add(AdditionalDetail);
        
        JLabel Name = new JLabel("Religion:");
        Name.setFont(new Font("Times New Roman",Font.BOLD,22));
        Name.setBounds(100,140,100,30);
        
        add(Name);
        
        String vReligion[] = {"HINDU","MUSLIM","SIKH","CHRISTIAN","OTHER"};
        religion = new JComboBox(vReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Times New Roman",Font.BOLD,22));
        Category.setBounds(100,190,200,30);
        add(Category);

        String vcategory[] = {"GENERAL","OBC","ST","SC","OTHER"};
        category = new JComboBox(vcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Times New Roman",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomecategory[] = {"NULL","< 1,50,000","< 2,50,000","< 5,00,000","More Than 5 lak"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
       
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Times New Roman",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
               
        JLabel email = new JLabel("Qulification:");
        email.setFont(new Font("Times New Roman",Font.BOLD,22));
        email.setBounds(100,315,200,30);
        add(email);
        
        String eduvalue[] = {"Non-Graduation","Graduaction","Post-Graduation","Doctarte","other"};
        education = new JComboBox(eduvalue);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
                
        JLabel marital = new JLabel("Occupation:");
        marital .setFont(new Font("Times New Roman",Font.BOLD,22));
        marital .setBounds(100,390,200,30);
        add(marital);
        
        String occupationvalue[] = {"Salaried","Self-Employed","Bussiness","Student","other"};
        occupation = new JComboBox(occupationvalue);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
       
        
        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Times New Roman",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);
        
        pan =new JTextField();
        pan.setFont(new Font("Times New Roman",Font.BOLD,20));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city = new JLabel("Aadhar Number:");
        city .setFont(new Font("Times New Roman",Font.BOLD,22));
        city .setBounds(100,490,200,30);
        add(city);
        
        aadhar =new JTextField();
        aadhar.setFont(new Font("Times New Roman",Font.BOLD,20));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state= new JLabel("Senior Citizen:");
        state.setFont(new Font("Times New Roman",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes= new JRadioButton("Yes");
        syes.setBounds(300,540,100,30); 
        syes.setBackground(Color.BLACK);
        syes.setForeground(Color.RED);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.BLACK);
        sno.setForeground(Color.RED);
        add(sno);
        
        
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        
        JLabel pincode= new JLabel("Exisiting Account:");
        pincode.setFont(new Font("Times New Roman",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes= new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30); 
        eyes.setBackground(Color.BLACK);
        eyes.setForeground(Color.RED);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.BLACK);
        eno.setForeground(Color.RED);
        add(eno);
        
        
        
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
     
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.red);
        next.setFont(new Font("Times New Roman",Font.BOLD,18));
        next.setBounds(620,660,80,40);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
      String formno =""+random;
      String sreligion = (String)religion.getSelectedItem();
      String scategory = (String)category.getSelectedItem();
      String sincome = (String)income.getSelectedItem();
      String seducation = (String)education.getSelectedItem();
      String soccupation = (String)occupation.getSelectedItem();
      
           
      String seniorcitizen =null;
      if (syes.isSelected()){
          seniorcitizen = "Yes";
      }else if (sno.isSelected()){
          seniorcitizen ="No";
      }
      
      
      String exisitingaccount =null;
      if (eyes.isSelected()){
          exisitingaccount ="Yes"; 
      } else if (eno.isSelected()){
          exisitingaccount ="NO";
      }
      
      String span = pan.getText();
      String aaadhar = aadhar.getText();
     
       try {
                Conn c1 = new Conn();
                String query ="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+aaadhar+"','"+exisitingaccount+"','"+seniorcitizen+"')";
                c1.s.executeUpdate(query); 
                
                new Signup3(formno).setVisible(true);
                setVisible(false);
        } catch (Exception e){
            System.out.println(e);
        }
  }

  public static void main(String args[]) {
        new signuptwo("").setVisible(true);
       } 
  
}
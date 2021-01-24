/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Manohar Vemuri
 */
public class Registration {
    public static void main(String[] args){
        registration_ ob1=new registration_();
    }
}


class registration_ extends JFrame{
    JPanel panel1;
    JLabel welcome;
    JLabel firstnameLabel;
    JTextField firstName;
    JLabel lastnameLabel;
    JTextField lastName;
    JLabel emailLabel;
    JTextField email;
    JLabel passwordLabel;
    JPasswordField password;
    JLabel DOBLabel;
    JTextField DOB;
    JLabel GenderLabel;
    JRadioButton male;
    JRadioButton female;
    JCheckBox agreeBox;
    JLabel agreeLabel;
    JButton signup;
    public registration_(){
        panel1=new JPanel();
        Color color=new Color(240,240,240);
        panel1.setBackground(color);
        welcome=new JLabel("Signup");
        welcome.setBounds(215,5,100,15);
        
        firstnameLabel=new JLabel("Firstname");
        firstnameLabel.setBounds(135, 30, 100, 20);
        firstName=new JTextField(15);
        firstName.setBounds(135, 50, 100, 25);
        
        lastnameLabel=new JLabel("Lastname");
        lastnameLabel.setBounds(245, 30, 100, 20);
        lastName=new JTextField(15);
        lastName.setBounds(245, 50, 100, 25);
        
        
        
        emailLabel=new JLabel("Email");
        email=new JTextField(25);
        
        emailLabel.setBounds(135,70,100,25);
        email.setBounds(135, 90, 210, 25);
        
        
        passwordLabel=new JLabel("Password");
        passwordLabel.setBounds(135, 110, 100, 20);
        password=new JPasswordField();
        password.setBounds(135,130,150,25);
        
        
        
        DOBLabel=new JLabel("Date of Birth");
        DOBLabel.setBounds(135,155,100,20);
        DOB=new JTextField();
        DOB.setBounds(135,175,100,25);
        
        GenderLabel=new JLabel("Gender");
        GenderLabel.setBounds(135, 200, 100, 20);
        male=new JRadioButton("Male");
        female=new JRadioButton("Female");
        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);
        male.setBounds(135,225,100,20);
        female.setBounds(245,225,100,20);
        
        
        agreeBox=new JCheckBox();
        agreeBox.setBounds(135,255,20,20);
        agreeLabel=new JLabel("I agree to sign up");
        agreeLabel.setBounds(170,254,100,25);
        
        
        signup=new JButton("Signup");
        signup.setBounds(190,300,100,20);
        
        
        
        
        signup.addActionListener((ActionEvent e)->{
            String selection=(male.isSelected())?male.getText():female.getText();
            String emailreg="^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$";
            Pattern pat=Pattern.compile(emailreg);
            if(pat.matcher(email.getText()).matches()){
                
                if(agreeBox.isSelected()){
                    try{

                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                    Statement stmt=con.createStatement();

                    String query="insert into MasterData(Firstname,Lastname,Email,Password,Date_of_Birth,Gender)"
                            + "values('"+firstName.getText()+"','"+lastName.getText()+"','"+email.getText()+"','"+password.getText()+"',"
                            + "'"+DOB.getText()+"','"+selection+"')";
                    stmt.execute(query);
                    stmt.close();
                    con.close();
                    int ans=JOptionPane.showConfirmDialog(null, "Registered Successfully\nDo you want to Sign in?"," ",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(ans==0){
                        new Login_();
                        dispose();
                    }
                    else if(ans==1){
                        dispose();
                    }
                    else{
                        dispose();
                    }

                    }
                    catch(Exception ex){
                        System.out.println("Fail:"+ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please Agree", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter Valid Email ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            //int ans=JOptionPane.showConfirmDialog(null, "Registered Successfully\nDo you want to Sign in?"," ",JOptionPane.YES_NO_CANCEL_OPTION);
            //System.out.println(ans);
            
            
            /*
            try{
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                Statement stmt=con.createStatement();
                
                String query="insert into MasterData(Firstname,Lastname,Email,Password,Date_of_Birth,Gender)"
                        + "values('"+firstName.getText()+"','"+lastName.getText()+"','"+email.getText()+"','"+password.getText()+"',"
                        + "'"+DOB.getText()+"','"+selection+"')";
                stmt.execute(query);
                stmt.close();
                con.close();
                
            }
            catch(Exception ex){
                System.out.println("Fail:"+ex);
            }
            */
        });
        
        
        
        
        
        add(panel1);
        panel1.add(welcome);
        panel1.add(firstnameLabel);
        panel1.add(firstName);
        panel1.add(lastnameLabel);
        panel1.add(lastName);
        panel1.add(emailLabel);
        panel1.add(email);
        panel1.add(passwordLabel);
        panel1.add(password);
        panel1.add(DOBLabel);
        panel1.add(DOB);
        panel1.add(GenderLabel);
        panel1.add(male);
        panel1.add(female);
        panel1.add(agreeBox);
        panel1.add(agreeLabel);
        panel1.add(signup);
        
        
        panel1.setLayout(null);
        
        setContentPane(panel1);
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Register");
    }
    
}

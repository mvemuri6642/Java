/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userlogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Manohar Vemuri
 */
public class UserLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login ob1=new Login();
        
    }
    
}

class Login extends JFrame implements ActionListener{
    JTextField Username;
    JPasswordField Password;
    JButton Login;
    JRadioButton male;
    JRadioButton female;
    JCheckBox prog;
    JCheckBox gamer;
    JLabel l1;
    JProgressBar p;
    int i=0;
    String name;
    public Login(){
        Username=new JTextField(10);
        Password=new JPasswordField(10);
        Login=new JButton("Login");
        male=new JRadioButton("Male");
        female=new JRadioButton("Female");
        prog=new JCheckBox("Programmer");
        gamer=new JCheckBox("Gamer");
        l1=new JLabel();
        p=new JProgressBar(0,20);
        add(Username);
        add(Password);
        add(male);
        add(female);
        ButtonGroup gender=new ButtonGroup();
        gender.add(male);
        gender.add(female);
        add(prog);
        add(gamer);
        add(l1);
        add(Login);
        add(p);
        
        Timer t=new Timer(250,this);
        
        Login.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String uid="manohar";
               String pass="m";
               if(male.isSelected()){
                   name="Mr. "+Username.getText();
               }
               if(female.isSelected()){
                   name="Ms. "+Username.getText();
               }
               if(Username.getText().equals(uid)&&Password.getText().equals(pass)){
                   t.start();
                   
               }
               else{
                   l1.setText("Invalid UID/PASS");
               }
               
           }
        });
        
        
        
        
        prog.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                System.out.println("Programmer");
                
            }
        });
        
        gamer.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                System.out.println("Gamer");
            }
        });
        
        
        
        
        
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if(i==20){
            
            new wel(name);
            dispose();
            
        }
        i++;
        p.setValue(i);
    }
    
}
class wel extends JFrame{
    JLabel l1;
    public wel(String res){
        l1=new JLabel();
        l1.setText("Welcome: "+res);
        add(l1);
        setVisible(true);
        setSize(300,300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
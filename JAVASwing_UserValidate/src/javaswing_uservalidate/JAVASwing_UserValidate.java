/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing_uservalidate;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Manohar Vemuri
 */
public class JAVASwing_UserValidate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Validate ob1=new Validate();
    }
    
}

class Validate extends JFrame{
    JTextField Username=new JTextField(10);
    JPasswordField Password=new JPasswordField(10);
    JButton Login=new JButton("Login");
    JLabel l1=new JLabel();
    public Validate(){
        add(Username);
        add(Password);
        add(Login);
        add(l1);
        
        Login.addActionListener(e->{
            String uid="m";
            String pass="m";
            if(Username.getText().equals(uid) && Password.getText().equals(pass)){
                l1.setText("Success");
            }
            else{
                l1.setText("Fail");
            }
        });
        
        setVisible(true);
        setSize(400,400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

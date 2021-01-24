/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Manohar Vemuri
 */

public class Login{
    public static void main(String[] args){
        new Login_();
    }
}

class Login_{

    /**
     * @param args the command line arguments
     */
    
    public Login_(){
        // TODO code application logic here
        JFrame f=new JFrame();
        JPanel p1=new JPanel();
        f.add(p1);
        p1.setLayout(null);
        JLabel l1=new JLabel();
        JLabel l2=new JLabel();
        l1.setText("Email");
        JTextField t1=new JTextField(20);
        JPasswordField t2=new JPasswordField(20);
        JButton b1=new JButton("Sign in");
        t1.setBounds(100, 20, 250, 25);
        t2.setBounds(100, 50, 250, 25);
        l2.setText("Password");
        l1.setBounds(10,20,80,25);
        l2.setBounds(10,50,80,25);
        b1.setBounds(120, 100, 80, 25);
        
        JButton b2=new JButton("Reset");
        b2.setBounds(220, 100, 80, 25);
        
        JButton b3=new JButton("Signup");
        b3.setBounds(165, 150, 80, 25);
        p1.add(l1);
        p1.add(l2);
        p1.add(t1);
        p1.add(t2);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        f.setTitle("Login");
        f.setSize(450,250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
        b1.addActionListener(e->{
           System.out.println();
           try{
               //Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
               Statement stmt=con.createStatement();
               String query="select * from MasterData where Email='"+t1.getText()+"' and Password='"+t2.getText()+"'";
               ResultSet rs1=stmt.executeQuery(query);
               if(rs1.next()){
                   System.out.println("Success");
                   JOptionPane.showMessageDialog(null, "Success","Login Success",JOptionPane.INFORMATION_MESSAGE);
               }
               else{
                   JOptionPane.showMessageDialog(null,"Login Failed\nUsername/Password invalid","Failed",JOptionPane.ERROR_MESSAGE);
                   f.dispose();
                   
               }
               
           }
           catch(SQLException ex){
               System.out.println(ex);
           }
        });
        
   
        
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t1.setText("");
                t2.setText("");
            }
        });
        
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new registration_();
                f.dispose();
            }
        });
        
        
    }
    
}

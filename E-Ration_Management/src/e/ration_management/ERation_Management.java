/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.ration_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.print.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.print.PrinterException;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javafx.stage.*;
import java.sql.*;


/**
 *
 * @author Manohar Vemuri
 */
public class ERation_Management {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new login();
        
        
    }
    
}


class login extends JFrame{
    JPanel p1;
    JComboBox logintype;
    JTextField usernameText;
    JPasswordField passText;
    JButton login;
    JButton clr;
    public login(){
        p1=new JPanel();
        
        
        JLabel loginLabel=new JLabel("Ration Management ");
        loginLabel.setBounds(480, 35, 300, 100);
        loginLabel.setFont(new Font("Courier",Font.BOLD,25));
        
        JLabel roleLabel=new JLabel("Select");
        roleLabel.setBounds(800,200,200,27);
        roleLabel.setFont(new Font("Courier",Font.BOLD,12));
        
        
        
        
        String st[]={"Admin","Officer"};
        logintype=new JComboBox(st);
        logintype.setBounds(900, 200, 240, 27);
        logintype.setSelectedIndex(0);
        
        
        JLabel usernameLabel=new JLabel("Username");
        usernameLabel.setBounds(800,275,200,27);
        
        
        
        usernameText=new JTextField();
        usernameText.setBounds(900, 275, 240, 27);
        
        JLabel passLabel=new JLabel("Password");
        passLabel.setBounds(800,350,200,27);
        
        passText=new JPasswordField();
        passText.setBounds(900,350, 240, 27);
        
        login=new JButton("Login");
        login.setBounds(910, 425, 100, 27);
        
        clr=new JButton("Clear");
        clr.setBounds(1030, 425, 100, 27);
        
        
        
        
        
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                    
                    
                    
                    String query="select * from eRation where email='"+usernameText.getText()+"' and password='"+passText.getText()+"'"
                            + " and type='"+String.valueOf(logintype.getSelectedItem())+"'";
                    
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery(query);
                    if(rs.next()){
                      if(String.valueOf(logintype.getSelectedItem())=="Admin"){
                          new admin_();
                          dispose();
                      }  
                      else{
                          new officer_();
                          dispose();
                          
                      }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password","Login Error",JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
                catch(Exception e1){
                    System.out.println(e1);
                    
                }
                
                
                
                
            }
        });
        
        
        clr.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                logintype.setSelectedIndex(0);
                usernameText.setText("");
                passText.setText("");
                
            }
        });
        
        
        
        
        
        p1.add(loginLabel);
        p1.add(logintype);
        p1.add(roleLabel);
        p1.add(usernameLabel);
        p1.add(usernameText);
        p1.add(passLabel);
        p1.add(passText);
        p1.add(login);
        p1.add(clr);
        add(p1);
        p1.setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,750);
        setLocationRelativeTo(null);
        setTitle("Login");
    
    }

}
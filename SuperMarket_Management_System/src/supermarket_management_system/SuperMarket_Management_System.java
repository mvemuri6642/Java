/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.print.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.print.PrinterException;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javafx.stage.*;

/**
 *
 * @author Manohar Vemuri
 */
public class SuperMarket_Management_System {

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
    JTextField emailText;
    JPasswordField passText;
    JButton login;
    JButton clr;
    public login(){
        p1=new JPanel();
        
        
        JLabel loginLabel=new JLabel("Welcome");
        loginLabel.setBounds(560, 35, 200, 100);
        loginLabel.setFont(new Font("Courier",Font.BOLD,25));
        
        JLabel roleLabel=new JLabel("Select Role");
        roleLabel.setBounds(800,200,200,27);
        roleLabel.setFont(new Font("Courier",Font.BOLD,12));
        
        
        
        
        String st[]={"Admin","Employee"};
        logintype=new JComboBox(st);
        logintype.setBounds(900, 200, 240, 27);
        logintype.setSelectedIndex(0);
        
        
        JLabel emailLabel=new JLabel("Email");
        emailLabel.setBounds(800,275,200,27);
        
        
        
        emailText=new JTextField();
        emailText.setBounds(900, 275, 240, 27);
        
        JLabel passLabel=new JLabel("Password");
        passLabel.setBounds(800,350,200,27);
        
        passText=new JPasswordField();
        passText.setBounds(900,350, 240, 27);
        
        login=new JButton("Login");
        login.setBounds(910, 425, 100, 27);
        
        clr=new JButton("Clear");
        clr.setBounds(1030, 425, 100, 27);
        
        
        login.addActionListener(e->{
            try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                Statement stmt=con.createStatement();
                //String type=String.valueOf(logintype.getSelectedItem());
                String query="select * from SuperMarket_Credentials where Type='"+String.valueOf(logintype.getSelectedItem())+"' "
                        + "and Email='"+emailText.getText()+"' and Password='"+passText.getText()+"'";
                ResultSet rs=stmt.executeQuery(query);
                if(rs.next()){
                    System.out.println("Success");
                    if(String.valueOf(logintype.getSelectedItem())=="Admin"){
                        
                        new Admin_Login_();
                        dispose();
                        
                    }
                    else{
                        new Seller_Login_();
                        dispose();
                        
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid UID/Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(Exception ex){
                System.out.println(ex);
                
            }
            
        });
        clr.addActionListener(e->{
            emailText.setText("");
            passText.setText("");
            logintype.setSelectedIndex(0);
        });
        
        
        
        
        
        
        
        p1.add(loginLabel);
        p1.add(logintype);
        p1.add(roleLabel);
        p1.add(emailLabel);
        p1.add(emailText);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.ration_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Manohar Vemuri
 */
public class addOfficer {
    public static void main(String [] args){
        new addOfficer_();
        
    }
    
}


class addOfficer_ extends JFrame{
    public addOfficer_(){
        JPanel p1=new JPanel();
        
        
        JLabel l1=new JLabel("Add Officer");
        l1.setBounds(550,50,150,30);
        
        
        
        JLabel nameLabel=new JLabel("Name :");
        nameLabel.setBounds(470,150,50,25);
        
        
        JTextField nameText=new JTextField();
        nameText.setBounds(570,150,200,25);
        
        
        JLabel emailLabel=new JLabel("Email :");
        emailLabel.setBounds(470,210,50,25);
        
        JTextField emailText=new JTextField();
        emailText.setBounds(570,210,200,25);
        
        
        JLabel passLabel=new JLabel("Password :");
        passLabel.setBounds(470,270,100,25);
        
        JPasswordField passText=new JPasswordField();
        passText.setBounds(570,270,200,25);
        
        
        JLabel contactLabel=new JLabel("Contact :");
        contactLabel.setBounds(470,330,100,25);
        
        JTextField contactText=new JTextField();
        contactText.setBounds(570,330,200,25);
        
        
        
        JLabel divLabel=new JLabel("Division :");
        divLabel.setBounds(470,390,100,25);
        
        JTextField divText=new JTextField();
        divText.setBounds(570,390,200,25);
        
        
        
        JButton back=new JButton("Back");
        back.setBounds(470,500,100,25);
        
        JButton add=new JButton("Add");
        add.setBounds(670,500,100,25);
        
        
        
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    System.out.println(nameText.getText());
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                    Statement stmt=con.createStatement();
                    String st="insert into eRation(name,email,password,contact,division,status,type)values"
                            + "('"+nameText.getText()+"','"+emailText.getText()+"','"+passText.getText()+"',"+contactText.getText()+","+divText.getText()+","
                            + "'N','Officer')";
                    stmt.executeUpdate(st);
                    JOptionPane.showMessageDialog(null, "Added Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Success");
                }
                catch(Exception e2){
                    System.out.println(e2);
                }
                
            }
        });
        
        
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new admin_();
                dispose();
            }
        });
        
        
        
        
        
        p1.add(l1);
        p1.add(nameLabel);
        p1.add(nameText);
        p1.add(emailLabel);
        p1.add(emailText);
        p1.add(passLabel);
        p1.add(passText);
        p1.add(contactLabel);
        p1.add(contactText);
        p1.add(divLabel);
        p1.add(divText);
        p1.add(add);
        p1.add(back);
        
        add(p1);
        p1.setLayout(null);
        setVisible(true);
        setSize(1200,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

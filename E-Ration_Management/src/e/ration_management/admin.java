/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.ration_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Manohar Vemuri
 */
public class admin {
    public static void main(String [] args){
        
        new admin_();
    }
    
}


class admin_ extends JFrame{
    public admin_(){
        
        
        JPanel p1=new JPanel();
        
        JLabel l1=new JLabel("Admin");
        l1.setBounds(540,25,200,50);
        l1.setFont(new Font("Courier",Font.BOLD,25));
        
        
        JButton add=new JButton("Add Officer");
        add.setBounds(400,100,150,50);
        
        JButton view=new JButton("View Officers");
        view.setBounds(600,100,150,50);
        
        
        JButton logout=new JButton("Logout");
        logout.setBounds(525,400,100,30);
        
        
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new addOfficer_();
                dispose();
                
            }
        });
        
        view.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new viewOfficer_();
                dispose();
                
            }
        });
        
        
        logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new login();
                dispose();
                
            }
        });
        
        
        p1.add(l1);
        p1.add(add);
        p1.add(view);
        p1.add(logout);
        add(p1);
        
        
        
        p1.setLayout(null);
        setVisible(true);
        setSize(1200,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}




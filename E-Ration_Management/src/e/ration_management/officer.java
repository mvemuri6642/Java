/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.ration_management;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Manohar Vemuri
 */
public class officer {
    public static void main(String args[]){
        new officer_();
    }
}


class officer_ extends JFrame{
    public officer_(){
        
        JPanel p1=new JPanel();
        
        
        JLabel viewLabel=new JLabel("Officers Details");
        viewLabel.setBounds(500,25,200,30);
        viewLabel.setFont(new Font("Courier",Font.BOLD,25));
        
        JButton add=new JButton("Add Account");
        add.setBounds(450,150,125,25);
        
        JButton view=new JButton("View Accounts");
        view.setBounds(600,150,125,25);
        
        JButton status=new JButton("Status");
        status.setBounds(525,250,125,25);
        
        
        JButton logout=new JButton("Logout");
        logout.setBounds(1050,25,75,25);
        
        
        
        add.addActionListener(e->{
            new addAccount_();
            dispose();
        });
        
        view.addActionListener(e->{
            new viewAccount_();
            dispose();
        });
        
        status.addActionListener(e->{
            new status_();
            dispose();
        });
        logout.addActionListener(e->{
            new login();
            dispose();
        });
        int div=login.d;
        System.out.println(div);
        
        
        
        
        
        
        add(p1);
        p1.add(viewLabel);
        p1.add(add);
        p1.add(view);
        p1.add(status);
        p1.add(logout);
        p1.setLayout(null);
        setVisible(true);
        setSize(1200,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
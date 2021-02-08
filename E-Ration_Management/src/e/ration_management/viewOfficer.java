/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.ration_management;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Manohar Vemuri
 */
public class viewOfficer {
    public static void main(String [] args){
        new viewOfficer_();
    }
}


class viewOfficer_ extends JFrame{
    DefaultTableModel tbmodel;
    public viewOfficer_(){
        
        JPanel p1=new JPanel();
        
        
        JLabel viewLabel=new JLabel("Officers Details");
        viewLabel.setBounds(200,25,200,30);
        viewLabel.setFont(new Font("Courier",Font.BOLD,18));
        
        
        tbmodel=new DefaultTableModel();
        JTable tb=new JTable(tbmodel);
        tb.setCellSelectionEnabled(true);
        tb.setPreferredScrollableViewportSize(new Dimension(850,200));
        tbmodel.addColumn("Name");
        tbmodel.addColumn("Email");
        tbmodel.addColumn("Password");
        tbmodel.addColumn("Contact");
        tbmodel.addColumn("Division");
        tbmodel.addColumn("Status");
        JScrollPane sp=new JScrollPane(tb);
        sp.setBounds(25,60,500,200);
        
        
        JLabel updateLabel=new JLabel("Update Details");
        updateLabel.setBounds(820,25,200,30);
        updateLabel.setFont(new Font("Courier",Font.BOLD,18));
        
        
        JLabel nameLabel=new JLabel("Name :");
        nameLabel.setBounds(770,100,50,25);
        
        
        JTextField nameText=new JTextField();
        nameText.setBounds(870,100,200,25);
        
        
        JLabel emailLabel=new JLabel("Email :");
        emailLabel.setBounds(770,160,50,25);
        
        JTextField emailText=new JTextField();
        emailText.setBounds(870,160,200,25);
        
        
        JLabel passLabel=new JLabel("Password :");
        passLabel.setBounds(770,220,100,25);
        
        JPasswordField passText=new JPasswordField();
        passText.setBounds(870,220,200,25);
        
        
        JLabel contactLabel=new JLabel("Contact :");
        contactLabel.setBounds(770,280,100,25);
        
        JTextField contactText=new JTextField();
        contactText.setBounds(870,280,200,25);
        
        
        
        JLabel divLabel=new JLabel("Division :");
        divLabel.setBounds(770,340,100,25);
        
        JTextField divText=new JTextField();
        divText.setBounds(870,340,200,25);
        
        
        
        JButton clr=new JButton("Clear");
        clr.setBounds(750,460,100,25);
        
        JButton delete=new JButton("Delete");
        delete.setBounds(870,460,100,25);
        
        JButton edit=new JButton("Edit");
        edit.setBounds(990,460,100,25);
        
        
        JButton back=new JButton("Back");
        back.setBounds(50,650,100,25);
        
        
        
        
        
        p1.add(viewLabel);
        p1.add(sp);
        p1.add(updateLabel);
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
        p1.add(edit);
        p1.add(delete);
        p1.add(clr);
        p1.add(back);
        add(p1);
        p1.setLayout(null);
        setVisible(true);
        setSize(1200,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

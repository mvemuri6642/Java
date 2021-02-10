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
public class viewAccount {
    public static void main(String [] args){
        new viewAccount_();
        
    }
    
}
class viewAccount_ extends JFrame{
    DefaultTableModel tbmodel;
    public viewAccount_(){
        JLabel viewLabel=new JLabel("Account Details");
        viewLabel.setBounds(550,10,200,25);
        JPanel p1=new JPanel();
        
        tbmodel=new DefaultTableModel();
        JTable tb=new JTable(tbmodel);
        tbmodel.addColumn("ID");
        tbmodel.addColumn("Name");
        tbmodel.addColumn("Aadhaar");
        tbmodel.addColumn("Contact");
        tbmodel.addColumn("Door No");
        tbmodel.addColumn("Division");
        tbmodel.addColumn("Village");
        tbmodel.addColumn("Mandal");
        tbmodel.addColumn("Status");
        JScrollPane sp=new JScrollPane(tb);
        sp.setBounds(50,50,1080,250);
        
        
        JLabel updateLabel=new JLabel("Account Update");
        updateLabel.setBounds(550,350,200,25);
        
        
        JLabel idLabel=new JLabel("ID");
        idLabel.setBounds(50,400,100,25);
        
        JTextField idText=new JTextField();
        idText.setBounds(150,400,150,25);
        
        JLabel nameLabel=new JLabel("Name");
        nameLabel.setBounds(50,450,100,25);
        
        JTextField nameText=new JTextField();
        nameText.setBounds(150,450,150,25);
        
        JLabel contactLabel=new JLabel("Contact");
        contactLabel.setBounds(50,500,100,25);
        
        JTextField contactText=new JTextField();
        contactText.setBounds(150,500,150,25);
        
        JLabel divisionLabel=new JLabel("Division");
        divisionLabel.setBounds(50,550,100,25);
        
        JTextField divisionText=new JTextField();
        divisionText.setBounds(150,550,150,25);
        
        JLabel mandalLabel=new JLabel("Mandal");
        mandalLabel.setBounds(50,600,100,25);
        
        JTextField mandalText=new JTextField();
        mandalText.setBounds(150,600,150,25);
        
        
        JLabel statusLabel=new JLabel("Status");
        statusLabel.setBounds(400,400,100,25);
        
        JTextField statusText=new JTextField();
        statusText.setBounds(500,400,150,25);
        
        JLabel doorLabel=new JLabel("Door No");
        doorLabel.setBounds(400,450,100,25);
        
        JTextField doorText=new JTextField();
        doorText.setBounds(500,450,150,25);
        
        JLabel aadhaarLabel=new JLabel("Aadhaar No");
        aadhaarLabel.setBounds(400,500,100,25);
        
        JTextField aadhaarText=new JTextField();
        aadhaarText.setBounds(500,500,150,25);
        
        JLabel villageLabel=new JLabel("Village");
        villageLabel.setBounds(400,550,100,25);
        
        JTextField villageText=new JTextField();
        villageText.setBounds(500,550,150,25);
        
        
        
        JButton delete =new JButton("Delete");
        delete.setBounds(750,400,100,25);
        JButton update =new JButton("Clear");
        update.setBounds(750,450,100,25);
        JButton clr =new JButton("Delete");
        clr.setBounds(750,500,100,25);
        
        
        JButton back =new JButton("Back");
        back.setBounds(1030,400,100,25);
        JButton logout =new JButton("Logout");
        logout.setBounds(1030,450,100,25);
        
        
        
        
        
        
        
        
        
        p1.add(viewLabel);
        p1.add(sp);
        p1.add(updateLabel);
        p1.add(idLabel);
        p1.add(idText);
        p1.add(nameLabel);
        p1.add(nameText);
        p1.add(contactLabel);
        p1.add(contactText);
        p1.add(divisionLabel);
        p1.add(divisionText);
        p1.add(mandalLabel);
        p1.add(mandalText);
        p1.add(statusLabel);
        p1.add(statusText);
        p1.add(doorLabel);
        p1.add(doorText);
        p1.add(aadhaarLabel);
        p1.add(aadhaarText);
        p1.add(villageLabel);
        p1.add(villageText);
        p1.add(delete);
        p1.add(update);
        p1.add(clr);
        p1.add(back);
        p1.add(logout);
        
        add(p1);
        p1.setLayout(null);
        setVisible(true);
        setSize(1200,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}

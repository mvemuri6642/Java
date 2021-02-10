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
public class status {
    public static void main(String[] args){
        new status_();
        
    }
    
}


class status_ extends JFrame{
    public status_(){
        DefaultTableModel tbmodel;
        JLabel viewLabel=new JLabel("Status");
        viewLabel.setBounds(570,10,200,25);
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
        
        
        
        
        p1.add(viewLabel);
        p1.add(sp);
        add(p1);
        
        p1.setLayout(null);
        setVisible(true);
        setSize(1200,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

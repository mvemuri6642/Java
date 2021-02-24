/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.ration_management;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
        
        
        
        
        tbmodel.setRowCount(0);
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            String query="select * from account where division="+login.d+" and status='N'";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String id=String.valueOf(rs.getString("ID"));
                String name=String.valueOf(rs.getString("name"));
                String aadhaar=String.valueOf(rs.getString("aadhaar"));
                String contact=String.valueOf(rs.getString("Contact"));
                String door=String.valueOf(rs.getString("door_no"));
                String village=String.valueOf(rs.getString("village"));
                String mandal=String.valueOf(rs.getString("mandal"));
                String div=String.valueOf(rs.getString("division"));
                String status=String.valueOf(rs.getString("status"));
                
                
                String tbdata[]={id,name,aadhaar,contact,door,village,mandal,div,status};
                tbmodel.addRow(tbdata);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
        
        
        
        
        p1.add(viewLabel);
        p1.add(sp);
        add(p1);
        
        p1.setLayout(null);
        setVisible(true);
        setSize(1200,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

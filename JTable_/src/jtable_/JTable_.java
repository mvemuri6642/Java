/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtable_;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Manohar Vemuri
 */
public class JTable_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new jtable_example();
    }
    
}
class jtable_example extends JFrame{
    public jtable_example(){
        String[] Column={"Name"};
        String [][] data={};
        
        //tb.setFillsViewportHeight(true);
        DefaultTableModel tbmodel=new DefaultTableModel();
        JTable tb=new JTable(tbmodel);
        tb.setPreferredScrollableViewportSize(new Dimension(850,50)); //table size
        tbmodel.addColumn("Firstname");
        tbmodel.addColumn("Lastname");
        tbmodel.addColumn("Email");
        tbmodel.addColumn("Password");
        JScrollPane sp=new JScrollPane(tb);
        sp.setBounds(100, 200, 800, 150);
        add(sp);
        
        setSize(1200,750);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu", "root", "manu");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select firstName,lastname,Email,Password from MasterData");
            while(rs.next()){
                String firstname=String.valueOf(rs.getString("firstname"));
                String lastname=String.valueOf(rs.getString("lastname"));
                String email=String.valueOf(rs.getString("email"));
                String pass=String.valueOf(rs.getString("password"));
                String tbdata[]={firstname,lastname,email,pass};
                DefaultTableModel model=(DefaultTableModel)tb.getModel();
                model.addRow(tbdata);
            }
           
        }
        catch(Exception e){
            System.out.println("Error"+e);
            
        }
    }
    
    
    
}

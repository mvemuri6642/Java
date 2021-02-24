/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.ration_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
    static String name="";
    String email="";
    public viewOfficer_(){
        
        JPanel p1=new JPanel();
        
        
        JLabel viewLabel=new JLabel("Officers Details");
        viewLabel.setBounds(200,25,200,30);
        viewLabel.setFont(new Font("Courier",Font.BOLD,18));
        
        
        tbmodel=new DefaultTableModel();
        JTable tb=new JTable(tbmodel);
        tb.setCellSelectionEnabled(true);
        tb.setPreferredScrollableViewportSize(new Dimension(850,200));
        tbmodel.addColumn("ID");
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
        
        JTextField idText=new JTextField();
        
        
        tbmodel.setRowCount(0);
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            String query="select * from eRation where type='Officer'";
            
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String name=String.valueOf(rs.getString("Name"));
                String email=String.valueOf(rs.getString("Email"));
                String pass=String.valueOf(rs.getString("password"));
                String contact=String.valueOf(rs.getString("Contact"));
                String div=String.valueOf(rs.getString("division"));
                String status=String.valueOf(rs.getString("status"));
                String id=String.valueOf(rs.getString("ID"));
                
                String tbdata[]={id,name,email,pass,contact,div,status};
                tbmodel.addRow(tbdata);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    
        
        
        
        tb.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int i=tb.getSelectedRow();
                TableModel model=tb.getModel();
                idText.setText(model.getValueAt(i, 0).toString());
                nameText.setText(model.getValueAt(i, 1).toString());
                emailText.setText(model.getValueAt(i, 2).toString());
                passText.setText(model.getValueAt(i, 3).toString());
                contactText.setText(model.getValueAt(i, 4).toString());
                divText.setText(model.getValueAt(i, 5).toString());
                //qtyText.setText(model.getValueAt(i,2).toString());
                name=nameText.getText();
                email=emailText.getText();
            }
        });
        
        System.out.println(name);
        edit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                    Statement stmt=con.createStatement();
                    
                    String query="update eRation set name='"+nameText.getText()+"',email='"+emailText.getText()+"',password='"+passText.getText()+"',"
                            + "contact='"+contactText.getText()+"',division='"+divText.getText()+"' where ID='"+idText.getText()+"'";
            
                    stmt.executeUpdate(query);
                    RefreshTB();
                    
                    
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error","Error",JOptionPane.INFORMATION_MESSAGE);
                    
                }
            }
        });
        
        
        
        delete.addActionListener(e->{
            int a=JOptionPane.showConfirmDialog(null, "Delete?","",JOptionPane.YES_NO_OPTION);
            if(a==0){
                try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                Statement stmt=con.createStatement();
                String query="delete from eRation where id='"+idText.getText()+"'";
                stmt.executeUpdate(query);
                RefreshTB();
                }
                catch(Exception ex2){
                JOptionPane.showMessageDialog(null, "Error","Error",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
            }
            
            
        });
        clr.addActionListener(e->{
            nameText.setText("");
            emailText.setText("");
            passText.setText("");
            contactText.setText("");
            divText.setText("");
            idText.setText("");
        });
        
        back.addActionListener(e->{
            new admin_();
            dispose();
        });
        
        
        
        
        
        
        
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
    public void RefreshTB(){
        tbmodel.setRowCount(0);
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            String query="select * from eRation where type='Officer'";
            
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                String name=String.valueOf(rs.getString("Name"));
                String email=String.valueOf(rs.getString("Email"));
                String pass=String.valueOf(rs.getString("password"));
                String contact=String.valueOf(rs.getString("Contact"));
                String div=String.valueOf(rs.getString("division"));
                String status=String.valueOf(rs.getString("status"));
                String id=String.valueOf(rs.getString("ID"));
                
                String tbdata[]={id,name,email,pass,contact,div,status};
                tbmodel.addRow(tbdata);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}

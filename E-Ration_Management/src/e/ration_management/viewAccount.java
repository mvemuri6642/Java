/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.ration_management;
import static e.ration_management.viewOfficer_.name;
import javax.swing.*;
import java.awt.*;
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
        tbmodel.addColumn("Village");
        tbmodel.addColumn("Mandal");
        tbmodel.addColumn("Division");
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
        nameLabel.setBounds(50,400,100,25);
        
        JTextField nameText=new JTextField();
        nameText.setBounds(150,400,150,25);
        
        JLabel contactLabel=new JLabel("Contact");
        contactLabel.setBounds(50,450,100,25);
        
        JTextField contactText=new JTextField();
        contactText.setBounds(150,450,150,25);
        
        JLabel divisionLabel=new JLabel("Division");
        divisionLabel.setBounds(50,500,100,25);
        
        JTextField divisionText=new JTextField();
        divisionText.setBounds(150,500,150,25);
        
        JLabel mandalLabel=new JLabel("Mandal");
        mandalLabel.setBounds(50,550,100,25);
        
        JTextField mandalText=new JTextField();
        mandalText.setBounds(150,550,150,25);
        
        
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
        
        
        
        JButton update =new JButton("Update");
        update.setBounds(750,400,100,25);
        JButton delete =new JButton("Delete");
        delete.setBounds(750,450,100,25);
        JButton clr =new JButton("Clear");
        clr.setBounds(750,500,100,25);
        
        
        JButton back =new JButton("Back");
        back.setBounds(1030,400,100,25);
        JButton logout =new JButton("Logout");
        logout.setBounds(1030,450,100,25);
        
        
        
        
        
        
        
        
        
        
        
        
        
        tbmodel.setRowCount(0);
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            String query="select * from account where division="+login.d+"";
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
    
        
        
        
        tb.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int i=tb.getSelectedRow();
                TableModel model=tb.getModel();
                idText.setText(model.getValueAt(i, 0).toString());
                nameText.setText(model.getValueAt(i, 1).toString());
                aadhaarText.setText(model.getValueAt(i, 2).toString());
                contactText.setText(model.getValueAt(i, 3).toString());
                doorText.setText(model.getValueAt(i, 4).toString());
                villageText.setText(model.getValueAt(i, 5).toString());
                mandalText.setText(model.getValueAt(i, 6).toString());
                divisionText.setText(model.getValueAt(i, 7).toString());
                statusText.setText(model.getValueAt(i, 8).toString());
                //qtyText.setText(model.getValueAt(i,2).toString());
            }
        });
        
        
        update.addActionListener(e->{
            try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            String query="update account set name='"+nameText.getText()+"',aadhaar="+aadhaarText.getText()+",contact="+contactText.getText()+",door_no='"+doorText.getText()+"',"
                    + "village='"+villageText.getText()+"',mandal='"+mandalText.getText()+"',division='"+divisionText.getText()+"',status='"+statusText.getText()+"' where id="+idText.getText()+"";
            int rs=stmt.executeUpdate(query);
            if(rs!=0){
                JOptionPane.showConfirmDialog(null, "Updated","",JOptionPane.PLAIN_MESSAGE);
                refresh();
            }
            else{
                System.out.println("fail");
            }
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
            
        });
        
        delete.addActionListener(e->{
            try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            String query="delete from account where id='"+idText.getText()+"'";
            int rs=stmt.executeUpdate(query);
            if(rs!=0){
                JOptionPane.showConfirmDialog(null, "Deleted","",JOptionPane.PLAIN_MESSAGE);
                refresh();
            }
            else{
                System.out.println("fail");
            }
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        });
        clr.addActionListener(e->{
            idText.setText("");
            nameText.setText("");
            aadhaarText.setText("");
            contactText.setText("");
            doorText.setText("");
            villageText.setText("");
            mandalText.setText("");
            divisionText.setText("");
            statusText.setText("");
        });
        
        back.addActionListener(e->{
            new officer_();
            dispose();
        });
        
        logout.addActionListener(e->{
            new login();
            dispose();
        });
        
        
        
        
        
        
        
        p1.add(viewLabel);
        p1.add(sp);
        p1.add(updateLabel);
        //p1.add(idLabel);
        //p1.add(idText);
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
    public void refresh(){
        tbmodel.setRowCount(0);
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
            Statement stmt=con.createStatement();
            String query="select * from account where division="+login.d+"";
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
    }
}


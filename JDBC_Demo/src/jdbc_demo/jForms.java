/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_demo;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author Manohar Vemuri
 */
public class jForms {
    
    
    
    public jForms(){
        JFrame f=new JFrame();
        JTextField t1=new JTextField(10);
        JButton ins=new JButton("Insert");
        JButton dis=new JButton("Display");
        JButton del=new JButton("Delete");
        JLabel l1=new JLabel();
        f.add(t1);
        f.add(ins);
        f.add(dis);
        f.add(del);
        f.add(l1);
        
        
        ins.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                    Statement stmt=con.createStatement();
                    stmt.executeUpdate("insert into student values('"+t1.getText()+"')");
                    t1.setText("");
                    if(stmt!=null){
                        l1.setText("1 Row affected");
                    }
                    
                    stmt.close();
                    con.close();
                }
                catch(SQLException ex){
                    System.out.println("Fail to insert :"+ex);
                }
            }
        });
        
        
        
        dis.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("select * from student");
                    while(rs.next()){
                        System.out.println(rs.getString(1));
                    }
                    rs.close();
                    stmt.close();
                    con.close();
                }
                catch(SQLException ex1){
                    System.out.println("Fail to select:"+ex1);
                }
            }
        });
        
        
        
        
        del.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manu","root","manu");
                    Statement stmt=con.createStatement();
                    stmt.executeUpdate("delete from student where sname='"+t1.getText()+"'");
                    t1.setText("");
                    l1.setText("1 Row affected");
                    stmt.close();
                    con.close();
                }
                catch(SQLException ex2){
                    System.out.println("Fail to delete:"+ex2);
                }
                
            }
        });
        
        t1.addMouseListener(new MouseAdapter(){
           public void mousePressed(MouseEvent e){
               l1.setText("");
           } 
        });
        
        
        
        
        
        f.setVisible(true);
        f.setSize(300,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        
        
    }
    public static void main(String[] args){
        new jForms();
    }
    
}

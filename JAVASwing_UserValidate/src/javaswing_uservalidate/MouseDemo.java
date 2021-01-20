/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing_uservalidate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Manohar Vemuri
 */
public class MouseDemo {
    public static void main(String[] args){
        mouseDem ob1=new mouseDem();
    }
    
}
class  mouseDem extends JFrame{
    JButton b1;
    JLabel l1;
    JTextField t1;
    JTextField t2;
    public mouseDem(){
        b1=new JButton("Submit");
        l1=new JLabel();
        t1=new JTextField(5);
        t2=new JTextField(5);
        add(t1);
        add(t2);
        add(b1);
        add(l1);
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int x=e.getX();
                int y=e.getY();
                System.out.println(x+","+y);
            }
        });
        b1.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int num1=Integer.parseInt(t1.getText());
                int num2=Integer.parseInt(t2.getText());
                int val=num1+num2;
                l1.setText(" "+val);
            }
        });
        
        
        
        setVisible(true);
        setSize(400,400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Manohar Vemuri
 */
public class SubGui {
    public static void main(String[] args){
        Subt ob1=new Subt();
    }
}


class Subt extends JFrame{
    JTextField t1=new JTextField(10);
    JTextField t2=new JTextField(10);
    JButton b1=new JButton("Addition");
    JButton b2=new JButton("Subtract");
    JButton b3=new JButton("Multiply");
    JLabel l1=new JLabel("Result:");
    public Subt(){
        add(t1);
        add(t2);
        add(l1);
        add(b1);
        add(b2);
        add(b3);
        //Addition
        ActionListener a1=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int num1=Integer.parseInt(t1.getText());
                int num2=Integer.parseInt(t2.getText());
                int val=num1+num2;
                l1.setText("Result: "+val);
            }
        }; //Anonymous class
        b1.addActionListener(a1);
        
        // Subtraction without creating an object 
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int num1=Integer.parseInt(t1.getText());
                int num2=Integer.parseInt(t2.getText());
                int val=num1-num2;
                l1.setText("Result: "+val);
            }
        });
        
        
        //Multiply using Lambda Expression   "Lambda Expression only works on JAVA 8.0"
        b3.addActionListener(e ->{
            int num1=Integer.parseInt(t1.getText());
            int num2=Integer.parseInt(t2.getText());
            int val=num1*num2;
            l1.setText("Result: "+val);
        });
        
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Manohar Vemuri
 */
public class AddGui {
    public static void main(String[] args){
        Addition ob1= new Addition();
    }
    
}

class Addition extends JFrame implements ActionListener{
    JTextField t1=new JTextField(10);
    JTextField t2=new JTextField(10);
    JLabel l1=new JLabel("Result:");
    JButton b1=new JButton("Calculate");
    public Addition(){
        add(t1);
        add(t2);
        add(l1);
        add(b1);
        b1.addActionListener(this);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        int num1=Integer.parseInt(t1.getText());
        int num2=Integer.parseInt(t2.getText());
        int val=num1+num2;
        l1.setText("Result: "+val+" ");
    }
}

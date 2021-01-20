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
public class JFrame_Caller {
    public static void main(String[] args){
        callJFrame ob1=new callJFrame();
    }
}


class callJFrame extends JFrame implements ActionListener{
    JProgressBar p;
    int i=0;
    public callJFrame(){
        
        JButton b1=new JButton("Login");
        p=new JProgressBar(0,20);
        Timer t=new Timer(250,this);
        b1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               t.start();
           } 
        });
        add(b1);
        add(p);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if(i==20){
            new RadioDemo();
            dispose();
        }
        i++;
        p.setValue(i);
    }
}

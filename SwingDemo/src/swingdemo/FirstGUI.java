/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdemo;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
/**
 *
 * @author Manohar Vemuri
 */
public class FirstGUI {
    public static void main(String[] args){
        GUI ob1=new GUI();
    }
    
    
}

class GUI extends JFrame{
    public GUI(){
        setVisible(true);
        setSize(300,300);
        setLayout(new FlowLayout());
        JLabel l1=new JLabel("Hello, World");
        JLabel l2=new JLabel("Manohar");
        add(l1);
        add(l2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //or you can just send a parameter as " 3 "
    }
}

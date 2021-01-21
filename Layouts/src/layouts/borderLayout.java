/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Manohar Vemuri
 */
public class borderLayout {
    public static void main(String[] args){
        new border_Layout();
    }
}

class border_Layout extends JFrame{
    JFrame f;
    JPanel p1;
    JPanel p2;
    JPanel p3;
    JPanel p4;
    JPanel p5;
    
    JPanel p6;
    JLabel l1;
    public border_Layout(){
        f=new JFrame();
        f.setLayout(new BorderLayout(5,5));
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();
        
        p6=new JPanel();
        
        l1=new JLabel("Hello");
        
        p1.setBackground(Color.red);
        p2.setBackground(Color.blue);
        p3.setBackground(Color.yellow);
        p4.setBackground(Color.magenta);
        p5.setBackground(Color.green);
        p6.setBackground(Color.black);
        
        
        p1.add(l1);
        
        
        p1.setPreferredSize(new Dimension(100,100));
        p2.setPreferredSize(new Dimension(100,100));
        p3.setPreferredSize(new Dimension(100,100));
        p4.setPreferredSize(new Dimension(100,100));
        p5.setPreferredSize(new Dimension(100,100));
        
        
        
        p6.setPreferredSize(new Dimension(50,50));
        
        
        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.SOUTH);
        f.add(p3,BorderLayout.EAST);
        f.add(p4,BorderLayout.WEST);
        f.add(p5,BorderLayout.CENTER);
        
        p5.setLayout(new BorderLayout());
        p5.add(p6,BorderLayout.NORTH);
        
        f.setVisible(true);
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
                
    }
}
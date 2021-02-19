/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtab;
import javax.swing.*;

/**
 *
 * @author Manohar Vemuri
 */

class Jtab{
    JFrame f;
    Jtab(){
        f=new JFrame();
        JLabel l1=new JLabel("djn");
        JTextField ta=new JTextField(20);  
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        p1.add(ta);
        p2.add(l1);
        JTabbedPane tp=new JTabbedPane();  
        tp.setBounds(50,50,200,200);
        tp.add("main",p1);
        tp.add("ab",p2);
        f.add(tp);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Jtab();
        
        
    }
}


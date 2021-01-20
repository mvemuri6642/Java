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
public class UserInput {
    public static void main(String[] args){
        RadioDemo ob1=new RadioDemo();
    }
    
    
}

class RadioDemo extends JFrame{
    JTextField t1;
    JButton b1;
    JRadioButton r1;
    JRadioButton r2;
    JLabel l1;
    JCheckBox c1,c2;
    public RadioDemo(){
        t1=new JTextField(15);
        b1=new JButton("OK");
        r1=new JRadioButton("Male");
        r2=new JRadioButton("Female");
        l1=new JLabel();
        c1=new JCheckBox("Programmer");
        c2=new JCheckBox("Gamer");
        add(t1);
        add(r1);
        add(r2);
        add(c1);
        add(c2);
        add(b1);
        add(l1);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        
        
        c1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                System.out.println("Programmer");
            }
        });
        c2.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                System.out.println("Gamer");
            }
        });
        
        
        
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               String name=t1.getText();
               if(r1.isSelected()){
                   name="Mr. "+name;
               }
               else{
                   name="Ms. "+name;
               }
               if(c1.isSelected()){
                   name=name+", Programmer";
               }
               if(c2.isSelected()){
                   name=name+", Gamer";
               }
               l1.setText("Hello, "+name);
            }
        });
        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

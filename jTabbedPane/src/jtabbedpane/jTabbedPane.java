/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtabbedpane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Manohar Vemuri
 */
public class jTabbedPane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new JTabbed_Pane();
    }
    
}

class JTabbed_Pane{
    public JTabbed_Pane(){
        
        JFrame f=new JFrame();
        JTabbedPane tp=new JTabbedPane(JTabbedPane.LEFT); 
        //tp.setTabPlacement(JTabbedPane.RIGHT);
        
        JPanel dept=new JPanel();
        JPanel lang=new JPanel();
        JRadioButton cs=new JRadioButton("CSE");
        JRadioButton it=new JRadioButton("IT");
        JCheckBox cl=new JCheckBox("C Language");
        JCheckBox cpp=new JCheckBox("C++");
        JCheckBox python=new JCheckBox("Python");
        JCheckBox java=new JCheckBox("JAVA");
        
        ButtonGroup bg=new ButtonGroup();
        dept.add(cs);
        bg.add(cs);
        dept.add(it);
        bg.add(it);
        
        lang.add(cl);
        lang.add(cpp);
        lang.add(python);
        lang.add(java);
        
        
        
        
        
        
        
        
        
        tp.setBounds(50,50,200,200);
        tp.addTab("Department",dept);
        tp.addTab("Language", lang);
        tp.setBackgroundAt(0,Color.BLUE);
        tp.setForegroundAt(1,Color.RED);
        tp.setMnemonicAt(0, KeyEvent.VK_D);
        tp.setMnemonicAt(1,KeyEvent.VK_L);
        
        tp.setToolTipTextAt(0, "Department");
        tp.setToolTipTextAt(1, "Language");
        f.add(tp);
        f.setLayout(new GridLayout(1,1));
        f.setVisible(true);
        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

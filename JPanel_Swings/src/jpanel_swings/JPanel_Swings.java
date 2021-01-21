/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanel_swings;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

/**
 *
 * @author Manohar Vemuri
 */
public class JPanel_Swings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JLabel l1=new JLabel("Hello");
        l1.setVerticalAlignment(JLabel.TOP);
        l1.setHorizontalAlignment(JLabel.RIGHT);
        l1.setBounds(0,0,250,250);
        JPanel redpanel =new JPanel();
        
        JFrame f=new JFrame();
        redpanel.setBackground(Color.RED);
        redpanel.setBounds(0,0,250,250);
        f.add(redpanel);
        
        JPanel bluePanel=new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(250,0,250,250);
        bluePanel.add(l1);
        f.add(bluePanel);
        
        JPanel greenPanel=new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0,250,500,250);
        greenPanel.setLayout(new BorderLayout());
        //greenPanel.add(l1);
        f.add(greenPanel);
        
        
        
        f.setLayout(null);
        f.setSize(750,750);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

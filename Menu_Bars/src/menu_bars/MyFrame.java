/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_bars;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Manohar Vemuri
 */
public class MyFrame {
    public static void main(String[]args){
        MyFrame_ ob1=new MyFrame_();
    }
    
    
}
class MyFrame_ extends JFrame{
    JFrame f;
        JMenuBar m;
        JMenu fileMenu;
        JMenu edit;
        JMenu help;
        JMenuItem loadItem;
        JMenuItem saveItem;
        JMenuItem exitItem;
        
        public MyFrame_(){
        f=new JFrame();
        m=new JMenuBar();
        
        fileMenu=new JMenu("File");
        loadItem=new JMenuItem("Load");
        saveItem=new JMenuItem("Save");
        exitItem=new JMenuItem("Exit");
        
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        
        loadItem.addActionListener(e->{
            if(e.getSource()==loadItem){
                System.out.println("You Loaded Item");
            }
        });
        
        saveItem.addActionListener(e->{
            if(e.getSource()==saveItem){
                System.out.println("You saved a File");
            }
        });
        
        exitItem.addActionListener(e->{
           if(e.getSource()==exitItem){
               //f.dispose();
               System.exit(0);
           } 
        });
        
        
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        
        
        loadItem.setMnemonic(KeyEvent.VK_L);
        saveItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_E);
        
        edit=new JMenu("Edit");
        help=new JMenu("Help");
        m.add(fileMenu);
        m.add(edit);
        m.add(help);
        edit.setMnemonic(KeyEvent.VK_E);
        help.setMnemonic(KeyEvent.VK_H);
        f.setJMenuBar(m);
        f.setVisible(true);
        f.setSize(300,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
            
        }
        /*
        public void actionPerformed(ActionEvent e){
        if(e.getSource()==loadItem){
            System.out.println("Hello");
            }
        }
        */
}

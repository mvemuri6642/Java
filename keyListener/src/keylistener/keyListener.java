/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keylistener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Manohar Vemuri
 */
public class keyListener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new key_Listener();
    }
    
}

class key_Listener extends JFrame implements KeyListener{
    
    JLabel l1;
    ImageIcon icon;
    public key_Listener(){
        this.getContentPane().setBackground(Color.black);
        l1=new JLabel();
        icon=new ImageIcon("D:\\Manu\\Code\\Java\\keyListener\\src\\keylistener\\r.png");
        l1.setIcon(icon);
        l1.setBounds(0,0,100,100);
        //l1.setBackground(Color.red);
        //l1.setOpaque(true);
        add(l1);
        
        addKeyListener(this);
        
        
        setLayout(null);
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void keyTyped(KeyEvent e){
        switch(e.getKeyChar()){
            case 'a':   l1.setLocation(l1.getX()-10, l1.getY());
                        break;
            case 'd':   l1.setLocation(l1.getX()+10, l1.getY());
                        break;
            case 's':   l1.setLocation(l1.getX(),l1.getY()+10);
                        break;
            case 'w':   l1.setLocation(l1.getX(),l1.getY()-10);
                        break;
            default:    l1.setLocation(l1.getX(), l1.getY());
                        break;
            
        }
        
    }
    public void keyPressed(KeyEvent e){
        
    }
    public void keyReleased(KeyEvent e){
        //System.out.println("You Released key character"+e.getKeyChar());
        //System.out.println("You released key code:"+e.getKeyCode());
        
        
    }
}

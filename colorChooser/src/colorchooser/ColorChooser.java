/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Manohar Vemuri
 */
public class ColorChooser {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        color_Chooser ob1=new color_Chooser();
        
        
    }
}
    
    
    class color_Chooser extends JFrame implements ActionListener{
        JButton b1;
        JLabel l1;
        public color_Chooser(){
            b1=new JButton("Click");
            l1=new JLabel();
            l1.setText("Hello!");
            l1.setBackground(Color.white);
            l1.setFont(new Font("MV Boli",Font.PLAIN,50));
            l1.setOpaque(true);
            
            add(b1);
            add(l1);
            b1.addActionListener(this);
            
            setVisible(true);
            setSize(400,400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());
        }
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==b1){
                //JColorChooser cc=new JColorChooser();
                Color color=JColorChooser.showDialog(null, "Pick a color", Color.black);
                l1.setForeground(color);
                
            }
        }
}
    
    
    


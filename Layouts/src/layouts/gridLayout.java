/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Manohar Vemuri
 */
public class gridLayout {
    public static void main(String[] args){
        new grid_Layout();
    }
    
}
class grid_Layout extends JFrame{
    
    public grid_Layout(){
        setLayout(new GridLayout(3,3,5,5));
        add(new JButton("1"));
        add(new JButton("2"));
        add(new JButton("3"));
        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        add(new JButton("7"));
        add(new JButton("8"));
        add(new JButton("9"));
        add(new JButton("0"));
        
        
        
        
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

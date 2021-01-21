/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joptionpanes;
import javax.swing.*;
/**
 *
 * @author Manohar Vemuri
 */
public class JOptionPanes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f=new JFrame();
        JLabel l1=new JLabel();
        // TODO code application logic here
        //JOptionPane.showMessageDialog(null, "Success", "JOptionPane Demo", JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Information Message","Information Message",JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null,"Error Message","Error Message",JOptionPane.ERROR_MESSAGE);
        //JOptionPane.showMessageDialog(null,"Warning Message","Warning Message",JOptionPane.WARNING_MESSAGE);
        //JOptionPane.showMessageDialog(null,"Question Message","Question Message",JOptionPane.QUESTION_MESSAGE);
        
        f.add(l1);
        f.setVisible(true);
        f.setSize(300,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setVerticalAlignment(JLabel.CENTER);
        int ans=JOptionPane.showConfirmDialog(null, "Are You human?"," ",JOptionPane.YES_NO_CANCEL_OPTION);
        if(ans==0){
            l1.setText("Human");
        }
        else if(ans==1){
            l1.setText("Not a Human");
        }
        
        String [] responses={"Thankyou","cool","cheers"};
        //ImageIcon image=new ImageIcon("D:\\Manu\\Code\\Java\\JOptionPanes\\src\\joptionpanes\\img.png");
        //String Name=JOptionPane.showInputDialog(null,"What is your name:","Name",JOptionPane.PLAIN_MESSAGE);
        
        //JOptionPane.showMessageDialog(null, "Hello,"+Name,"Name",JOptionPane.PLAIN_MESSAGE);
        
        JOptionPane.showOptionDialog(null,"You're awsome bro!","Name",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.YES_NO_CANCEL_OPTION,
                null,responses,0);
    }
    
}

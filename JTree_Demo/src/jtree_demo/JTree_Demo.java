/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtree_demo;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
/**
 *
 * @author Manohar Vemuri
 */
public class JTree_Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        jTree ob1=new jTree();
    }
    
}

class jTree{
    
    public void jTree(){
        JFrame f=new JFrame();
        f.setLayout(new FlowLayout());
        DefaultMutableTreeNode col=new DefaultMutableTreeNode("College");
        
        DefaultMutableTreeNode as=new DefaultMutableTreeNode("Arts&Science");
        DefaultMutableTreeNode eng=new DefaultMutableTreeNode("Engineering");
        
        DefaultMutableTreeNode ba=new DefaultMutableTreeNode("BA");
        DefaultMutableTreeNode bsc=new DefaultMutableTreeNode("BSc");
        DefaultMutableTreeNode bcom=new DefaultMutableTreeNode("Bcom");
        
        DefaultMutableTreeNode btech=new DefaultMutableTreeNode("B.Tech");
        DefaultMutableTreeNode be=new DefaultMutableTreeNode("BE");
        
        
        
        
        col.add(as);
        col.add(eng);
        
        eng.add(be);
        eng.add(btech);
        
        as.add(ba);
        as.add(bsc);
        as.add(bcom);
        
        
        JTree jt=new JTree(col);
        f.add(jt);
        
        f.setSize(300,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
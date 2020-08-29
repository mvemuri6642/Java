/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copyconstructor;

/**
 *
 * @author Manohar V
 */
public class CopyConstructor {
    double width;
    double height;
    double depth;
    CopyConstructor(double w,double h,double d)
    {
        width=w;
        height=h;
        depth=d;
        System.out.println("width="+width+" "+"height="+height+" "+"depth="+depth);
    }
    
    CopyConstructor(CopyConstructor c1)
    {
        width=c1.width;
        height=c1.height;
        depth=c1.depth;
        System.out.println("Copy Constructor:"+(width*height*depth));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CopyConstructor c1=new CopyConstructor(10,20,30);
        CopyConstructor c2=new CopyConstructor(c1);
    }
    
}

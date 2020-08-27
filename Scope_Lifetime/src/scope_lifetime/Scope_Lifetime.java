/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scope_lifetime;

/**
 *
 * @author Manohar V
 */
public class Scope_Lifetime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x;
        x=10;
        if(x==10){
            int y=20;
            System.out.println("x and y:"+x+" "+y);
            x=y*2;
        }
        // y=100; // error y is not known here
        //x is still known here
        System.out.println("x is:"+x);
    }
    
}

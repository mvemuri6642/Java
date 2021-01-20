/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method_overriding;

/**
 *
 * @author Manohar Vemuri
 */
class one{
    void calculate(double d){
        System.out.println("square is:"+(d*d));
    }
}
class two extends one{
    void calculate(double d){
        System.out.println("square root is:"+(Math.sqrt(d))); //sqrt is a static method in Math class
    }
}



public class Method_Overriding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        two t = new two();
        t.calculate(25); //sub class method will only be invoked in method overriding
    }
    
}

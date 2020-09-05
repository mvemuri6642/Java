/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstract_class;

/**
 *
 * @author Manohar V
 */
abstract class one{
    abstract void calculate(double x);
}
class two extends one{
    void calculate(double x){
        System.out.println("square:"+(x*x));
    }
}
public class Abstract_Class {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        two t = new two();
        t.calculate(25);
        one o;
        o=t;
        System.out.println("Abstract Class:");
        o.calculate(5);
        
    }
    
}

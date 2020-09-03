/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single_inheritance;

/**
 *
 * @author Manohar V
 */
class Calculation{
    
    void addition(int a, int b){
        System.out.println("addition of (a,b):"+(a+b));
    }
    void subtraction(int a,int b){
        System.out.println("Subtraction of (a,b):"+(a-b));
    }
    }
class My_Calculation extends Calculation{
    void multiplication(int a, int b){
        System.out.println("Multiplication of (a,b) "+(a*b));
    }
}
public class Single_Inheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        My_Calculation o = new My_Calculation();
        o.addition(4, 3);
        o.subtraction(4, 3);
        o.multiplication(4, 3);
        
    }
    
}

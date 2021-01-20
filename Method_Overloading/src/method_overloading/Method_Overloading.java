/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method_overloading;

/**
 *
 * @author Manohar Vemuri
 */
class one{
    void add(int a, int b){
        System.out.println("Sum is:"+(a+b));
    }
    void add(int a, double b){
        System.out.println("Sum is:"+(a+b));
    }
}
public class Method_Overloading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        one o = new one();
        o.add(10,20);
        o.add(10,2.5);
    }
    
}

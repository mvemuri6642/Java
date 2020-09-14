/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Manohar V
 */
interface A{
    void calculate(double x);
}
interface B extends A {
    void calculate1(double x);
}
class C implements A{
    public void calculate(double x){
        System.out.println("square root="+(Math.sqrt(x)));
    }
}
class D implements B{
    public void calculate(double x){
        System.out.println("area of circle="+(3.14*x*x)); //extends interface A
    }
    public void calculate1(double x){
        System.out.println("square="+(x*x));             //interface B
    }
}






public class Interfaces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        C c=new C();
        c.calculate(25);
        D d=new D();
        d.calculate(5);
        d.calculate1(5);
    }
    
}

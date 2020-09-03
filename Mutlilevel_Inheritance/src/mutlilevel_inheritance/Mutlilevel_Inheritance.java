/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutlilevel_inheritance;

/**
 *
 * @author Manohar V
 */
class Addition{
    public void add(int a,int b){
        System.out.println("Addition:"+(a+b));
    }
}
class Subtraction extends Addition{
    public void sub(int a, int b){
        System.out.println("Subtraction:"+(a-b));
    }
}
class Multiplication extends Subtraction{
    public void mul(int a, int b){
        System.out.println("Multiplication:"+(a*b));
    }
}
public class Mutlilevel_Inheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Multiplication o = new Multiplication();
        o.add(4, 3);
        o.sub(4, 3);
        o.mul(4, 3);
    }
    
}

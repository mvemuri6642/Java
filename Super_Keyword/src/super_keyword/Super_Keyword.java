/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_keyword;

/**
 *
 * @author Manohar V
 */
class Super{
    int i;
    Super(int m){
        System.out.println(m);
    }
    void show(){
        System.out.println("Super Class");
    }
}
class Sub extends Super{
    int i;
    int c;
    Sub(){
        super(5);           //invoke super class constructor by sending a parameters
    }
    Sub(int a , int b,int c){
        this();          // used to invoke current class constructor
        super.i=a;      //used to refer super class variable
        i=b;
        this.c=c;       //used to refer current class instance variable
        System.out.println(super.i);
        System.out.println(i);
        this.show();
    }
    //method overriding
    void show(){
        super.show();       //invokes super class method 
        System.out.println("Sub Class");
        System.out.println(c);
    }
}
public class Super_Keyword {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sub ob1 = new Sub(10,20,30);
    }
}

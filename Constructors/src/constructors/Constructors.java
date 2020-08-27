/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructors;

/**
 *
 * @author Manohar V
 */


//default constructor which doesn't have any parameters
class defaultCon{
    int a,b;
    defaultCon(){ //constructors do not have any return type, not even void also
        a=10;
        b=20;
        System.out.println("default constructor:");
        System.out.println("a="+a+" "+"b="+b);
    }
}



public class Constructors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        defaultCon o=new defaultCon();
    }
    
}

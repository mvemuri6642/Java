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
/**
class defaultCon{
    int a,b;
    defaultCon(){ //constructors do not have any return type, not even void also
        a=10;   //instance variables
        b=20;   //the variables which are defined inside classand outside method are called instance variables
        System.out.println("default constructor:");
        //System.out.println(+a+" "+b);
        System.out.println("a="+a+" "+"b="+b);
    }
}
*/


class ParameterizedCon
{
    double width;
    double height;
    double depth;
    ParameterizedCon(double w,double h,double d)
    {
        width=w;
        height=h;
        depth=d;
    }
    double volume()
    {
        return width*height*depth;
    }
}


public class Constructors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ParameterizedCon p=new ParameterizedCon(10,20,30);
        System.out.println("Volume is:"+(p.volume()));
    }
    
}

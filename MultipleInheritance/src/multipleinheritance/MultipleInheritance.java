/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multipleinheritance;

/**
 *
 * @author Manohar V
 */
interface Area_Rectangle{
    void rectangle(double a,double b);
}
interface Area_Square{
    void square(double a);
}
class Area implements Area_Rectangle,Area_Square{
    public void rectangle(double a,double b){
        System.out.println("Area of Rectangle:"+(a*b));
    }
    public void square(double a){
        System.out.println("Square:"+(a*a));
    }
}
public class MultipleInheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Area c=new Area();
        c.rectangle(5,6);
        c.square(5);
    }
    
}

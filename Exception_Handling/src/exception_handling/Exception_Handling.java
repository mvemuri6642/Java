/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception_handling;

/**
 *
 * @author Manohar V
 */


/* 

An Exception is a condition that is caused by a runtime error
   Types of Exceptions:
        1.Checked Exception:
            The Exceptions which are checked by the compiler are called checked exceptions
                ex:FileNotFoundException
        2.Unchecked Exception:
            The Exceptions which are checked at the runtime are called as unchecked exceptions
Exception Handling is a mechanism to handle the runtime errors so that normal flow of the program can be maintained

*/
public class Exception_Handling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a[]=new int[3];
        // TODO code application logic here
        
        
        //ArithmeticException
        /*
        System.out.println("Hello");
        System.out.println("Hello");
        try{
            System.out.println(+(10/0));
        }
        catch(ArithmeticException e){
            System.out.println(e);
        System.out.println("Hello");
        System.out.println("Hello");
        */
        
        
        //ArrayIndexOutOfBoundsException
        a[0]=10;
        a[1]=20;
        a[2]=30;
        System.out.println(+a[0]+"\n"+a[1]+"\n"+a[2]);
        try{
            try{
                String str="one";
                int i=Integer.parseInt(str);
                System.out.println(i);
            }
            catch(NumberFormatException nf){
                System.out.println(nf);
            }
            System.out.println(a[3]);
            
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        try{
            System.out.println(10/0);
        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
        catch(NullPointerException np){
            System.out.println(np);
        }
    }
}

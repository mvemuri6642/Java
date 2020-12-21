/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package throws_exception;
import java.io.IOException;
/**
 *
 * @author Manohar V
 */
class throw_Implement{
    void check_Age(int age) throws ArithmeticException{
        if(age<18){
            throw new ArithmeticException("You must me 18 years old");
        }
        else{
            System.out.println(+age);
        }
    }
}
public class Throws_Exception {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        throw_Implement ob=new throw_Implement();
        ob.check_Age(15);
        System.out.println("Normal Flow");
    }
    
}

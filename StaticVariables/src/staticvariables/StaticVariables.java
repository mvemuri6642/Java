/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticvariables;

/**
 *
 * @author Manohar V
 */
public class StaticVariables {

    /**
     * @param args the command line arguments
     */
    static int x=10;
    public static void main(String[] args) {
        // TODO code application logic here
        //if the variable value is not varied from object 
        //to object such type of variable is called as static variables
        System.out.println("static area:"+x);
        StaticVariables s=new StaticVariables();
        System.out.println("object name:"+s.x);
        System.out.println("class name:"+StaticVariables.x);
        s.show();
    }
    public  void show(){
        System.out.println("instance area:"+x);
    }
}

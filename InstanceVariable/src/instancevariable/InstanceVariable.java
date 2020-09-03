/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancevariable;

/**
 *
 * @author Manohar V
 */
public class InstanceVariable {

    /**
     * @param args the command line arguments
     */
    int x=10;
    public static void main(String[] args) {
        // TODO code application logic here
        InstanceVariable i =new InstanceVariable();
        System.out.println(i.x);
        i.show();
    }
    void show(){
        System.out.println(x);
    }
}

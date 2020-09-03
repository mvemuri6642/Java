/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hierarchical_inheritance;

/**
 *
 * @author Manohar V
 */
class One{
    public String method1(){
        String str="Hello,";
        return str;
        
    }
    public String method2(){
        String str="Manohar";
        return str;
        
    }
}
class Two extends One{
    public String method3(){
        String str="Vemuri";
        return str;
    }
}
class Three extends One{
    public void method4(){
    }
}
public class Hierarchical_Inheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Three ob1 = new Three();
        ob1.method1();
        Two ob2 = new Two();
        ob2.method2();
        System.out.println(ob1.method1()+" "+ob2.method2()+" "+ob2.method3());
        ob2.method3();
    }
    
}

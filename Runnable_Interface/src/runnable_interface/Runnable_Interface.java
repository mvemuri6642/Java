/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnable_interface;

/**
 *
 * @author Manohar V
 */
class Thread1 implements Runnable{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Thread 1:"+i);
        }
    }
}
class Thread2 implements Runnable{
    public void run(){
        for(int j=0;j<10;j++){
            System.out.println("Thread 2:"+j);
        }
    }
}
public class Runnable_Interface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread1 ob1=new Thread1();
        Thread2 ob2=new Thread2();
        Thread t1=new Thread(ob1);
        Thread t2=new Thread(ob2);
        t1.start();
        t2.start();
    }
    
}

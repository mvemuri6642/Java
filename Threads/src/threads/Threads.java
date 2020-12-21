/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author Manohar V
 */
class thread1 extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Thread1:"+i);
        }
    }
}
class thread2 extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Thread2:"+i);
        }
    }
}
public class Threads {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        thread1 ob1=new thread1();
        thread2 ob2=new thread2();
        ob1.start();
        ob2.start();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queues;
import java.util.Scanner;

/**
 *
 * @author Manohar V
 */
class Queue_Implementation{
    static final int MAX=1000;
    int rear=0;
    int front=0;
    int i;
    int n;
    int q[]=new int[MAX];
    void insert(int x){
        if(rear==MAX-1){
            System.out.println("Queue is full");
        }
        else{
            q[rear]=x;
            rear++;
            System.out.println("Inserted Element is:"+x);
        }
    }
    void delete(){
        if(front==rear){
            System.out.println("Queue is empty");
        }
        else{
            n=q[front];
            front++;
            System.out.println("Deleted Element is:"+n);
        }
    }
    void display(){
        if(front==rear){
            System.out.println("Queue is empty");
        }
        else{
            for(i=front;i<rear;i++){
                System.out.print(+q[i]+" ");
            }
        }
    }
}
public class Queues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue_Implementation ob=new Queue_Implementation();
        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter Size");
        int n=Scan.nextInt();
        for(int i=0;i<=n;i++){
            System.out.println("Enter Element to insert:");
            int m=Scan.nextInt();
            ob.insert(m);
        }
        ob.delete();
        ob.display();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue_using_stacks;
import java.util.Scanner;

/**
 *
 * @author Manohar V
 */
class Queue_Stack_Implementation{
    static final int MAX=10;
    int top1=-1;
    int top2=-1;
    int count=0;
    int i;
    int j;
    int q1[]=new int[MAX];
    int q2[]=new int[MAX];
    void enqueue(int x){
        push1(x);
        count++;
    }
    void dequeue(){
        if(top1==-1 && top2==-1){
            System.out.println("Stack is empty");
        }
        else{
            for(i=0;i<count;i++){
                int a=pop1();
                push2(a);
            }
            int  b=pop2();
            System.out.println("Deleted Element is:"+b);
            count--;
            for(j=0;j<count;j++){
                int a=pop2();
                push1(a);
            }
        }
    }
    void push1(int x){
        if(top1==MAX-1){
            System.out.println("Overflow");
        }
        else{
            top1++;
            q1[top1]=x;
        }
    }
    void push2(int x){
        if(top2==MAX-1){
            System.out.println("Overflow");
        }
        else{
            top2++;
            q2[top2]=x;
        }
    }
    int pop1(){
        return q1[top1--];
    }
    int pop2(){
        return q2[top2--];
    }
    void display(){
        if(top1==-1){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack is:");
            for(i=0;i<=top1;i++){
                System.out.println(+q1[i]);
            }
        }
    }
}
public class Queue_using_Stacks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner Scan=new Scanner(System.in);
        Queue_Stack_Implementation ob=new Queue_Stack_Implementation();
        System.out.println("Enter Size");
        int n= Scan.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter Element");
            int m=Scan.nextInt();
            ob.enqueue(m);
        }
        ob.dequeue();
        ob.display();
    }
    
}

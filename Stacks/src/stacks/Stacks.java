/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stacks;
import java.util.Scanner;

/**
 *
 * @author Manohar V
 */
class StackImplement{
    int top=-1;
    static final int MAX=100;
    int a[]=new int[MAX]; //Max Array
    void push(int x){
        if(top==MAX-1){
            System.out.println("Stack overflow");
        }
        else{
            top++;
            a[top]=x;
        }
    }
    void pop(){
        if(top==-1){
            System.out.println("Stack is underflow");
        }
        else{
            int x=a[top];
            top--;
            System.out.println();
            System.out.println("Deleted Element is:"+x);
        }
    }
    void display(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Elements in the stack are:");
            for(int i=top;i>=0;i--){
                System.out.println(+a[i]);
            }
        }
    }
}
public class Stacks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StackImplement ob=new StackImplement();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Size:");
        int n=scan.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter a Value");
            int m=scan.nextInt();
            ob.push(m);
        }
        ob.pop();
        System.out.println();
        ob.display();
        
    }
    
}

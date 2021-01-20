/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple_constructors;

/**
 *
 * @author Manohar Vemuri
 */
class NumberVal{
    private int num;
    public NumberVal(){
        num=6;
        
    }
    public NumberVal(int n){
        num=n;
    }
    public void display(){
        System.out.println("Number Value: "+num);
    }
}

public class Multiple_Constructors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NumberVal ob1=new NumberVal();
        NumberVal ob2=new NumberVal(5);
        ob1.display();
        ob2.display();
    }
    
}

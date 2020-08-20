/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditional_statements;

import java.util.Scanner;

/**
 *
 * @author Manohar V
 */
public class Conditional_Statements {

    /**
     * @param args the command line arguments
     */
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        n=scan.nextInt();
        if(n%2==0){
            if(n>=2 && n<=5){
                System.out.println("Not Weird");
            }
            else if(n>=6 && n<=20){
                System.out.println("Weird");
            }
            else{
                System.out.println("Not Weird");
            }
        }
        else{
            System.out.println("Weird");
        }
    }
    
}

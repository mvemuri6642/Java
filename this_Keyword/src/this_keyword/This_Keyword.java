/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package this_keyword;

/**
 *
 * @author Manohar V
 */
class Student{
    int rollno;
    String name;
    Student(){
        System.out.println("Default Constructors");
    }
    Student(int rollno,String name){
        this(); //used to invoke current class constructor
        this.rollno=rollno;
        this.name=name;
        this.display(); //used to invoke current class method
    }
    void display(){
        System.out.println(rollno+" "+name);
    }
}
public class This_Keyword {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student s=new Student(6642,"Manohar");
    }
}
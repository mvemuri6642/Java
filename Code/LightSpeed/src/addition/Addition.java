/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addition;

/**
 *
 * @author tejav
 */
public class Addition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int lightspeed=299792;
        long days=1000;
        long seconds=days*24*60*60;
        long distance=lightspeed*seconds;
        System.out.println("In "+days+ " days light will travel about "+distance+ " kilometers");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.*;

/**
 *
 * @author Manohar Vemuri
 */
public class SqlInsert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:7000:XE","manohar","manu");
            //Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:7000:XE","manohar","manu");
            Statement stmt=con.createStatement();
            String query="insert into student values(18113253,'Teja')";
            int rs=stmt.executeUpdate(query);
            if(rs==0){
                System.out.println("Fail");
            }
            else{
                System.out.println("Success");
            }

        }
        catch(Exception ex){
            System.out.println(ex);
            
        }
        
        
    }
    
}


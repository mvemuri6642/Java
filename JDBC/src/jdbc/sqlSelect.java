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
public class sqlSelect {
    public static void main(String[] args){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:7000:XE","manohar","manu");
            Statement stmt=con.createStatement();
            String query="select * from student";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("SID")+" "+rs.getString("SNAME"));
            }
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}

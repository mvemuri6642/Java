/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_demo;
import java.sql.*;

/**
 *
 * @author Manohar Vemuri
 */
public class JDBC_Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        
            String url="jdbc:mysql://localhost:3306/manu";
            String uid="root";
            String pass="manu";
            String query1="INSERT INTO student " +
                   "VALUES ('seshu')";
            String query2="select * from student";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,uid,pass);
            Statement st=con.createStatement();
            st.executeUpdate(query1);
            ResultSet rs =st.executeQuery(query2);
            rs.next();
            String name=rs.getString("sname");
            System.out.println(name);
            st.close();
            con.close();
        
    }
    
}

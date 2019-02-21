/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paperB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Salitha
 */
public class ConnectionManager {
    public static Connection con;
   public void connect(){
            
    } 
   public static  Connection GetConnection() throws ClassNotFoundException, SQLException{
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = (Connection) DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ITP_2017_EXAM","test","1234");
            return con;
   }
}

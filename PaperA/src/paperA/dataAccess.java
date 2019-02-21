/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paperA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tenusha
 */
public class dataAccess {
    Connection con;
    public void dbcon() throws ClassNotFoundException, SQLException{
        
        ConnectionManager c = new ConnectionManager();
        this.con = c.GetConnection();
    }
    ResultSet getManufactures() throws SQLException{
        ResultSet rs = con.createStatement().executeQuery("SELECT * from appliance_manufacturers");
        return rs;
    }
    
    String getManufacturerName(String name) throws SQLException{
        ResultSet rs = con.createStatement().executeQuery("SELECT Man_Id from appliance_manufacturers where Manufacturer ='"+name+"'");
        rs.next();
        return rs.getString("Manufacturer");
    }
    
    boolean addAppliances(int sno,int mid,String atype,String date,String war,String price,int qty){
        try {
            con.prepareStatement("insert into appliances (Serial_No,Man_Id,Appliance_Type,Date_Added,Waranty,Price,Qty) values("+sno+","+mid+",'"+atype+"','"+date+"','"+war+"','"+price+"',"+qty+")").execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(dataAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
   
    
    ResultSet getAllAppliances(int id) throws SQLException{
        ResultSet rs = con.createStatement().executeQuery("SELECT * from appliances where Man_Id ='"+id+"'");
        return rs;
    }
    
    ResultSet getAllAppliances() throws SQLException{
        ResultSet rs = con.createStatement().executeQuery("SELECT * from appliances");
        return rs;
    }
}

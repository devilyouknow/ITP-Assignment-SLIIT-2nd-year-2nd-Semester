/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paperB;

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
        ResultSet rs = con.createStatement().executeQuery("SELECT Man_id from piano_manufacturers");
        return rs;
    }
    
    String getManufacturerName(int manID) throws SQLException{
        ResultSet rs = con.createStatement().executeQuery("SELECT manufacturer from piano_manufacturers where man_id ='"+manID+"'");
        rs.next();
        return rs.getString("manufacturer");
    }
    
    boolean addPiano(int mo,int ma,String wood,String price,int qty,String date,String model){
        try {
            con.prepareStatement("insert into piano (Model_No,Man_Id,Model,Date_Added,Wood,Price,Qty) values("+mo+","+ma+",'"+model+"','"+date+"','"+wood+"','"+price+"',"+qty+")").execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(dataAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    boolean updatepiano(int mo,String wood,String price,int qty,String date,String model){
        try {
            con.prepareStatement("UPDATE piano set Model ='"+model+"',Date_Added ='"+date+"',Price ='"+price+"',Wood ='"+wood+"',Qty ="+qty+" where Model_No ="+mo+"").execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(dataAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    ResultSet getPianoDetails(int id) throws SQLException{
        ResultSet rs = con.createStatement().executeQuery("SELECT * from piano where Model_No ='"+id+"'");
        return rs;
    }
    
    ResultSet getPianoModelNo() throws SQLException{
        ResultSet rs = con.createStatement().executeQuery("SELECT Model_No from piano");
        return rs;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Igor Ferrani
 */
public class ConnectionBd {
    private static String status = ">> Status: disconected.";
    
    public static void main(String[] args){
        ConnectionBd connectionBd = new ConnectionBd();
        System.out.println(">> Trying..");
        try {
            getConnection();
        } catch (Exception e){
            System.out.println(">> Error: " + e.getMessage());
        }
        System.out.println(getStatusConnection());
    }
    
    public ConnectionBd(){}
    
    public static String getStatusConnection(){
        return status;
    }
    
    public static java.sql.Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String host = "localhost";
            String dbname = "mysql";
            String user = "root";
            String password = "";
            
            String url = "jdbc:mysql://" + host + "/" + dbname;
            con = DriverManager.getConnection(url, user, password);
            
            if(con != null){
                status = ">> Status: Connection Successfull!";
            } else {
                status = ">> Status: Unable to Connection";
            }
            return con;
        } catch (SQLException e){
            System.out.println(">> Error SQLException (getConnection): " + e.getMessage());
        } catch (ClassNotFoundException e){
            System.out.println(">> Error ClassNotFoundException (getConnection): " + e.getMessage());
        } catch (Exception e) {
            System.out.println(">> Error Exception (getConnection): " + e.getMessage());
        }
        return null;
    }
}

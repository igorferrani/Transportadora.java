/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Igor Ferrani
 */
public class DepositoPersistencia {
    
    public ResultSet selectAllRecords(java.sql.Connection con) throws Exception{
        try {            
            String sql = "SELECT * FROM deposito";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+getClass().getName()+"): " + e.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Deposito;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Igor Ferrani
 */
public class DepositoPersistencia {
    
    public ResultSet selectAllRecords(Deposito obj, java.sql.Connection con) throws Exception{
        try {            
            String sql = "SELECT * FROM deposito WHERE codCliente = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCodCliente());
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+getClass().getName()+"): " + e.getMessage());
        }
    }
    
    public ResultSet selectRecord(Deposito deposito, java.sql.Connection con) throws Exception{
        try {            
            String sql = "SELECT * FROM deposito WHERE codDeposito = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, deposito.getCodDeposito());
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+getClass().getName()+"): " + e.getMessage());
        }
    }
}

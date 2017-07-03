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
    
    public int insertRecord(Deposito deposito, java.sql.Connection con) throws Exception{
        int codArmazem = 0;
        try {            
            String sql = "INSERT INTO deposito VALUES(0, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, deposito.getCodCliente());
            stmt.setString(2, deposito.getNomDeposito());
            stmt.setDouble(3, deposito.getCodEndereco());
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                codArmazem = generatedKeys.getInt(1);
            
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+this.getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+this.getClass().getName()+"): " + e.getMessage());
        }
        return codArmazem;
    }
    
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

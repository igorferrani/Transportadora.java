/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Cliente;
import Model.Deposito;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Igor Ferrani
 */
public class ClientePersistencia {
    
    public ResultSet selectAllRecords(java.sql.Connection con) throws Exception{
        try {            
            String sql = "SELECT * FROM cliente";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+getClass().getName()+"): " + e.getMessage());
        }
    }
    
    public ResultSet selectRecord(Cliente cliente, java.sql.Connection con) throws Exception{
        try {            
            String sql = "SELECT * FROM cliente WHERE codCliente = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getCodCliente());
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+getClass().getName()+"): " + e.getMessage());
        }
    }
}

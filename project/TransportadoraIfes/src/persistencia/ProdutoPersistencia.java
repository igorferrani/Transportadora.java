/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Igor Ferrani
 */
public class ProdutoPersistencia {
    
    public ResultSet selectAllRecords(Produto obj, java.sql.Connection con) throws Exception{
        try {            
            String sql = "SELECT * FROM produto WHERE codCliente = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCodCliente());
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e){
            throw new Exception("Error SQLException (CaminhaoPersistencia): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception (CaminhaoPersistencia): " + e.getMessage());
        }
    }
    
    public ResultSet selectRecord(Produto produto, java.sql.Connection con) throws Exception{
        try {            
            String sql = "SELECT * FROM produto HWERE codProduto = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getCodProduto());
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e){
            throw new Exception("Error SQLException (ProdutoPersistencia): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception (ProdutoPersistencia): " + e.getMessage());
        }
    }
}

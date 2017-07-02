/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Estoque;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Igor Ferrani
 */
public class EstoquePersistencia {
    
    public ResultSet selectProdutoPorArmazem(Estoque obj, java.sql.Connection con) throws Exception{
        try {            
            String sql = "SELECT COALESCE(SUM(qtdProduto), 0) AS qtdProduto FROM estoque WHERE codArmazem = ? AND codProduto = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCodArmazem());
            stmt.setInt(2, obj.getCodProduto());
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+this.getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+this.getClass().getName()+"): " + e.getMessage());
        }
    }
    
    public boolean updateQtdEstoqueProdutoPorArmazem(Estoque obj, java.sql.Connection con) throws Exception{
        try {            
            String sql = "UPDATE estoque SET qtdProduto = qtdProduto - ? WHERE codArmazem = ? AND codProduto = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDouble(1, obj.getQtdProduto());
            stmt.setInt(2, obj.getCodArmazem());
            stmt.setInt(3, obj.getCodProduto());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+this.getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+this.getClass().getName()+"): " + e.getMessage());
        }
    }
}

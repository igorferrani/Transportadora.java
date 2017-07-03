/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Estoque;
import Model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Igor Ferrani
 */
public class ProdutoPersistencia {
    
    public int insertRecord(Produto obj, java.sql.Connection con) throws Exception{
        int codProduto = 0;
        try {            
            String sql = "INSERT INTO produto VALUES(0, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, obj.getCodCliente());
            stmt.setString(2, obj.getNomProduto());
            stmt.setDouble(3, obj.getValProduto());
            stmt.setDouble(4, obj.getQtdPesoProduto());
            stmt.setDouble(5, obj.getQtdVolumeProduto());
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                codProduto = generatedKeys.getInt(1);
            
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+this.getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+this.getClass().getName()+"): " + e.getMessage());
        }
        return codProduto;
    }
    
    public ResultSet selectAllRecords(Produto obj, Estoque estoque, java.sql.Connection con) throws Exception{
        try {            
            String sql = "SELECT produto.* FROM produto "
                    + "LEFT JOIN estoque ON estoque.codProduto = produto.codProduto "
                    + "WHERE produto.codCliente = ? AND estoque.codArmazem = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCodCliente());
            stmt.setInt(2, estoque.getCodArmazem());
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+this.getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+this.getClass().getName()+"): " + e.getMessage());
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
            throw new Exception("Error SQLException ("+this.getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+this.getClass().getName()+"): " + e.getMessage());
        }
    }
}

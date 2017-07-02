/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.ItemRemessa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Igor Ferrani
 */
public class ItemRemessaPersistencia {
    
    public int insertRecord(ItemRemessa itemRemessa, java.sql.Connection con) throws Exception{
        int codItemRemessa = 0;
        try {
            String insertItemRemessa = "INSERT INTO item_remessa VALUES(0, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(insertItemRemessa, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, itemRemessa.getCodRemessa());
            stmt.setInt(2, itemRemessa.getCodProduto());
            stmt.setDouble(3, itemRemessa.getQtdProduto());
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                codItemRemessa = generatedKeys.getInt(1);
            
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+this.getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+this.getClass().getName()+"): " + e.getMessage());
        }
        return codItemRemessa;
    }
}

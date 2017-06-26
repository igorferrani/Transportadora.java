/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.ItemRemessa;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Igor Ferrani
 */
public class ItemRemessaPersistencia {
    
    public boolean insertRecord(ItemRemessa itemRemessa, java.sql.Connection con) throws Exception{
        PreparedStatement stmt = null;
        try {
            String insertItemRemessa = "INSERT INTO item_remessa VALUES(0, ?, ?, ?)";
            stmt = con.prepareStatement(insertItemRemessa);
            stmt.setInt(1, itemRemessa.getCodRemessa());
            stmt.setInt(2, itemRemessa.getCodProduto());
            stmt.setDouble(3, itemRemessa.getQtdProduto());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException e){
            throw new Exception("Error SQLException (CaminhaoPersistencia): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception (CaminhaoPersistencia): " + e.getMessage());
        }
    }
}

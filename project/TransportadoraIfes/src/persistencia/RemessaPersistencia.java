/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Remessa;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Igor Ferrani
 */
public class RemessaPersistencia {
    
    public boolean insertRecord(Remessa remessa, java.sql.Connection con) throws Exception{
        PreparedStatement stmt = null;
        try {
            String insertRemessa = "INSERT INTO remessa VALUES(0, ?, ?, ?)";
            stmt = con.prepareStatement(insertRemessa);
            stmt.setInt(1, remessa.getCodViagem());
            stmt.setInt(2, remessa.getCodDeposito());
            stmt.setString(3, remessa.getNumRemessa());
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException e){
            throw new Exception("Error SQLException (CaminhaoPersistencia): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception (CaminhaoPersistencia): " + e.getMessage());
        }
    }
}

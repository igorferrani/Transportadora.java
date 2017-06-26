/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Viagem;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Igor Ferrani
 */
public class ViagemPersistencia {
    
    public boolean insertRecord(Viagem viagem, java.sql.Connection con) throws Exception{
        PreparedStatement stmt = null;
        try {
            String insertViagem = "INSERT INTO viagem VALUES(0, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(insertViagem);
            stmt.setInt(1, viagem.getCodArmazem());
            stmt.setInt(2, viagem.getCodCaminhao());
            stmt.setInt(3, viagem.getNumViagem());
            stmt.setDouble(4, 0);
            stmt.setDouble(5, 0);
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException e){
            throw new Exception("Error SQLException (CaminhaoPersistencia): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception (CaminhaoPersistencia): " + e.getMessage());
        }
    }
    
    public boolean updateRecord(Viagem viagem, java.sql.Connection con) throws Exception{
        PreparedStatement stmt = null;
        try {
            String updateViagem = "UPDATE viagem SET codArmazem = ?, codCaminhao = ?, numViagem = ?, qtdPesoViagem = ?, qtdVolumeViagem = ? WHERE codViagem = ?";
            stmt = con.prepareStatement(updateViagem);
            stmt.setInt(1, viagem.getCodArmazem());
            stmt.setInt(2, viagem.getCodCaminhao());
            stmt.setInt(3, viagem.getNumViagem());
            stmt.setDouble(4, viagem.getQtdPesoViagem());
            stmt.setDouble(5, viagem.getQtdVolumeViagem());
            stmt.setDouble(6, viagem.getCodViagem());
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e){
            throw new Exception("Error SQLException (CaminhaoPersistencia): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception (CaminhaoPersistencia): " + e.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Viagem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Igor Ferrani
 */
public class ViagemPersistencia {
    
    public ResultSet selectAllRecords(java.sql.Connection con) throws Exception{
        try {            
            String sql = "SELECT viagem.*, armazem.nomArmazem, caminhao.numLicencaCaminhao FROM viagem "
                    + "INNER JOIN armazem ON armazem.codArmazem = viagem.codArmazem "
                    + "INNER JOIN caminhao ON caminhao.codCaminhao = viagem.codCaminhao "
                    + "ORDER BY codViagem DESC";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+this.getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+this.getClass().getName()+"): " + e.getMessage());
        }
    }
    
    public int insertRecord(Viagem viagem, java.sql.Connection con) throws Exception{
        int codViagem = 0;
        try {
            String insertViagem = "INSERT INTO viagem VALUES(0, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(insertViagem, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, viagem.getCodArmazem());
            stmt.setInt(2, viagem.getCodCaminhao());
            stmt.setString(3, viagem.getNumViagem());
            stmt.setDouble(4, 0);
            stmt.setDouble(5, 0);
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                codViagem = generatedKeys.getInt(1);

        } catch (SQLException e){
            throw new Exception("Error SQLException ("+this.getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+this.getClass().getName()+"): " + e.getMessage());
        }
        return codViagem;
    }
    
    public boolean updateRecord(Viagem viagem, java.sql.Connection con) throws Exception{
        PreparedStatement stmt = null;
        try {
            String updateViagem = "UPDATE viagem SET codArmazem = ?, codCaminhao = ?, numViagem = ?, qtdPesoViagem = ?, qtdVolumeViagem = ? WHERE codViagem = ?";
            stmt = con.prepareStatement(updateViagem);
            stmt.setInt(1, viagem.getCodArmazem());
            stmt.setInt(2, viagem.getCodCaminhao());
            stmt.setString(3, viagem.getNumViagem());
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

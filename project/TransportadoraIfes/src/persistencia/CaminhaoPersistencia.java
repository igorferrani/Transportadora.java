/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Caminhao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Igor Ferrani
 */
public class CaminhaoPersistencia {
    
    public int insertRecord(Caminhao caminhao, java.sql.Connection con) throws Exception{
        int codCaminhao = 0;
        try {            
            double qtdVolumeCaminhao = caminhao.getQtdVolumeCaminhao();
            double qtdPesoCaminhao = caminhao.getQtdPesoCaminhao();
            String numLicencaCaminhao = caminhao.getNumLicencaCaminhao();
            
            String sql = "INSERT INTO caminhao VALUES(0, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, qtdVolumeCaminhao);
            stmt.setDouble(2, qtdPesoCaminhao);
            stmt.setString(3, numLicencaCaminhao);
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                codCaminhao = generatedKeys.getInt(1);
            
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+this.getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+this.getClass().getName()+"): " + e.getMessage());
        }
        return codCaminhao;
    }
    
    public ResultSet selectAllRecords(java.sql.Connection con) throws Exception{
        try {            
            String sql = "SELECT * FROM caminhao";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e){
            throw new Exception("Error SQLException ("+this.getClass().getName()+"): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception ("+this.getClass().getName()+"): " + e.getMessage());
        }
    }
}

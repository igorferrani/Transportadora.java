/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Caminhao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Igor Ferrani
 */
public class CaminhaoPersistencia {
    
    public boolean insertRecord(Caminhao caminhao) throws Exception{
        Statement stmt = null;
        java.sql.Connection con = null;
        try {
            ConnectionBd connectionBd = new ConnectionBd();
            con = connectionBd.getConnection();
            
            double qtdVolumeCaminhao = caminhao.getQtdVolumeCaminhao();
            double qtdPesoCaminhao = caminhao.getQtdPesoCaminhao();
            String numLicencaCaminhao = caminhao.getNumLicencaCaminhao();
            
            String sql = "INSERT INTO caminhao VALUES(0, "+
                    qtdVolumeCaminhao+", "+
                    qtdPesoCaminhao+ ", '"+
                    numLicencaCaminhao+"')";
            
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            con.close();
            
            return true;
            
        } catch (SQLException e){
            throw new Exception("Error SQLException (CaminhaoPersistencia): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception (CaminhaoPersistencia): " + e.getMessage());
        }
    }
    
    public ResultSet selectAllRecords(java.sql.Connection con) throws Exception{
        try {            
            String sql = "SELECT * FROM caminhao";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e){
            throw new Exception("Error SQLException (CaminhaoPersistencia): " + e.getMessage());
        } catch (Exception e){
            throw new Exception("Error Exception (CaminhaoPersistencia): " + e.getMessage());
        }
    }
}

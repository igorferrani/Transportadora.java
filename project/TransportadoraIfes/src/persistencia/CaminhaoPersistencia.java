/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Caminhao;
import java.sql.Statement;

/**
 *
 * @author Igor Ferrani
 */
public class CaminhaoPersistencia {
    
    public void insertRecord(Caminhao caminhao){
        Statement stmt = null;
        try {
            ConnectionBd con = new ConnectionBd();
            con = (ConnectionBd) con.getConnection();
            
            double qtdVolumeCaminhao = caminhao.getQtdVolumeCaminhao();
            double qtdPesoCaminhao = caminhao.getQtdPesoCaminhao();
            String numLicencaCaminhao = caminhao.getNumLicencaCaminhao();
            
            String sql = "INSERT INTO caminhao VALUES(0, "+
                    qtdVolumeCaminhao+", "+
                    qtdPesoCaminhao+ ", "+
                    numLicencaCaminhao+")";
            
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            con.close();
            
            /* Modificar classe, tratar tipos.. */
            
        } catch (Exception e){
            
        }
    }
}

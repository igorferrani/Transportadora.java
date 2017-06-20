/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Model.Caminhao;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Igor Ferrani
 */
public class CaminhaoPersistencia {
    
    public static void main(String[] args){
        CaminhaoPersistencia caminhaoPersistencia = new CaminhaoPersistencia();
        Caminhao caminhao = new Caminhao();
        
        caminhao.setQtdVolumeCaminhao(12);
        caminhao.setQtdPesoCaminhao(23);
        caminhao.setNumLicencaCaminhao("A");
        
        try {
            caminhaoPersistencia.insertRecord(caminhao);
        } catch (Exception e){
            
        }
    }
    
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
            throw new Exception(">> Error SQLException (CaminhaoPersistencia): " + e.getMessage());
        } catch (Exception e){
            throw new Exception(">> Error Exception (CaminhaoPersistencia): " + e.getMessage());
        }
    }
    
    public ArrayList selectAllRecords() throws Exception{
        Statement stmt = null;
        java.sql.Connection con = null;
        ArrayList listCaminhao = new ArrayList();
        try {
            ConnectionBd connectionBd = new ConnectionBd();
            con = connectionBd.getConnection();
            
            String sql = "SELECT * FROM caminhao";
            
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Caminhao caminhao = new Caminhao();
                caminhao.setQtdVolumeCaminhao(rs.getDouble("qtdVolumeCaminhao"));
                caminhao.setQtdPesoCaminhao(rs.getDouble("qtdPesoCaminhao"));
                caminhao.setNumLicencaCaminhao(rs.getString("numLicencaCaminhao"));
                listCaminhao.add(caminhao);
            }
            rs.close();
            stmt.close();
            con.close();
            
            return listCaminhao;
            
        } catch (SQLException e){
            throw new Exception(">> Error SQLException (CaminhaoPersistencia): " + e.getMessage());
        } catch (Exception e){
            throw new Exception(">> Error Exception (CaminhaoPersistencia): " + e.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Caminhao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import persistencia.CaminhaoPersistencia;
import persistencia.ConnectionBd;
import transportadoraifes.Util;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlCaminhao {

    public void setComboBox(JComboBox inputSelect) throws SQLException, Exception{
        
        CaminhaoPersistencia caminhaoPersistencia = new CaminhaoPersistencia();
        java.sql.Connection con = ConnectionBd.getConnection();
        ResultSet rs;
        
        try {
            rs  = caminhaoPersistencia.selectAllRecords(con);
            while(rs.next()){
                Caminhao caminhao = new Caminhao();
                caminhao.setCodCaminhao(rs.getInt("codCaminhao"));
                caminhao.setNumLicencaCaminhao(rs.getString("numLicencaCaminhao"));
                inputSelect.addItem(caminhao);
            }
            rs.close();
            con.close();
        } catch(SQLException e){
            throw new SQLException(e.getMessage());
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public void setDataTable(DefaultTableModel tableModel) throws SQLException, Exception{
        
        CaminhaoPersistencia caminhaoPersistencia = new CaminhaoPersistencia();
        java.sql.Connection con = ConnectionBd.getConnection();
        ResultSet rs;
        
        try {
            rs  = caminhaoPersistencia.selectAllRecords(con);
            while(rs.next()){
                tableModel.addRow( new Object[] { 
                    rs.getInt("codCaminhao") , 
                    rs.getString("numLicencaCaminhao"),
                    rs.getDouble("qtdVolumeCaminhao"),
                    rs.getDouble("qtdPesoCaminhao")
                });
            }    
        } catch(SQLException e){
            throw new SQLException(e.getMessage());
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public boolean insertRecord(Caminhao caminhao) throws SQLException, Exception{
        try {
            CaminhaoPersistencia caminhaoPersistencia = new CaminhaoPersistencia();
            java.sql.Connection con = ConnectionBd.getConnection();
            if(caminhao.getNumLicencaCaminhao() != "" && caminhao.getQtdVolumeCaminhao() > 0 && caminhao.getQtdPesoCaminhao() > 0){
                if(caminhaoPersistencia.insertRecord(caminhao, con) != 0){
                    Util.showMessage("Caminhao inserido com sucesso !");
                }
            } else {
                throw new Exception("É preciso preencher todos os campos");
            }
            return true;
        } catch(SQLException e){
            throw new SQLException(e.getMessage());
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import persistencia.CaminhaoPersistencia;
import persistencia.ConnectionBd;
import transportadoraifes.Item;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlCaminhao {

    public void setComboBox(JComboBox inputSelect) throws SQLException, Exception{
        
        CaminhaoPersistencia caminhaoPersistencia = new CaminhaoPersistencia();
        ConnectionBd connectionBd = new ConnectionBd();
        java.sql.Connection con = connectionBd.getConnection();
        ResultSet rs;
        
        try {
            rs  = caminhaoPersistencia.selectAllRecords(con);
            while(rs.next()){
                inputSelect.addItem(new Item(
                    rs.getInt("codCaminhao"),
                    rs.getString("numLicencaCaminhao")
                ));
            }
            rs.close();
            con.close();
        } catch(SQLException e){
            throw new SQLException("Error SQLException (CtrlCaminhao): " + e.getMessage());
        } catch(Exception e){
            throw new Exception("Error Exception (CtrlCaminhao): " + e.getMessage());
        }
    }
    
    public void setDataTable(DefaultTableModel tableModel) throws SQLException, Exception{
        
        CaminhaoPersistencia caminhaoPersistencia = new CaminhaoPersistencia();
        ConnectionBd connectionBd = new ConnectionBd();
        java.sql.Connection con = connectionBd.getConnection();
        ResultSet rs;
        
        try {
            rs  = caminhaoPersistencia.selectAllRecords(con);
            while(rs.next()){
                tableModel.addRow( new Object[] { 
                    rs.getInt("codCaminhao") , 
                    rs.getDouble("qtdVolumeCaminhao"),
                    rs.getDouble("qtdPesoCaminhao"),
                    rs.getString("numLicencaCaminhao")
                });
            }    
        } catch(SQLException e){
            throw new SQLException("Error SQLException (CtrlCaminhao): " + e.getMessage());
        } catch(Exception e){
            throw new Exception("Error Exception (CtrlCaminhao): " + e.getMessage());
        }
    }
}

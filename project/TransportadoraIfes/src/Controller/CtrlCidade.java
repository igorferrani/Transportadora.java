/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import persistencia.ConnectionBd;
import persistencia.CidadePersistencia;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlCidade {
    
    public void setComboBox(JComboBox inputSelect, Cidade obj) throws SQLException, Exception{
        try {
            CidadePersistencia cidadePersistencia = new CidadePersistencia();
            java.sql.Connection con = ConnectionBd.getConnection();
            
            ResultSet rs  = cidadePersistencia.selectAllRecords(obj, con);
            while(rs.next()){
                Cidade cidade = new Cidade();
                cidade.setCodCidade(rs.getInt("codCidade"));
                cidade.setNomCidade(rs.getString("nomCidade"));
                inputSelect.addItem(cidade);
            }
            rs.close();
            con.close();
        } catch(SQLException e){
            throw new SQLException(e.getMessage());
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

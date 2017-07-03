/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pais;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import persistencia.ConnectionBd;
import persistencia.PaisPersistencia;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlPais {
    
    public void setComboBox(JComboBox inputSelect) throws SQLException, Exception{
        try {
            PaisPersistencia paisPersistencia = new PaisPersistencia();
            java.sql.Connection con = ConnectionBd.getConnection();
            
            ResultSet rs  = paisPersistencia.selectAllRecords(con);
            while(rs.next()){
                Pais pais = new Pais();
                pais.setCodPais(rs.getInt("codPais"));
                pais.setNomPais(rs.getString("nomPais"));
                inputSelect.addItem(pais);
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

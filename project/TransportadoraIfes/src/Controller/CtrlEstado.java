/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Estado;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import persistencia.ConnectionBd;
import persistencia.EstadoPersistencia;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlEstado {
    
    public void setComboBox(JComboBox inputSelect, Estado obj) throws SQLException, Exception{
        try {
            EstadoPersistencia estadoPersistencia = new EstadoPersistencia();
            java.sql.Connection con = ConnectionBd.getConnection();
            
            ResultSet rs  = estadoPersistencia.selectAllRecords(obj, con);
            while(rs.next()){
                Estado estado = new Estado();
                estado.setCodEstado(rs.getInt("codEstado"));
                estado.setNomEstado(rs.getString("nomEstado"));
                inputSelect.addItem(estado);
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

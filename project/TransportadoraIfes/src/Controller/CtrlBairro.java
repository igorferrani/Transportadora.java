/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bairro;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import persistencia.ConnectionBd;
import persistencia.BairroPersistencia;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlBairro {
    
    public void setComboBox(JComboBox inputSelect, Bairro obj) throws SQLException, Exception{
        try {
            BairroPersistencia bairroPersistencia = new BairroPersistencia();
            java.sql.Connection con = ConnectionBd.getConnection();
            
            ResultSet rs  = bairroPersistencia.selectAllRecords(obj, con);
            while(rs.next()){
                Bairro bairro = new Bairro();
                bairro.setCodBairro(rs.getInt("codBairro"));
                bairro.setNomBairro(rs.getString("nomBairro"));
                inputSelect.addItem(bairro);
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

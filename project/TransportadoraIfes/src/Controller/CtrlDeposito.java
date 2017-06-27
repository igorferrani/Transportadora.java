/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Deposito;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import persistencia.DepositoPersistencia;
import persistencia.ConnectionBd;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlDeposito {
    
    public void setComboBox(JComboBox inputSelect) throws SQLException, Exception{
        try {
            DepositoPersistencia depositoPersistencia = new DepositoPersistencia();
            ConnectionBd connectionBd = new ConnectionBd();
            java.sql.Connection con = connectionBd.getConnection();
            
            ResultSet rs  = depositoPersistencia.selectAllRecords(con);
            while(rs.next()){
                Deposito deposito = new Deposito();
                deposito.setCodDeposito(rs.getInt("codDeposito"));
                deposito.setCodCliente(rs.getInt("codCliente"));
                deposito.setCodEndereco(rs.getInt("codEndereco"));
                deposito.setNumDeposito(rs.getInt("numDeposito"));
                inputSelect.addItem(deposito);
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
        
        DepositoPersistencia depositoPersistencia = new DepositoPersistencia();
        ConnectionBd connectionBd = new ConnectionBd();
        java.sql.Connection con = connectionBd.getConnection();
        ResultSet rs;
        
        try {
            rs  = depositoPersistencia.selectAllRecords(con);
            while(rs.next()){
                tableModel.addRow( new Object[] { 
                    rs.getInt("codArmazem") , 
                    rs.getString("nomArmazem")
                });
            }    
        } catch(SQLException e){
            throw new Exception(">> Error SQLException (CtrlArmazem): " + e.getMessage());
        } catch(Exception e){
            throw new Exception(">> Error Exception (CtrlArmazem): " + e.getMessage());
        }
    }
}

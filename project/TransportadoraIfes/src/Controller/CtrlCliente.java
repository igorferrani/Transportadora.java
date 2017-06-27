/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import persistencia.ClientePersistencia;
import persistencia.ConnectionBd;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlCliente {
    
    public void setComboBox(JComboBox inputSelect) throws SQLException, Exception{
        try {
            ClientePersistencia clientePersistencia = new ClientePersistencia();
            java.sql.Connection con = ConnectionBd.getConnection();
            
            ResultSet rs  = clientePersistencia.selectAllRecords(con);
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCodCliente(rs.getInt("codCliente"));
                cliente.setNumCnpjCliente((int) rs.getLong("numCnpjCliente"));
                cliente.setNumCpfCliente((int) rs.getLong("numCpfCliente"));
                cliente.setNomCliente(rs.getString("nomCliente"));
                inputSelect.addItem(cliente);
            }
            rs.close();
            con.close();
        } catch(SQLException e){
            throw new SQLException(e.getMessage());
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public boolean setSelectedComboBox(Cliente obj, JComboBox<Cliente> inputSelect) throws SQLException, Exception{
        try {
            ClientePersistencia clientePersistencia = new ClientePersistencia();
            java.sql.Connection con = ConnectionBd.getConnection();
            
            ResultSet rs  = clientePersistencia.selectRecord(obj, con);
            int sizeInput = inputSelect.getComponentCount();
            for(int i=0; i < sizeInput; i++){
                Cliente cliente = inputSelect.getItemAt(i);
                if(cliente.getCodCliente() == obj.getCodCliente()){
                    inputSelect.setSelectedIndex(i);
                    return true;
                }
            }
            rs.close();
            con.close();
        } catch(SQLException e){
            throw new SQLException(e.getMessage());
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return false;
    }
    
    public void setDataTable(DefaultTableModel tableModel) throws SQLException, Exception{
        
        ClientePersistencia clientePersistencia = new ClientePersistencia();
        ConnectionBd connectionBd = new ConnectionBd();
        java.sql.Connection con = connectionBd.getConnection();
        ResultSet rs;
        
        try {
            rs  = clientePersistencia.selectAllRecords(con);
            while(rs.next()){
                tableModel.addRow( new Object[] { 
                    rs.getInt("codCliente") , 
                    rs.getString("nomCliente")
                });
            }    
        } catch(SQLException e){
            throw new Exception(">> Error SQLException (CtrlCliente): " + e.getMessage());
        } catch(Exception e){
            throw new Exception(">> Error Exception (CtrlCliente): " + e.getMessage());
        }
    }
}

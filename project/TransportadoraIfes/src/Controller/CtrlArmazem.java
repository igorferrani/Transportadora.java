/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Armazem;
import Model.Endereco;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import persistencia.ArmazemPersistencia;
import persistencia.ConnectionBd;
import persistencia.EnderecoPersistencia;
import transportadoraifes.Util;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlArmazem {
    
    public void setComboBox(JComboBox inputSelect) throws SQLException, Exception{
        
        ArmazemPersistencia armazemPersistencia = new ArmazemPersistencia();
        java.sql.Connection con = ConnectionBd.getConnection();
        ResultSet rs;
        
        try {
            rs  = armazemPersistencia.selectAllRecords(con);
            while(rs.next()){
                Armazem armazem = new Armazem();
                armazem.setCodArmazem(rs.getInt("codArmazem"));
                armazem.setNomArmazem(rs.getString("nomArmazem"));
                inputSelect.addItem(armazem);
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
        
        ArmazemPersistencia armazemPersistencia = new ArmazemPersistencia();
        java.sql.Connection con = ConnectionBd.getConnection();
        ResultSet rs;
        
        try {
            rs  = armazemPersistencia.selectAllRecords(con);
            while(rs.next()){
                tableModel.addRow( new Object[] { 
                    rs.getInt("codArmazem"),
                    rs.getString("nomArmazem")
                });
            }
        } catch(SQLException e){
            throw new Exception(e.getMessage());
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public boolean insertRecord(Armazem armazem, Endereco endereco) throws SQLException, Exception{
        try {
            ArmazemPersistencia armazemPersistencia = new ArmazemPersistencia();
            java.sql.Connection con = ConnectionBd.getConnection();
            
            con.setAutoCommit(false); //transaction block start
            
            if(!"".equals(armazem.getNomArmazem()) && endereco.getNumEndereco() != 0){
                // Grava o endereco do Armazem
                EnderecoPersistencia enderecoPersistencia = new EnderecoPersistencia();
                int codEndereco = enderecoPersistencia.insertRecord(endereco, con);
                if(codEndereco != 0){
                    armazem.setCodEndereco(codEndereco);
                    if(armazemPersistencia.insertRecord(armazem, con) != 0){
                        Util.showMessage("Armazem inserido com sucesso !");
                    }
                }
            } else {
                throw new Exception("É preciso preencher todos os campos");
            }
            con.commit(); //transaction block end
            con.close();
            return true;
        } catch(SQLException e){
            throw new SQLException(e.getMessage());
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

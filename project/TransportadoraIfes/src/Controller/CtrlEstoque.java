/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Estoque;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import persistencia.ConnectionBd;
import persistencia.EstoquePersistencia;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlEstoque {
    
    public void setInputQtdProdutoPorEstoque(JTextField input, Estoque obj) throws SQLException, Exception{
        try {
            EstoquePersistencia estoquePersistencia = new EstoquePersistencia();
            java.sql.Connection con = ConnectionBd.getConnection();
            
            ResultSet rs  = estoquePersistencia.selectProdutoPorArmazem(obj, con);
            while(rs.next()){
                input.setText(Double.toString(rs.getDouble("qtdProduto")));
            }
            rs.close();
            con.close();
        } catch(SQLException e){
            throw new SQLException(e.getMessage());
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    /*public void updateQtdEstoqueProdutoPorArmazem(Estoque obj) throws SQLException, Exception{
        try {
            EstoquePersistencia estoquePersistencia = new EstoquePersistencia();
            java.sql.Connection con = ConnectionBd.getConnection();
            estoquePersistencia.updateQtdEstoqueProdutoPorArmazem(obj, con);
            con.close();
        } catch(SQLException e){
            throw new SQLException(e.getMessage());
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }*/
}

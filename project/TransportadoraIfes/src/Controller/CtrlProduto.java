/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import persistencia.ProdutoPersistencia;
import persistencia.ConnectionBd;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlProduto {
    
    public void setComboBox(JComboBox inputSelect, Produto obj) throws SQLException, Exception{
        try {
            ProdutoPersistencia produtoPersistencia = new ProdutoPersistencia();
            java.sql.Connection con = ConnectionBd.getConnection();
            
            ResultSet rs  = produtoPersistencia.selectAllRecords(obj, con);
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodProduto(rs.getInt("codProduto"));
                produto.setNomProduto(rs.getString("nomProduto"));
                produto.setValProduto(rs.getDouble("valProduto"));
                produto.setQtdPesoProduto(rs.getDouble("qtdPesoProduto"));
                produto.setQtdVolumeProduto(rs.getDouble("qtdVolumeProduto"));
                inputSelect.addItem(produto);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Armazem;
import Model.Estoque;
import Model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import persistencia.ProdutoPersistencia;
import persistencia.ConnectionBd;
import persistencia.EstoquePersistencia;
import transportadoraifes.Util;

/**
 *
 * @author Igor Ferrani
 */
public class CtrlProduto {
    
    public boolean insertRecord(Produto produto, Estoque estoque) {
        try {
            java.sql.Connection con = ConnectionBd.getConnection();
            
            con.setAutoCommit(false); //transaction block start
            
            // Cria o produto na transporatadora
            ProdutoPersistencia produtoPersistencia = new ProdutoPersistencia();
            int codProduto = produtoPersistencia.insertRecord(produto, con);
            if(codProduto != 0){
                // Movimenta o estoque do armazem
                EstoquePersistencia estoquePersistencia = new EstoquePersistencia();
                estoque.setCodProduto(codProduto);
                estoquePersistencia.insertRecord(estoque, con);
                
                Util.showMessage("Produto inserido com sucesso");
            }

            con.commit(); //transaction block end
            con.close();
            return true;
        } catch(SQLException e){
            Util.showCatch(e.getMessage());
        } catch(Exception e) {
            Util.showCatch(e.getMessage());
        }
        return false;
    }
    
    public void setComboBox(JComboBox inputSelect, Produto obj, Estoque estoque) throws SQLException, Exception{
        try {
            ProdutoPersistencia produtoPersistencia = new ProdutoPersistencia();
            java.sql.Connection con = ConnectionBd.getConnection();
            
            ResultSet rs  = produtoPersistencia.selectAllRecords(obj, estoque, con);
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

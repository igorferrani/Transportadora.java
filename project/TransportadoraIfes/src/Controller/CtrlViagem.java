/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Remessa;
import Model.Viagem;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import persistencia.ConnectionBd;

/**
 *
 * @author Weliton de Oliveira
 */
public class CtrlViagem {
    
    public ArrayList insertRecord(ArrayList arrViagem){
        ArrayList list = new ArrayList();
        Viagem viagem = new Viagem();
        try {
            ConnectionBd connectionBd = new ConnectionBd();
            java.sql.Connection con = connectionBd.getConnection();
            
            int codArmazem = viagem.getCodArmazem();
            int codCaminhao = viagem.getCodCaminhao();
            int numViagem = viagem.getNumViagem();
            double qtdPesoViagem = 0;
            double qtdVolumeViagem = 0;
            
            con.setAutoCommit(false); //transaction block start
            
            String insertViagem = "INSERT INTO viagem VALUES(0, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(insertViagem);
            stmt.setInt(1, codArmazem);
            stmt.setInt(2, codCaminhao);
            stmt.setInt(3, numViagem);
            stmt.setDouble(4, 0);
            stmt.setDouble(5, 0);
            stmt.executeUpdate();
            
            // Chamar metodo para buscar o ultimo ID de remessa inserido
            int codViagem = 10;

            /* INSERCAO DAS REMESSAS */
            while(codViagem == 10){    
                String numRemessa = "REM_002";
                int codDeposito = 43;
                
                String insertRemessa = "INSERT INTO remessa VALUES(0, ?, ?)";
                stmt = con.prepareStatement(insertRemessa);
                stmt.setInt(1, codViagem);
                stmt.setInt(2, codDeposito);
                stmt.setString(3, numRemessa);
                stmt.executeUpdate();
                
                // Chamar metodo para buscar o ultimo ID de remessa inserido
                int codRemessa = 14;
                
                /* INSERCAO DE PRODUTOS NA REMESSA */
                while(true){
                    // Realiza a busca do produto no banco para obter os dados
                    int codProduto = 21;
                    double qtdPesoProduto = 0;
                    double qtdVolumeProduto = 0;
                    double qtdProduto = 72;
                    
                    qtdPesoViagem += qtdPesoProduto;
                    qtdVolumeViagem += qtdVolumeProduto;

                    String insertItemRemessa = "INSERT INTO item_remessa VALUES(0, ?, ?)";
                    stmt = con.prepareStatement(insertItemRemessa);
                    stmt.setInt(1, codRemessa);
                    stmt.setInt(2, codProduto);
                    stmt.setDouble(3, qtdProduto);
                    stmt.executeUpdate();
                }
            }
            
            /* ALTERA O PESO E VOLUME DA VIAGEM */
            String updateViagem = "UPDATE viagem SET qtdPesoViagem = ?, qtdVolumeViagem = ? WHERE codViagem = ?";
            stmt = con.prepareStatement(updateViagem);
            stmt.setDouble(1, qtdPesoViagem);
            stmt.setDouble(2, qtdVolumeViagem);
            stmt.setInt(3, codViagem);
            stmt.executeUpdate();
            
            con.commit(); //transaction block end
            con.close();
            
        } catch(Exception e){
            
        }
        return list;
    }
}

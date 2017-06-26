/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ItemRemessa;
import Model.Remessa;
import Model.Viagem;
import java.util.ArrayList;
import persistencia.ConnectionBd;
import persistencia.ItemRemessaPersistencia;
import persistencia.RemessaPersistencia;
import persistencia.ViagemPersistencia;

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
            
            // Insere a viagem
            ViagemPersistencia viagemPersistencia = new ViagemPersistencia();
            viagemPersistencia.insertRecord(viagem, con);
            
            // Chamar metodo para buscar o ultimo ID de remessa inserido
            int codViagem = 10;

            /* INSERCAO DAS REMESSAS */
            while(codViagem == 10){
                Remessa remessa = new Remessa();
                remessa.setNumRemessa("REM_002");
                remessa.setCodDeposito(43);
                remessa.setCodViagem(codViagem);
                
                // Insere a remessa
                RemessaPersistencia remessaPersistencia = new RemessaPersistencia();
                remessaPersistencia.insertRecord(remessa, con);
                
                // Chamar metodo para buscar o ultimo ID de remessa inserido
                int codRemessa = 14;
                
                while(codRemessa == 14){
                    // Realiza a busca do produto no banco para obter os dados
                    int codProduto = 21;
                    double qtdPesoProduto = 0;
                    double qtdVolumeProduto = 0;
                    double qtdProduto = 72;
                    
                    ItemRemessa itemRemessa = new ItemRemessa();
                    itemRemessa.setCodRemessa(codRemessa);
                    itemRemessa.setCodProduto(codProduto);
                    itemRemessa.setQtdProduto(qtdProduto);
                    
                    // Realiza somatorio para a viagem
                    qtdPesoViagem += qtdPesoProduto;
                    qtdVolumeViagem += qtdVolumeProduto;

                    // Insere o item de remessa
                    ItemRemessaPersistencia itemRemessaPersistencia = new ItemRemessaPersistencia();
                    itemRemessaPersistencia.insertRecord(itemRemessa, con);
                }
            }
            
            viagem = new Viagem();
            viagem.setQtdPesoViagem(qtdPesoViagem);
            viagem.setQtdVolumeViagem(qtdVolumeViagem);
            viagem.setCodViagem(codViagem);
            
            // Altera o peso e volume da viagem
            viagemPersistencia.updateRecord(viagem, con);
            
            con.commit(); //transaction block end
            con.close();
            
        } catch(Exception e){
            
        }
        return list;
    }
}

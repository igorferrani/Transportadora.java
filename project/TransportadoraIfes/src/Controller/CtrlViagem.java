/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Remessa;
import Model.Viagem;
import java.sql.Statement;
import java.util.ArrayList;
import persistencia.ConnectionBd;

/**
 *
 * @author Weliton de Oliveira
 */
public class CtrlViagem {
    
    public ArrayList insertRecord(Viagem viagem, Remessa remessa){
        ArrayList list = new ArrayList();
        try {
            ConnectionBd connectionBd = new ConnectionBd();
            java.sql.Connection con = connectionBd.getConnection();
            
            int codArmazem = viagem.getCodArmazem();
            int codCaminhao = viagem.getCodCaminhao();
            int numViagem = viagem.getNumViagem();
            //double qtdPesoViagem = viagem.getQtdPesoViagem();
            //double qtdVolumeViagem = viagem.getQtdVolumeViagem();
            
            String sql = "INSERT INTO viagem VALUES(0, "+
                    codArmazem+", "+
                    codCaminhao+ ", "+
                    numViagem+", 0, 0)";
            
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            
            
            /* INSERCAO DAS REMESSAS */
            double somaPeso = 0;
            double somaVolume = 0;
            while(true){    
                String sql = "INSERT INTO remessa VALUES(0, "+
                    codArmazem+", "+
                    codCaminhao+ ", "+
                    numViagem+", 0, 0)";

                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                
                /* INSERCAO DE PRODUTOS DA REMESSA */
                while(true){
                    somaPeso += peso_da_rodada;
                    somaVolume += volume_da_rodada;

                    String sql = "INSERT INTO item_remessa VALUES(0, "+
                        codArmazem+", "+
                        codCaminhao+ ", "+
                        numViagem+", 0, 0)";

                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(sql);
                }
            }
            
            /* ALTERA O PESO E VOLUME DA VIAGEM */
            String sql = "INSERT INTO viagem VALUES(0, "+
                    codArmazem+", "+
                    codCaminhao+ ", "+
                    numViagem+", 0, 0)";
            
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            con.close();
            
        } catch(Exception e){
            
        }
        return list;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Igor Ferrani
 */
public class Remessa {
    private int codRemessa;
    private int codViagem;
    private int codDeposito;
    private String numRemessa;
    private DefaultListModel arrayItemRemessa;
    private String nomCliente;
    private String nomDeposito;
    
    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getNomDeposito() {
        return nomDeposito;
    }

    public void setNomDeposito(String nomDeposito) {
        this.nomDeposito = nomDeposito;
    }

    public DefaultListModel getArrayItemRemessa() {
        return arrayItemRemessa;
    }

    public void setArrayItemRemessa(DefaultListModel arrayItemRemessa) {
        this.arrayItemRemessa = arrayItemRemessa;
    }

    public int getCodRemessa() {
        return codRemessa;
    }

    public void setCodRemessa(int codRemessa) {
        this.codRemessa = codRemessa;
    }

    public int getCodViagem() {
        return codViagem;
    }

    public void setCodViagem(int codViagem) {
        this.codViagem = codViagem;
    }

    public int getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(int codDeposito) {
        this.codDeposito = codDeposito;
    }
    
    public String getNumRemessa() {
        return numRemessa;
    }

    public void setNumRemessa(String numRemessa) {
        this.numRemessa = numRemessa;
    }
    
    public String toString(){
        return numRemessa + " | " + nomCliente + " | " + nomDeposito;
    }
}

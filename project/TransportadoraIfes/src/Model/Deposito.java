/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Igor Ferrani
 */
public class Deposito {
    private int codDeposito;
    private int codCliente;
    private int codEndereco;
    private String nomDeposito;

    public int getCodDeposito() {
        return codDeposito;
    }

    public void setCodDeposito(int codDeposito) {
        this.codDeposito = codDeposito;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(int codEndereco) {
        this.codEndereco = codEndereco;
    }

    public String getNomDeposito() {
        return nomDeposito;
    }

    public void setNomDeposito(String nomDeposito) {
        this.nomDeposito = nomDeposito;
    }
    
    public String toString(){
        return codDeposito + " - " + nomDeposito;
    }
}

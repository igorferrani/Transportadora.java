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
public class Cliente {
    private int codCliente;
    private int numCnpjCliente;
    private int numCpfCliente;
    private String nomCliente;

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    
    public int getNumCnpjCliente() {
        return numCnpjCliente;
    }

    public void setNumCnpjCliente(int numCnpjCliente) {
        this.numCnpjCliente = numCnpjCliente;
    }
    
    public int getNumCpfCliente() {
        return numCpfCliente;
    }

    public void setNumCpfCliente(int numCpfCliente) {
        this.numCpfCliente = numCpfCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }
    
    @Override
    public String toString(){
        return nomCliente;
    }
}

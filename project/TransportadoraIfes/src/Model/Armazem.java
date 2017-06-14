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
public class Armazem {
    private int codArmazem;
    private int codEndereco;
    private int numArmazem;
    private String nomArmazem;

    public int getCodArmazem() {
        return codArmazem;
    }

    public void setCodArmazem(int codArmazem) {
        this.codArmazem = codArmazem;
    }

    public int getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(int codEndereco) {
        this.codEndereco = codEndereco;
    }

    public int getNumArmazem() {
        return numArmazem;
    }

    public void setNumArmazem(int numArmazem) {
        this.numArmazem = numArmazem;
    }

    public String getNomArmazem() {
        return nomArmazem;
    }

    public void setNomArmazem(String nomArmazem) {
        this.nomArmazem = nomArmazem;
    }
}

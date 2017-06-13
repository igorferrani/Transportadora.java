/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

/**
 *
 * @author Igor Ferrani
 */
public class Bairro {
    private int codBairro;
    private int codCidade;
    private String nomBairro;

    public int getCodBairro() {
        return codBairro;
    }

    public void setCodBairro(int codBairro) {
        this.codBairro = codBairro;
    }

    public int getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
    }

    public String getNomBairro() {
        return nomBairro;
    }

    public void setNomBairro(String nomBairro) {
        this.nomBairro = nomBairro;
    }
}

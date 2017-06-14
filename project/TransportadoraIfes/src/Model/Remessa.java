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
public class Remessa {
    private int codRemessa;
    private int codViagem;
    private int codDeposito;

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
}

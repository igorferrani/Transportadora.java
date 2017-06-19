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
public class ItemRemessa {
    private int codItemRemessa;
    private int codRemessa;
    private double qtdProduto;

    public int getCodItemRemessa() {
        return codItemRemessa;
    }

    public void setCodItemRemessa(int codItemRemessa) {
        this.codItemRemessa = codItemRemessa;
    }

    public int getCodRemessa() {
        return codRemessa;
    }

    public void setCodRemessa(int codRemessa) {
        this.codRemessa = codRemessa;
    }
    
    public double getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(double qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
}

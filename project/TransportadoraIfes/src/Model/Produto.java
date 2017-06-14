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
public class Produto {
    private int codProduto;
    private int codItemRemessa;
    private int numProduto;
    private double valProduto;
    private double qtdPesoProduto;

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodItemRemessa() {
        return codItemRemessa;
    }

    public void setCodItemRemessa(int codItemRemessa) {
        this.codItemRemessa = codItemRemessa;
    }

    public int getNumProduto() {
        return numProduto;
    }

    public void setNumProduto(int numProduto) {
        this.numProduto = numProduto;
    }

    public double getValProduto() {
        return valProduto;
    }

    public void setValProduto(double valProduto) {
        this.valProduto = valProduto;
    }

    public double getQtdPesoProduto() {
        return qtdPesoProduto;
    }

    public void setQtdPesoProduto(double qtdPesoProduto) {
        this.qtdPesoProduto = qtdPesoProduto;
    }
}

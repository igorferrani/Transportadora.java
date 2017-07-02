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
    private int codProduto;
    private double qtdProduto;
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

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
    
    public String toString(){
        return produto.getCodProduto() + " - " + produto.getNomProduto() + " | Qtd: " + qtdProduto; 
    }
}

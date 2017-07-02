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
    private int codCliente;
    private String nomProduto;
    private double valProduto;
    private double qtdPesoProduto;
    private double qtdVolumeProduto;

    public double getQtdVolumeProduto() {
        return qtdVolumeProduto;
    }

    public void setQtdVolumeProduto(double qtdVolumeProduto) {
        this.qtdVolumeProduto = qtdVolumeProduto;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }
    
    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomProduto() {
        return nomProduto;
    }

    public void setNomProduto(String nomProduto) {
        this.nomProduto = nomProduto;
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
    
    public String toString(){
        return codProduto + " - " + nomProduto;
    }
}

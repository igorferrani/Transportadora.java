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
public class Caminhao {
    private int codCaminhao;
    private double qtdVolumeCaminhao;
    private double qtdPesoCaminhao;
    private String numLicencaCaminhao;

    public int getCodCaminhao() {
        return codCaminhao;
    }

    public void setCodCaminhao(int codCaminhao) {
        this.codCaminhao = codCaminhao;
    }

    public double getQtdVolumeCaminhao() {
        return qtdVolumeCaminhao;
    }

    public void setQtdVolumeCaminhao(double qtdVolumeCaminhao) {
        this.qtdVolumeCaminhao = qtdVolumeCaminhao;
    }

    public double getQtdPesoCaminhao() {
        return qtdPesoCaminhao;
    }

    public void setQtdPesoCaminhao(double qtdPesoCaminhao) {
        this.qtdPesoCaminhao = qtdPesoCaminhao;
    }

    public String getNumLicencaCaminhao() {
        return numLicencaCaminhao;
    }

    public void setNumLicencaCaminhao(String numLicencaCaminhao) {
        this.numLicencaCaminhao = numLicencaCaminhao;
    }
    
    public String toString(){
        return numLicencaCaminhao;
    }
}

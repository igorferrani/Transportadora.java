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
public class Viagem {
    private int codViagem;
    private int codArmazem;
    private int codCaminhao;
    private String numViagem;
    private double qtdPesoViagem;
    private double qtdVolumeViagem;
    private String dataDespacho;
    private String horaDespacho;

    public String getDataDespacho() {
        return dataDespacho;
    }

    public void setDataDespacho(String dataDespacho) {
        this.dataDespacho = dataDespacho;
    }

    public String getHoraDespacho() {
        return horaDespacho;
    }

    public void setHoraDespacho(String horaDespacho) {
        this.horaDespacho = horaDespacho;
    }

    public int getCodViagem() {
        return codViagem;
    }

    public void setCodViagem(int codViagem) {
        this.codViagem = codViagem;
    }

    public int getCodArmazem() {
        return codArmazem;
    }

    public void setCodArmazem(int codArmazem) {
        this.codArmazem = codArmazem;
    }

    public int getCodCaminhao() {
        return codCaminhao;
    }

    public void setCodCaminhao(int codCaminhao) {
        this.codCaminhao = codCaminhao;
    }

    public String getNumViagem() {
        return numViagem;
    }

    public void setNumViagem(String numViagem) {
        this.numViagem = numViagem;
    }

    public double getQtdPesoViagem() {
        return qtdPesoViagem;
    }

    public void setQtdPesoViagem(double qtdPesoViagem) {
        this.qtdPesoViagem = qtdPesoViagem;
    }

    public double getQtdVolumeViagem() {
        return qtdVolumeViagem;
    }

    public void setQtdVolumeViagem(double qtdVolumeViagem) {
        this.qtdVolumeViagem = qtdVolumeViagem;
    }
}

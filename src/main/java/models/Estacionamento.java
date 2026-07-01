package models;

public class Estacionamento {
    private int quantidadeVagas;
    private String localizacao;
    private int vagasOcupadas;
    private int valorHora;

    public Estacionamento(int quantidadeVagas, String localizacao, int vagasOcupadas, int valorHora) {
        this.quantidadeVagas = quantidadeVagas;
        this.localizacao = localizacao;
        this.vagasOcupadas = vagasOcupadas;
        this.valorHora = valorHora;
    }

    public int getQuantidadeVagas() {
        return quantidadeVagas;
    }

    public void setQuantidadeVagas(int quantidadeVagas) {
        this.quantidadeVagas = quantidadeVagas;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getVagasOcupadas() {return vagasOcupadas; }

    public void setVagasOcupadas(int vagasOcupadas) {
        this.vagasOcupadas = vagasOcupadas;
    }

    public int getValorHora() {return valorHora; }

    public void setValorHora(int valorHora) {this.valorHora = valorHora; }
}

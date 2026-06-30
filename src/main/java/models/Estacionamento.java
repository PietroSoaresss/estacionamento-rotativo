package models;

public class Estacionamento {
    private int quantidade_vagas;
    private String localizacao;
    private int vagas_ocupadas;
    private int valor_hora;

    public Estacionamento(int quantidade_vagas, String localizacao, int vagas_ocupadas, int valor_hora) {
        this.quantidade_vagas = quantidade_vagas;
        this.localizacao = localizacao;
        this.vagas_ocupadas = vagas_ocupadas;
        this.valor_hora = valor_hora;
    }

    public int getQuantidade_vagas() {
        return quantidade_vagas;
    }

    public void setQuantidade_vagas(int quantidade_vagas) {
        this.quantidade_vagas = quantidade_vagas;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getVagas_ocupadas() {
        return vagas_ocupadas;
    }

    public void setVagas_ocupadas(int vagas_ocupadas) {
        this.vagas_ocupadas = vagas_ocupadas;
    }

    public int getValor_hora() {return valor_hora; }

    public void setValor_hora(int valor_hora) {this.valor_hora = valor_hora; }
}

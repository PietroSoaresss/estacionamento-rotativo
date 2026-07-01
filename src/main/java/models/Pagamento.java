package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pagamento {
    private Estacionamento estacionamento;
    private Veiculo veiculo;
    private  FormaPagamento formaPagamento;
    private Double valor;
    private LocalTime horaPagamento;


    public Pagamento(Estacionamento estacionamento, Veiculo veiculo, FormaPagamento formaPagamento, Double valor) {
        this.estacionamento = estacionamento;
        this.veiculo = veiculo;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
        this.horaPagamento = LocalTime.now();
    }

    public void realizarPagamento() {
        formaPagamento.pagar(valor);
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public FormaPagamento getFormaPagamento() {return formaPagamento; }

    public void setFormaPagamento(FormaPagamento formaPagamento) {this.formaPagamento = formaPagamento; }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalTime getHoraPagamento() {
        return horaPagamento;
    }
}

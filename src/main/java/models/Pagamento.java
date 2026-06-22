package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pagamento {
    private Estacionamento estacionamento;
    private Veiculo veiculo;
    private String forma_pagamento;
    private Double valor;
    private LocalTime hora_pagamento;


    public Pagamento(Estacionamento estacionamento, Veiculo veiculo, String forma_pagamento, Double valor) {
        this.estacionamento = estacionamento;
        this.veiculo = veiculo;
        this.forma_pagamento = forma_pagamento;
        this.valor = valor;
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

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

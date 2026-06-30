package models;

import java.time.LocalTime;

    public class Carro extends Veiculo{
    public Carro(String placa, LocalTime horaEntrada) {
        super(placa, horaEntrada);
    }

    @Override
    public int getVagasOcupadas() {
        return 2;
    }
}

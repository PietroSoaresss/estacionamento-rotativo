package models;

import java.time.LocalTime;

    public class Moto extends Veiculo{
    public Moto(String placa, LocalTime horaEntrada) {
        super(placa, horaEntrada);
    }

    @Override
    public String getTipo() {
        return "Moto";
    }

    @Override
    public int getVagasOcupadas() {
        return 1;
    }
}

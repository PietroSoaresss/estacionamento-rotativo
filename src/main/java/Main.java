import models.*;

import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        int op = 0;

        Estacionamento estacionamento = null;
        Veiculo veiculo = null;
        Pagamento pagamento = null;

        do{
            System.out.println("|=============================|");
            System.out.println("|===ESTACIONAMENTO ROTATIVO===|");
            System.out.println("|=============================|");
            System.out.println("                               ");

            System.out.println("1 - cadastro de estacionamento");
            System.out.println("2 - entrar com carro no estacionamento");
            System.out.println("3 - entrar com moto no estacionamento");
            System.out.println("4 - pagamento");
            System.out.println("0 - encerrar programa");
            System.out.print("Escolha uma opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1:
                    System.out.print("Quantidade de vagas: ");
                    int qtdVagas = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Localização: ");
                    String local = sc.nextLine();

                    System.out.print("Valor da hora: ");
                    int valorHora = sc.nextInt();

                    estacionamento = new Estacionamento(qtdVagas, local, 0, valorHora);

                    System.out.println("Estacionamento cadastrado com sucesso!");

                    break;

                case 2:

                    if (estacionamento == null) {
                        System.out.println("Cadastre um estacionamento primeiro!");
                        break;
                    }

                    System.out.print("Placa do veículo: ");
                    String placaCarro = sc.nextLine();

                    veiculo = new Carro(placaCarro, LocalTime.now());

                    if (estacionamento.getQuantidade_vagas() - estacionamento.getVagas_ocupadas()
                            >= veiculo.getVagasOcupadas()) {

                        estacionamento.setVagas_ocupadas(
                                estacionamento.getVagas_ocupadas() + veiculo.getVagasOcupadas());

                        veiculos.add(veiculo);
                        System.out.println("Veículo entrou às " + veiculo.getHoraEntrada());

                    } else {
                        System.out.println("Não há vagas suficientes.");
                    }

                    break;

                case 3:

                    if (estacionamento == null) {
                        System.out.println("Cadastre um estacionamento primeiro!");
                        break;
                    }

                    System.out.print("Placa do veículo: ");
                    String placaMoto = sc.nextLine();

                    veiculo = new Moto(placaMoto, LocalTime.now());

                    if (estacionamento.getQuantidade_vagas() - estacionamento.getVagas_ocupadas()
                            >= veiculo.getVagasOcupadas()) {

                        estacionamento.setVagas_ocupadas(
                                estacionamento.getVagas_ocupadas() + veiculo.getVagasOcupadas());

                        veiculos.add(veiculo);
                        System.out.println("Veículo entrou às " + veiculo.getHoraEntrada());

                    } else {
                        System.out.println("Não há vagas suficientes.");
                    }

                    break;

                case 4:

                    if (veiculos.isEmpty()) {
                        System.out.println("Não há veículos estacionados.");
                        break;
                    }

                    System.out.print("Digite a placa do veículo: ");
                    String placa = sc.nextLine();

                    Veiculo veiculoEncontrado = null;

                    for (Veiculo v : veiculos) {
                        if (v.getPlaca().equalsIgnoreCase(placa)) {
                            veiculoEncontrado = v;
                            break;
                        }
                    }
                    if (veiculoEncontrado == null) {
                        System.out.println("Veículo não encontrado.");
                        break;
                    }


                    veiculoEncontrado.setHoraSaida(LocalTime.now());
                    System.out.println("Hora de saída: " + veiculoEncontrado.getHoraSaida());

                    System.out.println("Forma de pagamento:");
                    System.out.println("1 - Pix");
                    System.out.println("2 - Cartão");
                    System.out.println("3 - Dinheiro");

                    int opcaoPagamento = sc.nextInt();
                    sc.nextLine();

                    FormaPagamento formaPagamento = null;

                    switch (opcaoPagamento) {
                        case 1:
                            formaPagamento = new Pix();
                            break;

                        case 2:
                            formaPagamento = new Cartao();
                            break;

                        case 3:
                            formaPagamento = new Dinheiro();
                            break;

                        default:
                            System.out.println("Forma de pagamento inválida.");
                            break;
                    }

                    if (formaPagamento == null) {
                        break;
                    }

                    // Exemplo simples: cobra apenas 1 hora
                    double valor = 10.0;

                    pagamento = new Pagamento(
                            estacionamento,
                            veiculoEncontrado,
                            formaPagamento,
                            valor
                    );

                    pagamento.realizarPagamento();

                    break;

                case 0:

                    System.out.println("Programa encerrado.");

                    break;

                default:

                    System.out.println("Opção inválida!");

            }

        }while (op != 0);

        sc.close();

    }
}

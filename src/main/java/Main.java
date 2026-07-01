import models.*;

import java.sql.SQLOutput;
import java.time.Duration;
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

            //Menu de seleção das funções
            System.out.println("|=============================|");
            System.out.println("|===ESTACIONAMENTO ROTATIVO===|");
            System.out.println("|=============================|");
            System.out.println("                               ");

            System.out.println("1 - cadastro de estacionamento");
            System.out.println("2 - entrar com carro no estacionamento");
            System.out.println("3 - entrar com moto no estacionamento");
            System.out.println("4 - pagamento e saida");
            System.out.println("5 - exibir veiculos");
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
                    //Cria novo estacionamento usando o construtor da classe
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


                    //Cria novo veiculo usando o construtor da classe carro
                    veiculo = new Carro(placaCarro, LocalTime.now());

                    //Verifica se o estacionamento tem mais ou a mesma quantia de vagas que o veiculo necessita
                    if (estacionamento.getQuantidadeVagas() - estacionamento.getVagasOcupadas()
                            >= veiculo.getVagasOcupadas()) {

                        // Define a quantia de vagas do estacionamento adicionando o veiculo atual
                        estacionamento.setVagasOcupadas(
                                estacionamento.getVagasOcupadas() + veiculo.getVagasOcupadas());

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

                    //Cria novo estacionamento usando o construtor da classe moto
                    veiculo = new Moto(placaMoto, LocalTime.now());

                    //Verifica se o estacionamento tem mais ou a mesma quantia de vagas que o veiculo necessita
                    if (estacionamento.getQuantidadeVagas() - estacionamento.getVagasOcupadas()
                            >= veiculo.getVagasOcupadas()) {
                        // Define a quantia de vagas do estacionamento adicionando o veiculo atual
                        estacionamento.setVagasOcupadas(
                                estacionamento.getVagasOcupadas() + veiculo.getVagasOcupadas());
                        // Adiciona o veiculo no array de veiculos
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
                    // Lista veiculos no estacionamento
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

                    // Define hora da saída
                    veiculoEncontrado.setHoraSaida(LocalTime.now());
                    System.out.println("Hora de saída: " + veiculoEncontrado.getHoraSaida());

                    System.out.println("Forma de pagamento:");
                    System.out.println("1 - Pix");
                    System.out.println("2 - Cartão");
                    System.out.println("3 - Dinheiro");

                    int opcaoPagamento = sc.nextInt();
                    sc.nextLine();

                    FormaPagamento formaPagamento = null;

                    // Instancia a classe do metodo do pagamento mostrando mensagem personalizada
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

                    // Calcula tempo do veiculo no estacionamento
                    Duration tempo = Duration.between(
                            veiculoEncontrado.getHoraEntrada(),
                            veiculoEncontrado.getHoraSaida()
                    );

                    long minutos = tempo.toMinutes();

                    long horas = (long) Math.ceil(minutos / 60.0);

                    if (horas == 0) {
                        horas = 1;
                    }
                    // Calcula o valor do pagamento
                    double valor = horas * estacionamento.getValorHora();

                    System.out.println("Tempo estacionado: " + horas + " hora(s)");
                    System.out.println("Valor a pagar: R$ " + valor);

                    // Instancia classe pagamento
                    pagamento = new Pagamento(
                            estacionamento,
                            veiculoEncontrado,
                            formaPagamento,
                            valor
                    );

                    pagamento.realizarPagamento();

                    // Remove veiculo do estacionamento
                    estacionamento.setVagasOcupadas(
                            estacionamento.getVagasOcupadas() - veiculoEncontrado.getVagasOcupadas());

                    veiculos.remove(veiculoEncontrado);

                    System.out.println("Veículo saiu do estacionamento.");

                    break;

                case 5:

                    if (veiculos.isEmpty()) {
                        System.out.println("Não há veículos estacionados.");
                        break;
                    }

                    System.out.println("\n===== VEÍCULOS ESTACIONADOS =====");


                    for (Veiculo v : veiculos) {
                        //Calcula tempo no estacionamento
                        Duration duracao = Duration.between(v.getHoraEntrada(), LocalTime.now());
                        horas = duracao.toHours();
                        minutos = duracao.toMinutesPart();
                        long segundos = duracao.toSeconds();

                        System.out.println("Placa: " + v.getPlaca());
                        System.out.println("Tipo: " + v.getTipo());
                        System.out.println("Entrada: " + v.getHoraEntrada());
                        System.out.println("Tempo no estacionamento: " + horas +":" + minutos +":"+ segundos);
                        System.out.println("Ocupa: " + v.getVagasOcupadas() + " vaga(s)");
                        System.out.println("----------------------------");
                    }
                    System.out.println("Vagas livres: " + (estacionamento.getQuantidadeVagas() - estacionamento.getVagasOcupadas() ) );

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

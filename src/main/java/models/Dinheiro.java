package models;

public class Dinheiro implements FormaPagamento{

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento em dinheiro realizado.");
        System.out.println("Valor: R$ " + valor);
    }
}

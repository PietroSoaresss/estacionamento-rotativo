package models;

public class Cartao implements FormaPagamento{
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via Cartao realizado");
        System.out.println("Valor: R$ " + valor);
    }
}

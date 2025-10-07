
//Interface que define o contrato para diferentes processadores de pagamento.
// Cada meio de pagamento (cartao, boleto, PIX) implementara esta interface com sua propri logic de processamento.
public interface ProcessadorPagamento {

    String processarPagamento(double valor, String dadosPagamento);

    String getTipoPagamento();

    boolean validarDados(String dadosPagamento);
}




/**
 * Fábrica responsável por criar diferentes tipos de processadores de pagamento.
 * Esta classe encapsula toda a lógica de criação e instanciação dos objetos,
 * permitindo que o código cliente não precise conhecer os detalhes de criação.
 */
public class FabricaPagamento {
    public static ProcessadorPagamento criarProcessador(String tipoPagamento) {
        if (tipoPagamento == null || tipoPagamento.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo de pagamento nao pode ser nulo ou vazio");
        }

        switch (tipoPagamento.toLowerCase().trim()) {
            case "cartao de credito":
                return new CartaoCreditoProcessador();

            case "boleto bancario":
                return new BoletoProcessador();

            case "pix":
                return new PixProcessador();

            default:
                throw new IllegalArgumentException("Tipo de pagamento nao reconhecido: " + tipoPagamento);
        }
    }

    public static String[] getTiposDisponiveis() {
        return new String[]{"Carto de Credito", "Boleto Bancario", "PIX"};
    }
}



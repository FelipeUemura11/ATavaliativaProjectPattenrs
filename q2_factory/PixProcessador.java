public class PixProcessador implements ProcessadorPagamento {

    private static int contadorPix = 0;

    @Override
    public String processarPagamento(double valor, String dadosPagamento) {
        if (!validarDados(dadosPagamento)) {
            return "ERRO: Chave PIX invalida";
        }

        contadorPix++;
        String idTransacao = gerarIdTransacao();

        return String.format(
            "PIX realizado no valor de R$ %.2f\n" +
            "Chave: %s\n" +
            "ID da transacao: %s\n" +
            "Status: Concluido",
            valor,
            dadosPagamento,
            idTransacao
        );
    }

    @Override
    public String getTipoPagamento() {
        return "PIX";
    }

    @Override
    public boolean validarDados(String dadosPagamento) {
        if (dadosPagamento == null || dadosPagamento.trim().isEmpty()) {
            return false;
        }

        String chave = dadosPagamento.trim();
        if (chave.matches("\\d{11}")) {
            return true;
        }

        if (chave.matches("\\d{14}")) {
            return true;
        }

        if (chave.matches("\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\d{4}")) {
            return true;
        }

        if (chave.matches(".+@.+\\..+")) {
            return true;
        }

        return chave.matches("[a-zA-Z0-9]{32}");
    }

    private String gerarIdTransacao() {
        return String.format("PIX%06d%010d", contadorPix, System.currentTimeMillis() % 1000000000L);
    }
}



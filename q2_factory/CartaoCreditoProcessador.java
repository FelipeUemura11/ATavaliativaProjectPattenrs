
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//Implementação do processador para pagamentos com cartão de credito. Simula validação de dados do cartão e processamento do pagamento.
public class CartaoCreditoProcessador implements ProcessadorPagamento {

    private static final String FORMATO_VALIDADE = "MM/yy";

    @Override
    public String processarPagamento(double valor, String dadosPagamento) {
        if (!validarDados(dadosPagamento)) {
            return "ERRO: Dados do cartao invalidos";
        }

        // Simulacao de processamento
        return String.format("Pagamento de R$ %.2f processado com cartao de credito", valor);
    }

    @Override
    public String getTipoPagamento() {
        return "Cartao de Credito";
    }

    @Override
    public boolean validarDados(String dadosPagamento) {
        if (dadosPagamento == null || dadosPagamento.trim().isEmpty()) {
            return false;
        }

        String[] partes = dadosPagamento.split(",");
        if (partes.length != 3) {
            return false;
        }

        String numero = partes[0].trim();
        String validade = partes[1].trim();
        String cvv = partes[2].trim();
        if (!numero.matches("\\d{16}")) {
            return false;
        }

        try {
            LocalDate.parse("01/" + validade, DateTimeFormatter.ofPattern("dd/MM/yy"));
        } catch (DateTimeParseException e) {
            return false;
        }

        return cvv.matches("\\d{3}");
    }
}



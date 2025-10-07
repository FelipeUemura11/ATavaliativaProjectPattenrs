
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Implementação do processador para pagamentos com boleto bancário.
 * Gera um boleto com vencimento e código de barras simulado.
 *
 * Esta é um Concrete Product do padrão Factory.
 */
public class BoletoProcessador implements ProcessadorPagamento {

    private static int contadorBoletos = 0;

    @Override
    public String processarPagamento(double valor, String dadosPagamento) {
        if (!validarDados(dadosPagamento)) {
            return "ERRO: Dados do boleto invalidos";
        }

        contadorBoletos++;
        String codigoBarras = gerarCodigoBarras(valor);

        return String.format(
            "Boleto gerado no valor de R$ %.2f\n" +
            "Codigo de barras: %s\n" +
            "Vencimento: %s\n" +
            "ID do boleto: %010d",
            valor,
            codigoBarras,
            LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            contadorBoletos
        );
    }

    @Override
    public String getTipoPagamento() {
        return "Boleto Bancario";
    }

    @Override
    public boolean validarDados(String dadosPagamento) {
        // Para boleto, dados podem ser opcionais (nome, CPF, etc.)
        // Apenas verifica se não está null
        return dadosPagamento != null;
    }

    private String gerarCodigoBarras(double valor) {
        // Simulação de geração de código de barras
        return String.format("03399.81204 56910.123456 78901.234567 8 %08.2f",
                          valor).replace(".", "").replace(" ", "");
    }
}



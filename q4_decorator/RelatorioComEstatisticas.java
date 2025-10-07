import java.text.DecimalFormat;
import java.util.List;

public class RelatorioComEstatisticas extends RelatorioDecorator {

    private DecimalFormat formatoMoeda = new DecimalFormat("R$ #,##0.00");


    public RelatorioComEstatisticas(Relatorio relatorio) {
        super(relatorio);
    }

    @Override
    public String gerarConteudo() {
        StringBuilder conteudo = new StringBuilder();
        conteudo.append(relatorio.gerarConteudo()).append("\n");

        // Adicionar seção de estatísticas
        conteudo.append("=== Estatísticas de Faturamento ===\n");
        conteudo.append("Total de Pedidos: ").append(getNumeroPedidos()).append("\n");
        conteudo.append("Faturamento Total: ").append(formatoMoeda.format(getFaturamentoTotal())).append("\n");
        conteudo.append("Valor Médio por Pedido: ").append(formatoMoeda.format(getValorMedioPedido())).append("\n");
        conteudo.append("Pedido de Maior Valor: ").append(formatoMoeda.format(getMaiorPedido())).append("\n");
        conteudo.append("Pedido de Menor Valor: ").append(formatoMoeda.format(getMenorPedido())).append("\n");

        return conteudo.toString();
    }

    @Override
    public String getTitulo() {
        return relatorio.getTitulo() + " + Estatísticas";
    }

    @Override
    public int getTamanhoEstimado() {
        return relatorio.getTamanhoEstimado() + 500;
    }


    public int getNumeroPedidos() {
        return relatorio.getDados().size();
    }


    public double getFaturamentoTotal() {
        return relatorio.getDados().stream()
            .mapToDouble(this::extrairValor)
            .sum();
    }

    public double getValorMedioPedido() {
        return getNumeroPedidos() > 0 ? getFaturamentoTotal() / getNumeroPedidos() : 0;
    }

    public double getMaiorPedido() {
        return relatorio.getDados().stream()
            .mapToDouble(this::extrairValor)
            .max()
            .orElse(0);
    }

    public double getMenorPedido() {
        return relatorio.getDados().stream()
            .mapToDouble(this::extrairValor)
            .min()
            .orElse(0);
    }

    private double extrairValor(String pedido) {
        try {
            // Encontrar o padrão "R$ XX,XX" na string
            String valorStr = pedido.replaceAll(".*R\\$ ([0-9,]+).*", "$1");
            return Double.parseDouble(valorStr.replace(",", "."));
        } catch (Exception e) {
            return 0.0;
        }
    }
}



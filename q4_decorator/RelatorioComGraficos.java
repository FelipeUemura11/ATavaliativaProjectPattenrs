// CONCRETE DECORATOR
public class RelatorioComGraficos extends RelatorioDecorator {

    public RelatorioComGraficos(Relatorio relatorio) {
        super(relatorio);
    }

    @Override
    public String gerarConteudo() {
        StringBuilder conteudo = new StringBuilder();
        conteudo.append(relatorio.gerarConteudo()).append("\n");

        // Adicionar seção de gráficos
        conteudo.append("=== Gráficos e Visualizações ===\n");

        // Gráfico de barras simples
        conteudo.append("Distribuição de Valores dos Pedidos:\n");
        conteudo.append(gerarGraficoBarras()).append("\n");

        // Gráfico de pizza simples (representação textual)
        conteudo.append("Proporção por Faixa de Valor:\n");
        conteudo.append(gerarGraficoPizza()).append("\n");

        return conteudo.toString();
    }

    @Override
    public String getTitulo() {
        return relatorio.getTitulo() + " + Gráficos";
    }

    @Override
    public int getTamanhoEstimado() {
        return relatorio.getTamanhoEstimado() + 800; // + 800 bytes
    }

    private String gerarGraficoBarras() {
        StringBuilder grafico = new StringBuilder();

        for (String pedido : relatorio.getDados()) {
            double valor = extrairValor(pedido);
            int tamanhoBarra = (int) (valor / 10);

            grafico.append(String.format("%-30s | ", pedido.substring(0, Math.min(30, pedido.length()))));
            for (int i = 0; i < tamanhoBarra && i < 50; i++) { // Máximo 50 barras
                grafico.append("=");
            }
            grafico.append(String.format(" R$ %.2f%n", valor));
        }

        return grafico.toString();
    }
    private String gerarGraficoPizza() {
        StringBuilder grafico = new StringBuilder();

        // Categorizar pedidos por faixas de valor
        int faixa1 = 0; // Até R$ 100
        int faixa2 = 0; // R$ 100 a R$ 200
        int faixa3 = 0; // R$ 200 a R$ 300
        int faixa4 = 0; // Acima de R$ 300

        for (String pedido : relatorio.getDados()) {
            double valor = extrairValor(pedido);
            if (valor <= 100) faixa1++;
            else if (valor <= 200) faixa2++;
            else if (valor <= 300) faixa3++;
            else faixa4++;
        }

        int total = faixa1 + faixa2 + faixa3 + faixa4;

        grafico.append(String.format("Até R$ 100:     %d pedidos (%d%%)%n", faixa1, calcularPorcentagem(faixa1, total)));
        grafico.append(String.format("R$ 100-200:    %d pedidos (%d%%)%n", faixa2, calcularPorcentagem(faixa2, total)));
        grafico.append(String.format("R$ 200-300:    %d pedidos (%d%%)%n", faixa3, calcularPorcentagem(faixa3, total)));
        grafico.append(String.format("Acima R$ 300:  %d pedidos (%d%%)%n", faixa4, calcularPorcentagem(faixa4, total)));

        return grafico.toString();
    }

    private int calcularPorcentagem(int parte, int total) {
        return total > 0 ? Math.round((parte * 100.0f) / total) : 0;
    }

    private double extrairValor(String pedido) {
        try {
            String valorStr = pedido.replaceAll(".*R\\$ ([0-9,]+).*", "$1");
            return Double.parseDouble(valorStr.replace(",", "."));
        } catch (Exception e) {
            return 0.0;
        }
    }
}



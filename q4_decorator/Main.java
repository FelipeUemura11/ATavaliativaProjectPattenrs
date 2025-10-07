/**
 * Decorator no sistema de relatórios de vendas com funcionalidades opcionais.
 *
 * Diferentes funcionalidades podem ser
 * adicionadas dinamicamente a um relatório básico sem modificar a estrutura original
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Sistema de Relatórios de Vendas ===\n");

        // Criar relatório básico
        Relatorio relatorioBasico = new RelatorioBasico("Relatório de Vendas - Janeiro 2024");

        System.out.println("1. === Relatório Básico ===");
        System.out.println(relatorioBasico.gerarConteudo());
        System.out.printf("Tamanho estimado: %d bytes%n%n", relatorioBasico.getTamanhoEstimado());

        // Adicionar estatísticas
        Relatorio relatorioComEstatisticas = new RelatorioComEstatisticas(relatorioBasico);

        System.out.println("2. === Relatório com Estatísticas ===");
        System.out.println(relatorioComEstatisticas.gerarConteudo());
        System.out.printf("Tamanho estimado: %d bytes%n%n", relatorioComEstatisticas.getTamanhoEstimado());

        // Adicionar gráficos
        Relatorio relatorioComGraficos = new RelatorioComGraficos(relatorioComEstatisticas);

        System.out.println("3. === Relatório com Gráficos ===");
        System.out.println(relatorioComGraficos.gerarConteudo());
        System.out.printf("Tamanho estimado: %d bytes%n%n", relatorioComGraficos.getTamanhoEstimado());

        // Adicionar exportação PDF
        Relatorio relatorioCompleto = new RelatorioComPDF(relatorioComGraficos, "vendas_janeiro_2024.pdf");

        System.out.println("4. === Relatório Completo (PDF) ===");
        System.out.println(relatorioCompleto.gerarConteudo());
        System.out.printf("Tamanho estimado: %d bytes%n%n", relatorioCompleto.getTamanhoEstimado());

        // Demonstrar combinações diferentes
        System.out.println("5. === Comparação de Combinações ===\n");

        // Apenas básico + PDF
        Relatorio apenasBasicoPDF = new RelatorioComPDF(relatorioBasico);
        System.out.println("Relatório Básico + PDF:");
        System.out.printf("Título: %s%n", apenasBasicoPDF.getTitulo());
        System.out.printf("Tamanho: %d bytes%n", apenasBasicoPDF.getTamanhoEstimado());
        System.out.printf("Páginas PDF: %d%n%n", ((RelatorioComPDF) apenasBasicoPDF).calcularNumeroPaginas());

        // Apenas gráficos
        Relatorio apenasGraficos = new RelatorioComGraficos(relatorioBasico);
        System.out.println("Relatório Básico + Gráficos:");
        System.out.printf("Título: %s%n", apenasGraficos.getTitulo());
        System.out.printf("Tamanho: %d bytes%n%n", apenasGraficos.getTamanhoEstimado());

        // Todas as funcionalidades
        System.out.println("Relatório Completo (todas funcionalidades):");
        System.out.printf("Título: %s%n", relatorioCompleto.getTitulo());
        System.out.printf("Tamanho: %d bytes%n", relatorioCompleto.getTamanhoEstimado());
        if (relatorioCompleto instanceof RelatorioComPDF) {
            RelatorioComPDF pdfDecorator = (RelatorioComPDF) relatorioCompleto;
            System.out.printf("Arquivo PDF: %s%n", pdfDecorator.getNomeArquivo());
            System.out.printf("Páginas: %d%n", pdfDecorator.calcularNumeroPaginas());
            System.out.printf("Tamanho PDF: %d KB%n", pdfDecorator.getTamanhoPDF());
        }

        System.out.println("\n=== Demonstração de Flexibilidade ===");
        System.out.println("O sistema permite combinar funcionalidades de diferentes formas:");
        System.out.println("- Relatório básico (apenas dados essenciais)");
        System.out.println("- + Estatísticas (métricas financeiras)");
        System.out.println("- + Gráficos (visualizações)");
        System.out.println("- + PDF (exportação)");
        System.out.println("- Qualquer combinação intermediária");
        System.out.println("\nTodas as combinações mantêm a mesma interface e podem ser usadas");
        System.out.println("da mesma forma pelo código cliente.");
    }
}



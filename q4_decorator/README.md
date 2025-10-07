# Questão 4 - Sistema de Relatórios (Decorator Pattern)

Problema
Um sistema de pedidos online precisa gerar relatórios de vendas em diferentes formatos. Inicialmente, o relatório contém apenas informações básicas (lista de pedidos). Posteriormente, o gestor pode decidir adicionar funcionalidades adicionais, como estatísticas de faturamento, gráficos ou exportação em PDF. Esses recursos devem ser opcionais e adicionados de forma flexível, sem alterar o código existente do relatório básico.

Solução Implementada
Foi implementado o padrão Decorator para resolver este problema.

## Estrutura do Código

1. Relatorio (Component Interface)
Define contrato comum para todos os tipos de relatório
Métodos: `gerarConteudo()`, `getTitulo()`, `getDados()`, `getTamanhoEstimado()`

2. RelatorioBasico (Concrete Component)
   - Implementação básica do relatório
   - Contém apenas lista de pedidos
   - Serve como base para decoração

3. RelatorioDecorator (Base Decorator Class)
   - Classe base para todos os decoradores
   - Mantém referência para o relatório sendo decorado
   - Implementa interface Relatorio

### Decoradores Concretos

4. RelatorioComEstatisticas (Concrete Decorator)
   - Adiciona estatísticas financeiras (total, média, maior/menor pedido)
   - Calcula métricas automaticamente dos dados existentes

5. RelatorioComGraficos (Concrete Decorator)
   - Adiciona visualizações gráficas usando caracteres ASCII
   - Inclui gráfico de barras e distribuição por faixas

6. RelatorioComPDF (Concrete Decorator)
   - Adiciona funcionalidade de exportação em PDF
   - Simula geração e salvamento de arquivo PDF

7. Main (Classe de Demonstração)
   - Mostra diferentes combinações de funcionalidades
   - Demonstra flexibilidade do padrão

## Decorator Pattern

1. Extensão sem Modificação
Funcionalidades adicionadas sem alterar código existente
Relatório básico permanece inalterado
Novos decoradores podem ser criados facilmente

2. Composição Flexível
Funcionalidades podem ser combinadas livremente
Ordem de decoração pode variar conforme necessidade
Cada decorador adiciona responsabilidade específica

3. Princípio Aberto/Fechado
Sistema aberto para extensão (novos decoradores)
Fechado para modificação (classes existentes não mudam)

4. Single Responsibility
Cada decorador tem uma única responsabilidade
Relatório básico foca apenas nos dados essenciais
Cada funcionalidade adicional é independente

5. Transparência de Interface
Todos os decoradores implementam mesma interface
Código cliente usa decoradores da mesma forma que componente base
Não há necessidade de conhecer detalhes internos


# Questão 1 - Sistema de Logística (Strategy Pattern)

1. Problema
Uma empresa de logística precisa desenvolver um sistema de cálculo de tarifas para diferentes tipos de transporte: terrestre, aéreo e marítimo. Cada modalidade tem regras próprias para determinar o valor da entrega.

2.  Solução
Foi implementado o padrão **Strategy** para resolver este problema.
O sistema trata todos os transportes de forma uniforme através da interface `TransporteStrategy`
Cada modalidade mantém suas próprias regras específicas sem afetar outras

2. Flexibilidade e Extensibilidade
   - Novos tipos de transporte podem ser adicionados sem modificar código existente
   - Basta criar uma nova implementação da interface `TransporteStrategy`

3. Princípio Aberto/Fechado
   - A classe `SistemaLogistica` está aberta para extensão (novas estratégias)
   - Está fechada para modificação (não precisa alterar código existente)

4. Eliminação de Estruturas Condicionais
   - Sem Strategy: múltiplos `if/else` ou `switch` para diferentes tipos
   - Com Strategy: seleção dinâmica através de polimorfismo

5. Facilidade de Testes
   - Cada estratégia pode ser testada independentemente
   - Fácil criar mocks para testes unitários

### Interfaces e Classes

1. **TransporteStrategy** INTERFACE
   - define o contrato para cálculo de tarifas
   - metodo calcularTarifa(distanciaKm, pesoKg): calcula o valor da entrega
   - metodo getTipoTransporte(): retorna o nome da modalidade

2. **TransporteTerrestre** CONCRETE
   - implementação para terrestre
   - tarifa baseada principalmente na distância

3. **TransporteAereo** CONCRETE
   - implementação para aéreo
   - tarifa baseada no peso

4. **TransporteMaritimo** CONCRETE
   - implementação para marítimo
   - tarifa com taxa mínima e baseada no peso e distância

5. **SistemaLogistica**
   - classe que utiliza as estratégias
   - permite definir dinamicamente qual estratégia usar
   - encapsula a lógica de cálculo sem conhecer detalhes específicos

6. Main (Classe de Demonstração)
   - demonstra o uso do padrão com diferentes cenários
   - compara tarifas entre modalidades
   - identifica a opção mais econômica


# Questão 2 - Plataforma de Pagamentos (Factory Pattern)

Uma plataforma de pagamentos deve permitir a integração com diferentes meios (cartão de crédito, boleto bancário e PIX). A escolha do meio de pagamento deve ser configurável e o sistema precisa instanciar dinamicamente o processador correspondente sem que o código principal conheça detalhes da criação.

Solução Implementada
Foi implementado o padrão Factory para resolver este problema.


### Interfaces e Classes

1. ProcessadorPagamento (Product Interface)
   - Define o contrato para todos os processadores de pagamento
   - Métodos: `processarPagamento()`, `getTipoPagamento()`, `validarDados()`

2. CartaoCreditoProcessador (Concrete Product)
   - Implementação para pagamentos com cartão de crédito
   - Valida número, data de validade e CVV
   - Simula processamento de cartão

3. BoletoProcessador (Concrete Product)
   - Implementação para pagamentos com boleto bancário
   - Gera boleto com código de barras e data de vencimento
   - Permite dados opcionais do pagador

4. PixProcessador (Concrete Product)
   - Implementação para pagamentos via PIX
   - Valida diferentes tipos de chave PIX (CPF, telefone, email, aleatória)
   - Simula transferência instantânea

5. FabricaPagamento (Factory Class)
   - Responsável pela criação de processadores
   - Método `criarProcessador()`: instancia o processador correto baseado no tipo
   - Encapsula lógica de decisão e criação

6. Main(Classe de Demonstração)
   - Interface interativa para escolher meio de pagamento
   - Usa a fábrica para criar processadores dinamicamente
   - Coleta dados específicos de cada meio

## Factory Method
>> Encapsulamento da Criação
A fábrica centraliza toda lógica de instanciação
Código cliente não conhece detalhes de criação dos objetos

>> Facilidade de Extensão
Adicionar novos meios de pagamento requer apenas:
Criar nova implementação de `ProcessadorPagamento`
Adicionar caso no método `criarProcessador()`

>> Princípio Aberto/Fechado
Sistema aberto para novos tipos de pagamento
Fechado para modificação do código cliente

>> Eliminação de Código Duplicado
Lógica de decisão sobre qual classe instanciar fica centralizada
Evita `if/else` ou `switch` espalhados no código

>> Flexibilidade de Configuração
Sistema pode ser facilmente configurado para usar diferentes meios
Suporte a configuração externa (arquivos, banco de dados)



# Questão 3 - Site de Notícias (Observer Pattern)

## Solução Implementada
Foi implementado o padrão **Observer** para resolver este problema.

## Estrutura do Código

### Interfaces

1. **Observer** (Observer Interface)
   - Define contrato para objetos que desejam ser notificados
   - Método `notificar(topico, titulo, conteudo)`: recebe notificações
   - Método `getNome()`: identifica o observador

2. **Subject** (Subject Interface)
   - Define contrato para objetos observáveis (tópicos)
   - Métodos para gerenciar observadores: `adicionarObservador()`, `removerObservador()`
   - Método `notificarObservadores()`: envia notificações

### Classes Concretas

3. **TopicoNoticias** (Concrete Subject)
   - Implementa tópicos de notícias (Política, Esportes, Tecnologia)
   - Mantém lista de observadores (leitores inscritos)
   - Gerencia publicação e histórico de notícias

4. **LeitorNoticias** (Concrete Observer)
   - Representa leitores que se inscrevem em tópicos
   - Pode se inscrever em múltiplos tópicos simultaneamente
   - Recebe notificações apenas de tópicos de interesse

5. **SiteNoticias** (Gerenciador)
   - Coordena tópicos e leitores
   - Facilita inscrição/desinscrição
   - Gerencia publicação de notícias

6. **Main** (Classe de Demonstração)
   - Simula funcionamento completo do sistema
   - Cria leitores, tópicos e demonstra notificações

## OBSERVER PATTERNS:

1. **Desacoplamento entre Subject e Observer**
   - Tópicos não conhecem detalhes dos leitores
   - Leitores não conhecem detalhes dos tópicos
   - Comunicação unidirecional e indireta

2. **Notificações Automáticas**
   - Leitores são notificados automaticamente quando há novidades
   - Não há necessidade de verificação manual (polling)

3. **Suporte a Múltiplos Observadores**
   - Um tópico pode ter múltiplos leitores
   - Um leitor pode se inscrever em múltiplos tópicos

4. **Inscrição/Desinscrição Dinâmica**
   - Leitores podem entrar e sair de tópicos facilmente
   - Sistema se adapta automaticamente às mudanças

5. **Princípio Aberto/Fechado**
   - Novos tipos de notificações podem ser adicionados sem alterar código existente
   - Novos tópicos podem ser criados sem afetar leitores existentes




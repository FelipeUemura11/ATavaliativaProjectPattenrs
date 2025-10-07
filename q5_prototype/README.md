# Questão 5 - Padrão Prototype

## Problema
Uma empresa de design oferece modelos de documentos (currículos, propostas comerciais, relatórios). Cada modelo pode ser personalizado para um cliente específico (mudança de cores, fontes e logotipo). O sistema deve permitir que, a partir de um modelo existente, seja possível gerar rapidamente uma nova cópia personalizável, sem precisar recriar toda a estrutura do documento do zero.

## Solução - Padrão Prototype
O padrão Prototype permite criar objetos baseados em um protótipo existente, clonando-o e personalizando conforme necessário.

## Estrutura do Código

### 1. Interface `DocumentoPrototype`
- Define o contrato para objetos clonáveis
- Métodos: clonar(), personalizar(), exibir()

### 2. Classe Abstrata `Documento`
- Implementa funcionalidades comuns
- Atributos: tipo, nome, cor, fonte
- Método clonar() usando super.clone()

### 3. Classes Concretas
- Curricul - modelo de currículo
- PropostaComercial - modelo de proposta
- Relatorio - modelo de relatório


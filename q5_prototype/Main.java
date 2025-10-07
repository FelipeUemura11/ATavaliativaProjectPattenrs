/**
 * Classe principal que demonstra o padrão Prototype
 * Questão 5 - Atividade Avaliativa
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== QUESTÃO 5 - PADRÃO PROTOTYPE ===\n");
        
        // Demonstrar criação de documentos a partir de protótipos
        
        // 1. Currículo
        System.out.println("1. CRIANDO CURRICULO:");
        DocumentoPrototype curriculo = new Curriculo();
        curriculo.personalizar("João Silva", "Verde", "Times New Roman");
        System.out.println(curriculo.exibir());
        System.out.println();
        
        // 2. Proposta Comercial
        System.out.println("2. CRIANDO PROPOSTA COMERCIAL:");
        DocumentoPrototype proposta = new PropostaComercial();
        proposta.personalizar("Empresa ABC", "Azul", "Calibri");
        System.out.println(proposta.exibir());
        System.out.println();
        
        // 3. Relatório
        System.out.println("3. CRIANDO RELATÓRIO:");
        DocumentoPrototype relatorio = new Relatorio();
        relatorio.personalizar("Dr. Maria Santos", "Roxo", "Arial");
        System.out.println(relatorio.exibir());
        System.out.println();
        
        // 4. Demonstrar clonagem (essência do padrão Prototype)
        System.out.println("4. DEMONSTRANDO CLONAGEM:");
        DocumentoPrototype curriculoClone = curriculo.clonar();
        curriculoClone.personalizar("Ana Costa", "Vermelho", "Helvetica");
        System.out.println("Currículo original:");
        System.out.println(curriculo.exibir());
        System.out.println("\nCurrículo clonado (personalizado):");
        System.out.println(curriculoClone.exibir());
        System.out.println();
        
        // 5. Conclusão
        System.out.println("=== CONCLUSÃO ===");
        System.out.println("O padrão Prototype permite:");
        System.out.println("✓ Criar documentos rapidamente a partir de modelos existentes");
        System.out.println("✓ Personalizar cada cópia sem afetar o original");
        System.out.println("✓ Reutilizar estrutura complexa sem recriar do zero");
        System.out.println("✓ Facilitar manutenção e extensão do sistema");
    }
}

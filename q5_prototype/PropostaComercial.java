/**
 * Implementação concreta do protótipo Proposta Comercial
 * Concrete Prototype do padrão Prototype
 */
public class PropostaComercial extends Documento {
    
    public PropostaComercial() {
        super("Proposta Comercial");
    }
    
    @Override
    public String exibir() {
        return "=== " + tipo.toUpperCase() + " ===\n" +
               "Empresa: " + nome + "\n" +
               "Cor: " + cor + "\n" +
               "Fonte: " + fonte + "\n" +
               "Seções: Dados da Empresa, Produto, Valor, Condições\n" +
               "===============================";
    }
}

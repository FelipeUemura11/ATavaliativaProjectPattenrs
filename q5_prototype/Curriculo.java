// Implementação concreta do protótipo Currículo concrete Prototype do padrão Prototype
public class Curriculo extends Documento {
    
    public Curriculo() {
        super("Currículo");
    }
    
    @Override
    public String exibir() {
        return "=== " + tipo.toUpperCase() + " ===\n" +
               "Nome: " + nome + "\n" +
               "Cor: " + cor + "\n" +
               "Fonte: " + fonte + "\n" +
               "Seções: Dados Pessoais, Experiência, Formação\n" +
               "===============================";
    }
}

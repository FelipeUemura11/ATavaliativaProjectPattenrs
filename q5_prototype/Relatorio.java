public class Relatorio extends Documento {
    
    public Relatorio() {
        super("Relatório");
    }
    
    @Override
    public String exibir() {
        return "=== " + tipo.toUpperCase() + " ===\n" +
               "Autor: " + nome + "\n" +
               "Cor: " + cor + "\n" +
               "Fonte: " + fonte + "\n" +
               "Seções: Introdução, Metodologia, Resultados, Conclusão\n" +
               "===============================";
    }
}

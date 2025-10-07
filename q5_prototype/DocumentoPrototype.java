/**
 * Interface do padrão Prototype
 * Define o contrato para objetos que podem ser clonados
 */
public interface DocumentoPrototype extends Cloneable {
    
    DocumentoPrototype clonar();

    void personalizar(String nome, String cor, String fonte);

    String exibir();
}

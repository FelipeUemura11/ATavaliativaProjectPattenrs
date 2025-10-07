/**
 * Classe base abstrata para documentos
 * Implementa funcionalidades comuns do padrão Prototype
 */
public abstract class Documento implements DocumentoPrototype {
    
    protected String tipo;
    protected String nome;
    protected String cor;
    protected String fonte;
    
    public Documento(String tipo) {
        this.tipo = tipo;
        this.nome = "Nome Padrão";
        this.cor = "Azul";
        this.fonte = "Arial";
    }
    
    @Override
    public DocumentoPrototype clonar() {
        try {
            return (Documento) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    @Override
    public void personalizar(String nome, String cor, String fonte) {
        this.nome = nome;
        this.cor = cor;
        this.fonte = fonte;
    }
    
    public abstract String exibir();
}

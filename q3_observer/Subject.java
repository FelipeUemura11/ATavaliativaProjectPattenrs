// Interface Subject que define o contrato para tópicos de notícias que podem ser observados por múltiplos leitores
public interface Subject {

    void adicionarObservador(Observer observer);
    void removerObservador(Observer observer);
    void notificarObservadores(String titulo, String conteudo);

    String getNome();
}



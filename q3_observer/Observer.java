// Interface Observer que define o contrato para objetos que desejam ser notificados sobre mudanças em tópicos de notícias
public interface Observer {

    void notificar(String topico, String titulo, String conteudo);

    String getNome();
}



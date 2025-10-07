import java.util.ArrayList;
import java.util.List;

// Implementação concreta do tópico de notícias que gerencia
 
public class TopicoNoticias implements Subject {

    private String nome;
    private List<Observer> observadores;
    private List<String> historicoNoticias;

    public TopicoNoticias(String nome) {
        this.nome = nome;
        this.observadores = new ArrayList<>();
        this.historicoNoticias = new ArrayList<>();
    }

    @Override
    public void adicionarObservador(Observer observer) {
        if (observer != null && !observadores.contains(observer)) {
            observadores.add(observer);
            System.out.printf("Leitor '%s' inscrito no topico '%s'%n",
                            observer.getNome(), nome);
        }
    }

    @Override
    public void removerObservador(Observer observer) {
        if (observadores.remove(observer)) {
            System.out.printf("Leitor '%s' removido do topico '%s'%n",
                            observer.getNome(), nome);
        }
    }

    @Override
    public void notificarObservadores(String titulo, String conteudo) {
        String noticiaCompleta = String.format("[%s] %s", titulo, conteudo);
        historicoNoticias.add(noticiaCompleta);

        System.out.printf("\n=== Nova noticia no topico '%s' ===%n", nome);
        System.out.printf("Titulo: %s%n", titulo);
        System.out.printf("Conteudo: %s%n", conteudo);
        System.out.printf("Notificando %d leitor(es)...%n", observadores.size());

        for (Observer observer : observadores) {
            observer.notificar(nome, titulo, conteudo);
        }

        System.out.println("Notificacao enviada para todos os leitores.\n");
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void publicarNoticia(String titulo, String conteudo) {
        notificarObservadores(titulo, conteudo);
    }

    public int getNumeroLeitores() {
        return observadores.size();
    }

    public List<String> getHistoricoNoticias() {
        return new ArrayList<>(historicoNoticias);
    }
}



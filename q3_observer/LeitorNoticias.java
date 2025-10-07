import java.util.HashSet;
import java.util.Set;

public class LeitorNoticias implements Observer {

    private String nome;
    private Set<String> topicosInteresse;
    private String email;

    public LeitorNoticias(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.topicosInteresse = new HashSet<>();
    }

    @Override
    public void notificar(String topico, String titulo, String conteudo) {
        if (topicosInteresse.contains(topico)) {
            System.out.printf("   Email enviado para %s (%s):%n", nome, email);
            System.out.printf("   Assunto: Nova noticia em '%s'%n", topico);
            System.out.printf("   Titulo: %s%n", titulo);
            System.out.printf("   Preview: %.50s...%n%n", conteudo);
        }
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void adicionarTopicoInteresse(String topico) {
        topicosInteresse.add(topico);
    }

    public void removerTopicoInteresse(String topico) {
        topicosInteresse.remove(topico);
    }

    public Set<String> getTopicosInteresse() {
        return new HashSet<>(topicosInteresse);
    }
    public String getEmail() {
        return email;
    }
}



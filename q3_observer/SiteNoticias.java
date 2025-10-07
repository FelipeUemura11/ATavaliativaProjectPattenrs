import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe que gerencia o site de notícias, coordenando tópicos e leitores.
public class SiteNoticias {

    private Map<String, TopicoNoticias> topicos;
    private List<LeitorNoticias> leitores;

    // Construtor do site de notícias
    public SiteNoticias() {
        this.topicos = new HashMap<>();
        this.leitores = new ArrayList<>();

        // topicos padrao
        criarTopico("Politica");
        criarTopico("Esportes");
        criarTopico("Tecnologia");
        criarTopico("Economia");
    }
    public TopicoNoticias criarTopico(String nomeTopico) {
        if (!topicos.containsKey(nomeTopico)) {
            TopicoNoticias topico = new TopicoNoticias(nomeTopico);
            topicos.put(nomeTopico, topico);
            System.out.printf("Topico '%s' criado com sucesso.%n", nomeTopico);
        }
        return topicos.get(nomeTopico);
    }


    public LeitorNoticias registrarLeitor(String nome, String email) {
        LeitorNoticias leitor = new LeitorNoticias(nome, email);
        leitores.add(leitor);
        System.out.printf("Leitor '%s' registrado com email '%s'.%n", nome, email);
        return leitor;
    }

    public void inscreverEmTopico(LeitorNoticias leitor, String nomeTopico) {
        TopicoNoticias topico = topicos.get(nomeTopico);
        if (topico != null) {
            topico.adicionarObservador(leitor);
            leitor.adicionarTopicoInteresse(nomeTopico);
        } else {
            System.out.printf("Erro: Topico '%s' nao encontrado.%n", nomeTopico);
        }
    }
    public void desinscreverDeTopico(LeitorNoticias leitor, String nomeTopico) {
        TopicoNoticias topico = topicos.get(nomeTopico);
        if (topico != null) {
            topico.removerObservador(leitor);
            leitor.removerTopicoInteresse(nomeTopico);
        }
    }

    public void publicarNoticia(String nomeTopico, String titulo, String conteudo) {
        TopicoNoticias topico = topicos.get(nomeTopico);
        if (topico != null) {
            topico.publicarNoticia(titulo, conteudo);
        } else {
            System.out.printf("Erro: Topico '%s' nao encontrado.%n", nomeTopico);
        }
    }

    // Lista todos os tópicos disponíveis
    public void listarTopicos() {
        System.out.println("\n=== Topicos Disponiveis ===");
        for (TopicoNoticias topico : topicos.values()) {
            System.out.printf("- %s (%d leitor(es))%n",
                            topico.getNome(), topico.getNumeroLeitores());
        }
        System.out.println();
    }

    // Lista todos os leitores registrados
    public void listarLeitores() {
        System.out.println("\n=== Leitores Registrados ===");
        for (LeitorNoticias leitor : leitores) {
            System.out.printf("- %s (%s) - Interesses: %s%n",
                            leitor.getNome(), leitor.getEmail(), leitor.getTopicosInteresse());
        }
        System.out.println();
    }

    public TopicoNoticias getTopico(String nomeTopico) {
        return topicos.get(nomeTopico);
    }

    public List<TopicoNoticias> getTodosTopicos() {
        return new ArrayList<>(topicos.values());
    }
}



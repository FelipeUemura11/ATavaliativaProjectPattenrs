public class Main {

    public static void main(String[] args) {
        System.out.println("=== Site de Noticias - Sistema de Notificacoes ===\n");

        SiteNoticias site = new SiteNoticias();

        LeitorNoticias leitor1 = site.registrarLeitor("Joao Silva", "joao@email.com");
        LeitorNoticias leitor2 = site.registrarLeitor("Maria Santos", "maria@email.com");
        LeitorNoticias leitor3 = site.registrarLeitor("Carlos Oliveira", "carlos@email.com");

        // Inscrever leitores em tópicos
        site.inscreverEmTopico(leitor1, "Politica");
        site.inscreverEmTopico(leitor1, "Tecnologia");
        site.inscreverEmTopico(leitor2, "Esportes");
        site.inscreverEmTopico(leitor3, "Politica");
        site.inscreverEmTopico(leitor3, "Economia");

        site.listarTopicos();
        site.listarLeitores();

        System.out.println("=== Publicando Noticias ===\n");

        site.publicarNoticia("Politica",
            "Nova lei aprovada no Congresso",
            "O Congresso Nacional aprovou hoje uma nova legislacao sobre reforma tributaria que promete simplificar o sistema de impostos do pais.");

        site.publicarNoticia("Esportes",
            "Brasil vence Copa América",
            "A selecao brasileira de futebol conquistou o titulo da Copa America apos vitoria por 3 a 1 sobre a Argentina na final.");

        site.publicarNoticia("Tecnologia",
            "Nova descoberta em IA",
            "Pesquisadores anunciam avanço significativo em inteligencia artificial com novo modelo que supera benchmarks anteriores.");

        site.publicarNoticia("Politica",
            "Eleicoes municipais se aproximam",
            "Faltam menos de 30 dias para as eleicoes municipais e candidatos intensificam campanha em todo o pais.");

        // Demonstrar remoção de inscrição
        System.out.println("=== Alterando Inscricoes ===\n");

        site.desinscreverDeTopico(leitor1, "Politica");
        System.out.println("Joao nao recebera mais noticias de Politica.\n");

        site.publicarNoticia("Politica",
            "Presidente anuncia novo pacote economico",
            "Em pronunciamento nacional, o presidente anunciou medidas economicas que visam estimular o crescimento e gerar empregos.");

        // Mostrar histórico de um tópico
        System.out.println("=== Historico do Topico Politica ===");
        TopicoNoticias topicoPolitica = site.getTopico("Politica");
        if (topicoPolitica != null) {
            var historico = topicoPolitica.getHistoricoNoticias();
            for (int i = 0; i < historico.size(); i++) {
                System.out.printf("%d - %s%n", i + 1, historico.get(i));
            }
        }

        System.out.println("\n=== Demonstracao Finalizada ===");
        System.out.println("O sistema demonstrou como multiplos leitores podem ser");
        System.out.println("notificados automaticamente quando novas noticias são publicadas");
        System.out.println("em topicos de seu interesse, sem acoplamento entre publicador e leitores.");
    }
}



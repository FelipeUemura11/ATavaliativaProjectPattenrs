import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RelatorioBasico implements Relatorio {

    private String titulo;
    private List<String> pedidos;

    public RelatorioBasico(String titulo) {
        this.titulo = titulo;
        this.pedidos = new ArrayList<>(Arrays.asList(
            "Pedido #001 - R$ 150,00 (Produto A)",
            "Pedido #002 - R$ 89,90 (Produto B)",
            "Pedido #003 - R$ 234,50 (Produto C)",
            "Pedido #004 - R$ 67,80 (Produto D)",
            "Pedido #005 - R$ 445,00 (Produto E)"
        ));
    }

    @Override
    public String gerarConteudo() {
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("=== ").append(titulo).append(" ===\n\n");
        conteudo.append("Lista de Pedidos:\n");
        conteudo.append("- ").append(String.join("\n- ", pedidos)).append("\n");

        return conteudo.toString();
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public List<String> getDados() {
        return new ArrayList<>(pedidos);
    }

    @Override
    public int getTamanhoEstimado() {

        return gerarConteudo().getBytes().length;
    }
}



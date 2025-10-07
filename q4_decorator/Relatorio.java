import java.util.List;

public interface Relatorio {

    String gerarConteudo();

    String getTitulo();


    List<String> getDados();

    int getTamanhoEstimado();
}



import java.util.List;

public abstract class RelatorioDecorator implements Relatorio {

    protected Relatorio relatorio;

    public RelatorioDecorator(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    @Override
    public String getTitulo() {
        return relatorio.getTitulo();
    }

    @Override
    public List<String> getDados() {
        return relatorio.getDados();
    }

    @Override
    public int getTamanhoEstimado() {
        return relatorio.getTamanhoEstimado();
    }

    @Override
    public String gerarConteudo() {
        return relatorio.gerarConteudo();
    }
}



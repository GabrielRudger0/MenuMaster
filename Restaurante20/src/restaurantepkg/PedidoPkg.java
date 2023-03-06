package restaurantepkg;

public class PedidoPkg {

    private String avaliacao5Star;

    private String avaliacaoFinal;
    private String itenspedidos;

    private String observacao;

    private String quantidade;

    public String getItenspedidos() {
        return itenspedidos;
    }

    public void setItenspedidos(String itenspedidos) {
        this.itenspedidos = itenspedidos;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getAvaliacao5Star() {
        return avaliacao5Star;
    }

    public void setAvaliacao5Star(String avaliacao5Star) {
        this.avaliacao5Star = avaliacao5Star;
    }

    public String getAvaliacaoFinal() {
        return avaliacaoFinal;
    }

    public void setAvaliacaoFinal(String avaliacaoFinal) {
        this.avaliacaoFinal = avaliacaoFinal;
    }
}

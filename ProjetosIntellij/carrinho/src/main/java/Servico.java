public class Servico implements Vendavel {

    // Atributos
    private String descricao;
    private int codigo;
    private int qtdHoras;
    private double valorHora;

    // Construtor
    public Servico(String descricao, int codigo, int qtdHoras, double valorHora) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.qtdHoras = qtdHoras;
        this.valorHora = valorHora;
    }

    // Metodos
    @Override
    public double getValorVenda() {
        Double precoVenda;
        precoVenda = qtdHoras * valorHora;
        return precoVenda;
    }

    // toSring
    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + descricao + '\'' +
                ", codigo=" + codigo +
                ", qtdHoras=" + qtdHoras +
                ", valorHora=" + valorHora +
                '}';
    }

    // Getter's and Setter's
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(int qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}

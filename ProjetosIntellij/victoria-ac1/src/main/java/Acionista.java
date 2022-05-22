public class Acionista implements IBonus {

    // Atributos
    private String nome;
    private int qtdAcoes;
    private Double precoAcao;

    // Construtor
    public Acionista(String nome, int qtdAcoes, Double precoAcao) {
        this.nome = nome;
        this.qtdAcoes = qtdAcoes;
        this.precoAcao = precoAcao;
    }

    // Métodos
    @Override
    public Double getValorBonus() {
        Double valorTotalAcoes;
        Double valorGanhoBonus;
        valorTotalAcoes = qtdAcoes * precoAcao;
        valorGanhoBonus = valorTotalAcoes * 0.20;
        return valorGanhoBonus;
    }

    // toString
    @Override
    public String toString() {
        return "\nAcionista " +
                "\nNome: " + nome +
                "\nQuantidade Ações: " + qtdAcoes +
                "\nPreço Ação: " + precoAcao +
                "\nValor Ganho de Bônus: " + getValorBonus();
    }
}

public class Professor implements IBonus {

    // Atributos
    private String nome;
    private int qtdAulas;
    private Double valorHora;

    // Construtor
    public Professor(String nome, int qtdAulas, Double valorHora) {
        this.nome = nome;
        this.qtdAulas = qtdAulas;
        this.valorHora = valorHora;
    }

    // Métodos
    @Override
    public Double getValorBonus() {
        Double valor;
        valor = qtdAulas * valorHora * 4.5 * 0.15;
        return valor;
    }

    // toString
    @Override
    public String toString() {
        return "Professor: " + nome +
                "\nQuantidade de Aulas: " + qtdAulas +
                "\nValor da Hora: " + valorHora + "\n";
    }
}

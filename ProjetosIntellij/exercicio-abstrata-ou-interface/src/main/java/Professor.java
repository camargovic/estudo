public class Professor extends Funcionario {

    // Atributos
    private int qtdAulas;
    private Double valorHora;

    // Construtor
    public Professor(String nome, int qtdAulas, Double valorHora) {
        super(nome);
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
        return "\nProfessor " +
                "\nQuantidade de Aulas: " + qtdAulas +
                "\nValor da Hora: " + valorHora +
                "} " + super.toString();
    }
}

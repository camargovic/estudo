public class Coordenador extends Funcionario {

    // Atributos
    private int qtdHoras;
    private Double valorHora;

    // Construtor
    public Coordenador(String nome, int qtdHoras, Double valorHora) {
        super(nome);
        this.qtdHoras = qtdHoras;
        this.valorHora = valorHora;
    }

    // Métodos
    @Override
    public Double getValorBonus() {
        Double valor;
        valor = qtdHoras * valorHora * 4.5 * 0.2;
        return valor;
    }

    // toString
    @Override
    public String toString() {
        return "\nCoordenador " +
                "\nQuantidade de Horas: " + qtdHoras +
                "\nValor da Hora: " + valorHora +
                "} " + super.toString();
    }
}

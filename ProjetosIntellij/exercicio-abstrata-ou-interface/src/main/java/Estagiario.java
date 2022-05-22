public class Estagiario extends Funcionario {

    // Atributos
    private int qtdHora;
    private Double valorHora;

    // Contrutor
    public Estagiario(String nome, int qtdHora, Double valorHora) {
        super(nome);
        this.qtdHora = qtdHora;
        this.valorHora = valorHora;
    }

    // Métodos
    @Override
    public Double getValorBonus() {
        return 0.0;
    }

    // toString
    @Override
    public String toString() {
        return "\nEstagiario" +
                "\nQuantidade de Horas: " + qtdHora +
                "\nValor da Hora: " + valorHora
                + super.toString();
    }

}

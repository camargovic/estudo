public class FuncionarioHorista extends Funcionario {

    // Atributos
    private int qtdHora;
    private Double valorHora;

    // Construtor
    public FuncionarioHorista(int codigo, String nome, int qtdHora, Double valorHora) {
        super(codigo, nome);
        this.qtdHora = qtdHora;
        this.valorHora = valorHora;
    }

    // Métodos
    public Double getGanho() {
        Double valorGanho;
        valorGanho = qtdHora * valorHora;
        return valorGanho;
    }

    @Override
    public Double getValorBonus() {
        Double valorGanhoBonus;
        valorGanhoBonus = getGanho() * 0.10;
        return valorGanhoBonus;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() +
                "\nFuncionario Horista " +
                "\nQuantidade Hora: " + qtdHora +
                "\nValor Hora: " + valorHora +
                "\nValor Ganho de Bônus: " + getValorBonus();
    }
}

public class Horista extends Funcionario {

    // Atributos
    private Integer qtdHora;
    private Double valorHora;

    // Construtor
    public Horista(String cpf, String nome, Integer qtdHora, Double valorHora) {
        super(cpf, nome);
        this.qtdHora = qtdHora;
        this.valorHora = valorHora;
    }

    // Métodos
    @Override
    public Double calcSalario() {
        Double salario;
        salario = qtdHora * valorHora;
        return salario;
    }

    // toString
    @Override
    public String toString() {
        return "\nHorista: " +
                "\nQuantidade de horas: " + qtdHora +
                "\nValor da Hora: " + valorHora +
                "\nSalário: " + calcSalario() +
                super.toString();
    }
}

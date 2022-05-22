public class FuncionarioHoraExtra extends Funcionario {

    // Atributos
    private Double salario;
    private int qtdHoraExtra;
    private Double valorHoraExtra;

    // Construtor
    public FuncionarioHoraExtra(int codigo, String nome, Double salario, int qtdHoraExtra, Double valorHoraExtra) {
        super(codigo, nome);
        this.salario = salario;
        this.qtdHoraExtra = qtdHoraExtra;
        this.valorHoraExtra = valorHoraExtra;
    }

    // Métodos
    public Double getGanho(){
        Double valorGanho;
        valorGanho = salario + (qtdHoraExtra * valorHoraExtra);
        return valorGanho;
    }

    @Override
    public Double getValorBonus() {
        Double valorGanhoBonus;
        valorGanhoBonus = getGanho() * 0.15;
        return valorGanhoBonus;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() +
                "\nFuncionario Hora Extra" +
                "\nSalario: " + salario +
                "\nQuantidade Hora Extra:" + qtdHoraExtra +
                "\nValor Hora Extra: " + valorHoraExtra +
                "\nValor Ganho de Bônus: " + getValorBonus();
    }
}

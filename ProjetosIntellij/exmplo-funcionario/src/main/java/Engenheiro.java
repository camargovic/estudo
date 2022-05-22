public class Engenheiro extends Funcionario {

    // Atributo
    private Double salario;

    // Construtor
    public Engenheiro(String cpf, String nome, Double salario) {
        super(cpf, nome);
        this.salario = salario;
    }

    // Métodos
    // Implementação calcSalario()
    @Override
    public Double calcSalario() {
        return salario;
    }

    // toString
    @Override
    public String toString() {
        return "\nEngenheiro" +
                "\nSalario: " + salario +
                super.toString();
    }
}

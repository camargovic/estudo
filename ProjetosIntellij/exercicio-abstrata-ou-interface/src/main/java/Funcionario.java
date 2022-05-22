public abstract class Funcionario {

    // Atributos
    private String nome;

    // Construtor
    public Funcionario(String nome) {
        this.nome = nome;
    }

    // toString
    @Override
    public String toString() {
        return "\nFuncionario " +
                "Nome: " + nome;
    }

    // Métodos
    public abstract Double getValorBonus();
}

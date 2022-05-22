public abstract class Pet {

    // Atributos
    private String nome;
    private int idade;

    // Construtor
    public Pet(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos
    public abstract void darBanho();

    // toString
    @Override
    public String toString() {
        return "\nNome: " + nome +
                "\nIdade:" + idade + "\n";
    }

    // Get
    public String getNome() {
        return nome;
    }
}

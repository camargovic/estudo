public abstract class Funcionario implements IBonus {

    // Atributos
    private int codigo;
    private String nome;

    // Construtor
    public Funcionario(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    // toString
    @Override
    public String toString() {
        return "\nNome: " + nome
                +"\nCodigo: " + codigo;
    }

    // Getter's and Setters
    public int getCogidigo() {
        return codigo;
    }

    public void setCogidigo(int cogidigo) {
        this.codigo = cogidigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

public abstract class Aluno {

    // Atributos
    private Integer ra;
    private String nome;

    // Construtor
    public Aluno(Integer ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }

    // Métodos
    public abstract Double calcMedia();

    // toString
    @Override
    public String toString() {
        return "\nAluno Nome: " + nome +
                "\nRA: " + ra;
    }

    // Get

    public Integer getRa() {
        return ra;
    }
}

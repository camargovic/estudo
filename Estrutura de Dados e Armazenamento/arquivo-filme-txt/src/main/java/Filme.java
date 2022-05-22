public class Filme {

    // Atributos
    private Integer id;
    private String nome;
    private Double nota;
    private String genero;
    private Integer idade;

    // Contrutor
    public Filme(Integer id, String nome, Double nota, String genero, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.genero = genero;
        this.idade = idade;
    }

    // toString
    @Override
    public String toString() {
        return "\nFilme" +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nNota: " + nota +
                "\nGênero: " + genero +
                "\nIdade: " + idade + '\n';
    }

    // Gettter's and Setter's
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}

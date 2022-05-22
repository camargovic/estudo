public class Livro extends Produto{

    // Atributos
    private String nome;
    private String autor;
    private String isbn;

    // Construtor
    public Livro(int codigo, double precoCusto, String nome, String autor, String isbn) {
        super(codigo, precoCusto);
        this.nome = nome;
        this.autor = autor;
        this.isbn = isbn;
    }

    // Metododos
    @Override
    public double getValorVenda() {
        Double precoVenda;
        precoVenda = (getPrecoCusto() * 0.10) + getPrecoCusto();
        return precoVenda;
        /*
        ou
        getPrecoCusto * 1.1
        1.1 = 110%
        */
    }

    // toString
    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                "} " + super.toString();
    }

    // Getter's and Setter's
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

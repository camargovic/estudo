public class DVD extends Produto {

    // Atributos
    private String nome;
    private String gravadora;

    // Construtor
    public DVD(int codigo, double precoCusto, String nome, String gravadora) {
        super(codigo, precoCusto);
        this.nome = nome;
        this.gravadora = gravadora;
    }

    // Metodos
    @Override
    public double getValorVenda() {
        Double precoVenda;
        precoVenda = (getPrecoCusto() * 0.20) + getPrecoCusto();
        return precoVenda;
    }

    // toString
    @Override
    public String toString() {
        return "DVD{" +
                "nome='" + nome + '\'' +
                ", gravadora='" + gravadora + '\'' +
                "} " + super.toString();
    }

    // Getter's and Setter's
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGravadora() {
        return gravadora;
    }

    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }
}

public class Cliente {

    // Atributos
    private Integer id;
    private String nome;
    private Integer idade;
    private String metodo;
    private Double valorDoMetodo;
    private String corFavorita;
    private Boolean manutencao;

    // Construtor
    public Cliente(Integer id, String nome, Integer idade, String metodo, Double valorDoMetodo, String corFavorita, Boolean manutencao) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.metodo = metodo;
        this.valorDoMetodo = valorDoMetodo;
        this.corFavorita = corFavorita;
        this.manutencao = manutencao;
    }

    // Getter's and Setter's
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public Double getValorDoMetodo() {
        return valorDoMetodo;
    }

    public void setValorDoMetodo(Double valorDoMetodo) {
        this.valorDoMetodo = valorDoMetodo;
    }

    public String getCorFavorita() {
        return corFavorita;
    }

    public void setCorFavorita(String corFavorita) {
        this.corFavorita = corFavorita;
    }

    public Boolean getManutencao() {
        return manutencao;
    }

    public void setManutencao(Boolean manutencao) {
        this.manutencao = manutencao;
    }

    // toString
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", metodo='" + metodo + '\'' +
                ", valorDoMetodo=" + valorDoMetodo +
                ", corFavorita='" + corFavorita + '\'' +
                ", manutencao=" + manutencao +
                '}';
    }
}

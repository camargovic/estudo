public class Perfume extends Produto{

    // Atributos
    private String fragrancia;

    // Construtor
    public Perfume(int codigo, String descricao, double preco, String fragrancia) {
        super(codigo, descricao, preco);
        this.fragrancia = fragrancia;
    }

    // Métodos
    @Override
    public Double getValorTributo() {
        return getPreco() * 0.27;
    }

    // toString
    @Override
    public String toString() {
        return "Perfume{" +
                "fragrancia='" + fragrancia + '\'' +
                "Trubuto=" + getValorTributo() +
                "} " + super.toString();
    }
}

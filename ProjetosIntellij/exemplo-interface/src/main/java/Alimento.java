public class Alimento extends Produto {

    // Atributos
    private Integer quantVitamina;

    // Construtor
    public Alimento(int codigo, String descricao, double preco, Integer quantVitamina) {
        super(codigo, descricao, preco);
        this.quantVitamina = quantVitamina;
    }

    // Métodos
    //Impmlementação do getValorTributo()
    @Override
    public Double getValorTributo() {
        return getPreco() * 0.15;
    }

    // toString

    @Override
    public String toString() {
        return "Alimento{" +
                "quantVitamina=" + quantVitamina +
                "Trubuto=" + getValorTributo() +
                "} " + super.toString();
    }
}

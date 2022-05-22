public abstract class Produto implements Tributavel {

    // Atributos
    private int codigo;
    private String descricao;
    private double preco;

    // Construtor
    public Produto(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    // toString
    @Override
    public String toString() {
        return String.format("Produtos: " +
                "\nCódigo: %d" +
                "\nDescrição: %s" +
                "\nPreço: R$%.2f", codigo, descricao, preco);
    }

    // Getters


    public double getPreco() {
        return preco;
    }
}

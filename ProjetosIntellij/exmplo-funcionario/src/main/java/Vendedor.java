public class Vendedor extends Funcionario {

    // Atributos
    private Double vendas;
    private Double taxa;

    // Construtor
    public Vendedor(String cpf, String nome, Double vendas, Double taxa) {
        super(cpf, nome);
        this.vendas = vendas;
        this.taxa = taxa;
    }

    // Métodos
    @Override
    public Double calcSalario() {
        Double salario;
        salario = vendas * taxa;
        return salario;
    }

    // toString
    @Override
    public String toString() {
        return "\nVendedor: " +
                "\nVendas: " + vendas +
                "\nTaxa: " + taxa +
                "\nSalário: " + calcSalario() +
                super.toString();
    }
}

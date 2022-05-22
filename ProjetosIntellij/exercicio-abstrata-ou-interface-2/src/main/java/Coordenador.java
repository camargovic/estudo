public class Coordenador extends Professor{

    // Atributos
    private int qtdHorasCoord;
    private Double valorHoraCoord;

    // Construtor
    public Coordenador(String nome, int qtdAulas, Double valorHora, int qtdHorasCoord, Double valorHoraCoord) {
        super(nome, qtdAulas, valorHora);
        this.qtdHorasCoord = qtdHorasCoord;
        this.valorHoraCoord = valorHoraCoord;
    }

    // Métodos
    @Override
    public Double getValorBonus() {
        Double valorCoord;
        valorCoord = super.getValorBonus() + (qtdHorasCoord * valorHoraCoord * 4.5 * 0.2);
        return valorCoord;
    }

    // toString
    @Override
    public String toString() {
        return "Coordenador " +
                "\nQuantidade de Horas Coordenação: " + qtdHorasCoord +
                "\nValor Hora Coordenação " + valorHoraCoord + "\n"
                + super.toString();
    }
}

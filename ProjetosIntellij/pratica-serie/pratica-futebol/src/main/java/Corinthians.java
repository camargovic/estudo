public class Corinthians extends  TimeDeFutebol {

    // Atributos
    private int qtdJogadores;
    private Double valorHoraJogadores;

    // Construtor
    public Corinthians(String nome, String tecnico, int qtdJogadores, Double valorHoraJogadores) {
        super(nome, tecnico);
        this.qtdJogadores = qtdJogadores;
        this.valorHoraJogadores = valorHoraJogadores;
    }

    // Métodos
    @Override
    public void jogarCampeonato() {

    }
}

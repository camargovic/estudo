public abstract class TimeDeFutebol {

    // Atributos
    private String nome;
    private String tecnico;

    // Construtor
    public TimeDeFutebol(String nome, String tecnico) {
        this.nome = nome;
        this.tecnico = tecnico;
    }

    // Métodos
    public abstract void jogarCampeonato();
}

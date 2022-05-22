public class AlunoGraduacao extends Aluno {

    // Atributos
    private Double nota1;
    private Double nota2;

    // Construtor
    public AlunoGraduacao(Integer ra, String nome, Double nota1, Double nota2) {
        super(ra, nome);
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    // Metodos
    @Override
    public Double calcMedia() {
        Double media;
        media = (nota1 * 0.4) + (nota2 * 0.6);
        return media;
    }

    // toString
    @Override
    public String toString() {
        return String.format("Aluno Graduação: " +
                "\n%s" +
                "\nNota 1: %.2f" +
                "\nNota 2: %.2f" +
                "\nMedia: %.2f", super.toString(), nota1, nota2, calcMedia());
    }
}

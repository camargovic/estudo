public class AlunoPos extends Aluno {

    // Atributos
    private Double nota1;
    private Double nota2;
    private Double notaMonografia;

    // Construtor
    public AlunoPos(Integer ra, String nome, Double nota1, Double nota2, Double notaMonografia) {
        super(ra, nome);
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notaMonografia = notaMonografia;
    }

    // Metodos
    @Override
    public Double calcMedia() {
        Double media;
        media = (nota1 + nota2 + notaMonografia) / 3;
        return media;
    }

    // toString
    @Override
    public String toString() {
        return String.format("Aluno Pos: " +
                "\n%s" +
                "\nNota 1: %.2f" +
                "\nNota 2: %.2f" +
                "\nNota Monografica: %.2f" +
                "\nMedia: %.2f", super.toString(), nota1, nota2,notaMonografia, calcMedia());
    }
}

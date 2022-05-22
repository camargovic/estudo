public class AlunoFundamental extends Aluno {

    // Atributos
    private Double nota1;
    private Double nota2;
    private Double nota3;
    private Double nota4;

    // Construtor
    public AlunoFundamental(Integer ra, String nome, Double nota1, Double nota2, Double nota3, Double nota4) {
        super(ra, nome);
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    // Metodos
    @Override
    public Double calcMedia() {
        Double media;
        media = (nota1 + nota2 + nota3 + nota4) / 4;
        return media;
    }

    // toString
    @Override
    public String toString() {
        return String.format("Aluno Do Fundamental: " +
                "\n%s" +
                "\nNota 1: %.2f" +
                "\nNota 2: %.2f" +
                "\nNota 3: %.2f" +
                "\nNota 4: %.2f" +
                "\nMedia: %.2f", super.toString(), nota1, nota2, nota3, nota4, calcMedia());
    }
}

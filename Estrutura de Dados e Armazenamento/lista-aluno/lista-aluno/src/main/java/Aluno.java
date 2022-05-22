public class Aluno {
    private int ra;
    private String nome;
    private double nota;

    public Aluno(int ra, String nome, double nota) {
        this.ra = ra;
        this.nome = nome;
        this.nota = nota;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return String.format("%010d %-30s %5.2f", ra, nome, nota);
    }



}

public class Aluno {

    // Atributos
    private String ra;
    private String nome;
    private String curso;
    private String disciplina;
    private Double media;
    private Integer qtdFalta;

    // Construtor
    public Aluno(String ra, String nome, String curso, String disciplina, Double media, Integer qtdFalta) {
        this.ra = ra;
        this.nome = nome;
        this.curso = curso;
        this.disciplina = disciplina;
        this.media = media;
        this.qtdFalta = qtdFalta;
    }

    // toString
    @Override
    public String toString() {
        return "\nAluno: " +
                "\nRA: " + ra +
                "\nNome: " + nome +
                "\nCurso: " + curso +
                "\nDisciplina: " + disciplina +
                "\nMédia: " + media +
                "\nQuantidade de Falta: " + qtdFalta + "\n";
    }

    // Getter's and Setter's
    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Integer getQtdFalta() {
        return qtdFalta;
    }

    public void setQtdFalta(Integer qtdFalta) {
        this.qtdFalta = qtdFalta;
    }
}

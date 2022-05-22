package sptech.projeto03;

public class Herois {

    // Atributos
    private String nome;
    private int forca;
    private double popularidade;
    private String classe;
    private Boolean aposentado;

    // Construtor
    public Herois(String nome, int forca, double popularidade, String classe, Boolean aposentado) {
        this.nome = nome;
        this.forca = forca;
        this.popularidade = popularidade;
        this.classe = classe;
        this.aposentado = aposentado;
    }

    public Herois() {
    }

    // Getter's and Setter's
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public double getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(double popularidade) {
        this.popularidade = popularidade;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Boolean getAposentado() {
        return aposentado;
    }

    public void setAposentado(Boolean aposentado) {
        this.aposentado = aposentado;
    }
}

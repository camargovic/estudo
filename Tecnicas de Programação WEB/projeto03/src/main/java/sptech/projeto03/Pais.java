package sptech.projeto03;

public class Pais {

    // Atributos
    private String nome;
    private int medalhasDeOuro;
    private int medalhasDePrata;
    private int medalhasDeBronze;

    // Construtor
    public Pais(String nome, int medalhasDeOuro, int medalhasDePrata, int medalhasDeBronze) {
        this.nome = nome;
        this.medalhasDeOuro = medalhasDeOuro;
        this.medalhasDePrata = medalhasDePrata;
        this.medalhasDeBronze = medalhasDeBronze;
    }
    public Pais() {

    }

    // Getter's and Setter's
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMedalhasDeOuro() {
        return medalhasDeOuro;
    }

    public void setMedalhasDeOuro(int medalhasDeOuro) {
        this.medalhasDeOuro = medalhasDeOuro;
    }

    public int getMedalhasDePrata() {
        return medalhasDePrata;
    }

    public void setMedalhasDePrata(int medalhasDePrata) {
        this.medalhasDePrata = medalhasDePrata;
    }

    public int getMedalhasDeBronze() {
        return medalhasDeBronze;
    }

    public void setMedalhasDeBronze(int medalhasDeBronze) {
        this.medalhasDeBronze = medalhasDeBronze;
    }
}

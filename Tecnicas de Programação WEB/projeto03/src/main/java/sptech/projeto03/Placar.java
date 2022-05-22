package sptech.projeto03;

public class Placar {

    // Atributos
    private Integer vitorias;
    private Integer empates;
    private Integer derrotas;

    //Construtor
    public Placar() {
        vitorias = 0;
        empates = 0;
        derrotas = 0;
    }

    public int getPontosObtidos() {
        return vitorias * 3 + empates;
    }

    // Métodos
    public void registrarVitoria() {
        vitorias++;
    }

    public void registrarEmpate() {
        empates++;
    }

    public void registrarDerrota() {
        derrotas++;
    }

    // Getter's and Setter's
    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public double getAproveitamento() {
        double pontosPossiveis = (vitorias+empates+derrotas) * 3.0;
        double aproveitamento = getPontosObtidos() / pontosPossiveis * 100.0;
        return aproveitamento;
    }
}

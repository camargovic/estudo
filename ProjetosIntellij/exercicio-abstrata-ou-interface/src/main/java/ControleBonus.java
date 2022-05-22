import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    // Atributos
    private List<Funcionario> lista;

    // Construtor
    public ControleBonus() {
        lista = new ArrayList<>();
    }

    // Metodos
    public void adcionaFunc(Funcionario f) {
        lista.add(f);
        System.out.println("Funcionario Adcionado com sucesso!");
    }

    public void exibeTodos() {
        System.out.printf("\nLista de Funcionarios:");
        for (Funcionario f : lista) {
            System.out.println(f);
        }
    }

    public Double calculaTotalBonus() {
        Double total = 0.0;
       for (Funcionario f : lista) {
           total += f.getValorBonus();
       }
       return total;
    }
}

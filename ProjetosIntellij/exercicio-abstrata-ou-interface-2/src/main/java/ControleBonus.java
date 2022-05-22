import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    // Atributos
    private List<IBonus> lista;

    // Cosntrutor
    public ControleBonus() {
        lista = new ArrayList<>();
    }

    // Métodos
    // adcionar novo professor
    public void adcionaProfessor(IBonus b) {
        lista.add(b);
    }

    // mostrar a lista
    public void exibirList() {
        for (IBonus b : lista) {
            System.out.println(b);
        }
    }

    // calcular total de bonus
    public double calculaTotalBonus(){
        Double valorTotal = 0.0;
        for (IBonus b : lista) {
            valorTotal += b.getValorBonus();
        }
        return valorTotal;
    }
}

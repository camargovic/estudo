import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    // Atributos
    private List<IBonus> lista;

    // Construtor
    public ControleBonus(){
        lista = new ArrayList<>();
    }

    // Métodos
    public void adciona(IBonus b){
        lista.add(b);
        System.out.println("Funcionario adcionado com sucesso!");
    }

    public void exibirLista(){
        for (IBonus b : lista) {
            System.out.println("Exibindo lista de Pessoas que recebem o Bonus: ");
            System.out.println(b);
        }
    }

    public double calculaTotalBonus(){
        Double valorTotal = 0.0;
        for (IBonus b : lista) {
            valorTotal += b.getValorBonus();
        }
        return valorTotal;
    }
}

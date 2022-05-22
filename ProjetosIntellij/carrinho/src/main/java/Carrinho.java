import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    // Atributos
   private List<Vendavel>lista;

    // Construtor
    public Carrinho() {
        lista = new ArrayList<>();
    }

    // Metodos
    public void adcionaVendavel(Vendavel t){
        lista.add(t);
    }

    public double calculaTotalVenda(){
        Double valorTotal = 0.0;
        for (Vendavel v : lista) {
            valorTotal += v.getValorVenda();
        }
        return valorTotal;
    }

    public void exibeItensCarrinho(){
        for (Vendavel v : lista) {
            System.out.println(v);
        }
    }
}

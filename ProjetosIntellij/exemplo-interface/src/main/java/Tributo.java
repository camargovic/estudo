import java.util.ArrayList;
import java.util.List;

public class Tributo {

    // Atributos
    private List<Tributavel>lista;

    // Construtor
    public Tributo() {
        lista = new ArrayList<>();
    }

    // Métodos
    public void adcionaTributavel(Tributavel t) {
        lista.add(t);
    }

    public double calculaTotalTributo() {
        Double valorTotal = 0.0;
        for (Tributavel t : lista) {
            valorTotal += t.getValorTributo();
        }
        return valorTotal;
    }
}

/*
chamar metodo retornavel na main

System.out.printlm(trib.calculaTotalTributo()); - quando for usar só uma vez

Double total = trib.calculaTotalTributo();
System.out.printlm(total);
    usar esse quando for usar mais de uma vez
*/
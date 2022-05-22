import java.util.ArrayList;
import java.util.List;

public class Empresas {

    // Atributos
    private List<Funcionario> lista;

    // Construtor
    public Empresas() {
        lista = new ArrayList<>();
    }

    // Metodos
    public void adcionaFunc(Funcionario f) {
        lista.add(f);
    }

    public void exibeTodos() {
        System.out.println("Lista dos Funcionarios: ");
        for (Funcionario f : lista) {
            System.out.println(f);
        }
    }

    public void exbeTotalSalario() {
        Double total = 0.0;
        for (Funcionario f : lista) {
            total += f.calcSalario();
        }
        System.out.printf("Total dos salários: R$ %2f\n", total);
    }

    public void exibeHoristas() {
        System.out.println("Lista dos Horistas: ");
        for (Funcionario f : lista) {
            if (f instanceof Horista) {
                System.out.println(f);
            }
        }
    }

    public void buscaFunc(String cpf) {
        Boolean existe = false;
        for (Funcionario f : lista) {
            if (f.getCpf().equals(cpf)) {
                System.out.println(f);
                existe = true;
            }
        }
        if (existe.equals(false)) {
            System.out.println("Funcionario não cadastrado");
        }
    }
}

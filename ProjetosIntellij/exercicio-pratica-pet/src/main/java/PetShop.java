import java.util.ArrayList;
import java.util.List;

public class PetShop {

    // Atributos
    private List<Pet> pets;

    // Construtor
    public PetShop() {
        pets = new ArrayList<>();
    }

    // Métodos
    public void adcionar(Pet p) {
        pets.add(p);
        System.out.println("Pet adcionado com sucesso!!");
    }

    public void pesquisar(String nome) {
        Boolean existe = false;
        for (Pet p : pets) {
            if (p.getNome().equals(nome)) {
                System.out.println("Resultado da sua pesquisa:");
                System.out.println(p);
                existe = true;
            }
        }
        if (!existe) {
            System.out.println("Pet não cadastrado");
        }
    }

    public void exibirTodos() {
        System.out.println("Lista de todos os pets:");
        for (Pet p : pets) {
            System.out.println(p);
        }
    }

    public void excluir(String nome) {
        for (Pet p : pets) {
            if (p.getNome().equals(nome)) {
                System.out.println("Pet excluido da lista");
                pets.remove(p);
                return;
            }
        }
        System.out.println("Pet não cadastrado");
    }
}
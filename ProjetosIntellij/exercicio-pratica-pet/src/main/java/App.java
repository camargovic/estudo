public class App {
    public static void main(String[] args) {

        Gato g1 = new Gato("Mel", 10);
        Gato g2 = new Gato("Nalu", 9);
        Gato g3 = new Gato("Amy", 7);
        Gato g4 = new Gato("Chiquinho", 9);

        Cachorro c1 = new Cachorro("Bisteka", 14);
        Cachorro c2 = new Cachorro("Bruce", 2);

        PetShop MieAu = new PetShop();

        MieAu.adcionar(g1);
        MieAu.adcionar(g2);
        MieAu.adcionar(g3);
        MieAu.adcionar(g4);

        MieAu.adcionar(c1);
        MieAu.adcionar(c2);

        MieAu.exibirTodos();
        MieAu.pesquisar("Amy");
        MieAu.excluir("Chiquinho");
        MieAu.exibirTodos();
    }
}

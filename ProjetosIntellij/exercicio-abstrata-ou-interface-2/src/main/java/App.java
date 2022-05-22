public class App {
    public static void main(String[] args) {

        Professor p1 = new Professor("Suraia", 3, 20.0);
        Professor p2 = new Professor("Wesley", 5, 50.0);

        Coordenador c1 = new Coordenador("Marcos", 3, 20.0, 6, 60.0);
        Coordenador c2 = new Coordenador("Kaline", 3, 50.0, 6, 60.0);

        ControleBonus controleBonus = new ControleBonus();

        controleBonus.adcionaProfessor(p1);
        controleBonus.adcionaProfessor(p2);

        controleBonus.adcionaProfessor(c1);
        controleBonus.adcionaProfessor(c2);

        controleBonus.exibirList();

        controleBonus.calculaTotalBonus();
        System.out.println("Total de bonus fornecido: R$ " + controleBonus.calculaTotalBonus());
    }
}

public class App {
    public static void main(String[] args) {

        Professor p1 = new Professor("Margareth", 7, 50.0);
        Professor p2 = new Professor("Wesley", 7, 50.0);

        Coordenador c1 = new Coordenador("Marcos", 7, 70.0);
        Coordenador c2 = new Coordenador("Kaline", 10, 70.0);

        Estagiario e1 = new Estagiario("Fernanda", 6, 20.0);
        Estagiario e2 = new Estagiario("Victoria", 6, 20.0);

        ControleBonus cont1 = new ControleBonus();

        cont1.adcionaFunc(p1);
        cont1.adcionaFunc(p2);

        cont1.adcionaFunc(c1);
        cont1.adcionaFunc(c2);

        cont1.adcionaFunc(e1);
        cont1.adcionaFunc(e2);

        cont1.exibeTodos();

        cont1.calculaTotalBonus();
        System.out.println("\nTotal de bonus fornecido: \nR$" + cont1.calculaTotalBonus());
    }
}

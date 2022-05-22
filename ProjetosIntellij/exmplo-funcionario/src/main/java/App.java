public class App {
    public static void main(String[] args) {

        // Só para relembrar que uma classe abstrata não é instánciavel,
        // ou seja, não posso fazer "new" de uma classe abstrata
        // A linha abaixo é um erro
        // Funcionario f =

        Engenheiro e = new Engenheiro("12345", "Fulano", 15000.0);

        Vendedor v = new Vendedor("67890", "Mickey", 3000.0, 0.10);

        Horista h = new Horista("45678", "Pateta", 40, 100.0);

        System.out.println(e);
        System.out.println(v);
        System.out.println(h);

        Empresas sptech = new Empresas();
        sptech.adcionaFunc(e);
        sptech.adcionaFunc(v);
        sptech.adcionaFunc(h);

        sptech.exibeTodos();
        sptech.exbeTotalSalario();
        sptech.exibeHoristas();

    }
}

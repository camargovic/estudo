public class Exercicio3 {

    public static void main(String[] args) {
        PilhaObj pilhaString = new PilhaObj<String>(5);

        pilhaString.push("Teste1");
        pilhaString.push("Teste2");
        pilhaString.push("Teste3");
        pilhaString.push("Teste4");
        pilhaString.push("Teste5");
        pilhaString.push("Teste666");

        pilhaString.exibe();

        System.out.println("\nDesempilhando: ");
        System.out.println(pilhaString.pop());
        System.out.println(pilhaString.pop());
        System.out.println(pilhaString.pop());
        System.out.println(pilhaString.pop());
        System.out.println(pilhaString.pop());
    }
}

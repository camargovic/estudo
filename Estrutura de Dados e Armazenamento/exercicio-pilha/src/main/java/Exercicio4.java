public class Exercicio4 {

    public static void inverterFrase(String frase) {
        PilhaObj pilhaChar = new PilhaObj<Character>(frase.length());

        for (int i = 0; i < frase.length(); i++) {
            pilhaChar.push(frase.charAt(i));
        }

        while (!pilhaChar.isEmpty()) {
            System.out.print(pilhaChar.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {

        inverterFrase("Ninguém vai bater mais forte do que a vida. " +
                "Não importa como você bate e sim o quanto aguenta apanhar e continuar lutando; " +
                "o quanto pode suportar e seguir em frente. É assim que se ganha.");

        inverterFrase("Só existem dois dias no ano em que nada pode ser feito: " +
                "um se chama ontem e o outro, amanhã. Portanto, hoje é o dia certo para amar, " +
                "acreditar, fazer e, principalmente, viver! Aproveite a semana para exercitar a sua " +
                "capacidade de viver intensamente o dia de hoje.");

        inverterFrase("O problema não é o problema. O problema é a sua atitute perante o problema.");
    }
}

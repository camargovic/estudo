import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner leitorNl = new Scanner(System.in);
        String[] vetor = new String[10];
        String guarda;
        boolean tem = true;

            for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um nome para o vetor[" + i + "]");
            vetor[i] = leitorNl.nextLine();
        }
        System.out.println("Digite um nome para ser encotrada no vetor");
        guarda = leitorNl.nextLine();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals(guarda)) {
                tem = false;
                System.out.println("Encontrado no vetor[" + i + "]");
            }
        }
        if (tem) {
            System.out.println("Nome não encontrado");
        }
    }
}

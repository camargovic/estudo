import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        int[] vetor = new int[9];
        Scanner leitor = new Scanner(System.in);
        int acumulador = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor de vetor[" + i + "]");
            vetor[i] = leitor.nextInt();
            acumulador += vetor[i];
        }
        int media = acumulador/vetor.length;
        System.out.println(media);

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > media){
                System.out.println("Vetor[" + i + "] = "+ vetor[i]+" maior que a média");
            }
        }

    }
}

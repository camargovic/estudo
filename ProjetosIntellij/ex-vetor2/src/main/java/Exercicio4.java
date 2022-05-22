import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {

        int[] vetor = new int[10];
        Scanner leitor = new Scanner(System.in);
        int vezes;
        int acumulador = 0;
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor de vetor[" + i + "]");
            vetor[i] = leitor.nextInt();
        }

        System.out.println("Digite um número para ver quantas vezes ele é repetido");
        vezes = leitor.nextInt();

        for (int i = 0; i < vetor.length; i++) {
            if (vezes == vetor[i]){
                acumulador++;
            }
        }
        System.out.printf("O número %d se repete %d vezes", vezes, acumulador);
    }
}

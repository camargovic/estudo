import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        String[] vetor = new String[5];
        int[] vetor2 = new int[5];
        Scanner leitorNl = new Scanner(System.in);
        Scanner leitor = new Scanner(System.in);
        int rendimento = 0;
        int guardador = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o nome do carro de vetor[" + i + "]");
            vetor[i] = leitorNl.nextLine();
            System.out.printf("Digite o redimento do %s \n", vetor[i]);
            vetor2[i] = leitor.nextInt();
        }

        for (int i = 0; i < vetor2.length; i++){
            if (vetor2[i] > rendimento){
                rendimento = vetor2[i];
                guardador = i;
            }
        }

        System.out.printf("O %s é o carro com melhor rendimento %d", vetor[guardador], vetor2[guardador]);


    }
}

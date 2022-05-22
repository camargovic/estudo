import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        String[] vetor = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado"};
        Boolean sair = true;
        Integer escolha;
        Scanner leitor = new Scanner(System.in);
        do {
            System.out.println("Digite um número de 1 a 7");
            escolha = leitor.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println(vetor[0]);
                    break;
                case 2:
                    System.out.println(vetor[1]);
                    break;
                case 3:
                    System.out.println(vetor[2]);
                    break;
                case 4:
                    System.out.println(vetor[3]);
                    break;
                case 5:
                    System.out.println(vetor[4]);
                    break;
                case 6:
                    System.out.println(vetor[5]);
                    break;
                case 7:
                    System.out.println(vetor[6]);
                    break;
                default:
                    System.out.println("Digite um número válido");
                    break;
            }
        } while ((sair));
    }
}

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        int[] dias = {
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };
        Scanner leitor = new Scanner(System.in);
        int guardador, guardador2,conta=0;
        System.out.println("Digite o dia que quer descobrir");
        guardador = leitor.nextInt();
        System.out.println("Digite o mês que quer descobrir");
        guardador2 = leitor.nextInt();

        for (int i = 0; i < guardador2 -1; i++) {
            conta += dias[i];
        }
        System.out.printf("O dia no ano será: %d", conta+guardador);
    }
}


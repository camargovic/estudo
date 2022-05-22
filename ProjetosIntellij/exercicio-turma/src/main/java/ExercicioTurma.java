import java.util.Scanner;

public class ExercicioTurma {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String nome, turma;
        String[] turma1 = new String[50];
        String[] turma2 = new String[2];
        int indT1 = 0;  // intdT1 tem uma dupla função: represanta a quantidade de alunos inseridos
                        // na turma1 e indica a posição onde vai entrar proximo aluno
        int indT2 = 0;  // intdT2 tem uma dupla função: represanta a quantidade de alunos inseridos
                        // na turma2 e indica a posição onde vai entrar proximo aluno

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite o nome de um aluno");
            nome = leitor.next();
            do {
                System.out.println("Digite a turma do aluno: T1 ou T2");
                turma = leitor.next();
            } while (!turma.equalsIgnoreCase("T1") &&
                    !turma.equalsIgnoreCase("T2"));

            if (turma.equalsIgnoreCase("T1")) {
                turma1[indT1++] = nome;
            } else {
                turma2[indT2++] = nome;
            }
        }

        if (indT1 == 0) {
            System.out.println("Não há alunos na T1");
        } else {
            System.out.println("Há " + indT1 + " anulos na T1");
            for (int i = 0; i < indT1; i++) {
                System.out.println(turma1[i]);
            }
        }

        if (indT2 == 0) {
            System.out.println("Não há alunos na T2");
        } else {
            System.out.println("Há " + indT2 + " anulos na T2");
            for (int i = 0; i < indT2; i++) {
                System.out.println(turma2[i]);
            }
        }


    }
}

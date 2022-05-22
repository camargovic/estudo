import java.util.Scanner;

public class TesteListaAluno{

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean fim = false;		// indica fim do programa
        int ra;						// usado para ler o RA do aluno
        String nome;				// usado para ler o nome do aluno
        double nota;				// usado para ler a nota do aluno
        int opcao;					// usado para ler a opção digitada pelo usuário
        int indice;                 // usado para ler o índice desejado pelo usuário

        // Criação da lista que vai conter objetos Aluno
        ListaObj<Aluno> lista = new ListaObj(5);

        while (!fim) {	// Fica num loop até que o usuário escolha Fim
            // Exibe o menu de opções para o usuário
            System.out.println("\nEscolha uma das opções:");
            System.out.println("1- Adicionar um aluno");
            System.out.println("2- Exibir a lista");
            System.out.println("3- Exibir um aluno da lista");
            System.out.println("4- Limpar a lista");
            System.out.println("5- Fim");
            // Lê a opção digitada pelo usuário
            opcao= leitor.nextInt();

            switch(opcao) {
                // Opção 1 - Adicionar um aluno
                case 1:
                    // Solicita que o usuário digite o RA, nome e nota do aluno, e lê os valores
                    System.out.println("Digite o ra do aluno");
                    ra= leitor.nextInt();
                    System.out.println("Digite o nome do aluno");
                    nome= leitor.next();
                    System.out.println("Digite a nota do aluno");
                    nota= leitor.nextDouble();
                    // Cria um objeto aluno inicializando os atributos com os valores digitados pelo usuário
                    Aluno aluno = new Aluno(ra,nome,nota);
                    // Adiciona esse objeto à lista de alunos
                    lista.adiciona(aluno);
                    break;

                // Opção 2 - Exibir a lista
                case 2:
                    if (lista.getTamanho() == 0)  {
                        System.out.println("Lista vazia");
                    }
                    else {
                        lista.exibe();
                    }
                    break;

                // Opção 3 - Exibir um aluno da lista
                case 3:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há o que exibir");
                    }
                    else {
                        System.out.println("Digite o índice de um aluno");
                        indice = leitor.nextInt();
                        Aluno a = lista.getElemento(indice);
                        if (a == null) {
                            System.out.println("Índice inválido");
                        }
                        else {
                            System.out.println(a);
                        }
                    }
                    break;

                // Opção 4 - limpa a lista
                case 4:
                    lista.limpa();
                    break;

                // Opção 5 - Fim
                case 5:
                    fim = true;
                    break;

                // Opção diferente de 1 a 5
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

}

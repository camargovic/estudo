import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteListaAlunoGrava{

    /* Método gravaLista - recebe uma lista de objetos Aluno
     * e uma variável isCSV que indica se é arquivo CSV ou não
     * Se for arquivo CSV, grava os campos delimitados por ';'
     * Se for arquivo TXT, grava os campos delimitados por ' '
     */
    public static void gravaLista(ListaObj<Aluno> lista, String nomeArq) {
        FileWriter arq = null;		// objeto FileWriter - representa o arquivo
        Formatter saida = null;		// objeto Formatter para executar saída formatada
        boolean deuRuim = false;	// indica se deu erro

        nomeArq += ".csv";	        // acrescenta extensão .csv

        /* Abre o arquivo para escrita e de forma
         * que grave sempre no final do arquivo, sem apagar o que
         * já está gravado no arquivo (append)
         *
         * Vamos tratar esse arquivo como um objeto Formatter
         * para poder gravar usando format
         */
        try {
            arq = new FileWriter(nomeArq);  // true indica que vai fazer "append"
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);  // encerra o programa, com status de erro
        }

        // Grava no arquivo os dados dos objetos Aluno que estão na lista
        try {
            // percorre a lista de objetos Aluno
            for (int i=0; i< lista.getTamanho(); i++) {
                Aluno a = lista.getElemento(i);
                // Grava os atributos do objeto aluno no arquivo
                 saida.format("%d;%s;%.2f\n",a.getRa(),	// grava os atributos do objeto aluno
                            a.getNome(),a.getNota());	// separados por ';'

            }
        }
        catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim= true;
        }
        finally { // bloco finally é executado independente de dar erro ou não
            // usado para fechar os objetos saida e close.
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    /* Método leExibeArquivo - lê e exibe os registros de um arquivo
     * Recebe true se o arquivo a ser lido é o aluno.csv e false se for o aluno.txt
     */
    public static void leExibeArquivo(String nomeArq) {
        FileReader arq= null;		// objeto FileReader - representa o arquivo a ser lido
        Scanner entrada = null;		// objeto Scanner - para ler do arquivo
        boolean deuRuim= false;		// indica se deu erro

        nomeArq += ".csv";	        // acrescenta extensão .csv

        // Abre o arquivo para leitura
        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1); // encerra o programa, com status de erro
        }

        // Lê os registros do arquivo e exibe os dados lidos na console
        try {
            // Exibe na console os títulos das colunas
            System.out.printf("%10s %-30s %5s\n","RA","NOME","NOTA" );
            // Enquanto tem registro a ser lido
            while (entrada.hasNext()) {
                int ra = entrada.nextInt();				// Lê o RA
                String nome = entrada.next();			// Lê o nome
                double nota = entrada.nextDouble();		// Lê a nota
                System.out.printf("%10d %-30s %5.2f\n",ra,nome,nota);	// Exibe na console em colunas
            }
        }
        catch (NoSuchElementException erro)
        {
            System.err.println("Arquivo com problemas.");
            deuRuim = true;
        }
        catch (IllegalStateException erro)
        {
            System.err.println("Erro na leitura do arquivo.");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNL = new Scanner(System.in);
        boolean fim = false;		// indica fim do programa
        int ra;						// usado para ler o RA do aluno
        String nome;				// usado para ler o nome do aluno
        double nota;				// usado para ler a nota do aluno
        int opcao;					// usado para ler a opção digitada pelo usuário
        int indice;                 // usado para ler o índice desejado pelo usuário

        // Criação da lista que vai conter objetos Aluno
        ListaObj<Aluno> lista = new ListaObj(10);

        while (!fim) {	// Fica num loop até que o usuário escolha Fim
            // Exibe o menu de opções para o usuário
            System.out.println("\nEscolha uma das opções:");
            System.out.println("1- Adicionar um aluno");
            System.out.println("2- Exibir a lista");
            System.out.println("3- Exibir um aluno da lista");
            System.out.println("4- Gravar a lista num arquivo csv");
            System.out.println("5- Ler e exibir arquivo csv");
            System.out.println("6- Fim");
            // Lê a opção digitada pelo usuário
            opcao= leitor.nextInt();

            switch(opcao) {
                // Opção 1 - Adicionar um aluno
                case 1:
                    // Solicita que o usuário digite o RA, nome e nota do aluno, e lê os valores
                    System.out.println("Digite o ra do aluno");
                    ra= leitor.nextInt();
                    System.out.println("Digite o nome do aluno");
                    nome= leitorNL.nextLine();
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

                // Opção 4 - Gravar a lista num arquivo csv
                case 4:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista vazia. Não há o que gravar.");
                    }
                    else {
                        gravaLista(lista, "aluno");  // Chama o método gravaLista para gravar a lista num arquivo csv
                    }
                    break;

                // Opção 5 - Ler e exibir arquivo csv
                case 5:
                    leExibeArquivo("aluno");
                    break;

                // Opção 6 - Fim
                case 6:
                    fim = true;
                    break;

                // Opção diferente de 1 a 8
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

}

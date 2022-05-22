import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TesteFilme {
    public static void gravarArquivoCsv(ListaObj<Filme> lista, String nomeArquivo) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;
        nomeArquivo += ".csv";

        try {
            arq = new FileWriter(nomeArquivo);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Filme filme = lista.getElemento(i);
                saida.format("%d;%s;%.2f;%s;%d\n", filme.getIdFilme(), filme.getNome(), filme.getNota(), filme.getGenero(), filme.getIdade());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void gravarArquivoCsvGenero(ListaObj<Filme> lista, String nomeArquivo, String busca) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;
        nomeArquivo += ".csv";

        try {
            arq = new FileWriter(nomeArquivo);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            int contador = 0;
            for (int i = 0; i < lista.getTamanho(); i++) {
                if (lista.getElemento(i).getGenero().equalsIgnoreCase(busca)) {
                    contador++;
                    Filme filme = lista.getElemento(i);
                    saida.format("%d;%s;%.2f;%s;%d\n",
                            filme.getIdFilme(),
                            filme.getNome(),
                            filme.getNota(),
                            filme.getGenero(),
                            filme.getIdade());
                }
                if (contador == 0) {
                    System.out.println("Não há filmes deste gênero na lista");
                }
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }


    public static void leExibeArquivoCsv(String nomeArq) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;
        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        try {
            System.out.printf("\n%3s %-10s %4s %-10s %2s\n", "ID", "NOME", "NOTA", "GENERO", "IDADE");
            while (entrada.hasNext()) {
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                Double nota = entrada.nextDouble();
                String genero = entrada.next();
                Integer idade = entrada.nextInt();
                System.out.printf("%03d %-10s %04.1f %-10s %02d\n", id, nome, nota, genero, idade);
            }
            System.out.println("---------------------------------------\n");
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }

    }

    public static void main(String[] args) {
        ListaObj<Filme> lista = new ListaObj<>(5);
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNl = new Scanner(System.in);
        int opcao;
        boolean fim = false;
        int idFilme;
        String nome;
        double nota;
        String genero;
        int idade;
        String nomeArq;
        String busca;
        do {
            System.out.println("Escolha uma opção:\n1. Adicionar um filme\n2. Exibir a lista\n" +
                    "3. Gravar a lista em arquivo CSV" +
                    "\n4. Ler e exibir um arquivo CSV\n" +
                    "5. Gravar em outro arquivo CSV apenas filmes que estão na lista, mas de um determinado gênero\n" +
                    "6. Sair\n");
            opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o Id do filme:");
                    idFilme = leitor.nextInt();
                    System.out.println("Digite o nome do filme:");
                    nome = leitorNl.next();
                    do {
                        System.out.println("Digite a nota do filme(Obs: nota deve ser entre 0 e 10)");
                        nota = leitor.nextDouble();
                    } while (nota < 0 || nota > 10);
                    System.out.println("Digite o genero do filme:");
                    genero = leitorNl.next();
                    System.out.println("Digite a faixa etária do filme:");
                    idade = leitor.nextInt();
                    Filme novoFilme = new Filme(idFilme, nome, nota, genero, idade);
                    lista.adiciona(novoFilme);
                    break;
                case 2:
                    lista.exibe();
                    break;
                case 3:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista está vazia. Não há nada a gravar.");
                        break;
                    }
                    gravarArquivoCsv(lista, "filmes");
                    System.out.println("Lista foi gravada em um arquivo CSV");
                    break;
                case 4:
                    leExibeArquivoCsv("filmes");
                    break;
                case 5:
                    if (lista.getTamanho() == 0) {
                        System.out.println("Lista está vazia. Não há nada a gravar.");
                        break;
                    }
                    System.out.println("Genero que deseja buscar:");
                    busca = leitorNl.next();
                    System.out.println("Digite o nome do arquivo csv:");
                    nomeArq = leitorNl.next();
                    gravarArquivoCsvGenero(lista, nomeArq, busca);
                    System.out.println("Arquivo gênero gravado com sucesso");
                    break;
                case 6:
                    System.out.println("Até logo!");
                    fim = true;
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        } while (!fim); //diferente de fim
    }
}

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {

    public static void gravaArquivo(ListaObj<Cliente> listaCliente, String nomeArquivo) {
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
            for (int i = 0; i < listaCliente.getTamanho(); i++) {
                Cliente cliente = listaCliente.getElemento(i);
                saida.format("%d;%s;%d;%s;%.2f;%s;%b\n", cliente.getId(), cliente.getNome(), cliente.getIdade(),
                         cliente.getMetodo(), cliente.getValorDoMetodo(), cliente.getCorFavorita(), cliente.getManutencao()
                );
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

    public static void leEExibeArquivo(String nomeArq) {
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
            System.out.printf("%3s;%-10s;%2s;%-20s;%4s;%-10s;%5s", "ID", "NOME", "IDADE", "METODO", "VALOR", "COR",
                    "MANUTENÇÃO" + "\n");
            while (entrada.hasNext()) {
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                Integer idade = entrada.nextInt();
                String metodo = entrada.next();
                Double valor = entrada.nextDouble();
                String cor = entrada.next();
                Boolean manutencao = entrada.hasNextBoolean();
                System.out.printf("%03d;%-10s;%2d;%-20s;%4.2f;%-10s;%5b", id, nome, idade, metodo, valor, cor,
                        manutencao, "\n");
            }
            System.out.println("------------------------------------------------------------------------\n");
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        } catch (IllegalAccessError erro) {
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
        ListaObj<Cliente> listaCliente = new ListaObj(20);
        listaCliente.adiciona(new Cliente(1, "Thamyris", 21, "agrigel", 80.0,
                "azul", true));

        listaCliente.adiciona(new Cliente(2, "Rosana", 52, "mão tradicional", 20.0,
                "marrom", false));

        listaCliente.adiciona(new Cliente(3, "Renata", 18, "fibra de vidro", 100.0,
                "preto", true));

        listaCliente.adiciona(new Cliente(4, "Vera", 45, "fibra de vidro", 100.0,
                "rosa", true));

        listaCliente.adiciona(new Cliente(5, "Lucia", 60, "pé", 15.0,
                "verde", false));

        Scanner leitor = new Scanner(System.in);
        Scanner leitorNL = new Scanner(System.in);
        int id;
        String nome;
        int idade;
        String metodo;
        double valorDoMetodo;
        String corFavorita;
        boolean manutencao;
        int opcao;
        boolean fim = false;
        String nomeArq;
        String busca;

        do {

            System.out.println("\nOlá Selma, o que gostaria de fazer agora?");
            System.out.println("1- Adcionar nova cliente");
            System.out.println("2- Exibir todas as suas clientes");
            System.out.println("3- Gravar arquivo CSV");
            System.out.println("4- Ler e exibir o arquivo CSV");
            System.out.println("5- Aturalizar o metodo de alguma cliente");
            System.out.println("6- Fim");

            opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o ID da cliente:");
                    id = leitor.nextInt();

                    System.out.println("Digite o nome da cliente:");
                    nome = leitorNL.next();

                    System.out.println("Digite a idade da cliente");
                    idade = leitor.nextInt();

                    System.out.println("Qual o procedimento da cliente? (metodo)");
                    metodo = leitorNL.next();

                    System.out.println("Digite o valor do procedimento");
                    valorDoMetodo = leitor.nextDouble();

                    System.out.println("Qual a cor favorita dela?");
                    corFavorita = leitorNL.next();

                    System.out.println("É manutenção?");
                    manutencao = leitor.hasNextBoolean();

                    Cliente novaCliente = new Cliente(id, nome, idade, metodo, valorDoMetodo, corFavorita, manutencao);
                    listaCliente.adiciona(novaCliente);
                    break;
                case 2:
                    listaCliente.exibe();
                    break;
                case 3:
                    if (listaCliente.getTamanho() == 0) {
                        System.out.println("A lista está vazia, porque não tenta adicionar uma nova cliente?");
                        break;
                    }
                    gravaArquivo(listaCliente, "clientes");
                    System.out.println("A Lista foi gravada em um arquivo CSV");
                    break;
                case 4:
                    leEExibeArquivo("Clientes");
                    break;
                case 6:
                    fim = true;
                    break;
            }
        } while (!fim);
    }
}

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppArquivoCsv {
    public static void gravaArquivoCsv(ListaObj<Aluno> lista, String nomeArquivo){
        FileWriter arquivo = null; // É um objeto que representa o arquivo a ser gravado
        Formatter saida = null; // É um objeto que usamos para escrever no arquivo
        Boolean deuRuim = false;
        nomeArquivo += ".csv";// Acrescenta a extensão .csv ao nome do arquivo


        //Bloco (try catch) para abrir o arquivo
        try {
            arquivo = new FileWriter(nomeArquivo);
            saida = new Formatter(arquivo);
        }catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }


        //Bloco (try catch) para gravar o arquivo
        try{
            //Percorre a lista de produtos
            for (int i = 0; i < lista.getTamanho(); i++){
                // Obtenho um objeto da lista por vez (índice i)
                Aluno aluno = lista.getElemento(i);
                //Grava um registro com as informações do objeto (no caso é prod)
                // Delimito cada campo com ; pois é um arquivo CSV
                saida.format("%d;%s;%.2f\n",
                        aluno.getRa(),
                        aluno.getNome(),
                        aluno.getNota());
            }
        }catch (FormatterClosedException erro){ // FormatterClosedException é ????
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
        }
        try{
            arquivo.close();
        }
        catch (IOException erro){ // IOException é ????
            System.out.println("Erro ao fechar o arquivo");
            deuRuim = true;
        }
        if (deuRuim){
            System.exit(1);
        }
    }

    public static void gravarArquivoCsvNota(ListaObj<Aluno> lista, String nomeArquivo, Double busca) {
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
//                if (lista.getElemento(i).getPreco() == busca) { //equalsIgnoreCase é apenas para String e  não funciona com números
                if (busca.equals(lista.getElemento(i).getNota())){ // == Só funcionaria com números, mas como ele olha denro do arquivo CSV o == não funcona nesssa caso, já que o arquivo entende tudo como string
                    contador++;
                    Aluno aluno = lista.getElemento(i);
                    saida.format("%d;%s;%.2f\n",
                            aluno.getRa(),
                            aluno.getNome(),
                            aluno.getNota());

                }
                if (contador == 0) {
                    System.out.println("Não há essa nota na lista");
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


    //Exibe o arquivo Csv
    public static void leExibeArquivoCsv(String nomeArquivo){
        FileReader arquivo = null;
        Scanner entrada = null;
        Boolean deuRuim = false;
        nomeArquivo += ".csv";

        try{
            arquivo = new FileReader(nomeArquivo);
            entrada = new Scanner(arquivo).useDelimiter(";|\\n");
        }catch (FileNotFoundException erro){
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }
        try{
            System.out.printf("\n%4s  %6s   %5s\n","RA", "NOME", "NOTA");
            while (entrada.hasNext()){ // enquanto não chega ao final do arquivo
                // Leio o valor de cada campo, como quando leio do teclado usando Scanner
                Integer ra = entrada.nextInt();
                String nome = entrada.next(); // Leio o valor de cada campo, como quando leio do teclado usando Scanner
                Double nota = entrada.nextDouble();
                // Exibe os dados em formato de colunas
                System.out.printf("%4d  %6s   %5.2f\n", ra, nome, nota);
            }
            System.out.println("--------------------");
        }catch (NoSuchElementException erro){ // NoSuchElementException é ????
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }finally {
            entrada.close();
            try {
                arquivo.close();
            }catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim){
                System.exit(1);
            }
        }
    }
    //MAIN
   public static void main(String[] args) {
      boolean fim = false;
        int ra;
        String nome;
        double nota;
        int opcao;
        int indice = 0;


        Scanner leitor = new Scanner(System.in);
        Scanner leitorNl = new Scanner(System.in);
        ListaObj<Aluno> lista = new ListaObj<>(10);
        Aluno aluno = null;
        do {
            System.out.println("Escolha uma opção:\n1. Adicionar um aluno\n2. Exibir a lista\n3. Exibir um aluno da lista" +
                    "\n4. Limpar a lista\n5. Buscar um aluno pelo RA\n6. Gravar lista no arquivo CSV\n7. Ler e exibir arquivo CSV\n8. Fim");
            opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do(a) aluno(a)");
                    nome = leitorNl.nextLine();
                    System.out.println("Digite o RA do(a) aluno(a) " + nome);
                    ra = leitor.nextInt();
                    System.out.println("Digite a nota do(a) aluno(a) " + nome);
                    nota = leitor.nextDouble();
                    Aluno alunoNovo = new Aluno(ra, nome, nota);
                    lista.adiciona(alunoNovo);
                    break;
                case 2:
                    lista.exibe();
                    break;
                case 3:
                    System.out.println("Digite o índice do aluno que procura");
                    indice = leitor.nextInt();
                    lista.getElemento(indice);
                    break;
                case 4:
                    lista.limpa();
                    System.out.println("(!) Lista Limpa (!)");
                    break;
                case 5:
                    System.out.println("Digite o RA que deseja buscar");
                    ra = leitor.nextInt();
                    for (int i = 0; i < lista.getTamanho(); i++) {
                        if (lista.getElemento(i).getRa() == ra) {
                            aluno = lista.getElemento(i);
                            break;
                        }
                    }
                    System.out.println(aluno != null ? aluno : "Aluno não encotrado");
                    break;
                case 6:
                   if (lista.getTamanho() == 0){
                       System.out.println("Lista está vazia. Não há nada a gravar");
                   }else {
                       System.out.println("Lista foi gravada no arquivo CSV");
                       gravaArquivoCsv(lista,"alunos");
                   }
                    break;
                case 7:
                    leExibeArquivoCsv("alunos");
                    break;
                case 8:
                    System.out.println("Até logo!");
                    fim = true;
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        } while (!fim);

    }
}

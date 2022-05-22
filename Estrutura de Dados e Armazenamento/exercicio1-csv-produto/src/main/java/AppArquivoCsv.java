import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppArquivoCsv {
    public static void gravaArquivoCsv(ListaObj<Produto> lista, String nomeArquivo){
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
                Produto prod = lista.getElemento(i);
                //Grava um registro com as informações do objeto (no caso é prod)
                // Delimito cada campo com ; pois é um arquivo CSV
                saida.format("%d;%s;%.2f;%s;%d\n",
                        prod.getCodProduto(),
                        prod.getNome(),
                        prod.getPreco(),
                        prod.getAvaliacao(),
                        prod.getQuantidadeVendida());
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


    public static void gravarArquivoCsvPreco(ListaObj<Produto> lista, String nomeArquivo, Double busca) {
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
                  if (busca.equals(lista.getElemento(i).getPreco())){ // == Só funcionaria com números, mas como ele olha denro do arquivo CSV o == não funcona nesssa caso, já que o arquivo entende tudo como string
                    contador++;
                    Produto produto = lista.getElemento(i);
                    saida.format("%d;%s;%.2f;%s;%d\n",
                            produto.getCodProduto(),
                            produto.getNome(),
                            produto.getPreco(),
                            produto.getAvaliacao(),
                            produto.getQuantidadeVendida());

                }
                if (contador == 0) {
                    System.out.println("Não há produtos deste preço na lista");
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

            System.out.printf("\n%6s  %-18s %6s %10s  %18s\n","CODIGO", "NOME", "PRECO", "AVALIACAO", "QUANTIDADE VENDIDA");
            while (entrada.hasNext()){ // enquanto não chega ao final do arquivo
                // Leio o valor de cada campo, como quando leio do teclado usando Scanner
                Integer codigo = entrada.nextInt();
                String nome = entrada.next(); // Leio o valor de cada campo, como quando leio do teclado usando Scanner
                Double preco = entrada.nextDouble();
                String avaliacao = entrada.next();
                Integer quantidadeVendida = entrada.nextInt();
                // Exibe os dados em formato de colunas
                System.out.printf("%06d  %-18s %6.2f %10s  %18d\n", codigo, nome, preco, avaliacao, quantidadeVendida);
            }
            System.out.println("----------------------------------------------------------------");
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
        ListaObj<Produto> listaProd = new ListaObj(10);

        listaProd.adiciona(new Produto(1,"Macarrão Integral",7.0,"***",320));
        listaProd.adiciona(new Produto(2,"Caixa de Ovos",15.3,"****",1256));
        listaProd.adiciona(new Produto(3,"Queijo Branco",13.6,"*****",12543));
        listaProd.adiciona(new Produto(4,"Alface",9.0,"**",563));


        //Exibe a lista
        listaProd.exibe();

        // Grava o arquivo CSV com os dados que estão na lista(ela cria)
        gravaArquivoCsv(listaProd,"produtos");

        // Lê o arquivo CSV e exibe seu conteúdo na console
        leExibeArquivoCsv("produtos");

        //Apenas grava
        gravarArquivoCsvPreco(listaProd, "produtosPreco", 7.0);

        //Exibe no console
        leExibeArquivoCsv("produtosPreco");
    }

}




import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppArquivoCsv {

    public static void gravaArquivoCsv(ListaObj<Cachorro> lista, String nomeArq) {
        FileWriter arq = null;  // obj representa o arquivo a ser gravado
        Formatter saida = null; // obj que usaremos para escrever no arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";      // acrescenta a extensão .csv ao nome do arquivo

        // Bloco try catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // Bloco try catch para gravar o arquivo
        try {
            // Percorro a lista de cachorros
            for (int i = 0; i < lista.getTamanho(); i++) {
                // Obtenho um objeto da lista por vez (índice i)
                Cachorro dog = lista.getElemento(i);
                // Grava um registro com as informações do objeto dog
                // Delimito cada campo com ; pois é um arquivo CSV
                saida.format("%d;%s;%s;%.2f\n",dog.getId(),dog.getNome(),
                                               dog.getPorte(),dog.getPeso());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivoCsv(String nomeArq) {
        FileReader arq = null;  // obj que representa o arquivo para leitura
        Scanner entrada = null; // obj que será usado para ler do arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";      // acrescento a extensão .csv ao nome do arquivo

        // Bloco try catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            // defino que o delimitador de campo na leitura será o ; ou o \n (final do registro)
            entrada= new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado!");
            System.exit(1);
        }

        // Bloco try catch para ler o arquivo
        try {
            // Exibe uma linha com os títulos das colunas
            System.out.printf("%4s %-15s %-9s %5s\n","ID","NOME","PORTE","PESO");
            while (entrada.hasNext()) {   // enquanto não chega ao final do arquivo
                // Leio o valor de cada campo, como quando leio do teclado usando Scanner
                Integer id = entrada.nextInt();
                String nome = entrada.next();   // aqui o next lê a String delimitada por ; então lê até qdo tem nomes separados por branco
                String porte = entrada.next();
                Double peso = entrada.nextDouble();
                // Exibe os dados em formato de colunas
                System.out.printf("%4d %-15s %-9s %05.2f\n",id,nome,porte,peso);
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }


    }



    public static void main(String[] args) {
        ListaObj<Cachorro> listaDog = new ListaObj(7);

        listaDog.adiciona(new Cachorro(1,"Agata","Grande",50.0));
        listaDog.adiciona(new Cachorro(2,"Lara","Medio",12.0));
        listaDog.adiciona(new Cachorro(3,"Princesa","Medio",20.0));
        listaDog.adiciona(new Cachorro(4,"Binao","Medio",12.0));
        listaDog.adiciona(new Cachorro(5,"Juninho","Pequeno",10.0));

        // Exibe a lista
        listaDog.exibe();

        // Grava o arquivo CSV com os dados que estão na lista
        gravaArquivoCsv(listaDog, "dogs");

        // Lê o arquivo CSV e exibe seu conteúdo na console
        leExibeArquivoCsv("dogs");
    }



}

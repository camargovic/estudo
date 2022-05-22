import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {

    // Metodo para gerar registro
    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        //try-catch para abrir o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo " + erro);
        }

        //try-cath para gravar o registro e fechar o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo " + erro);
        }
    }

    // Método para gerar arquivo
    public static void gravaArquivoTXT(List<Filme> lista, String nomeArq) {
        int contaRegCorpo = 0;

        // Monta o registro do Header
        String header = "00FILMES";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        // grava o registro de header
        gravaRegistro(header, nomeArq);

        // monta os registros do corpo
        String corpo;
        for (Filme f : lista) {
            corpo = "02";
            corpo += String.format("%03d", f.getId());
            corpo += String.format("%-50.50s", f.getNome());
            corpo += String.format("%05.2f", f.getNota());
            corpo += String.format("%-10.10s", f.getGenero());
            corpo += String.format("%03d", f.getIdade());
            contaRegCorpo++;
            gravaRegistro(corpo, nomeArq);
        }

        // monta e grava o registro do trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegCorpo);
        gravaRegistro(trailer, nomeArq);
    }

    // metodo para ler arquivo
    public static void leArquivoTXT(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        Integer id, idade;
        String nome, genero;
        Double nota;
        int contaRegCorpoLido = 0;
        int qtdRegCorpoGravado;

        List<Filme> listaLida = new ArrayList<>();

        //try-cath para abrir o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo " + erro);
        }

        // try-cath para ler e fechar o arquivo
        try {
            // leitura do primeiroregistro do arquivo
            registro = entrada.readLine();

            while (registro != null) {// enquanto não chegou ao final do arquivo
                //obtem os dois primeiros caracteres do registro
                //01234567
                //00FILMES
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("É um registro de Header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 8));
                    System.out.println("Data e hora da gravação: " + registro.substring(8, 27));
                    System.out.println("Versão do documento: " + registro.substring(27, 29));
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("É um registro de Trailer");
                    qtdRegCorpoGravado = Integer.parseInt(registro.substring(2, 12));
                    if (contaRegCorpoLido == qtdRegCorpoGravado) {
                        System.out.println("Quantidade de registros lisdos é compativel com a quantidade de" +
                                " registros gravados");
                    } else {
                        System.out.println("Quantidade de registros lisdos não é compativel com a quantidade de" +
                                " registros gravados");
                    }
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("É um registro de Corpo");
                    id = Integer.valueOf(registro.substring(2, 5));
                    nome = registro.substring(5, 55).trim();
                    nota = Double.valueOf(registro.substring(55, 60).replace(',', '.'));
                    genero = registro.substring(60, 70).trim();
                    idade = Integer.valueOf(registro.substring(70, 73));
                    contaRegCorpoLido++;

                    // adcionando filme
                    Filme f = new Filme(id, nome, nota, genero, idade);
                    listaLida.add(f);
                } else {
                    System.out.println("Tipo de registro inválido");
                }

                // le o proximo registro
                registro = entrada.readLine();

            }
        } catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo " + erro);
        }
        // exibindo listaLida
        for (Filme f : listaLida) {
            System.out.println(f);
        }
    }

    // Metodo executável
    public static void main(String[] args) {

        // Criando lista de filmes
        List<Filme> lista = new ArrayList<>();

        // Adcionando a lista
        lista.add(new Filme(1, "Diario de uma paixão", 10.0, "Romance", 13));
        lista.add(new Filme(2, "Nasce uma estrela", 10.0, "Romance", 18));
        lista.add(new Filme(3, "Pantera negra", 10.0, "Ação", 16));
        lista.add(new Filme(4, "Ainda estou aqui", 7.0, "Romance", 13));
        lista.add(new Filme(5, "Invocação do mal", 9.0, "Terror", 18));

        // Exibindo a lista
        for (Filme f : lista) {
            System.out.println(f);
        }

        // Gravando a lista
       // gravaArquivoTXT(lista, "filme.txt");
        // ^ está comentado para não gravar mais

        //le a lista
        leArquivoTXT("filme.txt");
    }
}

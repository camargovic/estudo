import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {

    // Método para gravar o registro
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

    // Metodo para gravar o arquivo
    public static void gravaArquivoTXT(List<Aluno> lista, String nomeArq) {
        int contaRegCorpo = 0;

        // Monta o registro de header
        String header = "00NOTA20221";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        // grava o registro de header
        gravaRegistro(header, nomeArq);

        // monta os registros de corpo
        String corpo;
        for (Aluno a : lista) {
            corpo = "02";
            corpo += String.format("%-5.5s", a.getCurso());
            corpo += String.format("%-8.8s", a.getRa());
            corpo += String.format("%-50.50s", a.getNome());
            corpo += String.format("%-40.40s", a.getDisciplina());
            corpo += String.format("%05.2f", a.getMedia());
            corpo += String.format("%03d", a.getQtdFalta());
            contaRegCorpo++;
            gravaRegistro(corpo, nomeArq);
        }

        // monta e garva o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegCorpo);
        gravaRegistro(trailer, nomeArq);
    }

    // metodo que le arquivo txt
    public static void leArquivoTXT(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String ra, nome, curso, disciplina;
        Double media;
        Integer qtdFalta;
        int contaRegCorpoLido = 0;
        int qtdRegCorpoGravado;

        List<Aluno> listaLida = new ArrayList<>();

        //try-cath para abrir o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo " + erro);
        }

        //try-cath para ler e fechar o arquivo
        try {
            // leitura do primeiro registro do arquivo
            registro = entrada.readLine();

            while (registro != null) { // enquanto não chegou ao final do arquivo
                //obtem os dois primeiros caracteres do registro
                //01234567
                //00NOTA20221
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("É um registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 6));
                    System.out.println("Ano e semestre: " + registro.substring(6, 11));
                    System.out.println("Data e hora da gravação: " + registro.substring(11, 30));
                    System.out.println("Versão do documento: " + registro.substring(30, 32));
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("É um resgitro de trailer");
                    qtdRegCorpoGravado = Integer.parseInt(registro.substring(2, 12));
                    if (contaRegCorpoLido == qtdRegCorpoGravado) {
                        System.out.println("Quantidade de registros lidos não é compativel com quantidade de registros "
                                + "gravados");
                    } else {
                        System.out.println("Quantidade de registros lidos é compativel com quantidade de registros " +
                                "gravados");
                    }
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("É um resgitro de corpo");
                    curso = registro.substring(2, 7).trim();
                    ra = registro.substring(7, 15).trim();
                    nome = registro.substring(15, 65).trim();
                    disciplina = registro.substring(65, 105).trim();
                    media = Double.valueOf(registro.substring(105, 110).replace(',', '.'));
                    qtdFalta = Integer.valueOf(registro.substring(110, 113));
                    contaRegCorpoLido++;

                    Aluno a = new Aluno(ra, nome, curso, disciplina, media, qtdFalta);
                    // no projeto de pi poderia fazer:
                    // repository.save(a);

                    // no nosso caso, vamos adcionar o objeto listaLida
                    listaLida.add(a);

                } else {
                    System.out.println("Tipo de registro invalido!");
                }

                // le o proximo registro
                registro = entrada.readLine();
            }
        } catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo " + erro);
        }
        // no projeto de pi pode fazer:
        // repository.saveAll(listlID);

        // vamos exibir a listaLida
        System.out.println("\nConteudo da lista lida: ");
        for (Aluno a : listaLida) {
            System.out.println(a);
        }
    }

    // Executavel
    public static void main(String[] args) {

        // Criando a lista
        List<Aluno> lista = new ArrayList();

        // Adcionando á lista
        lista.add(new Aluno("01211124", "Victoria", "ADS", "Estrutura e Armazenamento de Dados",
                6.0, 12));
        lista.add(new Aluno("01211134", "Fulano", "ADS", "Prog. Web", 8.0, 6));
        lista.add(new Aluno("01211120", "Julia", "ADS", "Eng", 10.0, 0));
        lista.add(new Aluno("02211020", "Célia", "CCO", "Calculo Computacional", 7.0,
                12));
        lista.add(new Aluno("03221000", "Ana ", "SIS", "Banco de Dados", 8.5, 8));
        lista.add(new Aluno("04221030", "Yosh", "REDES", "Segurança", 6.0, 20));

        // Exibindo a lista
        for (Aluno a : lista) {
            System.out.println(a);
        }

        // Gravar a lista
        gravaArquivoTXT(lista, "aluno.txt");
        // ^ está comentdo para não gravar mais

        //le a lista
        leArquivoTXT("aluno.txt");
    }
}

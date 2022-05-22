import java.util.Scanner;

public class TestaCarrinho {
    public static void main(String[] args) {
        //variaveis
        Integer opcao;
        opcao = 0;
        String nome, autor, isbn, gravadora, descricao;
        Integer codigo, qtdHoras;
        Double valorHora, precoCusto;

        //criação de leitor
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNL = new Scanner(System.in);

        //varialvel booleana false
        Boolean fim;
        fim = false;

        // criar objeto classe carrinho
        Carrinho c1 = new Carrinho();

        do {
            System.out.println("1- Adicionar livro");
            System.out.println("2- Adicionar DVD");
            System.out.println("3- Adicionar Serviço");
            System.out.println("4- Exibir itens do carrinho");
            System.out.println("5- Exibir total de venda");
            System.out.println("6- Fim");
            opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("\nInsira o código do livro:");
                    codigo = leitor.nextInt();
                    System.out.println("\nInsira o preço de custo:");
                    precoCusto = leitor.nextDouble();
                    System.out.println("\nInsira o nome do livro:");
                    nome = leitorNL.nextLine();
                    System.out.println("\nInsira o nome do autor:");
                    autor = leitorNL.nextLine();
                    System.out.println("\nInsira o ISBN:");
                    isbn = leitorNL.nextLine();

                    Livro l1 = new Livro(codigo, precoCusto, nome, autor, isbn);
                    c1.adcionaVendavel(l1);
                    break;
                case 2:
                    System.out.println("\nInsira o código do dvd:");
                    codigo = leitor.nextInt();
                    System.out.println("\nInsira o preço de custo:");
                    precoCusto = leitor.nextDouble();
                    System.out.println("\nInsira o nome do dvd:");
                    nome = leitorNL.nextLine();
                    System.out.println("\nInsira o nome da gravadora:");
                    gravadora = leitorNL.nextLine();

                    DVD d1 = new DVD(codigo, precoCusto, nome, gravadora);
                    c1.adcionaVendavel(d1);
                    break;
                case 3:
                    System.out.println("\nInsira a descrição:");
                    descricao = leitorNL.nextLine();
                    System.out.println("\nInsira o código:");
                    codigo = leitor.nextInt();
                    System.out.println("\nInsira a quantidade de horas:");
                    qtdHoras = leitor.nextInt();
                    System.out.println("\nInsira o valor hora:");
                    valorHora = leitor.nextDouble();

                    Servico s1 = new Servico(descricao, codigo, qtdHoras, valorHora);
                    c1.adcionaVendavel(s1);
                    break;
                case 4:
                    c1.exibeItensCarrinho();
                    break;
                case 5:
                    System.out.printf("Total de venda: R$ %.2f", c1.calculaTotalVenda());
                    break;
                case 6:
                    System.out.println("Até a proxima!");
                    break;
                default:
                    break;
            }
        } while (opcao < 6 && opcao > 0);
    }
}

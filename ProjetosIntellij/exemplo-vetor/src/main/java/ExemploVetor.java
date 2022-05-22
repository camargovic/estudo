import java.util.Scanner;

public class ExemploVetor {

    public static void exibeVetor(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print("v[" + i + "]= " + v[i] + "\t");
        }
    }

    public static void main(String[] args) {

        // Criação de um objeto leitor
        Scanner leitor = new Scanner(System.in);

        //Criação de vetor de inteiros, de tamanho 5
        int[] vetor = new int[5];

        // Criação de um segundo vetor, já iniciado com valores
        // Nesse caso não usamos no "new"
        // vet2 já "nasce" com os valoresque estão na lista entre chaves
        int[] vet2 = {100, 200, 300, 400, 500, 600, 700};

        // Criação de um terceiro vetor, de Strings, de tamanho 4
        String[] vet3 = new String[4];


        //Preenche o vetor
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i * 10;
        }

        //Exibir o vetor
        exibeVetor(vetor);

        //Exibir o vetor vet2
        exibeVetor(vet2);

        // Solicita ao usuário digitar os valores do vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor de vetor[" + "]");
            vetor[i] = leitor.nextInt();
        }

        //Exibir o vetor
        exibeVetor(vetor);

        // Solicita ao usuário digitar os valores do vetor vet3
        for (int i = 0; i < vet3.length; i++) {
            System.out.println("Digite o valor de vet3[" + "]");
            vet3[i] = leitor.next();
        }

        // Exibe vet3
        for (String nome : vet3) {
            System.out.print(nome + "\t");
        }
        System.out.println();
    }


}

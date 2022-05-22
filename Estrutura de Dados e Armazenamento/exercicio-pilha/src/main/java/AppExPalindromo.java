/*Utilizando a classe Pilha feita em sala, implemente o método ehPalindromo, na classe onde
está o main. Esse método recebe um vetor de inteiros e retorna true se a sequência de
inteiros no vetor for palíndroma e retorna false, caso contrário.
No main, inicialize um vetor de inteiros com valores e teste se esse vetor é ou não
palíndromo.
*/
public class AppExPalindromo {

    public static boolean verificarPalindromo(Integer[] vetor) {
        PilhaObj pilha = new PilhaObj<>(vetor.length);

        for (int i = 0; i < vetor.length; i++) {
            pilha.push(vetor[i]);
        }

        for (int i = 0; i < vetor.length; i++) {
            if (pilha.pop() != vetor[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Integer[] vetor1 = {1,3,3,1};
        Integer[] vetor2 = {1,6,0,2,5};
        Integer[] vetor3 = {5,1,6,1,5};
        Integer[] vetor4 = {1,2,3,2,1};

        System.out.println(verificarPalindromo(vetor1) ? "É um palíndromo" : "Não é um palíndromo");
        System.out.println(verificarPalindromo(vetor2) ? "É um palíndromo" : "Não é um palíndromo");
        System.out.println(verificarPalindromo(vetor3) ? "É um palíndromo" : "Não é um palíndromo");
        System.out.println(verificarPalindromo(vetor4) ? "É um palíndromo" : "Não é um palíndromo");
    }

}

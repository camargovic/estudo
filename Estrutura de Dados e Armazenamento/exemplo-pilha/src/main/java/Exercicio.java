public class Exercicio {

    public static Boolean ehPalindromo(int[] vetor) {
        Pilha pilha = new Pilha(vetor.length);

        for (int i = 0; i < vetor.length; i++) {
            pilha.push(vetor[i]);
        }

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != pilha.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] vetor1 = {1, 3, 3, 1};
        int[] vetor2 = {10,20,30,40};
        int[] vetor3 = {1,2,3,2,1};

        if (ehPalindromo(vetor1)) {
            System.out.println("vetor1 é palíndromo");
        } else {
            System.out.println("vetor1 não é palindromo");
        }

        if (ehPalindromo(vetor2)) {
            System.out.println("vetor2 é palíndromo");
        } else {
            System.out.println("vetor2 não é palindromo");
        }

        if (ehPalindromo(vetor3)) {
            System.out.println("vetor3 é palíndromo");
        } else {
            System.out.println("vetor3 não é palindromo");
        }
    }
}

package exercicio5;

import exercicio1.PilhaObj;

import java.text.Normalizer;

public class App {

    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static boolean compararChars(String frase) {
        String fraseFormatada = frase.replace(" ", "");
        String fraseSemAcentos = removerAcentos(fraseFormatada);
        PilhaObj pilha = new PilhaObj<Character>(fraseSemAcentos.length());


        for (int i = 0; i < fraseSemAcentos.length(); i++) {
            pilha.push(fraseSemAcentos.charAt(i));
        }

        for (int i = 0; i < fraseSemAcentos.length(); i++) {
            if (Character.toLowerCase((char) pilha.pop()) != Character.toLowerCase(fraseSemAcentos.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String verificarPalindromo(String frase) {
        String resultado = compararChars(frase) ? "É um palíndromo\n" : "Não é um palíndromo\n";
        return resultado;
    }

    public static void main(String[] args) {

        System.out.printf(verificarPalindromo("ovo"));
        System.out.printf(verificarPalindromo("Ovo"));
        System.out.printf(verificarPalindromo("Tô com sono"));
        System.out.printf(verificarPalindromo("anotaram a data da maratona"));
        System.out.printf(verificarPalindromo("subi no ônibus"));
        System.out.printf(verificarPalindromo("ãëíéä"));
        System.out.printf(verificarPalindromo("Eu      ê"));
    }
}

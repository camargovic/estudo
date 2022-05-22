public class Teste {
    public static void main(String[] args) {
        PilhaObj<Livro> pilha = new PilhaObj<>(3);
        Livro livro1 = new Livro("O Homem de Giz", "C.J. Tudor");
        Livro livro2 = new Livro("O Príncipe", "Nicolau Maquiavel");
        Livro livro3 = new Livro("Política", "Aristóteles");

        pilha.push(livro1);
        pilha.push(livro2);
        pilha.push(livro3);

        pilha.exibe();
        
        pilha.multiPush(pilha.multiPop(2));

        System.out.println();

        pilha.exibe();
    }
}

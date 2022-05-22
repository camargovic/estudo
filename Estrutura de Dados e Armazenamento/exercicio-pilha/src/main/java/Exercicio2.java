public class Exercicio2 {

    public static double stackSize(double valor) {
        return (Math.log(valor) / Math.log(2)) + 1;
    }

    public static void decimalToBinary(int valor) {
        PilhaObj pilha = new PilhaObj<>((int) stackSize(valor));
        int divisivel = valor;

        while(divisivel > 0) {
            pilha.push(divisivel % 2);
            divisivel = divisivel/2;
        }

        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {

        decimalToBinary(64);
        decimalToBinary(128);
        decimalToBinary(37);

    }
}

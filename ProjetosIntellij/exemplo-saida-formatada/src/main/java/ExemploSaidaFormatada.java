public class ExemploSaidaFormatada {

    public static void main(String[] args) {
        int ra1 = 50000;
        int ra2 = 50001;
        String nome1 = "Maria";
        String nome2 = "João";
        Double nota1 = 8.0;
        Double nota2 = 7.5;

        System.out.printf("----------------------------------------------\n");
        System.out.printf("%-7s %-14s %7s\n","RA","NOME","NOTA");
        System.out.printf("%7d %-14s %07.2f\n",ra1, nome1, nota1);
        System.out.printf("%07d %-14s %7.2f\n",ra2, nome2, nota2);
    }
}

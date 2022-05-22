import java.util.Arrays;

public class Ordenacao {
    public static void selectionSort(int[] v) {
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < v.length-1; i++) {
            for (int j = i+1; j < v.length; j++) {
                comparacoes++;
                if (v[j] < v[i]) {
                    int aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                    trocas++;
                }
            }
        }
        System.out.printf("'Selection Sort' - Foram feitas %d comparações e %d trocas.\n",
                comparacoes, trocas);
    }

    public static void selectionSortOtimizado(int[] v) {
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < v.length-1; i++) {
            int min = i;
            for (int j = i+1; j < v.length; j++) {
                comparacoes++;
                if(v[j] < v[min]) {
                    min = j;
                }
            }
            int aux = v[i];
            v[i] = v[min];
            v[min] = aux;
            trocas++;
        }
        System.out.printf("'Selection Sort Otimizado' - Foram feitas %d comparações e %d trocas.\n",
                comparacoes, trocas);
    }

    public static void bubbleSort(int[] v) {
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < v.length-1; i++) {
            for (int j = 0; j < v.length-i-1; j++) {
                comparacoes++;
                if (v[j] > v[j+1]) {
                    int auxiliar = v[j];
                    v[j] = v[j+1];
                    v[j+1] = auxiliar;
                    trocas++;
                }
            }
        }
        System.out.printf("'Bubble Sort' - Foram feitas %d comparações e %d trocas.\n",
                comparacoes, trocas);
    }

    public static void main(String[] args) {
        int[] vetor = {4,7,5,2,8,1,6,3};
        int[] vetor2 = {4,7,5,2,8,1,6,3};
        int[] vetor3 = {4,7,5,2,8,1,6,3};

        selectionSort(vetor);
        selectionSortOtimizado(vetor2);
        bubbleSort(vetor3);

        System.out.println("vetor: " + Arrays.toString(vetor));
        System.out.println("vetor2: " + Arrays.toString(vetor2));
        System.out.println("vetor3: " + Arrays.toString(vetor3));
    }
}

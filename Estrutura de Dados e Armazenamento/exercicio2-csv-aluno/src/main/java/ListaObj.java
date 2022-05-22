public class ListaObj<T> {
    // Atributos
    private T[] vetor;
    private int nroElem;

    // Constructor
    public ListaObj(int tam) {
        vetor = (T[]) new Object[tam];
        nroElem = 0;
    }

    // Metodos
    public void adiciona(T valor) {
        try {
            vetor[nroElem] = valor;
            nroElem++;
        } catch (Exception e) {
            System.out.println("(!) Lista Cheia!\n");
        }

    }

    public void exibe() {
        if (nroElem == 0) {
            System.out.println("Lista está vazia!");
        }
        for (int i = 0; i < nroElem; i++) {
            System.out.println(vetor[i]);
        }
    }

    public int busca(T elemento) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int indice) {
        if (indice >= 0 && indice < nroElem) {
            for (int i = indice; i < nroElem - 1; i++) {
                vetor[i] = vetor[i + 1];
            }
            nroElem--;
            return true;
        }
        return false;
    }

    public boolean removeElemento(T elementoRemover) {
        return removePeloIndice(busca(elementoRemover));
    }

    public boolean substitui(int valorAntigo, T valorNovo) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals(valorAntigo)) {
                vetor[i] = valorNovo;
                return true;
            }
        }
        System.out.println("Valor não encontrado");
        return false;
    }

    public int contaOcorrencias(T valor) {
        int contador = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valor) {
                contador++;
            }
        }
        return contador;
    }

    public boolean adicionaNoInicio(T element) {
        if (nroElem < vetor.length) {
            for (int i = nroElem; i > 0; i--) {
                vetor[i] = vetor[i - 1];
            }
            vetor[0] = element;
            nroElem++;
            return true;
        }
        System.out.println("Lista cheia");
        return false;
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice > nroElem) {
            return null;
        }
        return vetor[indice];
    }

    public void limpa() {
        nroElem = 0;
    }

    public T buscarAlunoPorRa(int ra) {
        if (nroElem == 0) {
            System.out.println("Lista vazia.");
        } else {
            for (int i = 0; i < nroElem; i++) {
                if (vetor[i].equals(ra)) {
                    return vetor[i];
                }
            }
        }
        return null;
    }
}

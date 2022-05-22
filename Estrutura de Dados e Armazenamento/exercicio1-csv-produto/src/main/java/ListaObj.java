public class ListaObj<T> {

    private T[] vetor;
    private int nroElem;


    public ListaObj(int tam) {
        vetor = (T[]) new Object[tam];
        nroElem = 0;
    }


    //Adiciona um elemento na lista
    public void adiciona(T valor) {
        try {
            vetor[nroElem] = valor;
            nroElem++;
        } catch (Exception e) {
            System.out.println("(!) Lista Cheia!\n");
        }

    }


    //Exibe a lista
    public void exibe() {
        if (nroElem == 0) {
            System.out.println("Lista está vazia!");
        }
        for (int i = 0; i < nroElem; i++) {
            System.out.println(vetor[i]);
        }
    }


    //Busca o elemento
    public int busca(T elemento) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == elemento) {
                return i;
            }
        }
        return -1;
    }


    //Remove um elemento pelo indice
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


    //Remove um elemento
    public boolean removeElemento(T elementoRemover) {
        return removePeloIndice(busca(elementoRemover));
    }


    //Faz a substituição de um elemento (Atualiza ele)
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


    //??
    public int contaOcorrencias(T valor) {
        int contador = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valor) {
                contador++;
            }
        }
        return contador;
    }


    //Adiciona um elemento no inicio da lista
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


    //Mostra o tamanho da lista
    public int getTamanho() {
        return nroElem;
    }


    //Mostra a lista
    public T getElemento(int indice) {
        if (indice < 0 || indice > nroElem) {
            return null;
        }
        return vetor[indice];
    }


    //Limpa toda a lista
    public void limpa() { // Lim
        nroElem = 0;
    }


    //Faz a busca pelo Código, RA e etc.
    public T buscarPorCodigo(int codigo) {
        if (nroElem == 0) {
            System.out.println("Lista vazia.");
        } else {
            for (int i = 0; i < nroElem; i++) {
                if (vetor[i].equals(codigo)) {
                    return vetor[i];
                }
            }
        }
        return null;
    }
}

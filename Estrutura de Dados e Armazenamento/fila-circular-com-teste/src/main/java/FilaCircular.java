public class FilaCircular {

    // Atributos
    int tamanho, inicio, fim;
    String[] fila;

    // Construtor
    // Recebe a capacidade da fila (tamanho total do vetor)
    public FilaCircular(int capacidade) {
        // Cria o vetor para armazenar a fila e inicializa o tamanho
        fila = new String[capacidade];
        tamanho = 0;
    }

    // Métodos
    // Método isEmpty() - Retorna true se a fila está vazia e false caso contrário
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Método isFull() - Retorna true se a fila está cheia e false caso contrário
    public boolean isFull() {
        return tamanho == fila.length;
    }

    // Método insert - Recebe informação a ser inserida na fila
    public void insert(String info) {
        if (isFull()) {
            throw new IllegalStateException("A fila está cheia");
        } else {
            fila[fim] = info;
            fim= (fim+1) % fila.length;
            tamanho++;
        }
    }

    // Método peek() - Retorna o primeiro da fila, sem remover
    public String peek() {
        return fila[inicio];
    }

    // Método poll() - Retorna o primeiro da fila, removendo-o
    public String poll() {
        String primeiro = peek();
        if (!isEmpty()) {
            String comeco = fila[inicio];
            inicio = (inicio + 1) % fila.length;
            tamanho--;
            return comeco;
        } else {
            return null;
        }
    }

    // Método exibe() - exibe os elementos da fila
    public void exibe() {
        if (isEmpty()) {
        System.out.println("A fila es´ta vazia");
        } else {
            for (int ind=inicio, cont=0; cont<tamanho; ind(ind+1)%fila.length) {
                System.out.println();
            }
        }

        for (int cont = )
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }

    // Cria um vetor e percorre a fila adicionando os elementos no vetor (
    // Retorna o vetor criado e não a fila
    public String[] getFila() {

        return null;
    }
}

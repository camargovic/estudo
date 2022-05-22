public class ListaEstatica {

    // Atributos
    private int[] vetor;
    private int nroElem;    // Representa a quantidade de elementos realmente
                            // inserida no vetor e tambem representa o indice
                            // onde será inserido o proximo valor no vetor
    // Construtor
    // Recebe como parâmetro o tamanho máximo da lista
                            // Cria o vetor do tamanho especificado:
                            //vetor = new int[tam]
                            //Zera nroElem
    public ListaEstatica (int tam) {
        vetor = new int[tam];
        nroElem = 0;
    }

    // Métodos
    // 1) adiciona – tipo void
    //Recebe o elemento a ser inserido.
    //Se o vetor estiver “cheio”, exibe uma mensagem de “Lista cheia”
    public void adciona (){

    }

    // 2) exibe – tipo void
    //Exibe os elementos da lista
    public void exibe() {

    }

    //3) busca – tipo int
    //Recebe o elemento a ser procurado
    //Devolve o índice do vetor onde está o elemento ou -1 se não encontrou
    public int busca() {
        return 0;
    }

    //4) removePeloIndice – tipo boolean
    //Recebe o índice do elemento a ser removido
    //Devolve true se removeu ou false se índice inválido
    public Boolean removePeloIndice() {
        return true;
    }

    //5) removeElemento – tipo boolean
    //Recebe o elemento a ser removido
    //Procura o elemento a ser removido
    //Devolve true se removeu e false se não encontrou
    public Boolean removeElemento() {
        return true;
    }
}

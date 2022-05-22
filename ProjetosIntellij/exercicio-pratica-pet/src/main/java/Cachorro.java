public class Cachorro extends Pet {

    // Construtor
    public Cachorro(String nome, int idade) {
        super(nome, idade);
    }

    // Métodos
    @Override
    public void darBanho() {

    }

    // toString

    @Override
    public String toString() {
        return "\nCachorro" + super.toString();
    }
}

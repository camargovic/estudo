public class Gato extends Pet{

    // construtor

    public Gato(String nome, int idade) {
        super(nome, idade);
    }

    // Métodos
    @Override
    public void darBanho() {

    }

    // toString
    @Override
    public String toString() {
        return  "\nGato" + super.toString();
    }
}

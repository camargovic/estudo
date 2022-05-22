public class App {
    public static void main(String[] args) {

        // Criando Objetos
        FuncionarioHoraExtra fhe1 = new FuncionarioHoraExtra(123, "Julia", 2000.0, 3, 100.0);
        FuncionarioHoraExtra fhe2 = new FuncionarioHoraExtra(456, "Leonardo", 5000.0, 5, 300.0);

        FuncionarioHorista fh1 = new FuncionarioHorista(789, "Gabriel", 8, 30.0);
        FuncionarioHorista fh2 = new FuncionarioHorista(246, "Guilherme", 8, 100.0);

        Acionista ac1 = new Acionista("Victoria", 5, 2000.0);
        Acionista ac2 = new Acionista("Celia", 10, 3000.0);

        ControleBonus controleBonus = new ControleBonus();

        controleBonus.adciona(fhe1);
        controleBonus.adciona(fhe2);

        controleBonus.adciona(fh1);
        controleBonus.adciona(fh2);

        controleBonus.adciona(ac1);
        controleBonus.adciona(ac2);

        controleBonus.exibirLista();

        controleBonus.calculaTotalBonus();
    }

    /*
    ### Além das classes descritas no enunciado, pense numa possível classe adicional que também
    tenha que ser obrigada a ter esse método getValorBonus(). Escreva como comentário no main,
    que classe seria essa, aonde do diagrama ela se encaixaria e como seria o cálculo do seu
    bônus. Não precisa desenhar essa classe no diagrama, nem implementar o seu código.

        R: Eu implementaria a classe "Estagiario", ela seria herdeira de "Funcionario", já que
        ele "é um" funcionario tambem. Primeiro calcularia seu salario e depois somaria a sua
        quantidade de bonus, que seria de 5%, parecido como foi feito em "FuncionarioHoraExtra".
     */
}

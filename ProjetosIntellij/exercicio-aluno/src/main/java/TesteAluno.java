public class TesteAluno {
    public static void main(String[] args) {

        AlunoFundamental f = new AlunoFundamental(123, "Francisco", 7.0, 7.5, 8.0, 8.0);

        AlunoGraduacao g = new AlunoGraduacao(234, "Victoria", 1.0, 2.0);

        AlunoPos p = new AlunoPos(345, "Erika", 9.0, 9.5, 9.0);

        //System.out.println(f);
        //System.out.println(g);
        //System.out.println(p);

        Escola bandeirantes = new Escola("Bandeirantes");
        bandeirantes.adcionaAluno(f);
        bandeirantes.adcionaAluno(g);
        bandeirantes.adcionaAluno(p);

        //bandeirantes.buscaAluno(234);
        //bandeirantes.buscaAluno(678);

        //bandeirantes.exibeTodos();
        //bandeirantes.exibeAlunosGraduacao();
        bandeirantes.exibeAprovados();
    }
}

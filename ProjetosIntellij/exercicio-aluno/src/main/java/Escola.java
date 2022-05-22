import java.util.ArrayList;
import java.util.List;

public class Escola {

    // Atributos
    private String nome;
    private List<Aluno> alunos;

    // Construtor
    public Escola(String nome) {
        this.nome = nome;
        alunos = new ArrayList<>();
    }

    // Metodos
    public void adcionaAluno(Aluno a) {
        alunos.add(a);
    }

    public void exibeTodos() {
        System.out.println("Lista de todos os Alunos");
        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }

    public void exibeAlunosGraduacao() {
        System.out.println("Lista de Alunos De Graudação");
        for (Aluno a : alunos) {
            if (a instanceof AlunoGraduacao) {
                System.out.println(a);
            }
        }
    }

    public void exibeAprovados() {
        for (Aluno a : alunos) {
            if (a.calcMedia() > 6) {
                System.out.println("Alunos aprovados: ");
                System.out.println(a);
            }
        }
    }

    public void buscaAluno(Integer ra){
        Boolean existe = false;
        for (Aluno a : alunos) {
            if (a.getRa().equals(ra)) {
                System.out.println(a);
                existe = true;
            }
        }
        if (existe.equals(false)){
            System.out.println("Aluno não cadastrado");
        }
    }
}

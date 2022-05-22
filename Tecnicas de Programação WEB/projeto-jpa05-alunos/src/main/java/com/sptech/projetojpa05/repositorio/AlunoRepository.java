package com.sptech.projetojpa05.repositorio;

import com.sptech.projetojpa05.entidade.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    // Retornar uma lista de alunos procurando pelo id
    List<Aluno> findByTurmaId(Long id);

    // Retornar uma lista de alunos procurando pelo nome
    List<Aluno> findByTurmaNome(String id);

    // Retorna numero de quantidade de turmas procurando pelo id
    // long contByTurmaID(Long id);
}

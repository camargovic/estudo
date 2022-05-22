package com.sptech.projetojpa05.controle;

import com.sptech.projetojpa05.entidade.Aluno;
import com.sptech.projetojpa05.repositorio.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public ResponseEntity listarTodos() {
        List<Aluno> alunos = repository.findAll();

        if (alunos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity cadastrarAluno(@RequestBody Aluno aluno) {
        repository.save(aluno);
        return ResponseEntity.status(201).build();
    }

    // Filtrando por id
    @GetMapping("/{id}")
    public ResponseEntity<List<Aluno>> filtrarId(@PathVariable long id) {
        return ResponseEntity.status(200).body(repository.findByTurmaId(id));
    }

    // Filtrando por nome
    @GetMapping("/{nome}")
    public ResponseEntity<List<Aluno>> filtrarNome(@PathVariable String nome) {
        return ResponseEntity.status(200).body(repository.findByTurmaNome(nome));
    }


}

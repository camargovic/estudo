package com.sptech.projeto04.controle;

import com.sptech.projeto04.entidade.Alunos;
import com.sptech.projeto04.entidade.Linha;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    //USAR NO POSTMAN
    private List<Alunos> alunos = new ArrayList<>();

    //Mostrar a lista
    @GetMapping
    public List<Alunos> getAlunos() {
        return alunos;
    }

    //Post = Adicionar
    //Para add no PostMan é (raw) e depois escolher JASON
    @PostMapping
    public String adicionarAluno(@RequestBody Alunos novoAluno) {
        alunos.add(novoAluno);
        return "Aluno cadastrado!!!";
    }

    //Get = Pegar
    //Pegar pelo indice
    @GetMapping("/{indice}")
    public Alunos getAlunoPorIndice(@PathVariable int indice) {
        return alunos.get(indice);
    }

    //Put = Atualizar
    @PutMapping("/{indice}")
    public String atualizarAlunoPorIndice(
            @PathVariable int indice,
            @RequestBody Alunos alunoAtualizado
    ) {
        alunos.set(indice, alunoAtualizado);
        return "Aluno atualizado com sucesso";
    }

    //Delete = Deletar
    @DeleteMapping("/{indice}")
    public String removerPorIndice(@PathVariable int indice) {
        alunos.remove(indice);
        return "Aluno removido";
    }










    /*
    private List<Alunos> alunos = new ArrayList<>();

    @PostMapping
    public String postAluno(@RequestBody Alunos novoAluno) {
        alunos.add(novoAluno);
        return "Aluno cadastrado com sucesso!";
    }
*/


}

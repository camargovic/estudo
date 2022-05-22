package sptech.projetojpa01.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa01.entidade.Salgadinho;
import sptech.projetojpa01.repositorio.SalgadinhoRepository;
import sptech.projetojpa01.requisicao.SalgadinhoPrecoApimentadoRequisicao;
import sptech.projetojpa01.resposta.SalgadinhoSimplesResposta;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/salgadinhos")
public class SalgadinhoController {

    @Autowired
    private SalgadinhoRepository repository;

    @GetMapping
    public ResponseEntity getSalgadinhos() {
        List<Salgadinho> salgadinhos = repository.findAll();
        if (salgadinhos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(salgadinhos);
    }

    @GetMapping("/contagem")
    public ResponseEntity getContagem() {
// .count() faz um "select count(*)" p/ saberquantos registros tem na tabela
        long contagem = repository.count();
        return ResponseEntity.status(200).body(contagem);
    }

    @GetMapping("/simples")
    public ResponseEntity getSimples() {
        List<SalgadinhoSimplesResposta> salgadinhos =
                repository.listaSimples();
        if (salgadinhos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(salgadinhos);
    }

    /*
Necessário usar @Valid quando temos anotações de validação na classe enviada no corpo
     */
    @PostMapping
    public ResponseEntity postSalgadinho(
            @RequestBody @Valid Salgadinho novoSalgadinho) {
        repository.save(novoSalgadinho);

        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/{codigo}/preco/{novoPreco}")
    public ResponseEntity patchSalgadinho(
            @PathVariable long codigo,
            @PathVariable double novoPreco) {
        if (repository.existsById(codigo)) {
            repository.atualizarPreco(codigo, novoPreco);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping("/{codigo}/preco-apimentado")
    public ResponseEntity patchSalgadinho(
            @PathVariable long codigo,
            @RequestBody SalgadinhoPrecoApimentadoRequisicao requisicao) {
        if (repository.existsById(codigo)) {
            repository.atualizarPrecoApimentado(
                    codigo, requisicao.getNovoPreco(), requisicao.isApimentado());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/apimentados")
    public ResponseEntity<List<Salgadinho>> filtrarApimentados() {
        return ResponseEntity.status(200).body(repository.findByApimentado(true));
    }

    @GetMapping("/contagem-nao-apimentados")
    public ResponseEntity<Integer> filtrarNaoApimentados() {
        return ResponseEntity.status(200).body(repository.countByApimentado(false));
    }

    @GetMapping("/pouco-sal")
    public ResponseEntity<List<Salgadinho>> filtrarPoucoSal() {
        return ResponseEntity.status(200).body(repository.findByNivelSalLessThan(4));
    }

    @GetMapping("/caros")
    public ResponseEntity<List<Salgadinho>> filtrarCaros() {
        return ResponseEntity.status(200).body(repository.findByPrecoGreaterThanEqual(20.0));
    }

    @GetMapping("/relatorio-geral")
    public ResponseEntity relatorio() {
        List<Salgadinho> lista = repository.findAll();
        String relatorio = "";
        for (Salgadinho s : lista) {
            relatorio += "" + s.getCodigo() + "," + s.getNome() + "," + s.getNivelSal() + "," + s.getPreco() + "\r\n";
        }
        return ResponseEntity.status(200)
                .header("content-type", "text/csv")
                .header("content-disposition", "filename=salgadinhos.csv")
                .body(relatorio);
    }

}
package com.sptech.exercicioPratica.controle;

import com.sptech.exercicioPratica.entidade.Novela;
import com.sptech.exercicioPratica.entidade.Serie;
import com.sptech.exercicioPratica.repositorio.NovelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/novelas")
public class NovelaController {

    @Autowired
    private NovelaRepository repository;

    @PostMapping
    public ResponseEntity postNovela(@RequestBody @Valid Novela novaNovela) {
        repository.save(novaNovela);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Novela> getNovela(@PathVariable long codigo) {
        return ResponseEntity.of(repository.findById(codigo));
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity deleteNovela(@PathVariable long codigo) {
        repository.deleteById(codigo);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity <List<Novela>> getNovelas() {
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PatchMapping("/{codigo}/qntEpisodios/{qntEpisodiosNovo}")
    public ResponseEntity patchNovela(@PathVariable long codigo, @PathVariable int qntEpisodiosNovo) {
        if (repository.existsById(codigo)) {
            repository.atualizarEpisodios(codigo, qntEpisodiosNovo);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/contagem")
    public ResponseEntity getContagem() {
        long contagem = repository.count();
        return ResponseEntity.status(200).body(contagem);
    }

    @GetMapping("/relatorio")
    public ResponseEntity relatorio() {
        List<Novela> lista = repository.findAll();
        String conteudo = "CODIGO;NOME;QNTEPISODIOS;DATALANCAMENTO;ENCERRADA\r\n";
        for (Novela n : lista) {
            conteudo += "" + n.getCodigo() + ";" + n.getNome() + ";" + n.getQntEpisodios() + ";" + n.getDataLancamento() + ";" + n.getEncerrada() + ";" + "\r\n";
        }
        return ResponseEntity.status(200)
                .header("content-type", "text/csv")
                .header("content-disposition", "filename = download.csv")
                .body(conteudo);
    }
}

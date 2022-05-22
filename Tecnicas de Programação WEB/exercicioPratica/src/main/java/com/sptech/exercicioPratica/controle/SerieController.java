package com.sptech.exercicioPratica.controle;

import com.sptech.exercicioPratica.entidade.Serie;
import com.sptech.exercicioPratica.repositorio.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieRepository repository;

    @PostMapping
    public ResponseEntity postSerie(@RequestBody @Valid Serie novaSerie) {
        repository.save(novaSerie);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Serie> getSerie(@PathVariable long codigo) {
        return ResponseEntity.of(repository.findById(codigo));
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity deleteSerie(@PathVariable long codigo) {
        repository.deleteById(codigo);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<List<Serie>> getSerie() {
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PatchMapping("/{codigo}/qntTemporadas/{qntTemporadasNova}")
    public ResponseEntity patchSerie(@PathVariable long codigo, @PathVariable int qntTemporadasNova) {
        if (repository.existsById(codigo)) {
            repository.atualizarTemporadas(codigo, qntTemporadasNova);
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
        List<Serie> lista = repository.findAll();
        String conteudo = "CODIGO;NOME;QNTTEMPORADAS;DATALANCAMENTO;ENCERRADA\r\n";
        for (Serie s : lista) {
            conteudo += "" + s.getCodigo() + ";" + s.getNome() + ";" + s.getQntTemporadas() + ";" + s.getDataLancamento() + ";" + s.getEncerrada() + ";" + "\r\n";
        }
        return ResponseEntity.status(200)
                .header("content-type", "text/csv")
                .header("content-disposition", "filename = download.csv")
                .body(conteudo);
    }
}

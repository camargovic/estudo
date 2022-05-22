package sptech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.entidade.Filme;
import sptech.repositorio.FilmeRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @PostMapping
    public ResponseEntity <Void> postFilme(@RequestBody @Valid Filme novoFilme){
        repository.save(novoFilme);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity <Filme> getFilmePorID(@PathVariable Long codigo){
        if (repository.existsById(codigo)){
            return ResponseEntity.of(repository.findById(codigo));
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity <Void> deleteFilmePorId(@PathVariable Long codigo){
        if (repository.existsById(codigo)){
            repository.deleteById(codigo);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping
    public ResponseEntity<List<Filme>> getFilme(){
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PutMapping("/{codigo}")
    public ResponseEntity <Void> putFilme(@RequestBody @Valid Filme filmeAtualizado, @PathVariable Long codigo){
        if (repository.existsById(codigo)){
            filmeAtualizado.setCodigoFilme(codigo);
            repository.save(filmeAtualizado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/contagem")
    public ResponseEntity <Integer> getQuantidade(){
        if (repository.contagem() == 0){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(repository.contagem());
    }



    @GetMapping("/relatorio")
    public ResponseEntity getRelatorio(){
        List<Filme> lista = repository.findAll();
        String relatorio = "";
        relatorio+= "CÓDIGO;NOME;ANO;NOTA\n";

        for (Filme filme : lista){
            relatorio+= filme.getCodigoFilme()+";"+filme.getNome()+";"+filme.getAnoLancamento()+";"+filme.getNota()+"\n";
        }

        return ResponseEntity.status(200)
                .header("content-type", "text/csv")
                .header("content-disposition", "filename=\"relatorio-de-Filmes.csv\"")
                .body(relatorio);
    }

}

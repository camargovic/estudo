package sptech.projetojpa01.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa01.entidade.Anime;
import sptech.projetojpa01.repositorio.AnimeRepository;

import java.util.List;

@RestController
@RequestMapping("/animes")
public class AnimeController {

    // Esta anotação indica que o Spring vai instanciar este objeto por nós
    @Autowired
    private AnimeRepository repository;

    @PostMapping
    public ResponseEntity criarAnime(@RequestBody Anime novoAnime) {
        // o .save() faz o insert no banco
        repository.save(novoAnime);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getAnimes() {
        // o findAll() pega todos os registros da tabela
        List<Anime> animes = repository.findAll();
        if (animes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(animes);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity getUm(@PathVariable int codigo) {
        /*
O ResponseEntity.of() recebe um Optional e retorna...
- status 404 e sem corpo se não tiver valor
- status 200 e com o valor no corpo se tiver valor
         */
// O findById() tenta recuperar 1 registro do banco
        return ResponseEntity.of(repository.findById(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity deleteAnime(@PathVariable int codigo) {
// O existsById() faz um "select count" para saber se o id existe no banco
        if (repository.existsById(codigo)) {
            // deleteById() -> exclui o registro com o id indicado
            repository.deleteById(codigo);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/{codigo}")
    public ResponseEntity putAnime(@PathVariable int codigo,
                                   @RequestBody Anime anime) {
        if (repository.existsById(codigo)) {
            // indicamos o id para evitar um insert
            anime.setCodigo(codigo);
            repository.save(anime);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}

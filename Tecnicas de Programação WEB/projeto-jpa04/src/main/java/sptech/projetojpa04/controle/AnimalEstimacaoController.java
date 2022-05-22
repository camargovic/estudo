package sptech.projetojpa04.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa04.entidade.AnimalEstimacao;
import sptech.projetojpa04.repositorio.AnimalEstimacaoRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class AnimalEstimacaoController {

    @Autowired
    private AnimalEstimacaoRepository repository;

    @PostMapping
    public ResponseEntity postPet(
            @RequestBody @Valid AnimalEstimacao novoPet) {
        repository.save(novoPet);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<AnimalEstimacao>> getPets() {
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<AnimalEstimacao> getPet(@PathVariable long codigo) {
        return ResponseEntity.of(repository.findById(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity deletePet(@PathVariable long codigo) {
        repository.deleteById(codigo);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/relatorio")
    public ResponseEntity relatorio() {
        List<AnimalEstimacao> lista = repository.findAll();
        String relatorio = "";
        for (AnimalEstimacao pet : lista) {
            relatorio += "" + pet.getCodigo() + "," + pet.getNome() + "\r\n";
        }
        return ResponseEntity
                .status(200)
                .header("content-type", "text/csv")
                //.header("content-length", "95959595959595")
                .header("content-disposition", "filename=\"relatorio-de-pets.csv\"")
                .body(relatorio);
    }

    @GetMapping("/filtro/{nome}/{castrado}")
    public ResponseEntity<List<AnimalEstimacao>> filtrar(
            @PathVariable String nome, @PathVariable boolean castrado
    ) {
        return ResponseEntity.status(200)
                .body(repository.findByNomeAndCastrado(nome, castrado));
    }

    @GetMapping("/filtro/{nome}")
    public ResponseEntity<List<AnimalEstimacao>> filtrar(
            @PathVariable String nome) {
        return ResponseEntity.status(200)
                .body(repository.findByNome(nome));
    }
}

package sptech.controle;


import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.entidade.Filme;
import sptech.entidade.Musica;
import sptech.repositorio.MusicaRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaRepository repository;

    @PostMapping
    public ResponseEntity<Void> cadastroMusica(@RequestBody @Valid Musica novaMusica){
        repository.save(novaMusica);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Musica> getMusicaPorID(@Valid @PathVariable Long codigo){
        if (repository.existsById(codigo)){
            return  ResponseEntity.of(repository.findById(codigo));
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletarMusicaPeloCodigo(@PathVariable Long codigo){
        if (repository.existsById(codigo)){
            repository.deleteById(codigo);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping
    public ResponseEntity<List<Musica>> getMusica(){
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PutMapping("/{codigo}")
    public ResponseEntity <Void> putMusica(@RequestBody @Valid Musica atualizarMusica, @PathVariable Long codigo){
        if (repository.existsById(codigo)){
            atualizarMusica.setIdMusica(codigo);
            repository.save(atualizarMusica);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

//    @GetMapping("/contagem")
//    public  ResponseEntity <Integer> getContagem(){
//        if (repository.contagem() == 0){
//            return ResponseEntity.status(200).build();
//        }
//        return ResponseEntity.status(200).body(repository.contagem());
//    }

    @GetMapping("/contagemb")
    public ResponseEntity <Long> getContar(){
        if (repository.count() == 0){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(repository.count());
    }

    @GetMapping("/relatorio")
    public ResponseEntity getRelatorio(){
        List<Musica> lista = repository.findAll();
        String relatorio = "";
        relatorio+= "CÓDIGO;NOME DA MUSICA;CANTOR;DATA DO LANÇAMENTO;POSICAO TOP GLOBAL\n";

        for (Musica m : lista){
            relatorio+= m.getIdMusica()+";"+m.getNome()+";"+m.getCantor()+";"+m.getDataLancamento()+";"+m.getPosicaoTopGlobal()+"\n";
        }

        return ResponseEntity.status(200)
                .header("content-type", "text/csv")
                .header("content-disposition", "filename=\"relatorio-de-Musicas.csv\"")
                .body(relatorio);
    }


}

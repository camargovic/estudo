package com.sptech.projetojpa06.controle;


import com.sptech.projetojpa06.entidade.Modelo;
import com.sptech.projetojpa06.repositorio.ModeloRespository;
import com.sptech.projetojpa06.resposta.ModeloSimplesResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class ModeloController {

    @Autowired
    ModeloRespository repository;

    @GetMapping
    public ResponseEntity<List<Modelo>> getCarros() {
        if (repository.count() == 0) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(repository.findAll());
        }
    }

    /* GET /filtro/fabricante/{idFabricante} - retorna a lista de todos os carros conforme o código do fabricante
     informado na URI. Caso a consulta não encontre nada, retorne 204 sem corpo.
     */
    @GetMapping("/filtro/fabricante/{idFabricante}")
    public ResponseEntity<List<Modelo>> getFabricante(@PathVariable long idFabricante) {
        if (repository.count() == 0) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(repository.findByFabricanteId(idFabricante));
        }
    }

    /* GET /contagem/fabricante/{idFabricante} - retorna a contagem (somente o número) de carros conforme o código
     do fabricante informado na URI.
     */
    @GetMapping("/contagem/fabricante/{idFabricante}")
    public ResponseEntity contaFabricante(@PathVariable Long idFabricante) {
        return ResponseEntity.status(200).body(repository.countByFabricanteId(idFabricante));
    }

    /* GET /contagem/pais/{nomePais} - retorna a contagem (somente o número) de carros conforme o nome do país
     informado na URI. É possível informar apenas parte do nome do país.
     */
    @GetMapping("/contagem/pais/{nomePais}")
    public ResponseEntity contaPais(@PathVariable String nomePais) {
        return ResponseEntity.status(200).body(repository.countByFabricantePaisNomeContainsIgnoreCase(nomePais));
    }

    /* GET /simples/{modeloCarro} - retorna a lista de carros conforme o modelo informado na URI. Caso a consulta
    não encontre nada, retorne 204 sem corpo. O JSON que é retornado é como este:
    */
    @GetMapping("/simples/{modeloCarro}")
    public ResponseEntity<List<ModeloSimplesResposta>> getPorNome(@PathVariable String modeloCarro) {
        return ResponseEntity.status(200).body(repository.listaSimples("%"+modeloCarro+"%"));
    }
}

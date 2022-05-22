package sptech.projetojpa06.controle;

import feign.FeignException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa06.entidade.AnimalEstimacao;
import sptech.projetojpa06.repositorio.AnimalEstimacaoRepository;
import sptech.projetojpa06.resposta.ConsultaAnimalResposta;
import sptech.projetojpa06.rest.viacep.CepResposta;
import sptech.projetojpa06.rest.viacep.ClienteViaCep;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/pets")
public class AnimalEstimacaoController {

    @Autowired
    private AnimalEstimacaoRepository repository;

    @Autowired
    private ClienteViaCep clienteViaCep;

    @PatchMapping(value = "/foto/{codigo}", consumes = "image/jpeg")
    public ResponseEntity patchFoto(@PathVariable long codigo, @RequestBody byte[] novaFoto) {
        if (!repository.existsById(codigo)) {
            return status(404).build();
        }
        AnimalEstimacao pet = repository.findById(codigo).get();
        pet.setFoto(novaFoto);
        repository.save(pet);
        return status(200).build();
    }

    @GetMapping(value = "/foto/{codigo}", produces = "image/jpeg")
    public ResponseEntity<byte[]> getFoto(@PathVariable long codigo) {
        if (!repository.existsById(codigo)) {
            return status(404).build();
        }
        AnimalEstimacao pet = repository.findById(codigo). get();
        return status(200).body(pet.getFoto());
    }

    @PatchMapping("/endereco/{codigo}/{cep}/{complemento}")
    public ResponseEntity patchEndereco(@PathVariable long codigo, @PathVariable String cep, @PathVariable String complemento) {
        if (!repository.existsById(codigo)) {
            return status(404).build();
        }
        // para tratar possiveis erros com a outra api
        // usamos try-catch
        CepResposta cepEncontrado = null;
        try {
            cepEncontrado = clienteViaCep.getCep(cep);
        } catch (FeignException fe) {
            /*
            se cair no catch com FeingException significa que:
            - não foi possivel se comunicar com a api
            - status de erro da api (4xx ou 5xx)
            - erro na conversão do JSON (o DTO não está "igual" ao JSON)
            */
            if (fe.status() == -1) { // significa que não houve conexão
                return status(503).body("Sem comunicação com ViaCEP");
            }
            if (fe.status() >= 400 && fe.status() < 500) { // status 4xx
                return status(400).body("CEP inválido");
            }
            // se chegar aqui é erro de incompatibilidade do DTO com o JSON
            return status(500).body("Falha no processamento #chamado");
        }
        AnimalEstimacao pet = repository.findById(codigo).get();
        pet.setEndereco(cepEncontrado.getLogradouro() + " " + complemento);
        pet.setBairro(cepEncontrado.getBairro());
        pet.setMunicipio(cepEncontrado.getLocalidade());
        pet.setEstado(cepEncontrado.getUf());
        repository.save(pet);
        return status(200).build();
    }

    // Exista um novo EndPoint PATCH /pets/raca/{idPet}/{idRaca}
    @PatchMapping("/pets/raca/{idPet}/{idRaca}")
    public ResponseEntity patchRaca(@PathVariable long idPet, @PathVariable String idRaca) {

    }

    @PostMapping
    public ResponseEntity postPet(
            @RequestBody @Valid AnimalEstimacao novoPet) {
        repository.save(novoPet);
        return status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<AnimalEstimacao>> getPets() {
        return status(200).body(repository.findAll());
    }

    @ApiResponses({
        @ApiResponse(responseCode = "200",
                     content = @Content(mediaType = "text/csv"))
    })
    @GetMapping("/relatorio")
    public ResponseEntity getRelatorio() {
        List<AnimalEstimacao> lista = repository.findAll();
        String relatorio = "";
        for (AnimalEstimacao pet : lista) {
            relatorio += pet.getCodigo()+","+pet.getNome()+"\n";
        }
        return status(200)
                    .header("content-type", "text/csv")
                    .header("content-disposition", "filename=\"relatorio-de-pets.csv\"")
                    .body(relatorio);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<AnimalEstimacao> getPet(@PathVariable long codigo) {
        return of(repository.findById(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletePet(@PathVariable long codigo) {
        repository.deleteById(codigo);
        return status(200).build();
    }

    @GetMapping("/filtro/{nome}")
    public ResponseEntity<List<AnimalEstimacao>> filtro(
            @PathVariable String nome
    ) {
        return status(200).body(repository.findByNome(nome));
    }

    @GetMapping("/filtro/{nome}/{castrado}")
    public ResponseEntity<List<AnimalEstimacao>> filtro(
            @PathVariable String nome,
            @PathVariable boolean castrado
    ) {
        return status(200)
                .body(repository.findByNomeAndCastrado(nome, castrado));
    }

    /*
    GET /pets/tipo/{codigoTipo}
    Ex: /pets/tipo/1 -> traria todos os pets que são "gato"
     */
    @GetMapping("/tipo/{codigoTipo}")
    public ResponseEntity getPorTipo(@PathVariable int codigoTipo) {
        List<AnimalEstimacao> lista = repository.findByTipoCodigo(codigoTipo);
        if (lista.isEmpty()) {
            return status(204).build();
        } else {
            return status(200).body(lista);
        }
    }

    /*
    GET /pets/tipo-nome/{nomeTipo}
    Ex: /pets/tipo-nome/cho -> traria todos os pets contém "cho" na descricao do tipo
     */
    @GetMapping("/tipo-nome/{nomeTipo}")
    public ResponseEntity getPorDescricao(@PathVariable String nomeTipo) {
        List<AnimalEstimacao> lista = repository.findByTipoDescricaoContains(nomeTipo);
        if (lista.isEmpty()) {
            return status(204).build();
        } else {
            return status(200).body(lista);
        }
    }

    @GetMapping("/filtro-simples/{nome}")
    public ResponseEntity getSimplesPorNome(@PathVariable String nome) {
        List<ConsultaAnimalResposta> lista =
                repository.consultaSimplePorNome("%"+nome+"%");
        if (lista.isEmpty()) {
            return status(204).build();
        } else {
            return status(200).body(lista);
        }
    }
}

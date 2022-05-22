package sptech.projeto03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisesController {

    private List<Pais> paises = new ArrayList<>();

    // Métodos
    @GetMapping("/cadastrar/{nome}/{ouro}/{prata}/{bronze}")
    public String cadastrarPais(
        @PathVariable String nome,
        @PathVariable Integer ouro,
        @PathVariable Integer prata,
        @PathVariable Integer bronze
        ){
        paises.add(new Pais(nome, ouro, prata, bronze));
        return "Pais cadastrado com sucesso.";
    }

    @GetMapping("/listar")
    public List<Pais> listar(){
        return paises;
    }

    // /buscar/{indice}
    @GetMapping("/buscar/{indice}")
    public Pais buscarPorIndice(@PathVariable Integer indice){
        return paises.get(indice);
    }

    @GetMapping("/cadastrar/{indice}/{nome}/{ouro}/{prata}/{bronze}")
    public String atualizarPais(
            @PathVariable Integer indice,
            @PathVariable String nome,
            @PathVariable Integer ouro,
            @PathVariable Integer prata,
            @PathVariable Integer bronze
    ){
        paises.add(new Pais(nome, ouro, prata, bronze));
        return "Pais atualizado com sucesso.";
    }

    // /remover/{indide}

}

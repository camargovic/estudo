package com.sptech.projeto04.controle;

import com.sptech.projeto04.entidade.Linha;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/linhas")
public class LinhaController {

    private List<Linha> linhas = new ArrayList<>();

    @GetMapping
    public List<Linha> getLinhas() {
        return linhas;
    }

    @PostMapping
    public String postLinha(@RequestBody Linha novaLinha) {
        linhas.add(novaLinha);
        return "Linha cadastrada com sucesso!";
    }

    @GetMapping("/{indice}")
    public Linha getLinhaPorIndice(@PathVariable int indice) {
        return linhas.get(indice);
    }

    @PutMapping("/{indice}")
    public String atualizarLinhaPorIndice(@PathVariable int indice, @RequestBody Linha linhaAtualizada) {
        linhas.set(indice, linhaAtualizada);
        return "Linha atualizada com sucesso";
    }

    @DeleteMapping("/{indice}")
    public String removerPorIndice(@PathVariable int indice){
        linhas.remove(indice);
        return "Linha removida com sucesso";
    }
}


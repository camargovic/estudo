package sptech.projeto03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroisController {

    private List<Herois> herois = new ArrayList<>();

    @GetMapping("/cadastrar/{nome}/{forca}/{popularidade}/{aposentado}")
    public String cadastrarHeroi(@PathVariable String nome,
                                 @PathVariable int forca,
                                 @PathVariable double popularidade,
                                 @PathVariable Boolean aposentado){
        String classe;

        if (forca < 100) {
            classe = "C";
        } else if (forca <= 500){
            classe = "B";
        } else if (forca > 500 && popularidade > 70){
            classe = "S";
        } else {
            classe = "A";
        }

        herois.add(new Herois(nome, forca, popularidade, classe, aposentado));
        return "Heroi cadastrado com sucesso.";
    }

    @GetMapping("/descrever")
    public List<Herois> descreverHeroi(){
       return herois;
    }
}

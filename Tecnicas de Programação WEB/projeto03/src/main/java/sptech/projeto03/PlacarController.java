package sptech.projeto03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/placar")
public class PlacarController {

    private Placar placarGeral = new Placar();

    @GetMapping("/vitoria")
    public String registrarVitoria() {
        placarGeral.registrarVitoria();
        return "Registar Vitoria";
    }

    @GetMapping("/empate")
    public String registrarEmpate() {
        placarGeral.registrarEmpate();
        return "Registar Empate";
    }

    @GetMapping("/derrota")
    public String registrarDerrota() {
        placarGeral.registrarDerrota();
        return "Registar Derrota";
    }

    @GetMapping("/pontuacao")
    public Placar getPlacar() {
        return placarGeral;
    }
}

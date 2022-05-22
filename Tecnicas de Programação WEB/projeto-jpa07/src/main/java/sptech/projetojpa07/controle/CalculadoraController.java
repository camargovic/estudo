package sptech.projetojpa07.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.projetojpa07.servico.CalculosService;

@RestController
@RequestMapping("/calculos")
public class CalculadoraController {

    private CalculosService service = new CalculosService();

    @GetMapping("/clasee-social/{salario}")
    public ResponseEntity<String> getClasse(@PathVariable double salario) {
        try {
            return ResponseEntity.status(200).body(service.getClasseSocial(salario));
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(400).body(exception.getMessage());
        }
    }
}

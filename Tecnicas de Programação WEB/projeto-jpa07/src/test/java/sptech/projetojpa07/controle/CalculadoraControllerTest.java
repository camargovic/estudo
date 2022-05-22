package sptech.projetojpa07.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraControllerTest {

    CalculadoraController controller = new CalculadoraController();

    @Test
    @DisplayName("getClasse() deveria obter a classe correta")
    void getClasseCenarioValido() {
        ResponseEntity<String> resposta = controller.getClasse(300);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals("D - Muito Pobre", resposta.getBody());

        resposta = controller.getClasse(1000);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals("C - Pobre", resposta.getBody());

        resposta = controller.getClasse(1500);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals("C - Pobre", resposta.getBody());

        resposta = controller.getClasse(2500);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals("B - Classe Média", resposta.getBody());

        resposta = controller.getClasse(3000);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals("B - Classe Média", resposta.getBody());

        resposta = controller.getClasse(4500);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals("B - Classe Média", resposta.getBody());

        resposta = controller.getClasse(8000);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals("A -Rico", resposta.getBody());

        resposta = controller.getClasse(0);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals("D - Muito Pobre", resposta.getBody());
    }

    @Test
    @DisplayName("getClasse() deveria lançar Execeção")
    public void getClasseLancarErro() {
        ResponseEntity<String> resposta = controller.getClasse(-50);
        assertEquals(400, resposta.getStatusCodeValue());
        assertEquals("Salário inválido", resposta.getBody());
    }
}
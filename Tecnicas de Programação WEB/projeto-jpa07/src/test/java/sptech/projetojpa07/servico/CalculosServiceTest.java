package sptech.projetojpa07.servico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculosServiceTest {

    CalculosService service = new CalculosService();

    @Test // isso indica que é um método de teste automatizado
    @DisplayName("calcularInss() deveria calcular corretamente")
    void calcularInssCenarioValido() {
        assertEquals(50, service.calcularInss(1000.0));
        assertEquals(100, service.calcularInss(2000.0));
        assertEquals(300, service.calcularInss(3000.0));
        assertEquals(500, service.calcularInss(5000.0));
    }

    @Test
    @DisplayName("calcularInss() deveria lançar exceção p/ salario < 500")
    void calcularInssDeveLancarErro() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.calcularInss(499.99);
        });

        Exception exececao = assertThrows(IllegalArgumentException.class, () -> {
            service.calcularInss(-900.00);
        });

        assertEquals("Salário deve ser mais de 500", exececao.getMessage());
    }

    @Test
    @DisplayName("auxilioEmergencial()")
    void auxilioEmergencial() {

        assertTrue(service.receberaAuxilio(600, 0));
        assertTrue(service.receberaAuxilio(1000, 5));
        assertFalse(service.receberaAuxilio(3000, 1));
        assertTrue(service.receberaAuxilio(3000, 4));
        // pode ser assim tmb, mas não é o adequado
        assertEquals(false, service.receberaAuxilio(3500, 2));

        Exception exececao = assertThrows(IllegalArgumentException.class, () -> {
            service.receberaAuxilio(250, -1);
        });
        assertEquals("O salário deve ser a partir de 500  e os dependentes a partir de 0", exececao.getMessage());

        Exception exececaoo = assertThrows(IllegalArgumentException.class, () -> {
            service.receberaAuxilio(499.99, 1);
        });
        assertEquals("O salário deve ser a partir de 500  e os dependentes a partir de 0", exececaoo.getMessage());

        Exception exececaao = assertThrows(IllegalArgumentException.class, () -> {
            service.receberaAuxilio(800, -2);
        });
        assertEquals("O salário deve ser a partir de 500  e os dependentes a partir de 0", exececaao.getMessage());

        Exception exececaaoo = assertThrows(IllegalArgumentException.class, () -> {
            service.receberaAuxilio(499.99, -3);
        });
        assertEquals("O salário deve ser a partir de 500  e os dependentes a partir de 0", exececaaoo.getMessage());
    }
}
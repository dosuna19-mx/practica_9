package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TerricolaTest {

    @Test
    void getRepresentacion() {
        Escenario e = new Escenario("Test");
        Terricola t = new Terricola("Dan", e, new Posicion(0, 0));
        assertEquals('T', t.getRepresentacion(), "La representación de Terricola debe ser 'T'");
    }

    @Test
    void destruir() {
        Escenario e = new Escenario("Test");
        Terricola t = new Terricola("Kevin", e, new Posicion(0, 0));
        assertEquals("Terrícola destruido", t.destruir(), "El mensaje de destruir es incorrecto");
    }
}
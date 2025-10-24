package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExtraterrestreTest {

    @Test
    void getRepresentacion() {
        Escenario e = new Escenario("Test");
        Extraterrestre ex = new Extraterrestre("Depredador", e, new Posicion(0, 0));
        assertEquals('E', ex.getRepresentacion(), "La representación de Extraterrestre debe ser 'E'");
    }

    @Test
    void destruir() {
        Escenario e = new Escenario("Test");
        Extraterrestre ex = new Extraterrestre("Depredador", e, new Posicion(0, 0));
        assertEquals("Alien destruido", ex.destruir(), "El mensaje de destrucción es incorrecto");
    }
}
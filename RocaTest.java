package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RocaTest {

    @Test
    void getRepresentacion() {
        Escenario e = new Escenario("Test");
        Roca r = new Roca(e, new Posicion(0, 0));
        assertEquals('R', r.getRepresentacion(), "La representación de Roca debe ser 'R'");
    }
}
package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PosicionTest {

    @Test
    void getRenglon() {
        Posicion p = new Posicion(5, 10);
        assertEquals(5, p.getRenglon(), "El renglón debe ser 5");
    }

    @Test
    void getColumna() {
        Posicion p = new Posicion(5, 10);
        assertEquals(10, p.getColumna(), "La columna debe ser 10");
    }
}
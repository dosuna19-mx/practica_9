package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest {

    @Test
    void getNombre() {
        Escenario e = new Escenario("Test");
        Terricola t = new Terricola("Daniel Antonio", e, new Posicion(0, 0));
        assertEquals("Daniel Antonio", t.getNombre(), "El nombre del personaje debe ser 'Daniel Antonio'");
    }
}
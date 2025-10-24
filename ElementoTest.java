package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElementoTest {

    // Helper para crear una Roca, ya que Elemento es abstracto
    private Roca crearRoca(int r, int c) {
        Escenario e = new Escenario("Test");
        return new Roca(e, new Posicion(r, c));
    }

    @Test
    void getPosicion() {
        Roca r = crearRoca(3, 4);
        Posicion p = r.getPosicion();
        assertNotNull(p, "La posición no debe ser nula");
        assertEquals(3, p.getRenglon(), "Renglón inicial incorrecto");
        assertEquals(4, p.getColumna(), "Columna inicial incorrecta");
    }

    @Test
    void setPosicion() {
        Roca r = crearRoca(1, 1);
        Posicion nuevaPosicion = new Posicion(7, 8);
        r.setPosicion(nuevaPosicion);

        assertEquals(7, r.getPosicion().getRenglon(), "El renglón debe actualizarse a 7");
        assertEquals(8, r.getPosicion().getColumna(), "La columna debe actualizarse a 8");
    }

    // El método getRepresentacion es abstracto en Elemento y se prueba en sus subclases
    @Test
    void getRepresentacion() {

    }
}
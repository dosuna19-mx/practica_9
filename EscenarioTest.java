package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EscenarioTest {

    @Test
    void agregarElemento() {
        Escenario e = new Escenario("Test");
        Terricola t = new Terricola("T1", e, new Posicion(1, 1));
        e.agregarElemento(t);

        String representacion = e.toString();
        assertTrue(representacion.contains("T"), "El elemento Terricola debe aparecer en el escenario");
    }

    @Test
    void testToString() {
        Escenario e = new Escenario("Test");
        Roca r = new Roca(e, new Posicion(0, 0));
        Terricola t = new Terricola("T1", e, new Posicion(9, 9));
        e.agregarElemento(r);
        e.agregarElemento(t);

        String representacion = e.toString();
        assertNotNull(representacion, "toString no debe devolver nulo");
        int numLineBreaks = representacion.split("\n").length;
        assertEquals(10, numLineBreaks, "Deben haber 10 renglones");

        assertTrue(representacion.startsWith("R"), "Roca debe estar en (0, 0)");

        assertTrue(representacion.endsWith("T \n"), "Terricola debe estar en (9, 9) al final del string");
    }

    @Test
    void destruirElementos() {
        Escenario e = new Escenario("Test");
        Posicion centro = new Posicion(5, 5);
        int radio = 1;

        Terricola t1 = new Terricola("T1", e, new Posicion(4, 4));
        e.agregarElemento(t1);

        Roca r1 = new Roca(e, new Posicion(5, 5));
        e.agregarElemento(r1);

        e.destruirElementos(centro, radio);

        String resultado = e.toString();

        assertFalse(resultado.contains("T"), "Terrícola T1 (dentro de rango) debe ser removido");

        assertTrue(resultado.contains("R"), "Roca (no destruible) debe permanecer");

    }
}
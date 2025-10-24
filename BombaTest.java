package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BombaTest {

    @Test
    void getRepresentacion() {
        Escenario e = new Escenario("Test");
        Bomba b = new Bomba(e, new Posicion(0, 0), 1);
        assertEquals('B', b.getRepresentacion(), "La representación de Bomba debe ser 'B'");
    }

    @Test
    void destruir() {
        Escenario e = new Escenario("Test");
        Bomba b = new Bomba(e, new Posicion(0, 0), 1);
        assertEquals("Bomba destruida", b.destruir(), "El mensaje de destrucción es incorrecto");
    }

    @Test
    void explotar() {

        Escenario e = new Escenario("Test");
        Posicion centro = new Posicion(5, 5);
        Bomba b = new Bomba(e, centro, 1);
        e.agregarElemento(b);

        e.agregarElemento(new Terricola("T1", e, new Posicion(4, 5)));
        e.agregarElemento(new Extraterrestre("E1", e, new Posicion(6, 6)));

        e.agregarElemento(new Roca(e, new Posicion(0, 0))); // No destruible
        e.agregarElemento(new Terricola("T2", e, new Posicion(1, 1)));

        b.explotar();

        String resultado = e.toString();

        assertTrue(resultado.contains("R"), "Roca debe permanecer");
        assertTrue(resultado.contains("T"), "Terrícola T2 (fuera de rango) debe permanecer");
        assertFalse(resultado.contains("B"), "La bomba debe ser destruida y removida");

    }
}
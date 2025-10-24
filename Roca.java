package Test;

public class Roca extends Elemento {
    public Roca(Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
    }

    @Override
    public char getRepresentacion() {
        return 'R';
    }
}
package Test;

public class Terricola extends Personaje implements Destruible {

    public Terricola(String nombre, Escenario escenario, Posicion posicion) {
        super(nombre, escenario, posicion);
    }

    @Override
    public char getRepresentacion() {
        return 'T';
    }

    @Override
    public String destruir() {
        return "Terrícola destruido";
    }
}
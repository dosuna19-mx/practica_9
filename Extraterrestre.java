package Test;

public class Extraterrestre extends Elemento implements Destruible {
    private String nombre;

    public Extraterrestre(String nombre, Escenario escenario, Posicion posicion) {
        super(escenario, posicion);
        this.nombre = nombre;
    }

    @Override
    public char getRepresentacion() {
        return 'E';
    }

    @Override
    public String destruir() {
        return "Alien destruido";
    }
}
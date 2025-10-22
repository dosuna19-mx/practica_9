package Test;

public abstract class Elemento {
    protected Escenario escenario;
    protected Posicion posicion;

    public Elemento(Escenario escenario, Posicion posicion) {
        this.escenario = escenario;
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public abstract char getRepresentacion();

}
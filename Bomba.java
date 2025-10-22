package Test;

public class Bomba extends Elemento implements Destruible {
    private int radio;

    public Bomba(Escenario escenario, Posicion posicion, int radio) {
        super(escenario, posicion);
        this.radio = radio;
    }

    @Override
    public char getRepresentacion() {
        return 'B';
    }

    public void explotar() {
        System.out.println("Explotando bomba!!");
        escenario.destruirElementos(posicion, radio);
    }

    @Override
    public String destruir() {
        return "Bomba destruida";
    }
}
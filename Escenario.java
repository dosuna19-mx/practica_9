package Test;

import java.util.ArrayList;
import java.util.List;

public class Escenario {
    private String nombre;
    private int N = 10;
    private List<Elemento> campoDeBatalla = new ArrayList<>();

    
    public Escenario(String nombre) {
        this.nombre = nombre;
    }


    public void agregarElemento(Elemento e) {
        campoDeBatalla.add(e);
    }

    @Override
    public String toString() {
        char[][] matriz = new char[N][N];
        // Inicia la matriz con '0'
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                matriz[i][j] = '0';

        for (Elemento e : campoDeBatalla) {
            Posicion p = e.getPosicion();
            matriz[p.getRenglon()][p.getColumna()] = e.getRepresentacion();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(matriz[i][j]).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void destruirElementos(Posicion centro, int radio) {
    List<Elemento> enRango = new ArrayList<>();
    for (Elemento e : campoDeBatalla) {
        int dr = Math.abs(e.getPosicion().getRenglon() - centro.getRenglon());
        int dc = Math.abs(e.getPosicion().getColumna() - centro.getColumna());
        if (dr <= radio && dc <= radio) {
            enRango.add(e);
        }
    }
    for (Elemento e : enRango) {
        if (e instanceof Destruible) {
            System.out.println(((Destruible) e).destruir());
        }
    }
        campoDeBatalla.removeIf(e -> enRango.contains(e) && e instanceof Destruible);
    }
}
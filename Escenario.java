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

    /**
     * Genera una lista de cadenas que representan la configuración actual de los elementos.
     * El formato de cada cadena es: TipoElemento Renglon Columna [OtroParametro]
     */
    public List<String> obtenerConfiguracionActual() {
        List<String> configuracion = new ArrayList<>();

        for (Elemento e : campoDeBatalla) {
            StringBuilder sb = new StringBuilder();
            String tipo = e.getClass().getSimpleName();
            Posicion p = e.getPosicion();

            sb.append(tipo).append(" ");
            sb.append(p.getRenglon()).append(" ");
            sb.append(p.getColumna());

            // Maneja el caso especial de la Bomba para incluir su radio
            if (e instanceof Bomba) {
                sb.append(" ").append(((Bomba) e).getRadio());
            }

            // Maneja el caso especial de Extraterrestre/Terricola para incluir el nombre (opcional)
            // Por simplicidad, usamos los valores por defecto que se usaron en la lectura.

            configuracion.add(sb.toString());
        }
        return configuracion;
    }
}
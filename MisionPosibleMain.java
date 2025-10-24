package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MisionPosibleMain {

    public static void guardarConfiguracion(String nombreArchivo, List<String> configuracion) {
        java.io.PrintWriter writer = null;
        try {
            writer = new java.io.PrintWriter(nombreArchivo);
            for (String linea : configuracion) {
                writer.println(linea);
            }
            System.out.println("\nConfiguración final guardada en: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static List<String> leerConfiguracion(String nombreArchivo) {
        List<String> configuracion = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                // procesar solo espacios
                if (!linea.trim().isEmpty()) {
                    configuracion.add(linea);
                }
            }
            System.out.println("Configuración leída del archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
        return configuracion;
    }

    public static void main(String[] args) {
        Escenario e = new Escenario("Nostromo");
        // Guardar bombas
        List<Bomba> bombasDisponibles = new ArrayList<>();

        // Lectura del archivo de configuración
        List<String> elementosConfig = leerConfiguracion("C:\\Users\\TAPIAPC\\Desktop\\POO-LAB\\practica_9\\Test\\Elementos.txt");

        // Procesamiento y creación de elementos
        for (String linea : elementosConfig) {
            String[] partes = linea.trim().split(" ");
            String tipoElemento = partes[0];

            // Tipo Renglon Columna [OtroParametro]
            try {
                int renglon = Integer.parseInt(partes[1]);
                int columna = Integer.parseInt(partes[2]);
                Posicion posicion = new Posicion(renglon, columna);

                Elemento nuevoElemento = null;

                switch (tipoElemento) {
                    case "Roca":
                        nuevoElemento = new Roca(e, posicion);
                        break;
                    case "Extraterrestre":

                        nuevoElemento = new Extraterrestre("alien", e, posicion);
                        break;
                    case "Bomba":
                        // Bomba tiene un cuarto parámetro: el radio
                        if (partes.length >= 4) {
                            int radio = Integer.parseInt(partes[3]);
                            Bomba b = new Bomba(e, posicion, radio);
                            nuevoElemento = b;
                            // Se guarda CADA referencia de bomba en la lista
                            bombasDisponibles.add(b);
                        } else {
                            System.err.println("Error: La Bomba necesita el parámetro de radio. Línea ignorada: " + linea);
                        }
                        break;
                    case "Terricola":
                        // Se agrega un caso para Terricola
                        nuevoElemento = new Terricola("Ripley", e, posicion);
                        break;
                    default:
                        System.err.println("Tipo de elemento desconocido: " + tipoElemento + ". Línea ignorada.");
                        break;
                }

                if (nuevoElemento != null) {
                    e.agregarElemento(nuevoElemento);
                }

            } catch (NumberFormatException ex) {
                System.err.println("Error de formato numérico en la línea: " + linea + ". Asegúrate de que las coordenadas y el radio sean números.");
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("Error: Faltan coordenadas en la línea: " + linea + ". Línea ignorada.");
            }
        }

        // Agregar Terricola fuera del archivo
        e.agregarElemento(new Terricola("Ripley", e,new Posicion(3,2)));


        // Scanner
        Bomba bombaSeleccionada = null;

        if (!bombasDisponibles.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n--- Selección de Bomba a Explotar ---");

            // Bombas disponibles
            for (int i = 0; i < bombasDisponibles.size(); i++) {
                Bomba b = bombasDisponibles.get(i);
                Posicion p = b.getPosicion();
                System.out.println((i + 1) + ". Bomba en (" + p.getRenglon() + ", " + p.getColumna() + ") con radio " + b.getRadio());
            }

            int opcion = -1;
            while (opcion < 1 || opcion > bombasDisponibles.size()) {
                System.out.print("Selecciona una bomba disponible (1-" + bombasDisponibles.size() + "): ");
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                } else {
                    System.out.println("Entrada no válida. Por favor, ingresa un número.");
                    scanner.next();
                }
            }
            scanner.close(); // Cierra el scanner

            bombaSeleccionada = bombasDisponibles.get(opcion - 1);

            System.out.println("\n--- Ejecución de la Bomba Seleccionada ---");
            bombaSeleccionada.explotar();
            System.out.println("------------------------------------------");

        } else {
            System.out.println("No hay bombas disponibles para explotar en el escenario.");
        }


        // Imprimir el estado
        System.out.println("\n--- Estado del Escenario ---");
        System.out.println(e);

        // 5. Guardar la nueva configuración
        List<String> configuracionFinal = e.obtenerConfiguracionActual();
        guardarConfiguracion("Elementos_Final.txt", configuracionFinal);
    }
}
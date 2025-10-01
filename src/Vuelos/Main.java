package Vuelos;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        GrafoVuelos grafo = new GrafoVuelos();

        // Base de datos ficticia
        grafo.agregarVuelo("Nueva York", "Chicago", 200);
        grafo.agregarVuelo("Nueva York", "Miami", 300);
        grafo.agregarVuelo("Chicago", "Los Ángeles", 400);
        grafo.agregarVuelo("Chicago", "Miami", 250);
        grafo.agregarVuelo("Miami", "Los Ángeles", 500);
        grafo.agregarVuelo("Los Ángeles", "Nueva York", 600);

        String origen = "Nueva York";
        String destino = "Los Ángeles";

        long inicio = System.nanoTime();
        Map<String, Integer> costos = grafo.buscarCostosMinimos(origen);
        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1_000_000.0; // Convertir a milisegundos

        if (costos.containsKey(destino)) {
            System.out.println("El vuelo más barato de " + origen + " a " + destino + " cuesta: $" + costos.get(destino));
        } else {
            System.out.println("No hay vuelo de " + origen + " a " + destino);
        }
        System.out.printf("Tiempo de ejecución: %.3f ms%n", tiempoMs);
    }
}
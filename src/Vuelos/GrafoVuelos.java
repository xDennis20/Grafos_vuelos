package Vuelos;
import java.util.*;

public class GrafoVuelos {
    private Map<String, List<Nodo>> grafo = new HashMap<>();

    /** Agrega un vuelo al grafo. */
    void agregarVuelo(String origen, String destino, int costo) {
        if (!grafo.containsKey(origen)) {
            grafo.put(origen, new ArrayList<>());
        }
        grafo.get(origen).add(new Nodo(destino, costo));
    }
    /** Encuentra costos mínimos desde una ciudad origen. */
    Map<String, Integer> buscarCostosMinimos(String origen) {
        Map<String, Integer> costos = new HashMap<>();
        Set<String> visitados = new HashSet<>();
        PriorityQueue<Nodo> cola = new PriorityQueue<>((a, b) -> a.costo - b.costo);

        for (String ciudad : grafo.keySet()) {
            costos.put(ciudad, Integer.MAX_VALUE);
        }
        costos.put(origen, 0);
        cola.add(new Nodo(origen, 0));
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            String ciudad = actual.ciudad;

            if (visitados.contains(ciudad)) continue;
            visitados.add(ciudad);

            List<Nodo> destinos = grafo.getOrDefault(ciudad, new ArrayList<>());
            for (Nodo destino : destinos) {
                int nuevoCosto = costos.get(ciudad) + destino.costo;
                if (nuevoCosto < costos.getOrDefault(destino.ciudad, Integer.MAX_VALUE)) {
                    costos.put(destino.ciudad, nuevoCosto);
                    cola.add(new Nodo(destino.ciudad, nuevoCosto));
                }
            }
        }
        return costos;
    }

}

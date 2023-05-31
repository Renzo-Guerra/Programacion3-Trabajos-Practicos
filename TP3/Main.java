package TP3;

import TP3.grafo.GrafoDirigido;

public class Main {
  public static void main(String[] args) {
    GrafoDirigido<Integer> grafo = new GrafoDirigido<>();
    grafo.agregarVertice(1);
    grafo.agregarVertice(2);
    grafo.agregarVertice(3);

    grafo.agregarArco(1, 2, 10);
    grafo.agregarArco(2, 3, 20);
    // Comentar y descomentar la siguiente linea para cambiar los resultados de la consola.
    grafo.agregarArco(3, 1, 30);  

    System.out.println("Es ciclico: " + grafo.esCiclico());
  }
}

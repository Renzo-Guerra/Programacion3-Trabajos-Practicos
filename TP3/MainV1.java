package TP3;

import java.util.Iterator;

public class MainV1 {
  public static void main(String[] args) {
    GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

    grafo.agregarVertice(14);
    grafo.agregarVertice(11);
    grafo.agregarVertice(22);
    grafo.agregarVertice(25);

    System.out.println("Cantidad total de vertices: " + grafo.cantidadVertices());
    
    grafo.agregarArco(14, 11, 10);
    grafo.agregarArco(14, 22, 20);
    grafo.agregarArco(14, 25, 30);
    grafo.agregarArco(11, 22, 55);

    System.out.println("Cantidad total de arcos: " + grafo.cantidadArcos());
    System.out.println(grafo.obtenerArco(14, 22));
    
    // Imprimimos todos los vertices
    Iterator<Integer> it_v = grafo.obtenerVertices();
    System.out.println("\nVertices:");
    while(it_v.hasNext()){
      System.out.println(it_v.next());
    }

    // Imprimimos todos los arcos
    Iterator<Arco<Integer>> it_a = grafo.obtenerArcos();
    System.out.println("\nArcos:");
    while(it_a.hasNext()){
      System.out.println(it_a.next());
    }

  }
}

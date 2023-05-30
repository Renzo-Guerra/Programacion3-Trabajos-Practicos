package TP3;

import java.util.Iterator;

import TP3.grafo.GrafoDirigido;
import TP3.servicios.ServicioDFS;

public class Main {
  public static void main(String[] args) {
    GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

    grafo.agregarVertice(1);
    grafo.agregarVertice(2);
    grafo.agregarVertice(3);
    grafo.agregarVertice(4);
    grafo.agregarVertice(5);
    grafo.agregarVertice(6);
    grafo.agregarVertice(7);
    grafo.agregarVertice(8);
    grafo.agregarVertice(9);

    grafo.agregarArco(1, 2, 10);
    grafo.agregarArco(1, 5, 10);
    grafo.agregarArco(1, 4, 10);
    grafo.agregarArco(2, 5, 10);
    grafo.agregarArco(2, 9, 10);
    grafo.agregarArco(2, 6, 10);
    grafo.agregarArco(4, 8, 10);
    grafo.agregarArco(5, 7, 10);
    grafo.agregarArco(9, 3, 10);

    Iterator<Integer> it = grafo.obtenerVertices();

    System.out.println("Como los devuelve el grafo utilizando iterator:");
    System.out.print("[");
    while(it.hasNext()){
      System.out.print(it.next() + " ");
    }
    System.out.print("]\n");


    ServicioDFS sservicioDFS = new ServicioDFS(grafo);

    System.out.println("DFS: ");
    System.out.println(sservicioDFS.dfsForest());
  }
}

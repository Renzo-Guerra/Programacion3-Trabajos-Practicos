package TP3;

import java.util.Iterator;

import TP3.estructurasAuxiliares.MyQueue;
import TP3.grafo.GrafoDirigido;
import TP3.servicios.ServicioBFS;

public class Main {
  public static void main(String[] args) {
    MyQueue<Integer> cola = new MyQueue<>();
    cola.enqueue(1);
    cola.enqueue(3);
    cola.enqueue(5);
    cola.enqueue(7);
    System.out.println(cola.getValues());
    
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
    
    ServicioBFS sservicioBFS = new ServicioBFS(grafo);

    System.out.println("BFS: ");
    System.out.println(sservicioBFS.bfsForest());
  }
}

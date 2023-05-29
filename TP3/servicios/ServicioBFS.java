package TP3.servicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import TP3.estructurasAuxiliares.MyQueue;
import TP3.grafo.Grafo;

public class ServicioBFS {
  private Grafo<?> grafo;
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
  }
	
	public List<Integer> bfsForest() {
		HashSet<Integer> visitados = new HashSet<>();   // Se guardaran los vertices ya visitados
    // Se crea un arraylist donde se insertaran los vertices en el orden en el que fueron accedidos
    ArrayList<Integer> orden = new ArrayList<>(this.grafo.cantidadVertices());
    Integer verticeActual;
    Iterator<Integer> itVertices = this.grafo.obtenerVertices();
    
    while(itVertices.hasNext()){
      verticeActual = itVertices.next();
      if(!visitados.contains(verticeActual)){
        bfsForestAux(verticeActual, visitados, orden);
      }
    }
    return orden;
	}
	
  /**
   * Metodo el cual dado un vertice, verifica si tanto él, como sus adyacentes ya fueron visitados, en caso de que no, 
   * se los agrega a visitados y a su vez, se agregan a una lista en el orden en el que fueron visitados (en este metodo)
   * @param verticeActual
   * @param visitados
   * @param orden
   */
  private void bfsForestAux(Integer verticeActual, HashSet<Integer> visitados, ArrayList<Integer> orden){
    MyQueue<Integer> queue = new MyQueue<>();   // Fila donde se insertarán los no estaban visitados
    Iterator<Integer> itAdyacentes;             
    Integer adyacenteActual;

    visitados.add(verticeActual);       // Se agrega a visitados el vertice actual
    queue.enqueue(verticeActual);       // Tambien se agrega a la fila auxiliar

    // Mientras que la fila auxiliar tenga elementos
    while(!queue.isEmpty()){
      verticeActual = queue.dequeue();  // Quitamos el primer elemento de la fila auxiliar
      orden.add(verticeActual);         // Y lo agregamos a la lista orden
      itAdyacentes = this.grafo.obtenerAdyacentes(verticeActual);   // Obtenemos los adyacentes del verticeActual
      // Mientras existan adyacentes al vertice actual
      while(itAdyacentes.hasNext()){
        adyacenteActual = itAdyacentes.next();
        // Verificaremos si cada uno de los adyacentes ya fue visitado o no
        if(!visitados.contains(adyacenteActual)){
          // En caso de que no, se los agrega a visitados, y a su vez, a la fila auxiliar, 
          // cosa de mas tarde ser agregados a orden, y tambien evaluar sus adyacentes
          visitados.add(adyacenteActual);
          queue.enqueue(adyacenteActual);
        }
      }
    }
  }
}

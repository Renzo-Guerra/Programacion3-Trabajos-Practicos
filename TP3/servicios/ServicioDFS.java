package TP3.servicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import TP3.grafo.Grafo;

public class ServicioDFS {
	private Grafo<?> grafo;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public List<Integer> dfsForest() {
		Iterator<Integer> itVertices = this.grafo.obtenerVertices();
    HashSet<Integer> verticesVisitados = new HashSet<>(this.grafo.cantidadVertices());
    ArrayList<Integer> orden = new ArrayList<>(this.grafo.cantidadVertices());
    Integer verticeActual;

    while(itVertices.hasNext()){
      verticeActual = itVertices.next();
      if(!verticesVisitados.contains(verticeActual)){
        dfsForestAux(verticeActual, verticesVisitados, orden);
      }
    }

    return orden;
	}

  private void dfsForestAux(Integer verticeActual, HashSet<Integer> visitados, ArrayList<Integer> orden){
    Iterator<Integer> itAdyacentes = this.grafo.obtenerAdyacentes(verticeActual);
    Integer adyacenteActual;

    visitados.add(verticeActual);
    orden.add(verticeActual);

    while(itAdyacentes.hasNext()){
      adyacenteActual = itAdyacentes.next();
      if(!visitados.contains(adyacenteActual)){
        this.dfsForestAux(adyacenteActual, visitados, orden);
      }  
    }
  }
}
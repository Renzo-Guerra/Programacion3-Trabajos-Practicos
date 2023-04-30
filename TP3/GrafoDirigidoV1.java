package TP3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * El GrafoDirigidoV1 incorpora internamente un HashMap el cual 
 * de key tiene un vertice, y de value tiene un HashSet<Arco<T>>.
 * 
 * El problema es cuando quiero eliminar un arco, como hago?? 
 */

public class GrafoDirigidoV1<T> implements Grafo<T> {
  // En vez de integer, deveria ser T tambien...
  // Pero como la interfaz grafo en agregarVertice admite un int...
  private HashMap<Integer, HashSet<Arco<T>>> vertices;

  public GrafoDirigidoV1(){ 
    this.vertices = new HashMap<>();
  }

	@Override
	public void agregarVertice(int verticeId) {
    this.vertices.put(verticeId, new HashSet<>());
	}

	@Override
	public void borrarVertice(int verticeId) {
    this.vertices.remove(verticeId);
	}
  
  private boolean existeVertice(int verticeId){
    return this.vertices.containsKey(verticeId);
  }
  
  private boolean existenLosVertices(int verticeId1, int verticeId2){
    return (existeVertice(verticeId1) && !existeVertice(verticeId2));
  }

  @Override
  public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
    // Se verifica que existan ambos vertices
    if(existenLosVertices(verticeId1, verticeId2))  
      // Se crea un nuevo arco y se lo agrega, de manera que el vertice1 puede ir al vertice2. 
      // vertice1 --> vertice2
      this.vertices.get(verticeId1).add(new Arco<T>(verticeId1, verticeId2, etiqueta));
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
    if(existenLosVertices(verticeId1, verticeId2))
      this.vertices.get(verticeId1).remove(/* No puedo seleccionar un arco */);
	}
	
	@Override
	public boolean contieneVertice(int verticeId) {
		return this.vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.vertices.size();
	}

	@Override
	public int cantidadArcos() {
		return 0;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		return null;
	}

}

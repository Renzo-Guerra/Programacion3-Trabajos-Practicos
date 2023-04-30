package TP3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GrafoDirigidoV2<T> implements Grafo<T> {
  // En vez de integer, deveria ser T tambien...
  // Pero como la interfaz grafo en agregarVertice admite un int...
  private HashMap<Integer, HashMap<Integer, Arco<T>>> vertices;

  public GrafoDirigidoV2(){ 
    vertices = new HashMap<>();
  }

	@Override
	public void agregarVertice(int verticeId) {
    vertices.put(verticeId, new HashMap<>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		if(this.existeVertice(verticeId)){
			// Eliminamos dicho vertice
			vertices.remove(verticeId);
			
			// Eliminamos todos los arcos donde este era adyacente a otro vertice
			Iterator<Integer> it = obtenerVertices();
			while(it.hasNext()){
				// En caso de que haya una arco donde se apunte al
				// vertice eliminado, se elimina este arco
				this.vertices.get(it.next()).remove(verticeId);
				// si no existe este arco, el remove no hará nada. 
			}
		}
	}
  
  private boolean existeVertice(int verticeId){
    return vertices.containsKey(verticeId);
  }
  
  private boolean existenLosVertices(int verticeId1, int verticeId2){
    return (existeVertice(verticeId1) && existeVertice(verticeId2));
  }

  @Override
  public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
    // Se verifica que existan ambos vertices
    if(existenLosVertices(verticeId1, verticeId2))  
      // Se crea un nuevo arco y se lo agrega, de manera que el vertice1 puede ir al vertice2. 
      // vertice1 --> vertice2  
      vertices.get(verticeId1).put(verticeId2, new Arco<T>(verticeId1, verticeId2, etiqueta));
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
    // Se verifica que existan ambos vertices
		if(existenLosVertices(verticeId1, verticeId2))
      // Se elimina el arco que va desde verticeId1 a verticeId2
			vertices.get(verticeId1).remove(verticeId2);
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
						// Existen ambos vertices
		return ((existenLosVertices(verticeId1, verticeId2)) &&
						// VerticeId1 puede ir a verticeId2
						(vertices.get(verticeId1).containsKey(verticeId2)));
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(existeArco(verticeId1, verticeId2))
			return vertices.get(verticeId1).get(verticeId2);
		
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int cantidad = 0;
		// Obtenemos las keys de todos los vertices
		Set<Integer> keys = vertices.keySet();

		for(Integer key: keys)
			// Por cada key, obtenemos la cantidad de arcos que contiene
			cantidad += vertices.get(key).size();

		return cantidad;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		Set<Integer> keys = vertices.keySet();
		// Aca devuelve las keys (vertices) en forma de iterator.
		// No me sirve jaja
		return keys.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		if(existeVertice(verticeId))
			return vertices.get(verticeId).keySet().iterator();
		//?  ¿Estaría bien retornar null?
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// Obtenemos las keys (vertices)
		Set<Integer> keys = vertices.keySet();
		Set<Arco<T>> arcos = new HashSet<>();

		// Por cada vertice
		for(Integer key: keys){
			// traeme los arcos (en forma de Collection)
			// y agregalos al HasSet de arcos.
			arcos.addAll(vertices.get(key).values());
		}

		// Devolvemos un iterator de los arcos
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		if(existeVertice(verticeId)){
			return vertices.get(verticeId).values().iterator();
		}
		
		//?  ¿Estaría bien retornar null?
		return null;
	}

}

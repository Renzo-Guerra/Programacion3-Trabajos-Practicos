package TP1;

import java.util.ArrayList;
import java.util.Iterator;

public class MiListaDoble<T> implements Iterable<T>{
  private NodoDoble<T> primero;
  private int size;

  public MiListaDoble(){
    this.primero = null;
    this.size = 0;
  }

  public void insertFront(T data){
    NodoDoble<T> aux = new NodoDoble<T>(data);
    aux.setSiguiente(this.primero);
    this.primero = aux;
    this.size++;
  }

  public T extractFront(){
    T data = this.primero.getData();
    this.primero = this.primero.getSiguiente();
    this.size--;

    return data;
  }
  
  /**
	 * Dado un indice lo busca en la lista y devuelve el valor.
	 * @param index (int) del elemento a buscar.
	 * @return (T) valor del elemento de dicha posicion, en caso de insertar un indice no valido, retorna null.
	 */
  public T get(int index){
    if((index < 0) || (this.size-1) < index){return null;}

    int indexActual = 0;
    NodoDoble<T> aux = this.primero;
    
    while(indexActual < index){
      aux = aux.getSiguiente();
    }

    return aux.getData();
  }

  /**
	 * Por cada elemento de mi lista, lo agrega a una un arraylist cosa de poder implementar el metodo de toString() 
	 * que ArrayList posee, cosa de devolver una String con todos los elementos dentro de cada nodo de mi lista.
	 * @return (String) elementos dentro de mi lista.
	 */
	private String getElementos(){
		ArrayList<T> devolver = new ArrayList<T>();
		
		NodoDoble<T> aux = this.primero;

		while(aux != null){
			devolver.add(aux.getData());
			aux = aux.getSiguiente();
		}

		return devolver.toString();
	}

  public boolean isEmpty(){
    return (this.primero == null);
  }

  @Override
  public IteradorMiListaDoble<T> iterator() {
    return new IteradorMiListaDoble<T>(this.primero); 
  }

  /**
	 * Dado un elemento, devuelve la posicion de la primera ocurrencia.
	 * @param dataBuscar elemento a buscar.
	 * @return (int) pos elemento || -1.
	 */
	public int indexOf(T dataBuscar) {
		if(this.isEmpty()) {return -1;}
		
		int indexActual = 0;
		NodoDoble<T> aux = this.primero;
		
		while(aux.getData() != dataBuscar) {
			if(aux.getSiguiente() == null) {
				return -1;
			}
			
			indexActual++;
			aux = aux.getSiguiente();
		}
		
		return indexActual;
	}

  @Override
	public String toString() {
		return this.getElementos();
	}
}

package TP1;

import java.util.ArrayList;

public class MiLista<T> {
	protected Nodo<T> primero;
	protected int size;
	
	public MiLista(){
		this.primero = null;
		this.size = 0;
	}
	
	/**
	 * Agrega un dato de tipo T y lo pone en la primera posicion.
	 * @param data (T) a insertar
	 */
	public void insertFront(T data) {
		Nodo<T> temporal = new Nodo<T>(data, null);
		temporal.setSiguiente(this.primero);
		this.primero = temporal;
		this.size++;
	}
	
	/**
	 * Elimina el primer valor de la lista y lo retorna
	 * @return Primer elemento de la lista
	 */
	public T extractFront() {
		T dataDevolver = this.primero.getData();
		this.primero = this.primero.getSiguiente();
		this.size--;
		
		return dataDevolver;
	}
	
	/**
	 * Determina si la lista tiene o no elementos
	 * @return (boolean) 
	 */
	public boolean isEmpty() {
		return(this.primero == null);
	}
	
	/**
	 * Dado un indice lo busca en la lista y devuelve el valor.
	 * @param index (int) del elemento a buscar.
	 * @return (T) valor del elemento de dicha posicion, en caso de insertar un indice no valido, retorna null.
	 */
	public T get(int index) {
		if((index < 0) || ((this.size-1) < index)) {return null;}
		
		int indexActual = 0;
		Nodo<T> aux = this.primero;
		
		while(indexActual < index) {
			aux = aux.getSiguiente();
		}		
		return aux.getData();
	}
	
	/**
	 * Consulta la longitud de la lista
	 * @return (int) cantidad de elementos en la lista.
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Por cada elemento de mi lista, lo agrega a una un arraylist cosa de poder implementar el metodo de toString() 
	 * que ArrayList posee, cosa de devolver una String con todos los elementos dentro de cada nodo de mi lista.
	 * @return (String) elementos dentro de mi lista.
	 */
	private String getElementos(){
		ArrayList<T> devolver = new ArrayList<T>();
		
		Nodo<T> aux = this.primero;

		while(aux != null){
			devolver.add(aux.getData());
			aux = aux.getSiguiente();
		}

		return devolver.toString();
	}

	@Override
	public String toString() {
		return this.getElementos();
	}
}

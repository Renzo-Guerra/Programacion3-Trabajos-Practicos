package TP1.ParteDeListas;

public class Nodo<T> {
  private T data;
	private Nodo<T> siguiente;
	
	public Nodo(T data, Nodo<T> siguiente) {
		this.setData(data);
		this.setSiguiente(siguiente);
	}
	
	public Nodo<T> getSiguiente(){
		return this.siguiente;
	}
	
	public void setSiguiente(Nodo<T> nodo) {
		this.siguiente = nodo;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}
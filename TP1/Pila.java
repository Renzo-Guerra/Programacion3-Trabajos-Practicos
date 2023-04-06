package TP1;

public class Pila<T>{
	private MiLista<T> estructura;
	
	public Pila() {
		this.estructura = new MiLista<T>();
	}
	
  /**
   * Agrega un elemento al inicio de la pila
   * @param data (T) valor a ingresar
   */
	public void push(T data) {
		this.estructura.insertFront(data);
	}
	
  /**
   * Retira el elemento en el tope de la pila
   * @return (T) elemento tope
   */
	public T pop() {
		if(this.estructura.isEmpty()) {return null;}
		
		return this.estructura.extractFront();
	}
	
  /**
   * Devuelve el valor del valor tope de la lista
   * @return (T) valor del elemento tope
   */
	public T top() {
		if(this.estructura.isEmpty()) {return null;}
		
		return this.estructura.get(0);
	}
	
  /**
   * Invierte el orden de los elementos de la pila
   */
	public void reverse() {
		if(!this.estructura.isEmpty()) {			
			MiLista<T> inversa = new MiLista<T>();
			while(!this.estructura.isEmpty()) {
				inversa.insertFront(this.estructura.extractFront());
			}
		}		
	}
}

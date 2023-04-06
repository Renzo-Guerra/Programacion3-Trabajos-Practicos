package TP1;

public class NodoDoble<T> {
  private T data;
  private NodoDoble<T> siguiente;
  private NodoDoble<T> anterior;

  public NodoDoble(T data){
    setData(data);
    setSiguiente(null);
    setAnterior(null);
  }

  // Setters
  public void setData(T data) {
    this.data = data;
  }
  public void setAnterior(NodoDoble<T> anterior) {
    this.anterior = anterior;
  }
  public void setSiguiente(NodoDoble<T> siguiente) {
    this.siguiente = siguiente;
  }

  // Getters
  public T getData() {
    return data;
  }
  public NodoDoble<T> getAnterior() {
    return anterior;
  }
  public NodoDoble<T> getSiguiente() {
    return siguiente;
  }
}

package TP3.estructurasAuxiliares;

public class Nodo<T> {
  private T data;
  private Nodo<T> next;
  private Nodo<T> prev;

  public Nodo(T data){
    setData(data);
    setNext(null);
    setPrev(null);
  }

  // Setters
  public void setData(T data) {
    this.data = data;
  }
  public void setPrev(Nodo<T> prev) {
    this.prev = prev;
  }
  public void setNext(Nodo<T> next) {
    this.next = next;
  }

  // Getters
  public T getData() {
    return data;
  }
  public Nodo<T> getPrev() {
    return prev;
  }
  public Nodo<T> getNext() {
    return next;
  }

}

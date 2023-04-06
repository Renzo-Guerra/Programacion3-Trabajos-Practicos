package TP1.ParteDeListas;

import java.util.Iterator;

public class IteradorMiListaDoble<T> implements Iterator<T>{
  private NodoDoble<T> nodo;

  public IteradorMiListaDoble(NodoDoble<T> nodo){
    this.nodo = nodo;
  }

  @Override
  public boolean hasNext() {
    return (this.nodo != null);
  }

  @Override
  public T next() {
    T data = this.nodo.getData();
    this.nodo = this.nodo.getSiguiente();

    return data;
  }

  public T currentValue(){
    return this.nodo.getData();
  }
  
}

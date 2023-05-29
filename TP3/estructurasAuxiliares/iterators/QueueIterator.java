package TP3.estructurasAuxiliares.iterators;

import java.util.Iterator;

import TP3.estructurasAuxiliares.Nodo;

public class QueueIterator<T> implements Iterator<T>{
  private Nodo<T> head;

  public QueueIterator(Nodo<T> head){
    this.head = head;
  }

  @Override
  public boolean hasNext() {
    return (head != null);
  }

  @Override
  public T next() {
    T dev = this.head.getData();
    this.head = this.head.getNext();

    return dev;
  }

}

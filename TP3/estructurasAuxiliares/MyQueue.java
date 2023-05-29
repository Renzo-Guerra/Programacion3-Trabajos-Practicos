package TP3.estructurasAuxiliares;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import TP3.estructurasAuxiliares.iterators.QueueIterator;

public class MyQueue<T> implements Iterable<T>{
  private Nodo<T> head;
  private Nodo<T> tail;
  private int size;

  public MyQueue(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public boolean isEmpty(){
    return (size == 0);
  }

  public void enqueue(T newElement){
    if(newElement == null){return;}

    Nodo<T> newNode = new Nodo<>(newElement);
    if(isEmpty()){
      this.head = newNode;
      this.tail = newNode;
    }else{
      newNode.setNext(this.tail);
      this.tail.setPrev(newNode);
      this.tail = newNode;
    }
    this.size++;
  }

  public T dequeue(){
    if(isEmpty()){return null;}
    
    T value = this.head.getData();
    
    if(getSize() == 1){
      this.head = null;
      this.tail = null;
    }else{
      Nodo<T> aux = this.head.getPrev();
      aux.setNext(null);
      this.head.setPrev(null);
      this.head = aux;
    }
    this.size--;

    return value;
  }

  public int getSize(){
    return this.size;
  }

  @Override
  public Iterator<T> iterator() {
    return new QueueIterator<>(this.head);
  }

  public List<T> getValues(){
    ArrayList<T> dev = new ArrayList<>(this.size);
    Iterator<T> it = this.iterator();

    while(it.hasNext())
      dev.add(it.next());

    return dev;
  }
}

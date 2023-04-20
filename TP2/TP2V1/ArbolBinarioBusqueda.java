package TP2.TP2V1;

import java.util.ArrayList;

public class ArbolBinarioBusqueda {
  private Integer root;
  private ArbolBinarioBusqueda left;
  private ArbolBinarioBusqueda right;

  public ArbolBinarioBusqueda(int value){
    this.root = value;
    this.left = null;
    this.right = null;
  }

  /**
   * Dada la raiz del arbol, devuelve el valor de este.
   * En caso de que el arbol esté vacio, devuelve 0.
   * @return value of root
   */
  public int getRoot(){
    if(this.isEmpty()){return 0;}
    
    return this.root;
  }

  public boolean hasElem(int element){
    if(this.root == null){
      return false;
    }else{
      if(element == this.root){
        return true;
      }else{
        // En caso de que sea menor que el elemento actual
        if(element < this.root){
          // Si la izquierda esta vacia, no existe
          if(this.left == null){
            return false;
          }
          
          return this.left.hasElem(element);
        // En caso de que sea mayor que el elemento actual
        }else {
          // Si la derecha esta vacia, no existe
          if(this.right == null){
            return false;
          }
          
          return this.right.hasElem(element);
        }
      }
    }
  }

  public boolean isEmpty(){
    return (this.root == null);
  }

  public void insert(int newValue){
    if(this.root == null){
      this.root = newValue;
    }else{
      if(newValue < this.root){
        if(this.left == null){
          this.left = new ArbolBinarioBusqueda(newValue);
        }else{
          this.left.insert(newValue);
        }
      }else if(newValue > this.root){
        if(this.right == null){
          this.right = new ArbolBinarioBusqueda(newValue);
        }else{
          this.right.insert(newValue);
        }
      }
    }
  }

  public boolean delete(){
    return true;
  }

  public int getHeight(){
    if(this.root == null){
      return 0;
    }else{
      int sumaIzq = 0;
      int sumaDer = 0;
      
      if(this.left != null){
        sumaIzq = 1 + this.left.getHeight();
      }
      if(this.right != null){
        sumaDer += 1 + this.right.getHeight();
      }

      return (sumaIzq > sumaDer) ? sumaIzq : sumaDer;
    }
  }

  public void printPosOrder(){
    if(this.isEmpty()){return;}

    if(this.left != null)
      this.left.printPosOrder();
    if(this.right != null)
      this.right.printPosOrder();
    System.out.print(this.root + " | ");
  }

  public void printPreOrder(){
    if(this.isEmpty()){return;}

    System.out.print(this.root + " | ");
    if(this.left != null)
      this.left.printPreOrder();
    if(this.right != null)
      this.right.printPreOrder();
  }

  public void printInOrder(){
    if(this.isEmpty()){return;}

    if(this.left != null)
      this.left.printInOrder();
    System.out.print(this.root + " | ");
    if(this.left != null)
      this.right.printInOrder();
  }

  public ArrayList<Integer> getLongestBranch(){
    ArrayList<Integer> arr = new ArrayList<>();
    
    this.rootFromLongestPath(arr);
    return arr;
  }
  
  private void rootFromLongestPath(ArrayList<Integer> arr){
    if(!this.isEmpty()){
      arr.add(this.root);

      int leftLength = 0;
      int rightLength = 0;

      if(this.left != null)
        leftLength = this.left.getHeight();
      
      if(this.right != null)
        rightLength = this.right.getHeight();

      if(rightLength > leftLength)
        this.left.rootFromLongestPath(arr);
      else
        this.right.rootFromLongestPath(arr);
    }
  } 
}

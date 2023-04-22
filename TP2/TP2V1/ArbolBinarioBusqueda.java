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

      int leftLength = -1;
      int rightLength = -1;

      // El minimo valor que va a devolver getHeight es de 1
      if(this.left != null) // (Porq estoy previamente comprobando la nullidad)
        leftLength = this.left.getHeight();
      
      if(this.right != null) // Lo mismo aca
        rightLength = this.right.getHeight();
      if(leftLength != -1 || rightLength != -1){ 
        if(rightLength > leftLength)
          this.right.rootFromLongestPath(arr);
        else
          this.left.rootFromLongestPath(arr);
      }
    }
  } 

  /**
   * Lista con todas las hojas
   * @return
   */
  public ArrayList<Integer> getFrontera(){
    return new ArrayList<Integer>();
  }

  /**
   * Retorna el mayor elemento del arbol (El de mas a la derecha)
   * @return (Integer)
   */
  public Integer getMaxElement(){
    if(this.right == null){
      return this.root;
    }else{
      return this.right.getMaxElement();
    }
  }

  /**
   * Devuelve una lista de todos los elementos del arbol que esten en x nivel.
   * En caso de que el nivel no sea valido, se rotornará un ArrayList<Integer> vacio
   * @param level
   * @return
   */
  public ArrayList<Integer> getElemAtLevel(int level){
    ArrayList<Integer> dev = new ArrayList<Integer>();
    if(level < 0 || level > this.getHeight()){return dev;}

    return getElemAtLevel(dev, level);
  }
  
  private ArrayList<Integer> getElemAtLevel(ArrayList<Integer> arr, int currentLevel){
    if(this.root == null){
      return new ArrayList<Integer>();
    }else{
      if(currentLevel == 0){
        arr.add(this.root);
      }else{
        if(this.left != null)
          this.left.getElemAtLevel(arr, currentLevel-1);
        if(this.right != null)
          this.right.getElemAtLevel(arr, currentLevel-1);
      }
      
      return arr;
    }
  }
  
}

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

  /**
   * Inserta varios valores en el arbol (Los que no esten en el arbol)
   * @param values (int[]) numeros a ingresar
   */
  public void insert(int[] values){
    for(int i=0;i<values.length;i++){
      this.insert(values[i]);
    }
  }

  /**
   * Inserta un nuevo valor en el arbol
   * @param newValue (int) numero a insertar
   */
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

  /**
   * Asigna a "this" los valores del nodo izquierdo a "this",
   * y le asigna null al subArbol "right" de "this".
   */
  private void auxDeleteNodoConHijoIzquierdo(){
    this.root = this.left.root;
    this.right = null;
    this.left = this.left.right;
  }

  /**
   * Asigna a "this" los valores del nodo derecho a "this",
   * y le asigna null al subArbol "left" de "this".
   */
  private void auxDeleteNodoConHijoDerecho(){
    this.root = this.right.root;
    this.left = null;
    this.right = this.right.right;
  }

  /**
   * Retorna el Subarbol mas izquierdo del Arbol que invocó este metodo
   * @return (ArbolBinarioBusqueda)
   */
  private ArbolBinarioBusqueda getNodoMasIzquierdo(){
    if(this.root == null){
      return null;
    }else{
      if(this.left != null)
        this.left.getNodoMasIzquierdo();
      return this;
    }
  }

  /**
   * Verifica si el Arbol es o no solo una hoja (tiene left y right como null) 
   * @return (boolean)
   */
  private boolean esHoja(){
    return (this.left == null && this.right == null);
  }

  /**
   * Verifica si el Arbol tiene a "right" como null y a "left" con algun valor 
   * @return (boolean)
   */
  private boolean soloHijoPorIzquierda(){
    return (this.left != null && this.right == null);
  }
  
  /**
   * Verifica si el Arbol tiene a "left" como null y a "right" con algun valor 
   * @return (boolean)
   */
  private boolean soloHijoPorDerecha(){
    return (this.left == null && this.right != null);
  }

  /**
   * De ser capaz, elimina un arbol hoja
   * @return (boolean)
   */
  private boolean eliminarHoja(){
    if(this.esHoja()){
      // Caso de que sea una hoja:
      this.root = null;
      return true;
    }

    return false;
  }
  
  /**
   * De ser capaz, elimina un arbol el cual tenga un hijo x izquierda 
   * (este no debe de tener un hijo por derecha)
   * @return (boolean)
   */
  private boolean eliminarSoloHijoPorIzquierda(){
    if(this.soloHijoPorIzquierda()){
      // En caso de que tenga nomas un hijo a la izquierda
      this.auxDeleteNodoConHijoIzquierdo();
      return true;
    }

    return false;
  }
  
  /**
   * De ser capaz, elimina un arbol el cual tenga un hijo x derecha 
   * (este no debe de tener un hijo por izquierda)
   * @return (boolean)
   */
  private boolean eliminarSoloHijoPorDerecha(){
    if(this.soloHijoPorDerecha()){
      // En caso de que tenga nomas un hijo a la derecha
      this.auxDeleteNodoConHijoDerecho();
      return true;
    }

    return false;
  }

  /**
   * Dado un numero, si está en el arbol, lo elimina y retorna true. 
   * Caso contrario retorna false.
   * @param numEliminar (int) numero a eliminar
   * @return (boolean)
   */
  public boolean delete(int numEliminar){
    if(this.root == null){
      return false;
    }else{
      if(this.root == numEliminar){ 
        // Caso de que sea una hoja:
        if(this.eliminarHoja()){return true;}
        // Caso de que tenga solo un hijo x izquierda:
        if(this.eliminarSoloHijoPorIzquierda()){return true;}
        // Caso de que tenga solo un hijo x derecha:
        if(this.eliminarSoloHijoPorDerecha()){return true;}

        // En caso de que tenga tanto un hijo x izquierda como x derecha
        // Reemplazaremos el nodo con el NMI (Nodo Mas Izquierdo) del 
        // subarbol derecho.
        ArbolBinarioBusqueda nmi = this.right.getNodoMasIzquierdo();
        /*
         * Le asignamos al root mas ancestro del arbol al valor del nim derecho. 
         * 
         * NOTA: Al no usar "this", el atributo "root" es el de la primer instancia 
         * que invocó el metodo "delete".
         */ 
        root = nmi.root;
        
        // - Verificamos si nmi era hoja o no
        // - En caso de que sea hoja, se eliminara y listo.
        // - En caso de que tenga un hijo, la unica posibilidad es que sea por derecha
        //   ya que "nmi" es el "mas izquierdo".
        if(nmi.esHoja()){
          nmi.eliminarHoja();
        }else{
          nmi.eliminarSoloHijoPorDerecha();
        }

        return true;
      }else{
        // En caso de que el valor no sea igual al del eliminar, 
        // seguimos buscando recursivamente.
        if(this.root > numEliminar){
          if(this.left != null)
            return this.left.delete(numEliminar);
        }else{
          if(this.right != null)
            return this.right.delete(numEliminar);
        }
        // Si no se encuentra el valor a eliminar en el arbol, se retorna falso.
        return false;
      } 
    }
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
    if(this.right != null)
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
    ArrayList<Integer> dev = new ArrayList<Integer>();

    return getFrontera(dev);
  }

  private ArrayList<Integer> getFrontera(ArrayList<Integer> arr){
    if(this.root == null){
      return new ArrayList<Integer>();
    }else{
      if(this.left == null && this.right == null){
        arr.add(this.root);
      }else{
        if(this.left != null)
          this.left.getFrontera(arr);
        if(this.right != null)
          this.right.getFrontera(arr);
      }

      return arr;
    }
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

  /**
   * Calcula la sumatoria (la suma de todos los  elementos) del arbol.
   * @return (int) resultado de la sumatoria.
   */
  public int sumatoria(){
    if(this.root == null){
      return 0;
    }else{
      int acum = 0;
      
      if(this.left != null)
        acum += this.left.sumatoria();
      if(this.right != null)
        acum += this.root + this.right.sumatoria(); 
      
      return acum + this.root;
    }
  }

  
}

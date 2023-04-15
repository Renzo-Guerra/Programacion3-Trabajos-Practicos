package TP2.TP2V0;

public class Main {
  public static void main(String[] args) {
    //Ejercicio 1 A
    
    int[] arr = {12, 43, 2, 66, 1, 5, 46, 7};
    System.out.println(arr.length);
    System.out.println("Testing del ejercicio 1: ");
    System.out.println("Arreglo original: ");
    imprimirArreglo(arr);
    // ordSeleccion(arr);
    // ordBurbujeo(arr);
    // new MergeSort(arr);
    ordQuickSort(arr, 0, (arr.length-1));
    System.out.println("Arreglo ordenado: ");
    imprimirArreglo(arr);  
  }

  /**
   * Dado un array de integers, los ordena de lowIndex a mayor 
   * utilizando el ordenamiento por seleccion.
   * 
   * O(sumatoria(n)) donde n es la cantidad de elementos
   * @param numeros a ordenar
   */
  public static void ordSeleccion(int[] numeros){
    if(numeros.length < 2) {return;}

    for(int i = 0;i < (numeros.length-1);i++){
      int menor = i;
      int j = i+1;
      while(j < numeros.length){
        if(numeros[j] < numeros[menor]){
          menor = j;
        }
        j++;
      }
      
      /*
       * En caso de que se haya encontrado un numero 
       * menor al del indice actual, se los intercambia
       */
      if(menor > i){
        int aux = numeros[i];
        numeros[i] = numeros[menor];
        numeros[menor] = aux;
      }
      
    }
  }

  public static void imprimirArreglo(int[] arr){
    for(int i = 0;i<arr.length;i++){
      System.out.print(arr[i] + " | ");
    }
    System.out.println();
  }

  /**
   * Dado un array de integers, los ordena de menor a mayor 
   * utilizando el ordenamiento por burbujeo.
   * 
   * O(n^2) donde n es la cantidad de elementos
   * @param numeros a ordenar
   */
  public static void ordBurbujeo(int[] numeros){
    int aux;

    for(int i=0;i<numeros.length-1;i++){
      for(int j=i+1;j<numeros.length;j++){
        if(numeros[i]>numeros[j]){
          aux = numeros[i];      
          numeros[i] = numeros[j];      
          numeros[j] = aux;      
        }
      }
    }
  }

  /**
   * Complejidad O(n^2)
   * Complejidad promedio O(n.log2(n))
   * @param array
   * @param lowIndex
   * @param highIndex
   */
  public static void ordQuickSort(int[] array, int lowIndex, int highIndex){
    // En caso de que solo haya 1 elemento, ese "subarreglo" estará ordenado
    if(lowIndex >= highIndex){return;}

    int pivotValue = array[highIndex];  // Por default el pivote es el ultimo elemento del arreglo
    int pivotIndex = lowIndex;          // Por default el indice del pivote es el otro extremo (El inicio)
    
    for(int i = lowIndex;i<highIndex;i++){
      if(array[i] < pivotValue){
        swapValues(array, i, pivotIndex);
        pivotIndex++;
      }
    }
    
    // Intercambiamos la posicion del pivote 
    // NOTA: Recordar que el pivote actualmente se encuentra en "highIndex"
    swapValues(array, pivotIndex, highIndex);
    
    //* Ahora la posicion donde está el pivote es "pivotIndex"
    
    // Mandamos a hacer lo mismo con el subarray izquierdo;
    ordQuickSort(array, lowIndex, pivotIndex-1);
      
    // Mandamos a hacer lo mismo con el subarray derecho;
    ordQuickSort(array, pivotIndex+1, highIndex);
  }

  /**
   * Dado un array y dos posiciones del array, intercambia los valores de los indices
   * @param arr (int[]) referencia
   * @param posA (int)
   * @param posB (int)
   */
  public static void swapValues(int[] arr, int posA, int posB){
    int aux = arr[posA];
    arr[posA] = arr[posB];
    arr[posB] = aux;
  }

}       
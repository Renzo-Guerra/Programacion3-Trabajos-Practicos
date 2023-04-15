package TP2.TP2V0;

/**
 * Big O(n.log2 n)
 * Complejidad promedio de O(n) (Creo)
 * Recordar que este metodo, requiere de memoria adicional (para el helper)
 */
public class MergeSort {
  private int[] elements;
  private int[] helper;
  private int size;

  public MergeSort(int[] elements){
    // Se asignan los atributos de la instancia
    this.elements = elements;
    this.size = elements.length;
    this.helper = new int[this.size];
    // Se llama al metodo que divide el array
    mergeSort(0, (this.size - 1));
  }

  private void mergeSort(int low, int high){
    // Se verifica que el indice inferior sea menor que el indice superior
    if(low < high){
      // Se saca la mitad de la secuencia actual
      int middle = (low + high) / 2;

      // Se llama para ordenar la mitad izquierda de la seccion actual
      mergeSort(low, middle);
    
      // Se llama para ordenar la mitad derecha de la seccion actual
      mergeSort((middle + 1), high);

      merge(low, middle, high);      
    }
  }


  /*
   * Para entenderlo mejor, hacer de cuenta que:
   *  - De low a middle, hay un arreglo ordenado.
   *  - De middle+1 hasta high hay otro arreglo ordenado.
   * 
   *  - Pasamos ambos arreglos al arreglo helper (resultando en una copia
   *    del arreglo originial).
   * 
   *  - Ahora solo falta, recorrer ambos arreglos al mismo tiempo, 
   *    e ir insertando al arreglo original las nuevas posiciones de 
   *    los elementos, resultando en la combinacion de los 2 arreglos 
   *    ordenados, ordenados en un solo arreglo ORDENADO.
   */
  private void merge(int low, int middle, int high){
    // copiar ambas partes al array helper
    for (int i = low; i <= high; i++) {
      helper[i] = elements[i];
    }
  
    int i = low;
    int j = middle + 1;
    int k = low;
  
    // copiar de manera ordenada al array original los valores de la
    // mitad izquierda o de la derecha
    while ((i <= middle) && (j <= high)) {
      if (helper[i] <= helper[j]) {
        elements[k] = helper[i];
        i++;
      } else {
        elements[k] = helper[j];
        j++;
      }
      k++;
    }
  
    // Ahora solo falta copiar los elementos que sobraron del array original
    
    // si quedaron elementos en el lado izquierdo del array original 
    while (i <= middle) {
      elements[k] = helper[i];
      k++;
      i++;
    }

    // si quedaron elementos en el lado derecho del array original
    while (j <= high) {
      elements[k] = helper[j];
      k++;
      j++;
    }
  }
}

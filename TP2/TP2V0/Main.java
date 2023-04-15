package TP2.TP2V0;

public class Main {
  public static void main(String[] args) {
    //Ejercicio 1 A
    
    int[] arr = {12, 43, 2, 3, 1, 5, 56, 7};
    System.out.println("Testing del ejercicio 1: ");
    System.out.println("Arreglo original: ");
    imprimirArreglo(arr);
    // ordSeleccion(arr);
    // ordBurbujeo(arr);
    new MergeSort(arr);
    System.out.println("Arreglo ordenado: ");
    imprimirArreglo(arr);  
  }

  /**
   * Dado un array de integers, los ordena de menor a mayor 
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

}

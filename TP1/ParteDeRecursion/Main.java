package TP1.ParteDeRecursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    // Ejercicio 9
    String palabra1 = "neuquen";
    String palabra2 = "neuquenn";
    System.out.println("Testing del ejercicio 9: ");
    System.out.println(palabra1 + " es capicua: " + esCapicua(palabra1));
    System.out.println(palabra2 + " es capicua: " + esCapicua(palabra2) + "\n");
    

    // Ejercicio 10
    int[] arr1 = {1, 2, 3, 4, 8};
    System.out.println("Testing del ejercicio 10: ");
    System.out.println("El arreglo está ordenado: " + arregloOrdenadoAsc(arr1));
  }

  /**
   * Dada una cadena de texto (String) determina si la palabra es palindroma/capicua.
   * @param palabra a verificar.
   * @return (boolean)
   */
  public static boolean esCapicua(String palabra){
    if(palabra.length() <= 1){
      return true;
    }else{
      if(palabra.charAt(0) == palabra.charAt(palabra.length()-1)){
        return esCapicua(palabra.substring(1, palabra.length()-1));
      }else{
        return false;
      }
    }
  }
  
  public static boolean arregloOrdenadoAsc(int[] arr){
    if(arr.length <= 1){
      return true;
    }else{
      // Se compara la posicion 0 con la posicion 1;
      if((arr[arr.length - arr.length]) < (arr[arr.length - arr.length + 1])){
        // Se crea una copia del arreglo, solo que No se incluye el de la posicion 0.
        int[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
        
        return (true == arregloOrdenadoAsc(newArr));
      }else{
        return false;
      }
    }
  }

}

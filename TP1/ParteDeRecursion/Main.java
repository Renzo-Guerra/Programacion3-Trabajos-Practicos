package TP1.ParteDeRecursion;

public class Main {
  public static void main(String[] args) {
    // Ejercicio 9
    String palabra1 = "neuquen";
    String palabra2 = "neuquenn";
    System.out.println("Testing del ejercicio 9: ");
    System.out.println(palabra1 + " es capicua: " + esCapicua(palabra1));
    System.out.println(palabra2 + " es capicua: " + esCapicua(palabra2) + "\n");
    

    // Ejercicio 10
    int[] arr1 = {3, 2, 2, 4, 8};
    System.out.println("Testing del ejercicio 10: ");
    System.out.println("El arreglo está ordenado: " + arregloOrdenadoAsc(arr1, arr1.length));
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
  
  /*
   * A- La complejidad es de O(n) donde n es la cantidad de elementos en el array
   * B- Se debe pasar la longitud del arreglo como otro parametro, cosa de almacenar auxiliarmente el valor actual
   * C- Se podria consultar el valor del nodo anterior o siguiente sin necesidad de llevar un auxiliar
   */
  public static boolean arregloOrdenadoAsc(int[] arr, int longitudActual){
    if(longitudActual == 1 || longitudActual == 0){
      return true;
    }else{
      if((arr[longitudActual - 2]) > (arr[longitudActual - 1])){
        return false;
      }

      return arregloOrdenadoAsc(arr, --longitudActual);
    }
  }

}

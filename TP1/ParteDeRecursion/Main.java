package TP1.ParteDeRecursion;

public class Main {
  public static void main(String[] args) {
    // Ejercicio 9
    String palabra1 = "neuquen";
    String palabra2 = "neuquenn";
    System.out.println("Testing del ejercicio 9: ");
    System.out.println(palabra1 + " es capicua: " + esCapicua(palabra1));
    System.out.println(palabra2 + " es capicua: " + esCapicua(palabra2) + "\n");
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
}

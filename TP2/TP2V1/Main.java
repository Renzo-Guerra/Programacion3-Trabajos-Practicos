package TP2.TP2V1;

public class Main {
  public static void main(String[] args) {
    ArbolBinarioBusqueda arbol1 = new ArbolBinarioBusqueda(13);
    int[] numeros = {4, 2, 7, 16, 50, 9};
    arbol1.insert(numeros);

    System.out.println("InOrder: ");
    arbol1.printInOrder();
    System.out.println();
    System.out.println("PreOrder: ");
    arbol1.printPreOrder();
    System.out.println();
    System.out.println("PosOrder: ");
    arbol1.printPosOrder();
    System.out.println();
    
    System.out.println("Longest branch: ");
    System.out.println(arbol1.getLongestBranch());    
    
    System.out.println("get frontera: ");
    System.out.println(arbol1.getFrontera());    
    
    System.out.println("Max element: ");
    System.out.println(arbol1.getMaxElement()); 
    
    System.out.print("Elements al level: ");
    System.out.println(arbol1.getElemAtLevel(2));
  }
}

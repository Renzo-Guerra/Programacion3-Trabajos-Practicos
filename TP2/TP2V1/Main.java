package TP2.TP2V1;

public class Main {
  public static void main(String[] args) {
    ArbolBinarioBusqueda arbol1 = new ArbolBinarioBusqueda(13);
    arbol1.insert(4);
    arbol1.insert(2);
    arbol1.insert(7);
    arbol1.insert(16);
    arbol1.insert(50);
    arbol1.insert(9);

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
    
    System.out.println("Max element: ");
    System.out.println(arbol1.getMaxElement()); 
    
    System.out.print("Elements al level: ");
    System.out.println(arbol1.getElemAtLevel(2));
  }
}

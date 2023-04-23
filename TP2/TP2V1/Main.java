package TP2.TP2V1;

public class Main {
  public static void main(String[] args) {
    ArbolBinarioBusqueda arbol1 = new ArbolBinarioBusqueda(13);
    int[] numeros = {4, 2, 7, 16, 50, 9, 1};
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
    System.out.println(arbol1.getLongestBranch() + "\n");    
    
    System.out.println("get frontera: ");
    System.out.println(arbol1.getFrontera() + "\n");    
    
    System.out.println("Max element: ");
    System.out.println(arbol1.getMaxElement() + "\n"); 
    
    int lvl = 2;
    System.out.print("Elements al level " + lvl + ": ");
    System.out.println(arbol1.getElemAtLevel(lvl) + "\n");
  
    System.out.println("InOrder: ");
    arbol1.printInOrder();
    System.out.println("\n");
    int nroEliminar = 13;
    System.out.println("numero " + nroEliminar + " eliminado: " + arbol1.delete(nroEliminar) + "\n");
    System.out.println("preOrder: ");
    arbol1.printPreOrder();
    System.out.println();
    System.out.println("sumatoria: " + arbol1.sumatoria() + "\n");
  }
}

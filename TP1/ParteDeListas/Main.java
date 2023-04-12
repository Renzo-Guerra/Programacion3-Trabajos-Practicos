package TP1.ParteDeListas;

public class Main {
  public static void main(String[] args) {
    MiLista<Integer> lista1 = new MiLista<Integer>(new ComparadorInteger<>());
		MiLista<Integer> lista2 = new MiLista<Integer>(new ComparadorInteger<>());
		
		lista1.insertFront(2);
		lista1.insertFront(23);
		lista1.insertFront(32);
		lista1.insertFront(45);
		lista1.insertFront(87);
		lista1.insertFront(23);
		
		lista2.insertFront(45);
		lista2.insertFront(4);
		lista2.insertFront(65); 
		lista2.insertFront(16);
		lista2.insertFront(23);
		lista2.insertFront(33);
    
    System.out.println("Lista 1:");
    // NOTA: El '\n' agrega un salto de linea (un enter al escribir)
    // Es lo mismo que hacer System.out.println("");
    System.out.println(lista1 + "\n");
    System.out.println("Lista 2:");
    System.out.println(lista2 + "\n");
    System.out.println("Lista resultante del ejercicio 6 A:");
    System.out.println(combinarListas(lista1, lista2) + "\n");
    
		MiLista<Integer> lista3 = new MiLista<Integer>(new ComparadorInteger<>());
		MiLista<Integer> lista4 = new MiLista<Integer>(new ComparadorInteger<>());
		
		lista3.insertFront(11);
		lista3.insertFront(22);
		lista3.insertFront(33);
		lista3.insertFront(45);

		lista4.insertFront(1);
		lista4.insertFront(33);
		lista4.insertFront(12);
		lista4.insertFront(45);

		System.out.println("Lista resultante del ejercicio 6 B:");
    System.out.println(combinarListasOrdenadas(lista3, lista4) + "\n");   
		
		System.out.println("Lista resultante del ejercicio 7:");
    System.out.println(getElementosDiferentes(lista1, lista2) + "\n");   
		
	}

  /**
	 * Dadas 2 listas (sin importar su orden), las combina. 
	 * @param lista_A
	 * @param lista_B
	 * @return lista_C
	 */
	public static MiLista<Integer> combinarListas(MiLista<Integer> lista_A, MiLista<Integer> lista_B){
		MiLista<Integer> lista_dev = new MiLista<Integer>(new ComparadorInteger());
		
    /*
     *  El forEach seria un "Por cada elemento dentro de 'lista_A' asignale el valor 'el_A' 
     * y ejecuta lo que esta despues de "->" por cada elemento que tenga la 'lista_A'. 
    */
		lista_A.forEach(el_A -> lista_dev.insertarOrdenado(el_A));
		lista_B.forEach(el_B -> lista_dev.insertarOrdenado(el_B));
		
		return lista_dev;
	}

  public static MiLista<Integer> combinarListasOrdenadas(MiLista<Integer> lista_A, MiLista<Integer> lista_B){
		MiLista<Integer> lista_dev = new MiLista<Integer>(new ComparadorInteger());
		
		IteradorMiLista<Integer> it_A = lista_A.iterator();
		IteradorMiLista<Integer> it_B = lista_B.iterator();

		while(it_A.hasNext() && it_B.hasNext()) {
			if(it_A.currentValue() == it_B.currentValue()) {
				lista_dev.insertFront(it_A.next());
				it_B.next();
			}else if(it_A.currentValue() > it_B.currentValue()) {
				it_B.next();
			}else {
				it_A.next();
			}
		}

		return lista_dev;
	}

	/**
	 * Dadas 2 listas (MiLista) devuelve otra con los elementos que están en la lista_A pero no en lista_B.
	 * @param lista_A (MiLista) posibles numeros a devolver
	 * @param lista_B (MiLista) numeros con los que se compara
	 * @return MiLista
	 */
	public static MiLista<Integer> getElementosDiferentes(MiLista<Integer> lista_A, MiLista<Integer> lista_B){
		MiLista<Integer> lista_dev = new MiLista<Integer>(new ComparadorInteger());
		
		lista_A.forEach((el)->{
			if(lista_B.indexOf(el) == -1) {
				lista_dev.insertFront(el);
			}
		});
				
		return lista_dev;
	}

}

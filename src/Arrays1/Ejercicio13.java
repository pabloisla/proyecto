package Arrays1;

import java.util.Arrays;

public class Ejercicio13 {
	
	public static final int NUM_MAXIMO = 10;
	public static int[] pila = new int [NUM_MAXIMO];
	public static int numElementos = 0;
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 11; i++) {
			numeroApilado(i);
		}
		
		for (int j = 0; j < 11; j++) {
				numeroDesapilado();
		}
				numeroApilado(17);
	}

	
	
	private static void numeroApilado(int arrayN) {
		
		if (numElementos < NUM_MAXIMO) {
			pila[numElementos++] = arrayN;
		}else {
			System.out.println("La pila esta llena");
		}
		imprimirArray(); //hace la llamada al metodo 
	}	
	
	private static void numeroDesapilado() {
		
		if (numElementos > 0) {
			pila[--numElementos] = 0;
		}else {
			System.out.println("La pila esta vacia");
		}
		imprimirArray();
	
	}
	private static void imprimirArray() {
		System.out.println(Arrays.toString(pila));
	}
}
	
	

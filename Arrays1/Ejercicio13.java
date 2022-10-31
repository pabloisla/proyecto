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
		
	}
	
	
	private static void numeroApilado(int arrayN) {
		if (numElementos < NUM_MAXIMO) {
			pila[numElementos++] = arrayN;
			System.out.println(Arrays.toString(pila));
		}else {
			System.out.println("La pila esta llena");
		}
	}		
}
	
	

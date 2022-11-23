package Arrays1;

import java.util.Arrays;

public class Ejercicio14 {
	
	public static final int NUM_MAXIMO = 10;
	public static int[] cola = new int [NUM_MAXIMO];
	public static int numElementos = 0;
	public static int contadorP = 0;
	public static void main(String[] args) {
		
		for (int i = 0; i < 11; i++) {
			enColar(i);
		}
		
		for (int i = 0; i < 11; i++) {
			desColar();
		}
	}
	public static void enColar (int num) {
		if (numElementos < NUM_MAXIMO) {
			cola[(contadorP + numElementos++) % NUM_MAXIMO] = num;
			
		}else {
			System.out.println("La cola esta llena");
		}
		imprimirArray();
	}
	public static void desColar() {
		if (numElementos > 0) {
			contadorP = (contadorP + 1) % NUM_MAXIMO;
			numElementos--;
		}else {
			System.out.println("La cola esta vacia");
		}
			imprimirArray();
		}
	private static void imprimirArray() {
		System.out.println(Arrays.toString(cola));
	}
}
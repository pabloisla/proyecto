package Arrays1;

import java.util.Arrays;

public class Ejercicio12 {

	public static void main(String[] args) {
		int[] array = {5,3,9,7,2,1,4};
		System.out.println(Arrays.toString(arrayBurbuja(array)));
		
	}
	
	public static int[] arrayBurbuja (int[] O) {
		
		for (int i = 0; i < O.length - 1; i++) {
			for ( int j = 0; j < O.length - i - 1; j++) {
				if (O[j+1] < O[j]) {
					int ordenado = O[j + 1];
					O[j + 1] = O[j];
					O[j] = ordenado;
				}
			}
		}
		return O;
		
	}
}

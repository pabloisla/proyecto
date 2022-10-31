package Arrays1;

import java.util.Arrays;

public class Ejercicio10 {

	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5,3,1,4};
		
		System.out.println(Arrays.toString(eliminaDuplicados(array)));
		
	}
	private static int[] eliminaDuplicados(int[] numeros) {
		
		int[] nuevoArray = new int[numeros.length]; 
		int elementoArray = 0;
		
		for (int elemento: numeros) {
			
			if (!contieneElemento(nuevoArray, elemento)) {
				nuevoArray [elementoArray++] = elemento; 
			}
		}
			if(contieneElemento(numeros, 0)) {
				elementoArray++;
			}
			return recortaArray(nuevoArray,elementoArray);
	}
		private static int[] recortaArray(int[] nuevoArray, int elementoArray) {
		// TODO Auto-generated method stub
		return null;
	}
		private static boolean contieneElemento(int[] array, int elemento) {
			for (int i =  0; i < array.length; i++) {
				if (array[i] == elemento) {
					return true;
			}
		}
		return false;
	}
		private static int[] recortaArray1 (int[]array, int longitud){
			
			int[] nuevoArray = new int [longitud];
			
			for (int i = 0; i < longitud; i++) {
				nuevoArray[i] = array[i];
				
			}
			return nuevoArray;
		}
}



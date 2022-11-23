package Boletin_Matrices;

public class Ejercicio10 {
	
	public static void main(String[] args) {
		int matriz[][] = { { 14, 58, -21, 1, 100}, {14, 58, -21, 1, 100}, {1, 14, 100, -21}};
		if (compruebaSimetria(matriz)) {
			System.out.println("La matriz es simetrica");
		}else {
			System.out.println("La matriz no es simetrica");
		}
	}
	
	private static boolean compruebaSimetria(int [][] matriz1) {
		boolean iguales = true;
		for (int j = 0; j < matriz1[0].length/2 && iguales; j++) {// recorro las columnas de la matriz
			for (int i = 0; i < matriz1.length && iguales; i++) { //recorro las filas de la matriz
				if (matriz1[i][j] != matriz1[i][matriz1.length - 1 - j]) { //comparo si son diferentes, del primero
					iguales = false;
				}
			}
		}
		return iguales;
	}
}


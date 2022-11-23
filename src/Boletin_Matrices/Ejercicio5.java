package Boletin_Matrices;

public class Ejercicio5 {

	public static void main(String[] args) {
		int [][] matriz = { {1, 2, 3, 4}, {5, 6, 7, 8} };
		
		leerColumnas(matriz);
	}
	private static void leerColumnas (int[][] columnas) {
		
		for (int j = 0; j < columnas[0].length; j++) {
			for (int i = 0; i < columnas.length; i++) {
				System.out.printf("%2d", columnas[i][j]);
			}
		}
	}
}

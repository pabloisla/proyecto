package Boletin_Matrices;

public class Ejercicio16 {

	public static void main(String[] args) {
		int matriz[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 0 }, { 3, 2, 1, 4, 5 }, { 9, 5, 8, 6, 7 },
				{ 0, 9, 8, 5, 4 } };
		
		pintaMatriz(matriz);
		pintaMatriz(devuelvePosicion(matriz));
		
	}

	private static int[][] devuelvePosicion(int[][] matriz) {
		// Aqui guardara el numero de pares que tiene ese numero, para despues meterle
		// en la matriz nueva
		int numPares = 0;
		// Creo una nueva matriz de igual tamaño que la primera
		int nuevaM[][] = new int[matriz.length][matriz[0].length];
		// recorremos la fila de la matriz original
		for (int i = 0; i < matriz.length; i++) {
			// recorremos las columnas de la matriz original
			for (int j = 0; j < matriz[0].length; j++) {
				// recorre las filas, la anterior, la misma y la ultima
				// Comprobamos hasta el final de la matriz
				for (int f = i - 1; f <= i + 1 && f < matriz.length; f++) {
					// recorre las columnas, la anterior, la misma que esta y la de abajo
					// Comprobamos hasta el final de las columnas
					if (f < 0) {
						continue;
					}
					for (int c = j - 1; c <= j + 1 && c < matriz[0].length; c++) {
						// Si esta en la posicion de i me lo salto
						if (i == f && j == c) {
							continue;
						}
						// Si esta al principio de la fila o en la primera columna, no se le resta nada
						if (c < 0) {
							continue;
						}
						if (matriz[f][c] % 2 == 0) {
							numPares++;
						}
					}
				}
				nuevaM[i][j] = numPares;
				numPares = 0;
			}
		}
		return nuevaM;
	}

	private static void pintaMatriz(final int [][] matriz) {
	for (int i = 0; i < matriz.length; i++) {
		for (int j =0;j < matriz[0].length;j++) {
			System.out.printf("%4d", matriz[i][j]);
		}
		System.out.println();
		}
	}
}
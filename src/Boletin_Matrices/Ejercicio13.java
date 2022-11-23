package Boletin_Matrices;

public class Ejercicio13 {
	
	public static void main(String[] args) {
		//Declaro la matriz inicial
		int[][] matriz = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 0 }, { 3, 2, 1, 4, 5 }, { 9, 5, 8, 6, 7 },
				{ 0, 9, 8, 5, 4 } };
		// llamada al metodo
		
		int[][] nuevaMatrizImpresa = matrizCuadrada(matriz);
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(nuevaMatrizImpresa[i][j]+ " " );
			}
			System.out.println();
		}
	}
/**
 * comprueba que la matriz sea cuadrada y la refleja en diagonal.
 * @param matriz es la matriz que lo pasamos por parametros.
 * @return devuelve la matriz destino una vez que se han hecho las comprobaciones.
 */
	private static int[][] matrizCuadrada(int[][] matriz) {
		//declaro la matriz reflejada en diagonal
		int[][] diagonal = new int[matriz.length][matriz[0].length];
		if (matriz.length == matriz[0].length) {
			// los "for" recorren la matriz
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[0].length; j++) {
					//Jugamos con los indices de las matrices para ir invirtiendolas.
					diagonal[i][j] = matriz[matriz.length -1 -j][matriz.length -1 -i]; 
				}
			}
		}
		return diagonal;
	}
}


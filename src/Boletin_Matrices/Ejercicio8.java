package Boletin_Matrices;

public class Ejercicio8 {

	public static void main(String[] args) {
		int [][] matriz1 = { {1, 2, 3}, {4, 5, 6} };
		int [][] matriz2 = { {1, 2, 3}, {4, 5, 6} };

	if (sumaMatriz(matriz1, matriz2) != null) {
		
	}else {
		System.out.println("Es distinto");
	
	}
}
	private static int [][] sumaMatriz (int [][] matriz1,int [][] matriz2 ) {
		boolean iguales = true;
		int[][] suma;
		if (matriz1.length == matriz2.length) {
			for(int i = 0; i < matriz2.length && iguales; i++) {
				if (matriz1[i].length != matriz2[i].length) {
				iguales = false;
						}
					}
				}
			if (iguales) {
				suma = new int[matriz1.length][]; // reservo el espacio necesario para la suma
					for (int i = 0; i < matriz2.length; i++) { // recorremos las filas de matriz1
						suma[i] = new int [matriz2[i].length]; //reserva el mismo espacio para la suma de las filas
							for (int j = 0; j < matriz1[i].length; j++) {
								suma [i][j] = matriz1[i][j] + matriz2 [i][j];
								
					}
				}
					return suma;
					
			}else {
				return null;
			}
		}
	}
	
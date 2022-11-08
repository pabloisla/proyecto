package Boletin_Matrices;

public class Ejercicio7 {

	public static void main(String[] args) {
		int [][] matriz1 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		
		int [][] matriz2 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		
		if(compararIgualdad(matriz1, matriz2) {
		System.out.println("Las matrices son iguales");
		}
		else {
		System.out.println("Las matrices son diferentes");
	}
}
	private static boolean compararIgualdad (int[][] matriz1, int[][] matriz2 ) {
		boolean igual = true;
		if (matriz1.length == matriz2.length) {
			for(int i = 0; i < matriz2.length && igual; i++) {
				if (matriz1[i].length == matriz2[i].length) {
					for (int j = 0; j < matriz1[i].length && igual; j++) {
						if (matriz1[i][j] != matriz2[i][j]) {
							igual = false;
						}
						
					}
					
				}else {
					igual = false;
				}
				
			}
			
		}else {
			igual = false;
		}
	}
		return igual;
}




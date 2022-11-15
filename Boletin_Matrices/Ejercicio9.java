package Boletin_Matrices;

public class Ejercicio9 { 
// Crea un método que compruebe si una matriz pasada por parámetro es simétrica en
	//función del eje X. Es decir, la matriz
	
	public static void main(String[] args) {
		int[][] m = {
				{1,3,5,6},
				{4,2,0,8},
				{4,2,0,8},
				{1,3,5,6}
		};
		
		System.out.println("El resultado es " + esSimetrica(m));
	}
	public static boolean esSimetrica(int[][] matriz) {
		boolean esSimetrica = true;
		
		for (int i = 0; i < matriz.length/2 && esSimetrica; i++) {
			for (int j = 0; j < matriz[i].length && esSimetrica; j++) {
				if (matriz[i][j] != matriz[matriz.length - 1 - i][j]) {
					esSimetrica = false;
				}
			}
		}
		
		return esSimetrica;
	}
}

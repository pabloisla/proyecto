package Boletin_Matrices;

public class Ejercicio11 {
// Crea un método que reciba dos matrices, y compruebe si son matrices inversas, es decir,
//si tienen los mismos valores en los índices inversos:
	public static void main(String[] args) {
		int[][] matr1 = 
				{{5, 8, 9, 0},
				{4, 7, 5, 2},
				{1, 7, 3, 2}};
		
		int[][] matr2 =  
				{{2, 3, 7, 1},
				{2, 5, 7, 4},
				{0, 9, 8, 5}};
			
		if (compruebaInversa(matr1, matr2))	{
			System.out.println("Son inversas las matrices");
		}else {
			System.out.println("La matriz no es inversa");
		}
	}

private static boolean compruebaInversa(int[][] matr1, int[][] matr2) {
	
	boolean inversa = true;
	
		for (int j = 0; j < matr1.length && inversa; j++) { // recorremos las filas
			for (int i = 0; i < matr1[j].length && inversa; i++) { //recorremos las columnas
				if (matr1[j][i] != matr2[matr2.length - 1 - j][matr2[0].length - 1 - i]) { // si la matriz que he recorrido es inversa de la filas y luego de las columnas
					inversa = false;
				}
			}
		}
		return inversa;
	}
}

				
			
		


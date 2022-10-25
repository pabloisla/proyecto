package Arrays1;

public class Ejercicio1 {

	public static void main(String[] args) {

		int[] numeros = {0, 1, 2, 3, 4, 5, 6, 7, 8 };
		int sumaTotal = 0;
		
		for (int i = 0; i < numeros.length; i = i + 2) {
		sumaTotal = sumaTotal + numeros[i];	
		
		}
	System.out.println("Suma total: " + sumaTotal);
	}
}

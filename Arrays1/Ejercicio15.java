package Arrays1;

public class Ejercicio15 {
	public static int numF = 0; 
	private static int[] primos;
	
	public static void main(String[] args) {
		System.out.println("Introduce un numero");
		int num = Integer.parseInt (teclado.nextline());
		numF = num;
		primos = new int[numF];
		for (int i = 0; i < numF; i++) {
			primos[i] = i;
		}
		metodoPrimos(numF);
	}
	private static void metodoPrimos (int num) {
		for (int i = 2; i <= numF/2; i++) {
			for (int j = i+1; j < numF; j++) {
				if (primos[j] % i == 0) {
					primos[j] = 0;
				}
			}
		}
	}
}

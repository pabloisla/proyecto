package Arrays1;

public class Ejercicio8 {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		int posicion = devuelvePosicion(array, 5);
		
		if (posicion == -1) {
			System.out.println("El numero no se encuentra en el array");
		}
			else {
			System.out.printf("El numero se encuentra en la posicion %d" , posicion);
			}
		}
	private static int  devuelvePosicion(int[] array, int i) {
		
		int pos = -1;
		for (int j =  0; j < array.length; j++) {
			if (array[j] == i) {
			pos = j;
			}
		}
		return pos;
	}
}
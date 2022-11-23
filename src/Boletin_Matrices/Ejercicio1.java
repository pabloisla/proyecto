package Boletin_Matrices;

public class Ejercicio1 {

	 public static boolean verificaNegativos(int[][] verficar) {

	        int[][] verificar = verficar;
	        boolean verificacion = false;

	        for (int i = 0; i < verificar.length; i++) {      //Recorremos las filas de la matriz.
	            for (int j = 0; j < verificar[i].length; j++) { //Mientras en este recorremos las columnas de cada fila.
	                //Si alguno de los dos es menor que 0 es negativo, por lo tanto el booleano se cambia de false a true.
	                if (verficar[i][j] < 0) {
	                    verificacion = true;
	                    break;  //si es verdadero salimos no nos hace falta buscar más
	                } else {
	                    verificacion = false;
	                    continue; // si es falso continuamos buscando.
	                }
	            }
	        }

	        return verificacion;
	    }

	    public static void main(String[] args) {

	        int[][] verificar = {{2, 4, 5, 6}, {4, 2, 6, 7}, {4, 2, 6, 7}, {4, 2, 6, 7}, {4, 2, 6, -7}};

	        verificaNegativos(verificar);

	        if (verificaNegativos(verificar)) {

	            System.out.println("El array contiene elementos negativos ");

	        } else {
	            System.out.println("No contiene elementos negativos");
	        }
	    }
	}

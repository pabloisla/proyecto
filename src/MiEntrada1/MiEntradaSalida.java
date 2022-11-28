package MiEntrada1;

import java.util.Scanner;

public class MiEntradaSalida {

	public static Scanner sc = new Scanner(System.in);

	public static int solicitarEntero(String mensaje) {
		// Variable que almacenara el entero introducido por teclado.
		int integer = 0;
		// Variable que almacenara un booleano que indicara si se le debe volver a pedir
		// el dato al usuario.
		boolean flag = true;

		while (flag) {
			// Pedimos el entero por pantalla.
			System.out.println(mensaje);
			// Comprobamos si el usuario esta introduciendo algo correcto usando la
			// excepcion del metodo parseInt.
			try {
				integer = Integer.parseInt(sc.nextLine());
				// Si llegamos hasta aqui, es porque el usuario ha introducido un dato correcto
				// y no se ha lanzado ninguna excepcion.
				flag = false;
			}
			// Si se lanza la excepcion, informamos al usuario de su error.
			catch (NumberFormatException e) {
				System.out.println("Tienes que introducir un número entero");
			}

		}

		return integer;
	}

	public static int solicitarEnteroPositivo(String mensaje) {
		// Variable que almacenara el entero introducido por teclado.
		int integer = 0;
		// Variable que almacenara un booleano que indicar si se le debe volver a pedir
		// el dato al usuario.
		boolean flag = true;

		while (flag) {
			// Pedimos el entero por pantalla.
			System.out.println(mensaje);
			// Comprobamos si el usuario esta introduciendo algo correcto usando la
			// excepcion del metodo parseInt.
			try {
				integer = Integer.parseInt(sc.nextLine());
				// Si llegamos hasta aqui, es porque el usuario ha introducido un dato correcto
				// y no se ha lanzado ninguna excepcion.
				if (integer >= 0) {
					flag = false;
				}
			}
			// Si se lanza la excepcion, informamos al usuario de su error.
			catch (NumberFormatException e) {
				System.out.println("Introduzca un número entero positivo.");
			}

		}

		return integer;
	}

	public static int solicitarEnteroEnRango(String mensaje, int limiteInferior, int limiteSuperior) {
		// Variable que almacenara el entero introducido por teclado.
		int integer = 0;
		// Variable que almacenara un booleano que indicara si se le debe volver a pedir
		// el dato al usuario.
		boolean flag = true;

		while (flag) {
			// Pedimos el entero por pantalla.
			System.out.println(mensaje);
			// Comprobamos si el usuario esta introduciendo algo correcto usando la
			// excepcion del metodo parseInt.
			try {
				integer = Integer.parseInt(sc.nextLine());
				// Si llegamos hasta aqui, es porque el usuario ha introducido un dato correcto
				// y no se ha lanzado ninguna excepcion.
				if (integer >= limiteInferior && integer <= limiteSuperior) {
					flag = false;
				}
			}
			// Si se lanza la excepcion, informamos al usuario de su error.
			catch (NumberFormatException e) {
				System.out.println("Ha introducido un dato incorrecto.");
			}

		}

		return integer;
	}

	public static char solicitarCaracter(String mensaje) {
		char c = '0';

		// Variable que almacenara un booleano que indicara si se le debe volver a pedir
		// el dato al usuario.
		boolean flag = true;

		while (flag) {
			// Pedimos el entero por pantalla.
			System.out.println(mensaje);
			// Comprobamos si el usuario esta introduciendo algo correcto usando la
			// excepcion del metodo parseInt.
			try {
				c = sc.nextLine().charAt(0);
				// Si llegamos hasta aqui, es porque el usuario ha introducido un dato correcto
				// y no se ha lanzado ninguna excepcion.
				flag = false;
			}
			// Si se lanza la excepcion, informamos al usuario de su error.
			catch (IndexOutOfBoundsException e) {
				System.out.println("Ha introducido un dato incorrecto.");
			}

		}

		return c;
	}

	public static char solicitarCaracterSN(String mensaje) {
		char c = '0';

		// Variable que almacenara un booleano que indicara si se le debe volver a pedir
		// el dato al usuario.
		boolean flag = true;

		while (flag) {
			// Pedimos el entero por pantalla.
			System.out.println(mensaje);
			// Comprobamos si el usuario esta introduciendo algo correcto usando la
			// excepcion del metodo parseInt.

			String cadena = sc.nextLine();

			if (cadena.length() == 1) {
				c = cadena.toUpperCase().charAt(0);

				if (c == 'S' || c == 'N') {
					// Si llegamos hasta aqui, es porque el usuario ha introducido un dato correcto
					// y no se ha lanzado ninguna excepcion.
					flag = false;
				}
			}
		}

		return c;
	}

	public static String solicitarCadena(String mensaje) {
		String cadena = "";

		// Variable que almacenara un booleano que indicara si se le debe volver a pedir
		// el dato al usuario.
		boolean flag = true;

		while (flag) {
			// Pedimos el string por pantalla.
			System.out.println(mensaje);
			// Comprobamos si el usuario esta introduciendo algo correcto usando la
			// excepcion del metodo parseInt.

			cadena = sc.nextLine();

			if (cadena.length() > 0) {
				// Si llegamos hasta aqui, es porque el usuario ha introducido un dato correcto
				// y no se ha lanzado ninguna excepcion.
				flag = false;
			}
		}

		return cadena;
	}

}

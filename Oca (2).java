package oca;

import java.util.Random;
import java.util.Scanner;

/*
 * 
Crea un programa que permita simular un juego de la oca muy b�sico. El tama�o del tablero ser�
un cuadrado de 8x8 (puedes parametrizar dicho tama�o, el tablero siempre ser� cuadrado). 
Las normas son las siguientes:

Existen cuatro jugadores: (A)marillo, (V)erde, (R)ojo y (N)aranja (el azul se confundir�a con el amarillo). 
El programa debe decidir qui�n empieza. Para ello, debes implementar un m�todo dado, 
que genere n�meros aleatorios del 1 al 6. Cada jugador tirar� el dado una vez. 
El que saque el n�mero m�s alto empieza. En caso de empate, se repite entre los jugadores empatados. 
Despu�s el orden ser� desde el ganador, de izquierda a derecha teniendo en cuenta el orden de los 
colores: Amarillo, Verde, Rojo y Naranja. Ejemplo, si el Naranja es el que m�s puntuaci�n ha obtenido, 
le seguir� el Amarillo, luego el Verde y por �ltimo el Rojo.
Una vez decidido el orden, se comienza a avanzar por el tablero. Se avanzar� seg�n la puntuaci�n 
obtenida en una tirada del dado. El avance por el tablero, sin embargo, no es trivial, sino que seguir� 
la forma del juego original:

Gana el primer jugador que llegue a la casilla final.
Existen ciertas casillas especiales. Estas son:
Las casillas m�ltiplos de 4 son casillas de �oca�: hacen que el jugador avance hasta la siguiente casilla de oca. 
El jugador que caiga en una, adem�s, vuelve a tirar.
La antepen�ltima casilla es la casilla �calavera�, y hace que el jugador que caiga ah� vuelva a la primera posici�n.

    Consideraciones:
Siempre jugar�n 4 jugadores.
Utiliza el m�todo dado() tanto para decidir el orden inicial como para avanzar por el tablero.
Para facilitar la implementaci�n, si un jugador que est� cerca del final obtiene un n�mero mayor que el que necesita
para llegar a la casilla final, se le considera ganador.
La primera casilla es la casilla 1.

 */
public class Oca {
	private static final int NUMERO_CARAS_DADO = 6;
	private static final int TAMANO_TABLERO = 8;
	private static final int CASILLAS_MULTIPLOS_OCA = 4;
	
	private static final char JUGADOR_AMARILLO = 'A';
	private static final char JUGADOR_VERDE = 'V';
	private static final char JUGADOR_ROJO = 'R';
	private static final char JUGADOR_NARANJA = 'N';
	
	private static final String CADENA_JUGADOR_AMARILLO = "Amarillo";
	private static final String CADENA_JUGADOR_VERDE = "Verde";
	private static final String CADENA_JUGADOR_ROJO = "Rojo";
	private static final String CADENA_JUGADOR_NARANJA = "Naranja";
	
	private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Este array ser�a necesario si fuesemos a pintar el tablero, para no llenarlo con los nombres largos
		char[] jugadores = {JUGADOR_AMARILLO, JUGADOR_VERDE, JUGADOR_ROJO, JUGADOR_NARANJA};
		// Nombres largos de los jugadores. Debe estar en el mismo orden que el array jugadores
		String[] nombresJugadores = {CADENA_JUGADOR_AMARILLO, CADENA_JUGADOR_VERDE, CADENA_JUGADOR_ROJO, CADENA_JUGADOR_NARANJA};
		// Inicializamos las posiciones
		int[] posicionesJugadores = {1,1,1,1};
		
		// �ndice que marcar� qui�n juega a continuaci�n
		int indiceJugador;
		
		// Marcar� cu�ndo termina la partida
		boolean partidaTerminada = false;
		// Marcar� si el jugador ha ca�do en una oca y repite tirada
		boolean repiteTirada = false;
		
		// Vamos a decidir qui�n empieza
		indiceJugador = decideQuienEmpieza(nombresJugadores);
		
		while (!partidaTerminada) {
			// Si el jugador hubiese repetido tirada, lo reseteamos
			repiteTirada = false;
			System.out.printf("Jugador %s, est�s en la casilla %d. Tira el dado pulsando enter\n", 
					nombresJugadores[indiceJugador], posicionesJugadores[indiceJugador]);
			sc.nextLine();
			int tirada = dado();
			
			// Sumamos la posici�n de la tirada al jugador
			posicionesJugadores[indiceJugador] += tirada;
			
			// Si la tirada hace que el jugador se pase de la casilla final, haremos como que cae justo en la casilla final
			if (posicionesJugadores[indiceJugador] > (TAMANO_TABLERO * TAMANO_TABLERO)) {
				posicionesJugadores[indiceJugador] = TAMANO_TABLERO * TAMANO_TABLERO;
			}
			
			System.out.printf("Has sacado un %d. Te mueves a la casilla %d\n", tirada, posicionesJugadores[indiceJugador]);
			
			/*
			 * Toca ahora comprobar la casilla en la que el jugador ha ca�do. Tenemos que tener en cuenta varias cosas:
			 * 	- La casilla final es la casilla que ocupa la posicion NxN - 1
			 *  - Las casillas m�ltiplos de 4 son casillas oca. El jugador vuelve a tirar
			 *  - La antepen�ltima casilla es la casilla �calavera�, y hace que el jugador que caiga ah� vuelva a la primera posici�n.
			 */
			
			if (posicionesJugadores[indiceJugador] == (TAMANO_TABLERO * TAMANO_TABLERO)) {
				partidaTerminada = true;
			}
			else if (posicionesJugadores[indiceJugador] % CASILLAS_MULTIPLOS_OCA == 0) {
				// De oca en oca: sumamos CASILLAS_MULTIPLOS_OCA a la posici�n del jugador
				posicionesJugadores[indiceJugador] += CASILLAS_MULTIPLOS_OCA;				
				System.out.println("De oca en oca, y tiro porque me toca.");
				
				// Si el jugador cae en la �ltima casilla de oca y por ello gana, marcamos la partida como finalizada
				if (posicionesJugadores[indiceJugador] == (TAMANO_TABLERO * TAMANO_TABLERO)) {
					partidaTerminada = true;
				}
				else {
					// En caso contrario: tiro porque me toca. Hacemos que el jugador repita la tirada
					repiteTirada = true;
					System.out.printf("�El jugador %s se mueve a la casilla %d y tira de nuevo!\n", 
							nombresJugadores[indiceJugador], posicionesJugadores[indiceJugador]);
				}
			}
			else if (posicionesJugadores[indiceJugador] == (TAMANO_TABLERO * TAMANO_TABLERO) - 2) {
				// El jugador ha ca�do en la casilla calavera y vuelve a la primera posici�n
				System.out.println("�OOOOHH NOOOOO! Has ca�do en la casilla calavera y vuelves a la primera casilla");
				posicionesJugadores[indiceJugador] = 1;
			}
			
			/*
			 * En el caso de que la partida no est� ya acabada, o que el jugador actual no tenga que volver a tirar,
			 * avanzamos al jugador siguiente
			 */			
			if (!partidaTerminada && !repiteTirada) {
				// Avanzamos el �ndice. Ahora juega el siguiente jugador. Si pasamos del 4� jugador, volvemos al primero
				indiceJugador = ++indiceJugador % jugadores.length;
			}
		}
		
		// Si hemos salido del bucle es que la partida ha finalizado
		System.out.println("Felicidades jugador " + nombresJugadores[indiceJugador] + ". �Has ganado!");
	}
	
	/**
	 * Dada una lista de jugadores, hace que tiren los dados y decide qui�n sacar� en funci�n de la puntuaci�n que saquen.
	 * Si varios jugadores empatan al n�mero m�s alto, se hace una nueva ronda donde solo tirar�n ellos.
	 * @param jugadores array con los nombres de los jugadores
	 * @return �ndice del jugador que comienza a jugar
	 */
	private static int decideQuienEmpieza(String[] jugadores) {
		int[] resultados = new int[jugadores.length];
		
		// Indica cu�l es por ahora el m�ximo n�mero conseguido en la ronda actual
		int maximoRondaActual = 0;
		// Indica cu�l fue el m�ximo n�mero conseguido en la pasada ronda
		int maximoRondaAnterior = 0;
		// Indica cu�l es por ahora el jugador que ha sacado el mayor n�mero
		int indiceMaximo = 0;
		// Indica qui�n est� tirando el dado en este momento
		int indiceActual;
		// Indica si estamos en una situaci�n de empate
		boolean empate = false;
		// Indica si una ronda de tiradas ha finalizado
		boolean rondaFinalizada = false;
		
		/*
		 * Se deber�n jugar siempre rondas completas. Una ronda es completa cuando han tirado todos los jugadores
		 * que deb�an tirar en la misma. En la primera ronda, tiran el dado todos. 
		 * Si se produce un empate, se deber� volver a jugar una nueva ronda, donde s�lo tirar�n los jugadores
		 * que sacaron la m�xima puntuaci�n en la ronda anterior.
		 */
		for (int i = 0; !rondaFinalizada || (rondaFinalizada && empate); i++) {
			
			// Creamos esta variable para evitar tener que usar la operaci�n % cada vez que queramos sacar el �ndice actual
			indiceActual = i % jugadores.length;
			// Si es la �ltima tirada, marcamos que la ronda habr� finalizado justo despu�s de esta tirada
			if (indiceActual == (jugadores.length - 1)) {
				rondaFinalizada = true;
			}
			
			// Si hay una segunda, tercera... ronda, solo contaremos aquellos jugadores que hubiesen empatado en la ronda pasada
			if (i >= jugadores.length) {
				// Una nueva ronda. Quitamos el m�ximo actual y lo pasamos al anterior, y reseteamos empate
				if (indiceActual == 0) {
					System.out.println("Ha habido un empate. �Otra ronda!");
					rondaFinalizada = false;
					maximoRondaAnterior = maximoRondaActual;
					maximoRondaActual = 0;
					empate = false;
				}
				
				// �Este usuario debe volver a tirar?
				if (resultados[indiceActual] < maximoRondaAnterior) {
					// Este jugador no fue uno de los que empat�, no participa ya en esta ronda
					// Ponemos su puntuaci�n a 0 por si existe otra ronda m�s y se obtienen resultados m�s bajos en la siguiente.
					resultados[indiceActual] = 0;
					continue;
				}
			}
			
			System.out.println("Jugador " + jugadores[indiceActual] + ": tira el dado pulsando enter");
			sc.nextLine();
			resultados[indiceActual] = dado();
			
			System.out.println("Has sacado un " + resultados[indiceActual]);
			
			// Si es el primero de la ronda, o ha sacado un n�mero mayor que el m�ximo actual, actualizamos datos
			if (resultados[indiceActual] > maximoRondaActual) {
				maximoRondaActual = resultados[indiceActual];
				indiceMaximo = indiceActual;
				// En este caso, ya no habr�a empate porque el jugador ha obtenido un n�mero m�s alto que el anterior m�ximo
				empate = false;
			}
			else if (resultados[indiceActual] == maximoRondaActual) {
				// Si el n�mero es igual, marcamos empate para que, en caso de que la ronda acabe as�, se vuelva a tirar
				empate = true;
			}
			
		}
		
		System.out.println("Comienza sacando el jugador " + jugadores[indiceMaximo]);
		return indiceMaximo;
	}
	
	/**
	 * Simula una tirada en un dado de NUMERO_CARAS_DADO posiciones
	 * @return
	 */
	private static int dado() {
		Random r = new Random();
		return (r.nextInt(NUMERO_CARAS_DADO) + 1);
	}

}

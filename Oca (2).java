package oca;

import java.util.Random;
import java.util.Scanner;

/*
 * 
Crea un programa que permita simular un juego de la oca muy básico. El tamaño del tablero será
un cuadrado de 8x8 (puedes parametrizar dicho tamaño, el tablero siempre será cuadrado). 
Las normas son las siguientes:

Existen cuatro jugadores: (A)marillo, (V)erde, (R)ojo y (N)aranja (el azul se confundiría con el amarillo). 
El programa debe decidir quién empieza. Para ello, debes implementar un método dado, 
que genere números aleatorios del 1 al 6. Cada jugador tirará el dado una vez. 
El que saque el número más alto empieza. En caso de empate, se repite entre los jugadores empatados. 
Después el orden será desde el ganador, de izquierda a derecha teniendo en cuenta el orden de los 
colores: Amarillo, Verde, Rojo y Naranja. Ejemplo, si el Naranja es el que más puntuación ha obtenido, 
le seguirá el Amarillo, luego el Verde y por último el Rojo.
Una vez decidido el orden, se comienza a avanzar por el tablero. Se avanzará según la puntuación 
obtenida en una tirada del dado. El avance por el tablero, sin embargo, no es trivial, sino que seguirá 
la forma del juego original:

Gana el primer jugador que llegue a la casilla final.
Existen ciertas casillas especiales. Estas son:
Las casillas múltiplos de 4 son casillas de “oca”: hacen que el jugador avance hasta la siguiente casilla de oca. 
El jugador que caiga en una, además, vuelve a tirar.
La antepenúltima casilla es la casilla “calavera”, y hace que el jugador que caiga ahí vuelva a la primera posición.

    Consideraciones:
Siempre jugarán 4 jugadores.
Utiliza el método dado() tanto para decidir el orden inicial como para avanzar por el tablero.
Para facilitar la implementación, si un jugador que está cerca del final obtiene un número mayor que el que necesita
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
		// Este array sería necesario si fuesemos a pintar el tablero, para no llenarlo con los nombres largos
		char[] jugadores = {JUGADOR_AMARILLO, JUGADOR_VERDE, JUGADOR_ROJO, JUGADOR_NARANJA};
		// Nombres largos de los jugadores. Debe estar en el mismo orden que el array jugadores
		String[] nombresJugadores = {CADENA_JUGADOR_AMARILLO, CADENA_JUGADOR_VERDE, CADENA_JUGADOR_ROJO, CADENA_JUGADOR_NARANJA};
		// Inicializamos las posiciones
		int[] posicionesJugadores = {1,1,1,1};
		
		// Índice que marcará quién juega a continuación
		int indiceJugador;
		
		// Marcará cuándo termina la partida
		boolean partidaTerminada = false;
		// Marcará si el jugador ha caído en una oca y repite tirada
		boolean repiteTirada = false;
		
		// Vamos a decidir quién empieza
		indiceJugador = decideQuienEmpieza(nombresJugadores);
		
		while (!partidaTerminada) {
			// Si el jugador hubiese repetido tirada, lo reseteamos
			repiteTirada = false;
			System.out.printf("Jugador %s, estás en la casilla %d. Tira el dado pulsando enter\n", 
					nombresJugadores[indiceJugador], posicionesJugadores[indiceJugador]);
			sc.nextLine();
			int tirada = dado();
			
			// Sumamos la posición de la tirada al jugador
			posicionesJugadores[indiceJugador] += tirada;
			
			// Si la tirada hace que el jugador se pase de la casilla final, haremos como que cae justo en la casilla final
			if (posicionesJugadores[indiceJugador] > (TAMANO_TABLERO * TAMANO_TABLERO)) {
				posicionesJugadores[indiceJugador] = TAMANO_TABLERO * TAMANO_TABLERO;
			}
			
			System.out.printf("Has sacado un %d. Te mueves a la casilla %d\n", tirada, posicionesJugadores[indiceJugador]);
			
			/*
			 * Toca ahora comprobar la casilla en la que el jugador ha caído. Tenemos que tener en cuenta varias cosas:
			 * 	- La casilla final es la casilla que ocupa la posicion NxN - 1
			 *  - Las casillas múltiplos de 4 son casillas oca. El jugador vuelve a tirar
			 *  - La antepenúltima casilla es la casilla “calavera”, y hace que el jugador que caiga ahí vuelva a la primera posición.
			 */
			
			if (posicionesJugadores[indiceJugador] == (TAMANO_TABLERO * TAMANO_TABLERO)) {
				partidaTerminada = true;
			}
			else if (posicionesJugadores[indiceJugador] % CASILLAS_MULTIPLOS_OCA == 0) {
				// De oca en oca: sumamos CASILLAS_MULTIPLOS_OCA a la posición del jugador
				posicionesJugadores[indiceJugador] += CASILLAS_MULTIPLOS_OCA;				
				System.out.println("De oca en oca, y tiro porque me toca.");
				
				// Si el jugador cae en la última casilla de oca y por ello gana, marcamos la partida como finalizada
				if (posicionesJugadores[indiceJugador] == (TAMANO_TABLERO * TAMANO_TABLERO)) {
					partidaTerminada = true;
				}
				else {
					// En caso contrario: tiro porque me toca. Hacemos que el jugador repita la tirada
					repiteTirada = true;
					System.out.printf("¡El jugador %s se mueve a la casilla %d y tira de nuevo!\n", 
							nombresJugadores[indiceJugador], posicionesJugadores[indiceJugador]);
				}
			}
			else if (posicionesJugadores[indiceJugador] == (TAMANO_TABLERO * TAMANO_TABLERO) - 2) {
				// El jugador ha caído en la casilla calavera y vuelve a la primera posición
				System.out.println("¡OOOOHH NOOOOO! Has caído en la casilla calavera y vuelves a la primera casilla");
				posicionesJugadores[indiceJugador] = 1;
			}
			
			/*
			 * En el caso de que la partida no esté ya acabada, o que el jugador actual no tenga que volver a tirar,
			 * avanzamos al jugador siguiente
			 */			
			if (!partidaTerminada && !repiteTirada) {
				// Avanzamos el índice. Ahora juega el siguiente jugador. Si pasamos del 4º jugador, volvemos al primero
				indiceJugador = ++indiceJugador % jugadores.length;
			}
		}
		
		// Si hemos salido del bucle es que la partida ha finalizado
		System.out.println("Felicidades jugador " + nombresJugadores[indiceJugador] + ". ¡Has ganado!");
	}
	
	/**
	 * Dada una lista de jugadores, hace que tiren los dados y decide quién sacará en función de la puntuación que saquen.
	 * Si varios jugadores empatan al número más alto, se hace una nueva ronda donde solo tirarán ellos.
	 * @param jugadores array con los nombres de los jugadores
	 * @return índice del jugador que comienza a jugar
	 */
	private static int decideQuienEmpieza(String[] jugadores) {
		int[] resultados = new int[jugadores.length];
		
		// Indica cuál es por ahora el máximo número conseguido en la ronda actual
		int maximoRondaActual = 0;
		// Indica cuál fue el máximo número conseguido en la pasada ronda
		int maximoRondaAnterior = 0;
		// Indica cuál es por ahora el jugador que ha sacado el mayor número
		int indiceMaximo = 0;
		// Indica quién está tirando el dado en este momento
		int indiceActual;
		// Indica si estamos en una situación de empate
		boolean empate = false;
		// Indica si una ronda de tiradas ha finalizado
		boolean rondaFinalizada = false;
		
		/*
		 * Se deberán jugar siempre rondas completas. Una ronda es completa cuando han tirado todos los jugadores
		 * que debían tirar en la misma. En la primera ronda, tiran el dado todos. 
		 * Si se produce un empate, se deberá volver a jugar una nueva ronda, donde sólo tirarán los jugadores
		 * que sacaron la máxima puntuación en la ronda anterior.
		 */
		for (int i = 0; !rondaFinalizada || (rondaFinalizada && empate); i++) {
			
			// Creamos esta variable para evitar tener que usar la operación % cada vez que queramos sacar el índice actual
			indiceActual = i % jugadores.length;
			// Si es la última tirada, marcamos que la ronda habrá finalizado justo después de esta tirada
			if (indiceActual == (jugadores.length - 1)) {
				rondaFinalizada = true;
			}
			
			// Si hay una segunda, tercera... ronda, solo contaremos aquellos jugadores que hubiesen empatado en la ronda pasada
			if (i >= jugadores.length) {
				// Una nueva ronda. Quitamos el máximo actual y lo pasamos al anterior, y reseteamos empate
				if (indiceActual == 0) {
					System.out.println("Ha habido un empate. ¡Otra ronda!");
					rondaFinalizada = false;
					maximoRondaAnterior = maximoRondaActual;
					maximoRondaActual = 0;
					empate = false;
				}
				
				// ¿Este usuario debe volver a tirar?
				if (resultados[indiceActual] < maximoRondaAnterior) {
					// Este jugador no fue uno de los que empató, no participa ya en esta ronda
					// Ponemos su puntuación a 0 por si existe otra ronda más y se obtienen resultados más bajos en la siguiente.
					resultados[indiceActual] = 0;
					continue;
				}
			}
			
			System.out.println("Jugador " + jugadores[indiceActual] + ": tira el dado pulsando enter");
			sc.nextLine();
			resultados[indiceActual] = dado();
			
			System.out.println("Has sacado un " + resultados[indiceActual]);
			
			// Si es el primero de la ronda, o ha sacado un número mayor que el máximo actual, actualizamos datos
			if (resultados[indiceActual] > maximoRondaActual) {
				maximoRondaActual = resultados[indiceActual];
				indiceMaximo = indiceActual;
				// En este caso, ya no habría empate porque el jugador ha obtenido un número más alto que el anterior máximo
				empate = false;
			}
			else if (resultados[indiceActual] == maximoRondaActual) {
				// Si el número es igual, marcamos empate para que, en caso de que la ronda acabe así, se vuelva a tirar
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

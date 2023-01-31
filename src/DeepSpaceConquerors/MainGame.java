package DeepSpaceConquerors;

import java.util.Scanner;

/**
 *	Clase principal
 */
public class MainGame {
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Metodo main del juego.
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Variables
		int numberOfPlayers = 0;
		boolean finishedGame = false;
		int roundCounter = 0;
		boolean correctOption = false;
		final int SHIFTS_BY_PLAYERS = 2;
		int turnPlayer;
		boolean skipedTurn = false;
		int player;
		
		
		do {
			try {
				System.out.println("¿Cuantos jugadores van a participar? [Introduzca el numero de jugadores]");
				numberOfPlayers = Integer.parseInt(sc.nextLine());
				// Si el número de jugadores es menor que 2 y mayor que 4 la opci�n es incorrecta.
				// Si la opcion es correcta, continuamos.
				if (numberOfPlayers < 2 || numberOfPlayers > 4) {
					System.out.println("El numero minimo de jugadores es 2 y el maximo 4");
					correctOption = false;
				}
				else {
					correctOption = true;
				}
			} catch(NumberFormatException e) {
				System.out.println("ERROR: Tienes que introducir un numero.");
			}
		} while (!correctOption);
		
		// Creamos el tablero.
		Tablero tablero = new Tablero(numberOfPlayers);
		// A�adimos los jugadores al array.
		tablero.addPlayers();
		// Decidimos quien empieza.
		player = tablero.decideWhoStarts();
		// A�adimos lo planetas al array;
		tablero.addPlanets();
		// Imprimimos los jugadores.
		tablero.printPlayers();
		// Asignamos los planetas a los jugadores.
		tablero.assignPlanetsToPlayers();
		
		// Se repite mientras el juego no haya terminado.
		while(!finishedGame) {
			// Aumentamos el contador de rondas.
			roundCounter += 1;
			System.out.printf("Ronda %d \n", roundCounter);
			skipedTurn = false;
			
			// Esto lo hacemos para que jugador tenga 2 turnos. Si el jugador decide saltar su turno la variable skipedTurn se vuelve true.
			for (turnPlayer = 0; turnPlayer < SHIFTS_BY_PLAYERS && !skipedTurn; turnPlayer++) {
				System.out.printf("Turno del jugador %s \n", tablero.getPlayersName(player));
				tablero.generateDeckOfShips();
				skipedTurn = gameMenu(tablero, player);
			}
			
			player = ++player % tablero.getPlayers().length;
			// Comprobamos si el jugador todavia tiene planetas.
			tablero.checkIfPlayerHavePlanets();
			// Hacemos que cada ronda nazcan nuevas personas.
			tablero.populationBirth();
			// Comprobamos si el juego ha finalizado.
			tablero.checkFinishedGame(tablero.checkEliminatedPlayers());
		}
		
		
	}
	
	/**
	 * Metodo que muestra el menu del juego.
	 * @param tablero - Tablero
	 * @param player - Posicion del jugador en el array de jugadores.
	 * @return skipedTurn - Devuelve un boolean para saber si el jugador ha pasado turno.
	 */
	public static boolean gameMenu(Tablero tablero, int player) {
		int selectedOption;
		boolean skipedTurn = false;
		
		// Se repite hasta que el jugador introduzca una opcion correcta.
		
		try {
			System.out.println("1. Comprar cartas de nave.");
			System.out.println("2. Comprar cartas de construccion.");
			System.out.println("3. Coger carta del mazo de materias primas.");
			System.out.println("4. Construir.");
			System.out.println("5. Mover nave de un planeta a otro.");
			System.out.println("6. Atacar.");
			System.out.println("7. Transportar carga.");
			System.out.println("8. Transportar personas.");
			System.out.println("9. Mejorar una nave.");
			System.out.println("10. Reparar.");
			System.out.println("11. Mostrar informacion de los planetas.");
			System.out.println("12. Pasar turno.");
			System.out.println("Introduzca la opcion que desee hacer: ");
			
			selectedOption = Integer.parseInt(sc.nextLine());
			
			switch(selectedOption) {
			case 1:
				tablero.buyShipCard(player);
				skipedTurn = false;
				break;
			case 2:
				tablero.buyConstructionCard(player);
				skipedTurn = false;
				break;
			case 3:
				tablero.takeACardFromMaterialDeck(player);
				skipedTurn = false;
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				tablero.attackTarget(player);
				skipedTurn = false;
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;
			case 11:
				tablero.printPlanets();
				skipedTurn = false;
				break;
			case 12:
				skipedTurn = true;
				break;
			}
		} catch (NumberFormatException e) {
			System.out.println("ERROR: Tienes que introducir un n�mero.");
		}
		return skipedTurn;
		
	}

}

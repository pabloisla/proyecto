package DeepSpaceConquerors;

import java.util.Random;
import java.util.Scanner;

/**
 *	Clase tablero
 */
public class Tablero {

	// Constantes
	final int NUMBER_OF_CARDS_IN_BOARD = 4;
	final int PLANETS_BY_PLAYERS = 4;
	final int MINE_PRICE = 1;
	final int SHIELD_PRICE = 5;
	final int CONQUERED_PLANET_POINTS = 10;
	final int PROTECTIVE_SHIELD_POINTS = 3;
	final int MINE_POINTS = 2;
	final int POINTS_FOR_20_PEOPLE = 1;
	final int NO_DESTROYED_SHIP = 2;
	final int POINTS_FOR_GOLD = 1;
	final int POINTS_FOR_3_MATERIALS = 1;
	static Scanner sc = new Scanner(System.in);
	
	
	// Variables
	NaveCartas[] naveCards = new NaveCartas[NUMBER_OF_CARDS_IN_BOARD];
	ConstructorCartas[] constructorCards = new ConstructorCartas[NUMBER_OF_CARDS_IN_BOARD];
	int numberOfPlayers;
	int diceAFaces = 4;
	int diceAMinValue = 2;
	int diceAMaxValue = 5;
	int diceBFaces = 12;
	int diceBMinValue = 1;
	int diceBMaxValue = 12;
	int diceCFaces = 6;
	int diceCMinValue = 10;
	int diceCMaxValue = 15;
	int transportShipCardPrice = 2;
	int cargoShipCardPrice = 3;
	int attackShipCardPrice = 5;
	int protectiveShieldCardPrice = 5;
	int minesPrice = 1;
	int minedPerShift;
	boolean added = false;
	String selectedPlanet;
	String playerName;
	String[] planetName = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "l", "o", "p" };
	Planetas[] planets;
	Jugadores[] players;
	NaveCartas purchasedShipCard;
	ConstructorCartas purchasedConstructionCard;
	Dado dadoA;
	Dado dadoB;
	Dado dadoC;
	
	
	/**
	 * Constructor de la clase tablero
	 * @param numberOfPlayers - N�mero de jugadores de la partida.
	 */
	public Tablero(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
		Dado dadoA = new Dado(diceAFaces, diceAMinValue, diceAMaxValue);
		Dado dadoB = new Dado(diceBFaces, diceBMinValue, diceBMaxValue);
		Dado dadoC = new Dado(diceCFaces, diceCMinValue, diceCMaxValue);
		this.dadoA = dadoA;
		this.dadoB = dadoB;
		this.dadoC = dadoC;
		Planetas[] planets = new Planetas[this.numberOfPlayers * PLANETS_BY_PLAYERS];
		Jugadores[] players = new Jugadores[this.numberOfPlayers];
		this.planets = planets;
		this.players = players;
	}
	
	

	/**
	 * M�todo para a�adir jugadores en la partida. 
	 */
	public void addPlayers() {
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.println("Introduzca el nombre del jugador: ");
			playerName = sc.nextLine();
			Jugadores player = new Jugadores(playerName);
			players[i] = player;
		}

	}
	
	
	/**
	 * M�todo que genera los hatitantes de cada planeta en el array de jugadores.
	 */
	public void populationBirth() {
		for (int i = 0;i < planets.length; i++) {
			planets[i].setPopulation(2);
		}
	}
	
	

	/**
	 * M�todo para generar planetas
	 */
	public void addPlanets() {
		for (int i = 0; i < planets.length; i++) {
			Planetas planet = new Planetas(planetName[i]);
			planets[i] = planet;
		}
	}
	/**
	 * M�todo para obtener los planetas
	 * @return planets - Devuelve el array que contiene los planetas.
	 */
	public Planetas[] getPlanets() {
		return planets;
	}
	
	/**
	 * M�todo para obtener el n�mero de jugadores
	 * @return numberOfPlayers - Devuelve el n�mero de jugadores de la partida
	 */
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	
	/**
	 * M�todo que devuelve el array con los jugadores
	 * @return players
	 */
	public Jugadores[] getPlayers() {
		return players;
	}
	
	/**
	 * M�todo para atacar a otras naves o planetas.
	 * @param player - Posici�n del jugador en el array de jugadores.
	 */
	public void attackTarget(int player) {
		int option = 0;
		int shipOption = 0;
		int otherOption = 0;
		String target;
		AttackCard attackShip = null;
		boolean attacked = false;
		for (int i = 0; i < planets.length; i++) {
			for (int x = 0; x < planets[0].getShipsCardsArray().length; x++) {
				// Si la nave que tenemos en el planeta es de ataque lo mostramos al usuario.
				if (planets[i].getShipsCardsArray()[x] instanceof AttackCard) {
					System.out.printf("Tienes naves en el planeta %d. %s \n",i ,planets[i].getName());
				}
			}
		}
		
		// Le preguntamos al usuario que quiere atacar.
		System.out.println("�Qu� quieres atacar? 1.NAVE | 2. PLANETA");
		option = Integer.parseInt(sc.nextLine());
	
		if (option == 1) {
			// Le preguntamos al usuario que planeta quiere atacar.
			System.out.println("�En qu� planeta quieres atacar?");
			option = Integer.parseInt(sc.nextLine());
			
			
			for(int i = 0; i < planets[option].getShipsCardsArray().length; i++) {
				/*
				 * Si el jugador es propietario de la nave y la nave es de ataque podemos atacar.
				 */
				if (planets[option].getShipCard(i).getName() == players[player].getPlayerName() && planets[option].getShipCard(option) instanceof AttackCard) {
					System.out.println("Tienes naves de ataque en ese planeta. Puedes atacar.");
					// Le preguntamos que nave quieres atacar.
					System.out.println("Que nave quieres atacar?");
					// Le mostramos las naves enemigas.
					printEnemyShips(option, player);
					shipOption = Integer.parseInt(sc.nextLine());
					
				}
			}
			
			for(int i = 0; i < planets[option].getShipsCardsArray().length; i++) {
				if (planets[option].getShipCard(i).getName() == players[player].getPlayerName()) {
					System.out.printf("Puedes atacar con esta nave %d. %s", i, planets[option].getShipCard(i));
				}
			}
			
			System.out.println("Selecciona la nave con la que quieres atacar: ");
			option = Integer.parseInt(sc.nextLine());
			
			if(planets[otherOption].getShipCard(option) instanceof AttackCard) {
				// Una vez elegida a una nave de ataque la asignamos a una variable.
				attackShip = (AttackCard)planets[otherOption].getShipCard(option);
			}
			
			// Atacamos el planeta.
			attackShip.attack(planets[option].getShipCard(shipOption));
			
			
			
		}
		else if (option == 2) {
			// Le preguntamos que planeta quiere atacar.
			System.out.println("�Qu� planeta quieres atacar?");
			target = sc.nextLine(); 
			int x = 0;
			for(int i = 0; i < planets.length; i++) {
				// Si el nombre del planeta es igual al target continuamos.
				if (planets[i].getName() == target) {
					for (x = 0; x < planets[i].getShipsCardsArray().length && !attacked; x ++) {
						// Si tenemos naves de ataque en el planeta y es nuestra podemos atacar.
						if (planets[i].getShipsCardsArray()[x] instanceof AttackCard && planets[i].getShipsCardsArray()[x].getName() == players[player].getPlayerName()) {
							// La asignamos a una variable.
							attackShip = (AttackCard)planets[i].getShipsCardsArray()[x];
							// Y atacamos.
							attackShip.attack(planets[i]);
							attacked = true;
							
						}
					}
				}
			}
			
			// Si el escudo del planeta llega a 0, el planeta pasa a ser nuestro.
			if(planets[x].getProtectiveShield().health <= 0) {
				planets[x].setOwner(players[player].getPlayerName());
				players[player].setPoints(CONQUERED_PLANET_POINTS);
			}
		}
	}
	
	/**
	 * M�todo para imprimir las naves enemigas de un planeta.
	 * @param option - Planeta del que queremos imprimir las naves.
	 * @param player - Posici�n del jugador actual en el array de jugadores.
	 */
	public void printEnemyShips(int option, int player) {
		for (int i = 0; i < planets[option].getShipsCardsArray().length; i++) {
			if (planets[option].getShipCard(i).getName() != players[player].getPlayerName()) {
				System.out.printf("Nave enemiga n�mero %d", i);
			}
		}
	}
	
	/**
	 * M�todo que imprime la informaci�n de los planetas
	 */
	public void printPlanets() {
		for (int i = 0; i < planets.length; i++) {
			System.out.printf("Informaci�n del planeta %s \n", planets[i]);
		}
	}
	
	/**
	 * M�todo que imprime la informaci�n de los jugadores
	 */
	public void printPlayers() {
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i].getPlayerName());
		}
	}

	/**
	 * M�todo utilizado para comprar cartas de nave
	 * @param player - Posici�n del jugador en el array de jugadores
	 */
	public void buyShipCard(int player) {
		added = false;
		int option = 0;
		boolean correctOption = false;
		
		printDeckOfShips();

		do {
			try {
				System.out.println("Selecciona una de las cuatro cartas: ");
				option = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Tienes que introducir un n�mero.");
			}
			
			if (option < 1 || option > 4) {
				correctOption = false;
			}
			else {
				correctOption = true;
			}
		} while(!correctOption);
		
		checkGold(option, player);
		purchasedShipCard = naveCards[option - 1];
		selectPlanetToAddShip(purchasedShipCard, player);
		naveCards[option - 1] = null;
	}
	
	/**
	 * M�todo que comprueba si el jugador tiene oro suficiente como para comprar una nave.
	 * @param option
	 * @param player
	 */
	public void checkGold(int option, int player) {

		if (players[player].getGold() >= naveCards[option - 1].price) {
			for (int i = 0; i < planets.length; i++) {
				if (players[player].getPlayerName().equals(planets[i].getOwner())) {
					System.out.printf("Este planeta es tuyo: %s \n", planets[i].getName());
					players[player].setGold(players[player].getGold() - naveCards[option - 1].price);
				}
			}
		}
	}
	
	/**
	 * M�todo utilizado para seleccionar un planeta en el que a�adir la nave que acabamos de comprar
	 * @param purchasedShipCard - Nave que acabamos de comprar
	 * @param player - Posici�n del jugador en el array de jugadores
	 */
	public void selectPlanetToAddShip(NaveCartas purchasedShipCard, int player) {
		System.out.println("Introduce el nombre del planeta en el que vas a a�adir la nave: ");
		selectedPlanet = sc.nextLine();
		for (int i = 0; i < planets.length; i++) {
			if (planets[i].getName() == selectedPlanet && planets[i].getOwner() == players[player].getPlayerName()) {
				for (int x = 0; x < planets[i].getShipsCardsArray().length && !added; x++) {
					if (planets[i].getShipCard(x) == null) {
						added = true;
						planets[i].setShipCard(x, purchasedShipCard);
						planets[i].getShipsCardsArray()[x].setName(players[player].getPlayerName());
					}
				}
			}
			else {
				System.out.println("Este planeta no es tuyo");
			}
		}
	}
	
	/**
	 * M�todo utilizado para comprar carta de construcci�n.
	 * @param player - Posici�n del jugador en el array de jugadores
	 */
	public void buyConstructionCard(int player) {
		added = false;
		int option = 0;
		int mineOption = 0;
		boolean correctOption = false;
		boolean otherCorrectOption = false;
		
		
		do {
			try {
				// Le preguntamos al usuario que tipo de carta de construcci�n quiere.
				System.out.println("�Quieres carta de mina o de escudo? (Introduce 1 o 2)");
				option = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Tienes que introducir un n�mero");
			}
			
			if(option < 1 || option > 2) {
				otherCorrectOption = false;
			}
			else {
				otherCorrectOption = true;
			}
			
		} while (!otherCorrectOption);
		
		
		if (option == 1) {
			// Chequemos si el jugador tiene oro para la mina.
			if(checkGoldForMines(MINE_PRICE, player)) {
			try {
				do {
					// Le preguntamos que tipo de mina quiere.
					System.out.println("�Qu� tipo de mina quieres?(1.Hierro | 2.Piedra | 3. Combustible)");
					mineOption = Integer.parseInt(sc.nextLine());
					if (option < 1 || option > 3) {
						correctOption = false;
					} 
					else {
						correctOption = true;
					}
				} while(!correctOption);
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Tienes que introducir un n�mero.");
			}
			
			switch (mineOption) {
			case 1:
				// Creamos una mina de hierro.
				minedPerShift = dadoA.throwDace();
				HierroCartas ironMine = new HierroCartas(MINE_PRICE, minedPerShift);
				selectPlanetToAddMine(ironMine, player);
				break;
			case 2:
				// Creamos una mina de piedra.
				minedPerShift = dadoA.throwDace();
				PiedraCartas stoneMine = new PiedraCartas(MINE_PRICE, minedPerShift);
				selectPlanetToAddMine(stoneMine, player);
				break;
			case 3:
				// Creamos una mina de combustible.
				minedPerShift = dadoA.throwDace();
				CombustibleDeMinasCartas fuelMine = new CombustibleDeMinasCartas(MINE_PRICE, minedPerShift);
				selectPlanetToAddMine(fuelMine, player);
				break;
			}
			}
			else {
				System.out.println("No tienes oro suficiente.");
			}
		}
		else if (option == 2) {
			if (checkGoldForShields(SHIELD_PRICE,player)) {
				selectPlanetToAddShield(player);
			}
			else {
				System.out.println("No tienes oro suficiente.");
			}
		}
		
	}
	
	/**
	 * M�todo para coger una carta del mazo de materiales
	 * @param player - Posici�n del jugador en el array de jugadores
	 */
	public void takeACardFromMaterialDeck(int player) {
		int randomNum = (int) (Math.random() * (1 - 5) + 5);
		
		switch(randomNum) {
		case 1:
			System.out.println("Introduce el nombre del planeta en el que vas a a�adir el material: ");
			selectedPlanet = sc.nextLine();
			for(int i = 0; i > planets.length; i++) {
				if(planets[i].getName() == selectedPlanet && planets[i].getOwner() == players[player].getPlayerName()) {
					planets[i].setIron(1);
					System.out.println("El material se ha a�adido correctamente.");
				}
				else {
					System.out.println("El planeta no es v�lido o no es tuyo");
				}
			}
			break;
		case 2:
			System.out.println("Introduce el nombre del planeta en el que vas a a�adir el material: ");
			selectedPlanet = sc.nextLine();
			for(int i = 0; i > planets.length; i++) {
				if(planets[i].getName() == selectedPlanet && planets[i].getOwner() == players[player].getPlayerName()) {
					planets[i].setStone(1);
					System.out.println("El material se ha a�adido correctamente.");
				}
				else {
					System.out.println("El planeta no es v�lido o no es tuyo");
				}
			}
			break;
		case 3:
			System.out.println("Introduce el nombre del planeta en el que vas a a�adir el material: ");
			selectedPlanet = sc.nextLine();
			for(int i = 0; i > planets.length; i++) {
				if(planets[i].getName() == selectedPlanet && planets[i].getOwner() == players[player].getPlayerName()) {
					planets[i].setFuel(1);
					System.out.println("El material se ha a�adido correctamente.");
				}
				else {
					System.out.println("El planeta no es v�lido o no es tuyo");
				}
			}
			break;
		case 4:
			players[player].setGold(1);
			break;
		}
	}
	
	/**
	 * M�todo que genera los materiales al final de cada ronda.
	 */
	public void generateMaterials() {
		// Recorremos los planetas.
		for (int i = 0; i < planets.length; i++) {
			// Recorremos las minas del planeta.
			for (int x = 0; x < planets[i].getMineCardsArray().length; x++) {
				// Dependiendo del tipo de mina que sea generamos un material u otro.
				if(planets[i].mineCardsArray[x] instanceof PiedraCartas) {
					planets[i].setStone(planets[i].mineCardsArray[x].getMinedPerShift());
				}
				else if(planets[i].mineCardsArray[x] instanceof CombustibleDeMinasCartas) {
					planets[i].setFuel(planets[i].mineCardsArray[x].getMinedPerShift());
				}
				else if(planets[i].mineCardsArray[x] instanceof PiedraCartas) {
					planets[i].setIron(planets[i].mineCardsArray[x].getMinedPerShift());
				}
				else if (planets[i].mineCardsArray[x] == null) {
					
				}
			}
		}
	}
	
	/**
	 * M�todo para comprobar si el jugador tiene suficiente oro como para comprar una mina.
	 * @param MINE_PRICE - Precio de la mina.
	 * @param player - Posici�n de jugador en el array de jugadores.
	 * @return haveGold - Devuelve un boolean despu�s de comprobar si el jugador tiene oro suficiente o no.
	 */
	public boolean checkGoldForMines(int MINE_PRICE, int player) {
		boolean haveGold = false;
		if(players[player].getGold() >= MINE_PRICE) {
			for (int i = 0; i < planets.length; i++) {
				if (players[player].getPlayerName().equals(planets[i].getOwner())) {
					System.out.printf("Este planeta es tuyo: %s \n", planets[i].getName());
					haveGold = true;
				}
				
			}
		}
		else {
			haveGold = false;
		}
		return haveGold;
	}
	
	/**
	 * M�todo para comprobar si el jugador tiene suficiente oro como para comprar un escudo.
	 * @param SHIELD_PRICE - Precio del escudo.
	 * @param player - Posici�n del jugador en el array de jugadores.
	 * @return haveGold - Devuelve un boolean despu�s de comprobar si el jugador tiene oro suficiente o no.
	 */
	public boolean checkGoldForShields(int SHIELD_PRICE, int player) {
		boolean haveGold = false;
		if(players[player].getGold() >= SHIELD_PRICE) {
			for (int i = 0; i < planets.length; i++) {
				if (players[player].getPlayerName().equals(planets[i].getOwner())) {
					System.out.printf("Este planeta es tuyo: %s \n", planets[i].getName());
					haveGold = true;
				}
				else {
					System.out.println("Este planeta no es tuyo");
				}
			}
		}
		else {
			haveGold = false;
		}
		return haveGold;
	}
	
	/**
	 * M�todo para seleccionar un planeta en el que a�adir el escudo.
	 * @param player - Posici�n del jugador en el array de jugadores.
	 */
	
	public void selectPlanetToAddShield(int player) {
		System.out.println("Introduce el nombre del planeta en el que vas a a�adir la nave: ");
		selectedPlanet = sc.nextLine();
		for (int i = 0; i < planets.length; i++) {
			if (planets[i].getName() == selectedPlanet && planets[i].getOwner() == players[player].getPlayerName()) {
				if(planets[i].getShield() == null) {
					int variableHealth = dadoA.throwDace();
					EscudoCartas protectiveShield = new EscudoCartas(SHIELD_PRICE, variableHealth);
					planets[i].setProtectiveShield(protectiveShield);
				}
			}
		}
	}
	
	/**
	 * M�todo para seleccionar un planeta en el que a�adir la mina.
	 * @param constructionCard - Carta de construcci�n.
	 * @param player - Posici�n del jugador en el array de jugadores.
	 */
	public void selectPlanetToAddMine(ConstructorDeMinasCartas constructionCard, int player) {
		
		boolean incorrect = false;
		System.out.println("Introduce el nombre del planeta en el que vas a a�adir la construcci�n: ");
		selectedPlanet = sc.nextLine();
		for (int i = 0; i < planets.length && incorrect; i++) {
			if (planets[i].getName() == selectedPlanet && planets[i].getOwner() == players[player].getPlayerName()) {
				for (int x = 0; x < planets[i].getMineCardsArray().length && !added; x++) {
					if (planets[i].getMineCard(x) == null) {
						added = true;
						planets[i].setMineCard(x, constructionCard);
					}
				}
			}
			else {
				System.out.println("Este planeta no es tuyo");
				incorrect = false;
			}
		}
	}
	
	/**
	 * M�todo para seleccionar un planeta en el que a�adir el escudo.
	 * @param protectiveShield - Carta de escudo de protecci�n.
	 * @param player - Posici�n del jugador en el array de jugadores.
	 */
	public void selectPlanetToAddShield(EscudoCartas protectiveShield, int player) {
		System.out.println("Introduce el nombre del planeta en el que vas a a�adir el escudo:");
		selectedPlanet = sc.nextLine();
		for (int i = 0; i < planets.length; i++) {
			if (planets[i].getName() == selectedPlanet && planets[i].protectiveShield == null && planets[i].getOwner() == players[player].getPlayerName()) {
				planets[i].setProtectiveShield(protectiveShield);
			}
		}
	}

	/**
	 * M�todo para generar el mazo de cartas de naves.
	 */
	public void generateDeckOfShips() {
		for (int i = 0; i < NUMBER_OF_CARDS_IN_BOARD; i++) {
			if (naveCards[i] == null) {
				int randomNum = (int) (Math.random() * (1 - 4) + 4);
				switch (randomNum) {
				case 1:
					AttackCard attackShip = new AttackCard(attackShipCardPrice);
					naveCards[i] = attackShip;
					break;
				case 2:
					CargueroCard cargoShip = new CargueroCard(cargoShipCardPrice);
					naveCards[i] = cargoShip;
					break;
				case 3:
					TranporteCartas transportShip = new TranporteCartas(transportShipCardPrice);
					naveCards[i] = transportShip;
					break;
				}
			}
		}
	}
	

	/**
	 * M�todo para imprimir el mazo de cartas de naves.
	 */
	public void printDeckOfShips() {
		for (int i = 0; i < NUMBER_OF_CARDS_IN_BOARD; i++) {
			System.out.println(naveCards[i].getClass());
		}
	}
	
	/**
	 * M�todo para imprimir el mazo de cartas de construcci�n.
	 */
	public void printDeckOfConstructions() {
		for (int i = 0; i < NUMBER_OF_CARDS_IN_BOARD; i++) {
			System.out.println(constructorCards[i].getClass());
		}
	}

	/**
	 * M�todo que asigna planetas a jugadores aleatoriamente al principio de la partida.
	 */
	public void assignPlanetsToPlayers() {
		for (int i = 0; i < numberOfPlayers; i++) {
			int randomNum = (int) (Math.random() * (1 - numberOfPlayers * 4) + numberOfPlayers * 4);

			if (planets[randomNum].getConquered() == false) {
				planets[randomNum].setOwner(players[i].getPlayerName());
				planets[randomNum].setConquered(true);
			} else {
				i--;
			}

		}
	}

	/**
	 * M�todo que decide quien empieza.
	 * @return indiceM�ximo - Devuelve el �ndice del jugador que ha ganado la tirada.
	 */
	public int decideWhoStarts() {
		int[] resultados = new int[players.length];

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
		 * Se deber�n jugar siempre rondas completas. Una ronda es completa cuando han
		 * tirado todos los jugadores que deb�an tirar en la misma. En la primera ronda,
		 * tiran el dado todos. Si se produce un empate, se deber� volver a jugar una
		 * nueva ronda, donde s�lo tirar�n los jugadores que sacaron la m�xima
		 * puntuaci�n en la ronda anterior.
		 */
		for (int i = 0; !rondaFinalizada || (rondaFinalizada && empate); i++) {

			// Creamos esta variable para evitar tener que usar la operaci�n % cada vez que
			// queramos sacar el �ndice actual
			indiceActual = i % players.length;
			// Si es la �ltima tirada, marcamos que la ronda habr� finalizado justo despu�s
			// de esta tirada
			if (indiceActual == (players.length - 1)) {
				rondaFinalizada = true;
			}

			// Si hay una segunda, tercera... ronda, solo contaremos aquellos jugadores que
			// hubiesen empatado en la ronda pasada
			if (i >= players.length) {
				// Una nueva ronda. Quitamos el m�ximo actual y lo pasamos al anterior, y
				// reseteamos empate
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
					// Ponemos su puntuaci�n a 0 por si existe otra ronda m�s y se obtienen
					// resultados m�s bajos en la siguiente.
					resultados[indiceActual] = 0;
					continue;
				}
			}

			System.out.println("Jugador " + players[indiceActual].getPlayerName() + ": tira el dado pulsando enter");
			sc.nextLine();
			resultados[indiceActual] = dado();

			System.out.println("Has sacado un " + resultados[indiceActual]);

			// Si es el primero de la ronda, o ha sacado un n�mero mayor que el m�ximo
			// actual, actualizamos datos
			if (resultados[indiceActual] > maximoRondaActual) {
				maximoRondaActual = resultados[indiceActual];
				indiceMaximo = indiceActual;
				// En este caso, ya no habr�a empate porque el jugador ha obtenido un n�mero m�s
				// alto que el anterior m�ximo
				empate = false;
			} else if (resultados[indiceActual] == maximoRondaActual) {
				// Si el n�mero es igual, marcamos empate para que, en caso de que la ronda
				// acabe as�, se vuelva a tirar
				empate = true;
			}
		}
		System.out.println("Comienza sacando el jugador " + players[indiceMaximo].getPlayerName());
		return indiceMaximo;
	}
	
	/**
	 * M�todo para comprobar si un jugador tiene planetas.
	 */
	public void checkIfPlayerHavePlanets() {
		for(int i = 0; i < players.length; i++) {
			for (int x = 0; x < planets.length; x++) {
				if(players[i].getPlayerName() == planets[x].getOwner()) {
					players[i].setHavePlanets(true);
				}
			}
		}
	}
	
	/**
	 * M�todo para resolver el n�mero de jugadores eliminados.
	 * @return
	 */
	public int checkEliminatedPlayers() {
		int eliminatedPlayers = 0;
		
		for (int i = 0; i < players.length; i++) {
			if (!players[i].havePlanets) {
				eliminatedPlayers++;
			}
		}
		
		return eliminatedPlayers;
	}
	
	/**
	 * M�todo para comprobar si el juego ha terminado.
	 * @param eliminatedPlayers
	 * @return
	 */
	public boolean checkFinishedGame(int eliminatedPlayers) {
		boolean finishedGame = false;
		
		if (eliminatedPlayers >= 3) {
			finishedGame = true;
		}
		
		return finishedGame;
	}

	
	/**
	 * M�todo para obtener el nombre de un jugador espec�fico.
	 * @param position - Posici�n del jugador en el array de jugadores.
	 * @return playerName - Devuelve el nombre del jugador.
	 */
	public String getPlayersName(int position) {
		return players[position].getPlayerName();
	}

	/**
	 * M�todo para tirar el dado
	 * @return Devuelve un n�mero aleatorio entre 1 y 6.
	 */
	private static int dado() {
		Random r = new Random();
		return (r.nextInt(6) + 1);
	}

}

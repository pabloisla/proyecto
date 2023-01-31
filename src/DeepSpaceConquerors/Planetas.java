package DeepSpaceConquerors;

/**
 *	Clase Planetas
 */
public class Planetas implements IAttackable{
	
	boolean conquered = false;
	int mines;
	int population = 30;
	int stone = 5;
	int iron = 4;
	int fuel = 2;
	boolean haveProtectiveShield = false;
	EscudoCartas protectiveShield;
	String planetName;
	String playerOwner;
	NaveCartas[] naveCardsArray = new NaveCartas[100];
	ConstructorDeMinasCartas[] mineCardsArray = new ConstructorDeMinasCartas[100];
	
	/**
	 * Constructor de la clase planetas.
	 * @param planetName - Nombre del planeta.
	 */
	public Planetas(String planetName) {
		this.planetName = planetName;
	}
	
	/**
	 * M�todo que devuelve el array de naves.
	 * @return shipsCardsArray - Array de naves.
	 */
	public NaveCartas[] getShipsCardsArray() {
		return naveCardsArray;
	}
	
	/**
	 * M�todo que devuelve una nave espec�fica del array de naves
	 * @param position - Posici�n de la nave en el array.
	 * @return shipsCardsArray - Devuelve la nave.
	 */
	public NaveCartas getShipCard(int position) {
		return naveCardsArray[position];
	}
	
	/**
	 * M�todo para devolver el escudo del planeta.
	 * @return protectiveShield - Escudo protector.
	 */
	public EscudoCartas getShield() {
		return protectiveShield;
	}
	
	/**
	 * M�todo que devuelve una mina en espec�fico del array de minas.
	 * @param position - Posici�n de la mina.
	 * @return mine - Mina.
	 */
	public ConstructorDeMinasCartas getMineCard(int position) {
		return mineCardsArray[position];
	}
	
	/**
	 * M�todo que devuelve el array de minas.
	 * @return mineCardsArray - Array de minas.
	 */
	public ConstructorDeMinasCartas[] getMineCardsArray() {
		return mineCardsArray;
	}
	
	/**
	 * M�todo para cambiar los habitantes de un planeta
	 * @param population - Habitantes del planeta.
	 */
	public void setPopulation(int population) {
		this.population += population;
	}
	
	/**
	 * M�todo para cambiar la cantidad de hierro que hay en un planeta.
	 * @param iron - Hierro
	 */
	public void setIron(int iron) {
		this.iron += iron;
	}
	
	/**
	 * M�todo para cambiar la cantidad de piedra que hay en un planeta.
	 * @param stone - Piedra
	 */
	public void setStone(int stone) {
		this.stone += stone;
	}
	
	/**
	 * M�todo para cambiar la cantidad de combustible que hay en un planeta.
	 * @param fuel - Combustible
	 */
	public void setFuel(int fuel) {
		this.fuel += fuel;
	}
	
	/**
	 * M�todo para a�adir una nave al array de naves del planeta.
	 * @param position - Posici�n en la que vamos a a�adir la nave.
	 * @param ship - Nave.
	 */
	public void setShipCard(int position, NaveCartas ship) {
		this.naveCardsArray[position] = ship;
	}
	
	/**
	 * M�todo para a�adir una mina en el array de minas.
	 * @param position - Posici�n en la que vamos a a�adir la mina.
	 * @param mine - Mina
	 */
	public void setMineCard(int position, ConstructorDeMinasCartas mine) {
		this.mineCardsArray[position] = mine;
	}

	/**
	 * M�todo que devuelve el propietario de un planeta
	 * @return playerOwner - Nombre del jugador propietario del planeta.
	 */
	public String getOwner() {
		return playerOwner;
	}
	
	/**
	 * @param conquered
	 */
	public void setConquered(boolean conquered) {
		this.conquered = conquered;
	}
	
	/**
	 * Devuelve si el planeta est� conquistado o no.
	 * @return conquered - Boolean utilizado para saber si un planeta est� conquistado o no.
	 */
	public boolean getConquered() {
		return conquered;
	}
	
	/**
	 * M�todo para cambiar el propietario de un planeta.
	 * @param owner - Propietario del planeta.
	 */
	public void setOwner(String owner) {
		this.playerOwner = owner;
	}
	
	/**
	 * M�todo que devuelve el nombre del planeta.
	 * @return planetName - Nombre del planeta.
	 */
	public String getName() {
		return planetName;
	}
	
	/**
	 * M�todo para a�adir escudo de protecci�n al planeta.
	 * @param protectiveShield - Escudo protector.
	 */
	public void setProtectiveShield(EscudoCartas protectiveShield) {
		this.protectiveShield = protectiveShield;
	}
	
	/**
	 * Devuelve el escudo protector.
	 * @return
	 */
	public EscudoCartas getProtectiveShield() {
		return protectiveShield;
	}
	
	/**
	 * M�todo para imprimir una cosa u otra en funci�n de si el planeta est� conquistado o no.
	 * @return
	 */
	public String conqueredOrNah() {
		String answer;
		if(conquered) {
			answer = "�Conquistado?: S� \nNombre del propietario: "+playerOwner;
		}
		else {
			answer = "�Conquistado?: No";
		}
		return answer;
	}
	
	@Override
	public String toString() {
		return "\nPlanet: " + "Nombre del planeta: "+ planetName+ "\n" + conqueredOrNah() + "\n"+ "Habitantes: " + population +"\n"+ "Materias primas: "+ "\n" + "Piedra --> " + stone +"\n"+ "Hierro --> " + iron +"\n"+ "Combustible --> " + fuel + "\n"+"Minas: "+ mines+"\n";
	}


	@Override
	public void beAttacked(int attackPoints) {
		protectiveShield.setHealth(attackPoints);
		
	}


	@Override
	public int getDefensePoints() {
		// TODO Auto-generated method stub
		return 0;
	}

}

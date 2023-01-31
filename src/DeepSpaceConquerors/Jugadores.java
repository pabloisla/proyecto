package DeepSpaceConquerors;

/**
 *	Clase para los jugadores
 */
public class Jugadores {
	
	final int GOLD_INI = 3;
	int gold = GOLD_INI;
	String name;
	int points = 10;
	boolean havePlanets = true;
	
	/**
	 * Constructor de la clase jugadores.
	 * @param name - Nombre del jugador.
	 */
	public Jugadores(String name) {
		this.name = name;
	}
	
	/**
	 * Metodo para cambiar el estado de la variable havePlanets.
	 * @param havePlanets
	 */
	public void setHavePlanets(boolean havePlanets) {
		this.havePlanets = false;
	}
	
	/**
	 * Metodo utilizado para imprimir los puntos del jugador
	 * @return points - Puntos del jugador.
	 */
	public int getPoints() {
		return points;
	}
	
	
	/**
	 * Metodo para cambiar la cantidad de puntos del jugador.
	 * @param points - Puntos a sumar.
	 */
	public void setPoints(int points) {
		this.points += points;
	}
	
	/**
	 * Devuelve el nombre del jugador.
	 * @return
	 */
	public String getPlayerName() {
		return name;
	}
	
	/**
	 * Metodo que devuelve el oro del jugador.
	 * @return
	 */
	public int getGold() {
		return gold;
	}
	
	/**
	 * Metodo para cambiar el oro del jugador.
	 * @param gold - Oro.
	 */
	public void setGold(int gold) {
		this.gold += gold;
	}

}

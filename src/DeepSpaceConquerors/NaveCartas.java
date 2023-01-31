package DeepSpaceConquerors;

/**
 *	Clase de las cartas de nave.
 */
public abstract class NaveCartas extends Cartas implements IRepairable, IImprovable, IAttackable {

	
	String name;
	
	/**
	 * Constructor de la clase ShipsCards.
	 * @param price - Precio de la carta de nave.
	 */
	public NaveCartas(int price) {
		super(price);
	}
	
	/**
	 * Cambia el propietario de la nave.
	 * @param name - Nombre del jugador.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Metodo que devuelve el propietario de la nave.
	 * @return name - Nombre del jugador propietario de la nave
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Metodo que devuelve los puntos de defensa de la nave.
	 * @return defensePoints - Puntos de defensa.
	 */
	public int getDefensePoints() {
		return getDefensePoints();
	}
	
	@Override
	public void repairObject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void improveObject() {
		// TODO Auto-generated method stub
		
	}

}

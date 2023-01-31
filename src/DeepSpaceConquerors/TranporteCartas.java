package DeepSpaceConquerors;

/**
 * @author Juanmi
 *	M�todo TransportShipCards
 */
public class TranporteCartas extends NaveCartas implements ITransportable, IAttackable{
	
	int defensePoints = 4;
	int price = 2;
	
	/**
	 * Constructor de la clase TransportShipCards.
	 * @param price - Precio de la nave.
	 */
	public TranporteCartas(int price) {
		super(price);
	}
	
	public String getNme() {
		return name;
	}
	
	@Override
	public void transport(String destiny, int numberOfPeople) {
		
		
	}
	
	/**
	 * M�todo que determina la capacidad de la nave de transporte.
	 * @return capacity - Capacidad de la nave de transporte.
	 */
	public int determinateCapacity() {
		int capacity = 0;
		
		return capacity;
	}

	@Override
	public void beAttacked(int attackPoints) {
		
		defensePoints -= attackPoints;
		
	}

	@Override
	public int getDefensePoints() {
		
		return defensePoints;
	}
}

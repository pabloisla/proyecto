package DeepSpaceConquerors;

/**
 *	Clase de CargoShipCards
 */
public class CargueroCard extends NaveCartas implements ITransportador, IAttackable {
	
	int capacity;
	int defensePoints = 4;
	String name;
	
	/**
	 * Constructor de CargoShipsCards
	 * @param price  - Precio de la carta de nave.
	 */
	public CargueroCard(int price) {
		super(price);
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void transport(String destiny, String[] materials, int[] amountOfMaterials) {
		// TODO Auto-generated method stub
		
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
	
	


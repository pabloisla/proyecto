package DeepSpaceConquerors;

/**
 *	Clase para el escudo protector.
 */
public class EscudoCartas extends ConstructorCartas implements IRepairable, IImprovable {
	
	final int DEFAULT_HEALTH = 20;
	int health;
	int price = 5;
	
	/**
	 * Constructor de la clase ProtectiveShieldCards
	 * @param price - Precio del escudo.
	 * @param variableHealth - Salud del escudo determinada despu�s de tirar los dados.
	 */
	public EscudoCartas(int price, int variableHealth) {
		super(price);
		health = DEFAULT_HEALTH + variableHealth;
	}
	
	/**
	 * M�todo que devuelve la salud del escudo.
	 * @return
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * M�todo que cambia la salud del escudo.
	 * @param attackPoints
	 */
	public void setHealth(int attackPoints) {
		this.health -= attackPoints;
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

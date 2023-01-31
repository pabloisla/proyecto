package DeepSpaceConquerors;

/**
 *	Interfaz que implementan los objetos que pueden atacar.
 */
public interface IAttacker {
	
	/**
	 * Metodo atacar
	 * @param attackable - Objeto que implementa la interfaz atacable
	 */
	public void attack(IAttackable attackable);
	
}

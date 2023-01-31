package DeepSpaceConquerors;

/**
 *	Intefaz implementada en los objetos que son atacables.
 */
public interface IAttackable {
	
	/**
	 * Metodo ser atacado.
	 * @param attackPoints
	 */
	public void beAttacked(int attackPoints);
	
	/**
	 * Metodo que devuelve los puntos de defensa.
	 * @return
	 */
	public int getDefensePoints();
	
}

package DeepSpaceConquerors;

/**
 *	Clase de las cartas de combustible.
 */
public class CombustibleDeMinasCartas extends ConstructorDeMinasCartas {

	/**
	 * Constructor de las cartas de combustible.
	 * @param price - Precio de la carta.
	 * @param minedPerShift - Cantidad de combustible que va a generar por ronda.
	 */
	public CombustibleDeMinasCartas(int price, int minedPerShift) {
		super(price, minedPerShift);
	}

}

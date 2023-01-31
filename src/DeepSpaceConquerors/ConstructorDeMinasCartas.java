package DeepSpaceConquerors;

/**
 *	Clase de cartas de minas.
 */
public class ConstructorDeMinasCartas extends ConstructorCartas {
	
	int price = 1;
	int minedPerShift;
	
	/**
	 * Constructor de cartas de minas.
	 * @param price - Precio de cartas de minas.
	 * @param minedPerShift - Cantidad de minado por cada turno.
	 */
	public ConstructorDeMinasCartas(int price, int minedPerShift) {
		super(price);
		this.minedPerShift = minedPerShift;
	}
	
	/**
	 * Devuelve la cantidad que va a minar por cada ronda
	 * @return
	 */
	public int getMinedPerShift() {
		return minedPerShift;
	}

}

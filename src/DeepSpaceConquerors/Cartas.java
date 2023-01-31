package DeepSpaceConquerors;

/**
 *	Clase de cartas.
 */
public abstract class Cartas {

	private String nombre;
	public int price;
	
	/**
	 * Constructor de la clase Cartas.
	 * @param price - Precio de la carta.
	 */
	public Cartas(int price) {
		this.price = price;
	}

}

package DeepSpaceConquerors;

/**
 *	Clase dado.
 */
public class Dado implements IThrowable{
	
	int diceFaces;
	int diceMinValue;
	int diceMaxValue;
	
	
	/**
	 * Constructor de la clase dado.
	 * @param caraDados - Caras del dado.
	 * @param diceMinValue - Valor maximo del dado.
	 * @param diceMaxValue - Valor maximo del dado.
	 */
	public Dado(int caraDados, int diceMinValue, int diceMaxValue) {
		this.diceFaces = caraDados;
		this.diceMinValue = diceMinValue;
		this.diceMaxValue = diceMaxValue;
	}
	
	public int throwDace() {
		int diceValue = 0;
		
		diceValue = (int) (Math.round((Math.random() * (diceMaxValue - diceMinValue) + diceMinValue)));
		
		return diceValue;
	}
	
	/**
	 * Devuelve el valor m�ximo del dado.
	 * @return diceMaxValue - Valor maximo del dado.
	 */
	public int getMax() {
		return diceMaxValue;
	}
	
	/**
	 * Devuelve el valor m�nimo del dado.
	 * @return diceMinValue - Devuelve m�nimo del dado.
	 */
	public int getMin() {
		return diceMinValue;
	}
	
}

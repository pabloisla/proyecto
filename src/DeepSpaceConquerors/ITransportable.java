package DeepSpaceConquerors;

/**
 *	Interfaz que implementan los objetos que son transportables.
 */
public interface ITransportable {

	/**
	 * M�todo para tranportar.
	 * @param destiny - Destino al que queremos transportar el objeto.
	 * @param numberOfPeople - N�mero de personas
	 */
	public void transport(String destiny, int numberOfPeople);
}

package DeepSpaceConquerors;

/**
 *	Interfaz que implementan los objetos que pueden ser transportador.
 */
public interface ITransportador {
	
	/**
	 * M�todo para tranportar objetos.
	 * @param destiny - Destino.
	 * @param materials - Materiales
	 * @param amountOfMaterials - Array de la cantidad de materiales.
	 */
	public void transport(String destiny, String[] materials, int[] amountOfMaterials);
	
}

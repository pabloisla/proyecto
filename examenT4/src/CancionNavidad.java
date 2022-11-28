package boletin2.examenT4.src;

public class CancionNavidad {

	public static void main(String[] args) {
		String estribillo = "Feliz navidad, Feliz navidad";
		
		StringBuilder cancion = new StringBuilder(estribillo);
		
		cancion.append("\nEl módulo de programación quiero aprobar."
				+ "A mi profesor favorito tendré que sobornar."
				+ "Jamón y gambas tendré que comprar."
				+ "Porque si no me tocará pringar."
				+ "Y el año que viene el doble tendré que pagar.");
		
		int posPunto = 0;
		while (cancion.indexOf(".", posPunto) != -1) {
			posPunto = cancion.indexOf(".", posPunto) + 1;
			cancion.insert(posPunto, "\n" + estribillo + "\n");
		}
		
		System.out.println(cancion.toString());

	}

}

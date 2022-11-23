package Rectan;

import java.util.Scanner;

public class Rectangulo {

	private int longitud;
	private int anchura;

	public Rectangulo(int longitud, int anchura) {
		this.setAnchura(anchura);
		this.setLongitud(longitud);
	}

	public void setLongitud(int longitud) {
		if (longitud > 0 && longitud < 20) {
			this.longitud = longitud;
		}
	}

	public void setAnchura(int anchura) {
		if (anchura > 0 && anchura <= 20) {
			this.anchura = anchura;
		}
	}

	public static void main(String[] args) {// Imprime por pantalla todo aquello que este dentro
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce la longitud");
		int longitud = Integer.parseInt(sc.nextLine());
		System.out.print("Introduce la anchura");
		int anchura = Integer.parseInt(sc.nextLine());

		Rectangulo r = new Rectangulo(longitud, anchura);
		System.out.println(r.perimetro());
	}

	public int getAnchura() {
		return anchura;
	}

	public int perimetro() {
		return 2 * this.anchura + 2 * this.longitud;
	}

	public int area() {
		return this.anchura * this.longitud;

	}
}

package Repaso;

public class ej9 {

	public static final int x = 6;
	
	public static void main(String[] args) {
		for (int i = 0;i<=x;i++) {
			for (int j = 0; j < i + 1;j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}

}

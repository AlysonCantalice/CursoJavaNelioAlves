package introducao_prog_orientada_obj;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int quantia = sc.nextInt();
		int valores[] = { 100, 50, 20, 10, 5, 2, 1 };
		int notas;

		if (quantia > 0 && quantia < 1000000) {
			System.out.println(quantia);
			for (int i = 0; valores.length > i; i++) {
				notas = (int) (quantia / valores[i]);
				System.out.println(notas + " nota(s) de R$ " + valores[i] + ",00");
				quantia -= notas * valores[i];
			}
		}
		sc.close();
	}

}

package application;

import java.util.Scanner;

public class ExercicioMatriz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Número de linhas: ");
		int n = sc.nextInt();
		System.out.print("Número de colunas: ");
		int m = sc.nextInt();

		int[][] mat = new int[n][m];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		System.out.print("Número a ser analisado: ");
		int na = sc.nextInt();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == na) {
					System.out.println("Posição " + i + "," + j + ":");
					if ((j - 1) >= 0) {
						System.out.println("Left: " + mat[i][j - 1]);
					}
					if ((j + 1) <= (mat[i].length - 1)) {
						System.out.println("Right: " + mat[i][j + 1]);
					}
					if ((i - 1) >= 0) {
						System.out.println("Up: " + mat[i - 1][j]);
					}
					if ((i + 1) <= (mat.length - 1)) {
						System.out.println("Down: " + mat[i + 1][j]);
					}
				}

			}
		}

		sc.close();

	}

}

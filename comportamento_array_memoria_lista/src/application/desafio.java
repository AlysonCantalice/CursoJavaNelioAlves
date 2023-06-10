package application;

import java.util.Scanner;

import entities.Aluguel;

public class desafio {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();
		while (n < 0 && n > 10) {
			System.out.print("Invalid! Choose up to 10 rooms: ");
			n = sc.nextInt();
		}
		Aluguel[] vect = new Aluguel[10];
		for (int i = 0; i < 10; i++) {
			vect[i] = new Aluguel();
		}
		
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.printf("%nRent #%d%n", (i + 1));
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int room = sc.nextInt();
			vect[room] = new Aluguel(name, email, room);
		}

		System.out.printf("%nBusy rooms:%n");
		for (int i = 0; i < vect.length; i++) {
			if (vect[i].getRoom() != 0) {
				System.out.println(i + ": " + vect[i].toString());
			}
		}

		sc.close();
	}

}

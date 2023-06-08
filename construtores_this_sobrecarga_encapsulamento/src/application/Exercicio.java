package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Exercicio {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter account number: ");
		int accountNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter account holder: ");
		String name = sc.nextLine();

		System.out.print("Is there an initial deposit (y/n)? ");
		char answer = sc.next().charAt(0);
		
		while ((answer != 'y') && (answer != 'n')) {
			System.out.print("Entrada inválida! Tente novamente: ");
			answer = sc.next().charAt(0);
		}
		
		double deposit = 0;
		if (answer == 'y') {
			System.out.print("Enter initial deposit value: ");
			deposit = sc.nextDouble();
		}

		Account account = new Account(accountNumber, name, deposit);

		System.out.printf("%nAccount data:%n");
		System.out.printf("Account %d, Holder: %s, Balance: $ %.2f%n", account.getAccountNumber(), account.getName(),
				account.getBalance());

		System.out.printf("%nEnter a deposit value: ");
		deposit = sc.nextDouble();
		account.Deposit(deposit);
		
		System.out.printf("Updated account data:%n");
		System.out.printf("Account %d, Holder: %s, Balance: $ %.2f%n", account.getAccountNumber(), account.getName(),
				account.getBalance());

		System.out.printf("%nEnter a withdraw value: ");
		double withdraw = sc.nextDouble();
		account.Withdraw(withdraw);
		
		System.out.printf("Updated account data:%n");
		System.out.printf("Account %d, Holder: %s, Balance: $ %.2f%n", account.getAccountNumber(), account.getName(),
				account.getBalance());

		sc.close();
	}

}

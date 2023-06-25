package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Pessoa> pessoaList = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if (type == 'c') {
				System.out.print("Number of employees: ");
				int employeeCount = sc.nextInt();
				pessoaList.add(new PessoaJuridica(name, anualIncome, employeeCount));
			} else {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				pessoaList.add(new PessoaFisica(name, anualIncome, healthExpenditures));
			}
			
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		double sum = 0;
		for (Pessoa x: pessoaList) {
			System.out.println(x.getName() + ": $ " + String.format("%.2f", x.taxes()) );
			sum += x.taxes();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f%n", sum);
		sc.close();

	}

}

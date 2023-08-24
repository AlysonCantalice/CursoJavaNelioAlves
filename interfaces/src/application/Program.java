package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installments;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
		System.out.print("Valor do contrato: ");
		Double totalValue = sc.nextDouble();
		System.out.print("Entre com o numero de parcelas: ");
		int months = sc.nextInt();
		
		Contract contract = new Contract(number, date, totalValue);
		ContractService service = new ContractService();
		service.processContract(contract, months, new PaypalService());
		
		System.out.println("Parcelas:");
		List<Installments> installments = contract.getInstallments();
		for (Installments installment : installments) {
			System.out.println(installment);
		}
		
		sc.close();

	}

}

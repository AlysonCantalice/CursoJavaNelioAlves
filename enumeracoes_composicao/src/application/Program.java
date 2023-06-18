package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(level), baseSalary, new Department(departmentName));

		System.out.print("How many contracts to this worker? ");
		int nContracts = sc.nextInt();

		for (int i = 0; i < nContracts; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			sc.nextLine();
			String date = sc.nextLine();
			LocalDate time = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(time, valuePerHour, hours);
			worker.addContract(contract);
		}

		System.out.printf("%nEnter month and year to calculate income (MM/YYYY): ");
		sc.nextLine();
		String date = sc.nextLine();
		int year = Integer.parseInt(date.substring(3));
		int month = Integer.parseInt(date.substring(0, 2));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + date + ": " + String.format("%.2f", worker.income(year, month)));
		sc.close();

	}

}

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employees;

public class ExercicioLista {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();

		List<Employees> employeeList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.printf("%nEmployee #%d:%n", (i + 1));
			System.out.print("Id: ");
			int id = sc.nextInt();
			while (idCheck(employeeList, id) == true) {
				System.out.print("ID already taken! try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			Employees employee = new Employees(id, name, salary);
			employeeList.add(employee);
		}

		System.out.printf("%nEnter the employee ID that will have salary increase: ");
		int id = sc.nextInt();
		Boolean resID = false;

		for (Employees x : employeeList) {
			if (x.getId() == id) {
				resID = true;
				System.out.print("Enter the percentage: ");
				double porcento = sc.nextDouble();
				x.increaseSalary(porcento);
			}
		}

		if (resID == false) {
			System.out.println("This ID does not exist!");
		}

		System.out.printf("%nList of employees:%n");
		for (Employees x : employeeList) {
			System.out.println(x.toString());
		}

		sc.close();
	}

	public static Boolean idCheck(List<Employees> list, int id) {
		Boolean temp = false;
		for (Employees x : list) {
			if (id == x.getId()) {
				temp = true;
			}
		}
		return temp;
	}
}
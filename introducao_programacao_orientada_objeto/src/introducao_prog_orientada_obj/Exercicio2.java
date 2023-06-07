package introducao_prog_orientada_obj;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Exercicio2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Employee employee = new Employee();
		System.out.print("Name: ");
		employee.name = sc.nextLine();
		System.out.print("Gross salary: ");
		employee.grossSalary = sc.nextDouble();
		System.out.print("Tax: ");
		employee.tax = sc.nextDouble();
		
		System.out.printf("%nEmployee: %s, $ %.2f%n%n",employee.name, employee.NetSalary());
		System.out.print("Which percentage to increase salary? ");
		double raise = sc.nextDouble();
		employee.IncreaseSalary(raise);
		
		System.out.printf("%nUpdated data: %s, $ %.2f%n%n",employee.name, employee.NetSalary());
		
		sc.close();

	}

}

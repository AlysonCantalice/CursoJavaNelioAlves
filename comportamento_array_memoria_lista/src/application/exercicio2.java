package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;

public class exercicio2 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas pessoas serão digitadas? ");
		int n = sc.nextInt();
		
		Pessoa[] vect = new Pessoa[n];
		
		for (int i=0; i<vect.length; i++) {
			sc.nextLine();
			System.out.printf("Dados da %da pessoa:%n",i+1);
			System.out.print("Nome: ");
			String name = sc.nextLine();
			System.out.print("Idade: ");
			int age = sc.nextInt();
			System.out.print("Altura: ");
			double height = sc.nextDouble();
			vect[i] = new Pessoa(name, age, height);
		}
		
		double sum = 0.0;
		int under16 = 0;
		for (int i=0; i<vect.length; i++) {
			sum += vect[i].getHeight();
			if (vect[i].getAge() < 16) {
				under16++;
			}
		}
		
		double avg = sum / vect.length;
		System.out.printf("Altura média: %.2f%n",avg);
		double porcento = under16*100/vect.length;
		System.out.printf("Pessoas com menos de 16 anos: %.2f%%%n",porcento);
		for(int i=0; i<vect.length; i++) {
			if (vect[i].getAge() < 16) {
				System.out.println(vect[i].getName());
			}
		}
		sc.close();

	}

}

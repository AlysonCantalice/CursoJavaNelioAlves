package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import entities.Student;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Set<Student> teacher = new HashSet<>();
		List<String> courses = new ArrayList<>();

		courses.add("A");
		courses.add("B");
		courses.add("C");

		for (int i = 0; i < courses.size(); i++) {
			System.out.print("How many students for course " + courses.get(i) + "? ");
			int students = sc.nextInt();
			for (int j = 0; j < students; j++) {
				teacher.add(new Student(sc.nextInt()));
			}
		}
		System.out.println("Total students: " + teacher.size());

		sc.close();
	}

}

package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkin = LocalDate.parse(sc.nextLine(), fmt1);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkout = LocalDate.parse(sc.nextLine(), fmt1);

			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println();

			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(sc.nextLine(), fmt1);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(sc.nextLine(), fmt1);

			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		} catch (java.time.format.DateTimeParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainExceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
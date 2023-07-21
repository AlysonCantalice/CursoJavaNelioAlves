package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkin = LocalDate.parse(sc.nextLine(), fmt1);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkout = LocalDate.parse(sc.nextLine(), fmt1);

		if (checkout.isBefore(LocalDate.now()) || checkin.isBefore(LocalDate.now())) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates");
		} else if (checkout.isBefore(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(sc.nextLine(), fmt1);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(sc.nextLine(), fmt1);
			
			String error = reservation.updateDates(checkin, checkout);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}
		}
		sc.close();
	}

}
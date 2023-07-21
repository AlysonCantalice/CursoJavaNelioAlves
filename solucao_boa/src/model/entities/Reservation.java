package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exception.DomainExceptions;

public class Reservation {
	public Integer roomNumber;
	public LocalDate checkin;
	public LocalDate checkout;

	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		if (checkout.isBefore(LocalDate.now()) || checkin.isBefore(LocalDate.now())) {
			throw new DomainExceptions("Reservation dates for update must be future dates");
		}
		if (checkout.isBefore(checkin)) {
			throw new DomainExceptions("Check-out date must be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}
	
	public Integer duration() {
		long diff = ChronoUnit.DAYS.between(checkin, checkout);
		return (int)diff;
	}
	
	public void updateDates(LocalDate checkin, LocalDate checkout) {
		if (checkout.isBefore(LocalDate.now()) || checkin.isBefore(LocalDate.now())) {
			throw new DomainExceptions("Reservation dates for update must be future dates");
		}
		if (checkout.isBefore(checkin)) {
			throw new DomainExceptions("Check-out date must be after check-in date");
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ checkin.format(fmt1)
				+ ", check-out: "
				+ checkout.format(fmt1)
				+ ", "
				+ duration()
				+ " nights";
	}
}

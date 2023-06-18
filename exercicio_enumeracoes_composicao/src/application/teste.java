package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class teste {

	public static void main(String[] args) {
		String nasc = "11/10/2020";
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
		LocalDate data2 = LocalDate.parse(nasc, fmt1);
		System.out.println(data.format(fmt2));
		System.out.println(data);
		System.out.println(data2.format(fmt1));
	}

}

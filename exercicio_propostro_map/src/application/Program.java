package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Map<String, Integer> votes = new HashMap<>();

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file full path: ");
		String strPath = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				if (!votes.containsKey(fields[0])) {
					votes.put(fields[0], Integer.parseInt(fields[1]));
				} else {
					votes.put(fields[0], votes.get(fields[0]) + Integer.parseInt(fields[1]));
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		for (String key : votes.keySet()) {
			System.out.println(key + ": " + votes.get(key));
		}

		sc.close();
	}

}

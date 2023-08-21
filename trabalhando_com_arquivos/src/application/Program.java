package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		String path = "c:\\temp\\source.csv";
		String parentPath = "c:\\temp";
		String targetPath = parentPath + "\\out";
		Locale.setDefault(Locale.US);
		
		List<Product> products = new ArrayList<>();
		boolean success = new File(targetPath).mkdir();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] item = line.split(",");
				products.add(new Product(item[0],Double.parseDouble(item[1]),Integer.parseInt(item[2])));
				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath + "\\summary.csv"))) {
			for (Product product : products) {
				bw.write(product.getName() + "," + product.totalPrice());
				bw.newLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
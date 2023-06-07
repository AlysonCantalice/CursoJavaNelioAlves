package entities;

public class CurrencyConverter {
	public static double UStoBRL (double price, double quantity) {
		return (price * quantity * 1.06);
	}
}

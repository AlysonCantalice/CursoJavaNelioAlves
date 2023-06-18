package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private LocalDateTime moment;
	private OrderStatus status;

	private Client client;
	
	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
	List<OrderItem> orders = new ArrayList<>();

	public Order(LocalDateTime data, OrderStatus status, Client client) {
		this.moment = data;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public void addItem(OrderItem item) {
		orders.add(item);
	}

	public void removeItem(OrderItem item) {
		orders.remove(item);
	}

	public double total() {
		double sum = 0;
		for(OrderItem c : orders) {
			sum += c.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + moment.format(fmt2) + "\n");
		sb.append("Order status: " + status.toString() + "\n");
		sb.append(client + "\n");
		sb.append("Order items: ");
		for (OrderItem c : orders) {
			sb.append(c + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()) + "\n");
		return sb.toString();
	}
}

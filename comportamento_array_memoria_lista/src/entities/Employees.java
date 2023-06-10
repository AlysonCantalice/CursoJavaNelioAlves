package entities;

public class Employees {
	public int id;
	public String name;
	public double salary;

	public Employees(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void increaseSalary(double porcento) {
		salary *= porcento / 100 + 1;
	}

	public String toString() {
		return String.format("%d, %s, %.2f", id, name, salary);
	}
}

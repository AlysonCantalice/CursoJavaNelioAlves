package entities;

public final class PessoaJuridica extends Pessoa{
	private int employeeCount;

	public PessoaJuridica() {
	}
	
	public PessoaJuridica(String name, double anualIncome, int employeeCount) {
		super(name, anualIncome);
		this.employeeCount = employeeCount;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	
	@Override
	public double taxes() {
		double taxes = 0;
		if (employeeCount > 10) {
			taxes = anualIncome * 0.14;
		} else {
			taxes = anualIncome * 0.16;
		}
		return taxes;
	}
}

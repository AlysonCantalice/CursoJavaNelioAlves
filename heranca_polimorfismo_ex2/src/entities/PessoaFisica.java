package entities;

public final class PessoaFisica extends Pessoa {
	private double healthExpenditures;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String name, double anualIncome, double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double taxes() {
		double taxes = 0;
		if (anualIncome < 20000.00) {
			taxes = anualIncome * 0.15 - healthExpenditures * 0.5;
		} else {
			taxes = anualIncome * 0.25 - healthExpenditures * 0.5;
		}
		return taxes;
	}

}

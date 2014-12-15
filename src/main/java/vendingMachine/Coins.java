package vendingMachine;

public enum Coins {
	NICKEL(.05), DIME(.10), QUARTER(.25);

	private double value;

	private Coins(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}
}

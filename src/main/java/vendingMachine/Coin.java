package vendingMachine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public enum Coin {
	NICKEL(new BigDecimal(.05), 5, 21), DIME(new BigDecimal(.10), 2.2, 18), QUARTER(
			new BigDecimal(.25), 5.6, 24);

	private BigDecimal monetaryValue;
	private double weightInGrams;
	private int diameterInMillimeters;

	private Coin(BigDecimal monetaryValue, double weightInGrams,
			int diameterInMillimeters) {
		this.monetaryValue = monetaryValue.setScale(2, RoundingMode.DOWN);
		this.weightInGrams = weightInGrams;
		this.diameterInMillimeters = diameterInMillimeters;
	}

	public BigDecimal getMonetaryValue() {
		return this.monetaryValue;
	}

	public double getWeightInGrams() {
		return this.weightInGrams;
	}

	public int getDiameterInMillimeters() {
		return this.diameterInMillimeters;
	}

	// for simplicity's sake, assuming that there is no variation in the
	// weight or diameter of these coins
	public static Coin determineCoin(double weight, int diameter) {
		List<Coin> coins = Arrays.asList(Coin.values());
		for (Coin coin : coins) {
			if (coin.weightInGrams == weight
					&& coin.diameterInMillimeters == diameter) {
				return coin;
			}
		}
		return null;
	}
}

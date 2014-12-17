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

	public static String displayCoinWeightInformation() {
		StringBuffer displayString = new StringBuffer();
		displayString.append("Nickel weight: " + NICKEL.weightInGrams + "\n");
		displayString.append("Dime weight: " + DIME.weightInGrams + "\n");
		displayString.append("Quarter weight: " + QUARTER.weightInGrams + "\n");
		return displayString.toString();
	}

	public static String displayCoinDiameterInformation() {
		StringBuffer displayString = new StringBuffer();
		displayString.append("Nickel diameter: " + NICKEL.diameterInMillimeters
				+ "\n");
		displayString.append("Dime diameter: " + DIME.diameterInMillimeters
				+ "\n");
		displayString.append("Quarter diameter: "
				+ QUARTER.diameterInMillimeters + "\n");
		return displayString.toString();
	}

	// for simplicities sake, assuming that there is no variation in the
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

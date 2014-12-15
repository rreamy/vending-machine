package vendingMachine;

import java.util.Arrays;
import java.util.List;

public enum Coin {
	NICKEL(.05, 5, 21), DIME(.10, 2.2, 18), QUARTER(.25, 5.6, 24);

	private double monetaryValue;
	private double weightInGrams;
	private int diameterInMillimeters;

	private Coin(double monetaryValue, double weightInGrams,
			int diameterInMillimeters) {
		this.monetaryValue = monetaryValue;
		this.weightInGrams = weightInGrams;
		this.diameterInMillimeters = diameterInMillimeters;
	}

	public double getMonetaryValue() {
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

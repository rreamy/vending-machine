package vendingMachine;

import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		while (true) {
			System.out.println(vendingMachine.getDisplay());
			vendingMachine.handleCoins();
		}
	}

	public String getDisplay() {
		return "INSERT COIN";
	}

	private void handleCoins() {
		Scanner inputReader = new Scanner(System.in);
		System.out.println(Coin.displayCoinWeightInformation());
		System.out.println("Enter coin weight: ");
		double coinWeight = inputReader.nextDouble();

		System.out.println(Coin.displayCoinDiameterInformation());
		System.out.println("Enter coin diameter:");
		int coinDiameter = inputReader.nextInt();

		Coin coin = Coin.determineCoin(coinWeight, coinDiameter);
		if (coin == null) {
			System.err.println("Coin returned.");
		}
		// we add the value to the total and then we will display the new total
	}
}
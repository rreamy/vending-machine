package vendingMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class VendingMachine {

	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		while (true) {
			try {
				System.out.println(vendingMachine.getDisplay());
				vendingMachine.handleCoins();
			} catch (IOException error) {
				System.err.println("OUT OF ORDER");
			}
		}
	}

	private BigDecimal total;

	protected VendingMachine() {
		total = new BigDecimal(0);
	}

	public String getDisplay() {
		if (total.equals(BigDecimal.ZERO)) {
			return "INSERT COIN";
		}
		total = total.setScale(2, RoundingMode.DOWN);
		return String.valueOf(total);
	}

	private void handleCoins() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			System.out.println(Coin.displayCoinWeightInformation());
			System.out.println("Enter coin weight: ");
			double coinWeight = Double.valueOf(input.readLine());

			System.out.println(Coin.displayCoinDiameterInformation());
			System.out.println("Enter coin diameter:");
			int coinDiameter = Integer.valueOf(input.readLine());

			Coin coin = Coin.determineCoin(coinWeight, coinDiameter);
			if (coin == null) {
				System.err.println("Coin returned.");
			} else {
				coinAccepted(coin);
			}
		} catch (NumberFormatException e) {
			System.err.println("Invalid weight, please try again:\n");
			input.close();
			handleCoins();
		}

	}

	protected void coinAccepted(Coin coin) {
		this.total = total.add(coin.getMonetaryValue());
	}
}
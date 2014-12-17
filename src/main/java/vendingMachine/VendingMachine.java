package vendingMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class VendingMachine {

	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		while (true) {
			try {
				BufferedReader input = new BufferedReader(
						new InputStreamReader(System.in));
				System.out.println("Select option\n");
				System.out.println("1) Insert coins\n");
				System.out.println("2) Select product\n");
				String selection = input.readLine();
				if (selection.equals("1")) {
					System.out.println(vendingMachine.getDisplay());
					vendingMachine.handleCoins(input);
				} else {
					System.out.println(vendingMachine.displayProducts());
				}
			} catch (IOException error) {
				System.err.println("OUT OF ORDER");
			}
		}
	}

	private String displayProducts() {
		return null;
	}

	private BigDecimal total;

	protected VendingMachine() {
		total = new BigDecimal(0);
	}

	public String getDisplay() {
		if (total.equals(BigDecimal.ZERO)) {
			return "INSERT COIN";
		}
		return String.valueOf(total);
	}

	private void handleCoins(BufferedReader input) throws IOException {
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
			handleCoins(input);
		}

	}

	protected void coinAccepted(Coin coin) {
		this.total = total.add(coin.getMonetaryValue());
	}
}
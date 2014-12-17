package vendingMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class VendingMachine {

	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		Display display = new Display();
		while (true) {
			try {
				BufferedReader input = new BufferedReader(
						new InputStreamReader(System.in));
				System.out.println(display.vendingMachineOptionsMessage());
				String selection = input.readLine();
				if (selection.equals("1")) {
					vendingMachine.handleCoins(input, display);
				} else {
					System.out.println(display.productDisplayMessage());
				}
			} catch (IOException error) {
				System.err.println("OUT OF ORDER");
			}
		}
	}

	private BigDecimal total;

	protected VendingMachine() {
		total = new BigDecimal(0).setScale(2, RoundingMode.DOWN);
	}

	public void handleCoins(BufferedReader input, Display display)
			throws IOException {
		display.displayTotal(total);
		try {
			System.out.println(display.enterWeightMessage());
			double coinWeight = Double.valueOf(input.readLine());

			System.out.println(display.enterDiameterMessage());
			int coinDiameter = Integer.valueOf(input.readLine());

			Coin coin = Coin.determineCoin(coinWeight, coinDiameter);
			if (coin == null) {
				System.err.println(display.coinReturnedMessage());
			} else {
				coinAccepted(coin);
			}
		} catch (NumberFormatException e) {
			System.err.println(display.invalidCoinInformationMessage());
			input.close();
			handleCoins(input, display);
		}

	}

	protected void coinAccepted(Coin coin) {
		this.total = total.add(coin.getMonetaryValue());
	}
}
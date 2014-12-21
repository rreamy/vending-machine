package vendingMachine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Display {

	public String productDisplayMessage() {
		StringBuilder productsDisplay = new StringBuilder();
		productsDisplay.append("Select product:\n");
		List<Product> products = Arrays.asList(Product.values());
		for (Product product : products) {
			productsDisplay.append(product.getSelectionNumber());
			productsDisplay.append(")");
			productsDisplay.append(product.getProductName());
			productsDisplay.append(":\t$");
			productsDisplay.append(product.getPrice());
			productsDisplay.append("\n");
		}
		return productsDisplay.toString();
	}

	public String vendingMachineOptionsMessage() {
		StringBuilder display = new StringBuilder();
		display.append("Select option:\n");
		display.append("1) Insert coins\n");
		display.append("2) Select product\n");
		return display.toString();
	}

	public String enterWeightMessage() {
		StringBuilder displayString = new StringBuilder();
		displayString.append("Nickel weight: ");
		displayString.append(Coin.NICKEL.getWeightInGrams());
		displayString.append("\n");
		displayString.append("Dime weight: ");
		displayString.append(Coin.DIME.getWeightInGrams());
		displayString.append("\n");
		displayString.append("Quarter weight: ");
		displayString.append(Coin.QUARTER.getWeightInGrams());
		displayString.append("\n");
		displayString.append("Enter coin weight:\n");
		return displayString.toString();
	}

	public String enterDiameterMessage() {
		StringBuilder displayString = new StringBuilder();
		displayString.append("Nickel diameter: ");
		displayString.append(Coin.NICKEL.getDiameterInMillimeters());
		displayString.append("\n");
		displayString.append("Dime diameter: ");
		displayString.append(Coin.DIME.getDiameterInMillimeters());
		displayString.append("\n");
		displayString.append("Quarter diameter: ");
		displayString.append(Coin.QUARTER.getDiameterInMillimeters());
		displayString.append("\n");
		displayString.append("Enter coin diameter:\n");
		return displayString.toString();
	}

	public String coinReturnedMessage() {
		return "Coin returned.\n";
	}

	public String invalidCoinInformationMessage() {
		return "Invalid value, please try again:\n";
	}

	public String displayTotal(BigDecimal total) {
		if (total.equals(BigDecimal.ZERO)) {
			return "INSERT COIN";
		}
		String totalString = String.valueOf(total);
		return "$" + totalString;
	}

	public String dispenseProductMessage(Product product) {
		StringBuilder displayString = new StringBuilder();
		displayString.append(product.getProductName());
		displayString.append(" dispensed\n");
		displayString.append("THANK YOU\n");
		return displayString.toString();
	}

	public String displayPrice(Product product) {
		return "PRICE $" + product.getPrice() + "\n";
	}
}

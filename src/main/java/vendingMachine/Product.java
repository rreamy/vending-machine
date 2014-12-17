package vendingMachine;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Product {

	COLA("Cola", new BigDecimal(1.00), 1), CHIPS("Chips", new BigDecimal(.5), 2), CANDY(
			"Candy", new BigDecimal(.65), 3);

	private String productName;
	private BigDecimal price;
	private int selection;

	private Product(String productName, BigDecimal price, int selection) {
		this.productName = productName;
		this.selection = selection;
		this.price = price.setScale(2, RoundingMode.DOWN);
	}

	public String getProductName() {
		return this.productName;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public int getSelectionNumber() {
		return this.selection;
	}

	public static Product getProductBySelectionNumber(int selection) {
		for (Product product : Product.values()) {
			if (selection == product.getSelectionNumber()) {
				return product;
			}
		}
		return null;
	}
}

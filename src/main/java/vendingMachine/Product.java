package vendingMachine;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Product {

	COLA("Cola", new BigDecimal(1.00)), CHIPS("Chips", new BigDecimal(.5)), CANDY(
			"Candy", new BigDecimal(.65));

	private String productName;
	private BigDecimal price;

	private Product(String productName, BigDecimal price) {
		this.productName = productName;
		this.price = price.setScale(2, RoundingMode.DOWN);
	}

	public String getProductName() {
		return this.productName;
	}

	public BigDecimal getPrice() {
		return this.price;
	}
}

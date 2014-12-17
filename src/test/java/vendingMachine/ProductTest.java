package vendingMachine;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import org.junit.Test;

public class ProductTest {

	@Test
	public void testValues() {
		assertEquals(3, Product.values().length);
		assertEquals(Arrays.asList(Product.COLA, Product.CHIPS, Product.CANDY),
				Arrays.asList(Product.values()));
	}

	@Test
	public void testGetName() throws Exception {
		assertEquals("Cola", Product.COLA.getProductName());
		assertEquals("Candy", Product.CANDY.getProductName());
		assertEquals("Chips", Product.CHIPS.getProductName());
	}

	@Test
	public void testGetPrice() throws Exception {
		assertEquals(new BigDecimal(1.00).setScale(2, RoundingMode.DOWN),
				Product.COLA.getPrice());
		assertEquals(new BigDecimal(.50).setScale(2, RoundingMode.DOWN),
				Product.CHIPS.getPrice());
		assertEquals(new BigDecimal(.65).setScale(2, RoundingMode.DOWN),
				Product.CANDY.getPrice());
	}

	@Test
	public void testGetSelectionNumber() throws Exception {
		assertEquals(1, Product.COLA.getSelectionNumber());
		assertEquals(2, Product.CHIPS.getSelectionNumber());
		assertEquals(3, Product.CANDY.getSelectionNumber());
	}

	@Test
	public void testGetProductBySelectionNumber() throws Exception {
		assertEquals(Product.COLA, Product.getProductBySelectionNumber(1));
		assertEquals(Product.CHIPS, Product.getProductBySelectionNumber(2));
		assertEquals(Product.CANDY, Product.getProductBySelectionNumber(3));
		assertEquals(null, Product.getProductBySelectionNumber(44));
	}

}

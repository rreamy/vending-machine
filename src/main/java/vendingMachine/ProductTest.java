package vendingMachine;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

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

}

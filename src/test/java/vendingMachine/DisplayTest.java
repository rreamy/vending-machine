package vendingMachine;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DisplayTest {

	private Display display;

	@Before
	public void setUp() throws Exception {
		display = new Display();
	}

	@After
	public void tearDown() throws Exception {
		display = null;
	}

	@Test
	public void testProductDisplayMessage() {
		assertEquals(
				"Select product:\n1)Cola:\t$1.00\n2)Chips:\t$0.50\n3)Candy:\t$0.65\n",
				display.productDisplayMessage());
	}

	@Test
	public void testVendingMachineOptionsMessage() throws Exception {
		assertEquals("Select option:\n1) Insert coins\n2) Select product\n",
				display.vendingMachineOptionsMessage());
	}

	@Test
	public void testDisplayTotal_whenNoCoinsInserted() {
		assertEquals("INSERT COIN", display.displayTotal(BigDecimal.ZERO));
	}

	@Test
	public void testDisplayTotal_whenCoinsInserted() throws Exception {
		assertEquals("$0.05", display.displayTotal(new BigDecimal(".05")));
		assertEquals("$0.15", display.displayTotal(new BigDecimal(".15")));
		assertEquals("$0.40", display.displayTotal(new BigDecimal(".40")));
	}

	@Test
	public void testEnterWeightMessage() throws Exception {
		assertEquals(
				"Nickel weight: 5.0\nDime weight: 2.2\nQuarter weight: 5.6\nEnter coin weight:\n",
				display.enterWeightMessage());
	}

	@Test
	public void testEnterDiameterMessage() throws Exception {
		assertEquals(
				"Nickel diameter: 21\nDime diameter: 18\nQuarter diameter: 24\nEnter coin diameter:\n",
				display.enterDiameterMessage());
	}

	@Test
	public void testCoinReturnedMessage() throws Exception {
		assertEquals("Coin returned.\n", display.coinReturnedMessage());
	}

	@Test
	public void testInvalidCoinInformationMessage() throws Exception {
		assertEquals("Invalid value, please try again:\n",
				display.invalidCoinInformationMessage());
	}

	@Test
	public void testDispenseProductMessage() throws Exception {
		assertEquals("Cola dispensed\nTHANK YOU\n",
				display.dispenseProductMessage(Product.COLA));
		assertEquals("Chips dispensed\nTHANK YOU\n",
				display.dispenseProductMessage(Product.CHIPS));
		assertEquals("Candy dispensed\nTHANK YOU\n",
				display.dispenseProductMessage(Product.CANDY));
	}

	@Test
	public void testDisplayPrice() throws Exception {
		assertEquals("PRICE $1.00\n", display.displayPrice(Product.COLA));
		assertEquals("PRICE $0.50\n", display.displayPrice(Product.CHIPS));
		assertEquals("PRICE $0.65\n", display.displayPrice(Product.CANDY));
	}
}

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
	public void testDisplayProducts() {
		assertEquals(
				"Select product:\n1)Cola:\t$1.00\n2)Chips:\t$0.50\n3)Candy:\t$0.65\n",
				display.displayProducts());
	}

	@Test
	public void testDisplayVendingMachineOptions() throws Exception {
		assertEquals("Select option:\n1) Insert coins\n2) Select product\n",
				display.displayVendingMachineOptions());
	}

	@Test
	public void testGetDisplay_whenNoCoinsInserted() {
		assertEquals("INSERT COIN", display.displayTotal(BigDecimal.ZERO));
	}

	@Test
	public void testGetDisplay_whenCoinsInserted() throws Exception {
		assertEquals("$0.05", display.displayTotal(new BigDecimal(".05")));
		assertEquals("$0.15", display.displayTotal(new BigDecimal(".15")));
		assertEquals("$0.40", display.displayTotal(new BigDecimal(".40")));
	}

	@Test
	public void testDisplayEnterWeightMessage() throws Exception {
		assertEquals(
				"Nickel weight: 5.0\nDime weight: 2.2\nQuarter weight: 5.6\nEnter coin weight:\n",
				display.displayEnterWeightMessage());
	}

	@Test
	public void testDisplayEnterDiameterMessage() throws Exception {
		assertEquals(
				"Nickel diameter: 21\nDime diameter: 18\nQuarter diameter: 24\nEnter coin diameter:\n",
				display.displayEnterDiameterMessage());
	}
}

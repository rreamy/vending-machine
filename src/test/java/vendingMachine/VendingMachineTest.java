package vendingMachine;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	private VendingMachine vendingMachine;

	@Before
	public void setUp() throws Exception {
		vendingMachine = new VendingMachine();
	}

	@After
	public void tearDown() throws Exception {
		vendingMachine = null;
	}

	@Test
	public void testGetDisplay_whenNoCoinsInserted() {
		assertEquals("INSERT COIN", vendingMachine.getDisplay());
	}

	@Test
	public void testGetDisplay_whenCoinsInserted() throws Exception {
		vendingMachine.coinAccepted(Coin.NICKEL);
		assertEquals("0.05", vendingMachine.getDisplay());
		vendingMachine.coinAccepted(Coin.DIME);
		assertEquals("0.15", vendingMachine.getDisplay());
		vendingMachine.coinAccepted(Coin.QUARTER);
		assertEquals("0.40", vendingMachine.getDisplay());
	}
}

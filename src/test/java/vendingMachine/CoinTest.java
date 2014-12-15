package vendingMachine;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoinTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValues() {
		assertEquals(3, Coin.values().length);
		Coin[] values = Coin.values();
		assertEquals(Arrays.asList(Coin.NICKEL, Coin.DIME, Coin.QUARTER),
				Arrays.asList(values));

	}

	@Test
	public void testGetValues() throws Exception {
		assertEquals(.05, Coin.NICKEL.getMonetaryValue(), 0.0);
		assertEquals(.10, Coin.DIME.getMonetaryValue(), 0.0);
		assertEquals(.25, Coin.QUARTER.getMonetaryValue(), 0.0);
	}

	@Test
	public void testDetermineCoin() throws Exception {
		assertEquals(Coin.NICKEL, Coin.determineCoin(5, 21));
		assertEquals(Coin.DIME, Coin.determineCoin(2.2, 18));
		assertEquals(Coin.QUARTER, Coin.determineCoin(5.6, 24));
		assertEquals(null, Coin.determineCoin(15, 45));
	}
}

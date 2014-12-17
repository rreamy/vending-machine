package vendingMachine;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
		assertEquals(new BigDecimal(.05).setScale(2, RoundingMode.DOWN),
				Coin.NICKEL.getMonetaryValue());
		assertEquals(new BigDecimal(.10).setScale(2, RoundingMode.DOWN),
				Coin.DIME.getMonetaryValue());
		assertEquals(new BigDecimal(.25).setScale(2, RoundingMode.DOWN),
				Coin.QUARTER.getMonetaryValue());
	}

	@Test
	public void testDetermineCoin() throws Exception {
		assertEquals(Coin.NICKEL, Coin.determineCoin(5, 21));
		assertEquals(Coin.DIME, Coin.determineCoin(2.2, 18));
		assertEquals(Coin.QUARTER, Coin.determineCoin(5.6, 24));
		assertEquals(null, Coin.determineCoin(15, 45));
	}

	@Test
	public void testGetWeightInGrams() throws Exception {
		assertEquals(5, Coin.NICKEL.getWeightInGrams(), 0);
		assertEquals(2.2, Coin.DIME.getWeightInGrams(), 0);
		assertEquals(5.6, Coin.QUARTER.getWeightInGrams(), 0);
	}

	@Test
	public void testGetDiameterInMillimeters() throws Exception {
		assertEquals(21, Coin.NICKEL.getDiameterInMillimeters());
		assertEquals(18, Coin.DIME.getDiameterInMillimeters());
		assertEquals(24, Coin.QUARTER.getDiameterInMillimeters());
	}
}

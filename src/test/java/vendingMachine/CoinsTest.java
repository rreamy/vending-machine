package vendingMachine;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoinsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValues() {
		assertEquals(3, Coins.values().length);
		Coins[] values = Coins.values();
		assertEquals(Arrays.asList(Coins.NICKEL, Coins.DIME, Coins.QUARTER),
				Arrays.asList(values));

	}

	@Test
	public void testGetValues() throws Exception {
		assertEquals(.05, Coins.NICKEL.getValue(), 0.0);
		assertEquals(.10, Coins.DIME.getValue(), 0.0);
		assertEquals(.25, Coins.QUARTER.getValue(), 0.0);
	}
}

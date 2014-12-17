package vendingMachine;

import org.junit.After;
import org.junit.Before;

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

}

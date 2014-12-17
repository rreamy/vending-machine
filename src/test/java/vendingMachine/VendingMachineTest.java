package vendingMachine;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class VendingMachineTest {

	private VendingMachine vendingMachine;
	@Mock
	private Display display;
	@Mock
	private BufferedReader input;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		vendingMachine = new VendingMachine();
	}

	@After
	public void tearDown() throws Exception {
		vendingMachine = null;
	}

	@Test
	public void testHandleCoins_validCoin() throws Exception {
		when(input.readLine()).thenReturn("5", "21");
		when(display.enterWeightMessage()).thenReturn("enter weight");
		when(display.enterDiameterMessage()).thenReturn("enter diameter:");

		vendingMachine.handleCoins(input, display);

		verify(display, times(1)).enterDiameterMessage();
		verify(display, times(1)).enterWeightMessage();
		verify(display, times(1)).displayTotal(any(BigDecimal.class));
	}

	@Test
	public void testHandleCoins_invalidCoin() throws Exception {
		when(input.readLine()).thenReturn("555", "215");
		when(display.enterWeightMessage()).thenReturn("enter weight");
		when(display.enterDiameterMessage()).thenReturn("enter diameter:");

		vendingMachine.handleCoins(input, display);

		verify(display, times(1)).enterDiameterMessage();
		verify(display, times(1)).enterWeightMessage();
		verify(display, times(1)).displayTotal(any(BigDecimal.class));
		verify(display, times(1)).coinReturnedMessage();
	}

	@Test
	public void testHandleCoins_invalidWeightFirstTime() throws Exception {
		when(input.readLine()).thenReturn("aa5", "5", "21");
		when(display.enterWeightMessage()).thenReturn("enter weight",
				"enter weight");
		when(display.enterDiameterMessage()).thenReturn("enter diameter:");

		vendingMachine.handleCoins(input, display);

		verify(display, times(1)).enterDiameterMessage();
		verify(display, times(2)).enterWeightMessage();
		verify(display, times(2)).displayTotal(any(BigDecimal.class));
		verify(display, times(1)).invalidCoinInformationMessage();
	}

	@Test
	public void testHandleCoins_invalidDiameterFirstTime() throws Exception {
		when(input.readLine()).thenReturn("5", "3h", "5", "21");
		when(display.enterWeightMessage()).thenReturn("enter weight",
				"enter weight");
		when(display.enterDiameterMessage()).thenReturn("enter diameter:",
				"enter diameter:");

		vendingMachine.handleCoins(input, display);

		verify(display, times(2)).enterDiameterMessage();
		verify(display, times(2)).enterWeightMessage();
		verify(display, times(2)).displayTotal(any(BigDecimal.class));
		verify(display, times(1)).invalidCoinInformationMessage();
	}
}

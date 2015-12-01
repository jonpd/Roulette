package roulette.impl;

import roulette.impl.Wheel;
import org.junit.Before;
import org.junit.Test;
import roulette.IPocket;
import static org.junit.Assert.*;
import roulette.impl.Pocket;

public class WheelTest {

	private int pockets = 37;
	private Wheel wheel;

	@Before
	public void setUp() {

		wheel = new Wheel(pockets);
	}

	@Test
	public void testSpin() {

		IPocket result = wheel.spin();
		assertNotNull(result);
	}

	@Test
	public void testIsValidPocket_Valid() {

		IPocket pocket = new Pocket("15");
		boolean result = wheel.isValidPocket(pocket);

		assertTrue(result);
	}

	@Test
	public void testIsValidPocket_Invalid() {

		String invalidPocketValue = String.valueOf(pockets + 2);
		IPocket pocket = new Pocket(invalidPocketValue);
		boolean result = wheel.isValidPocket(pocket);

		assertFalse(result);
	}
}

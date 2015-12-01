package roulette.impl;

import org.junit.Before;
import org.junit.Test;
import roulette.impl.Pocket;
import static org.junit.Assert.*;

public class PocketTest {

	@Before
	public void setUp() {
	}

	@Test
	public void testGetValue() {

		String value = "13";
		Pocket instance = new Pocket(value);

		String result = instance.getValue();
		assertEquals(value, result);
	}

	@Test
	public void testIsEven_Even() {

		String value = "10";
		Pocket instance = new Pocket(value);

		boolean result = instance.isEven();
		assertTrue(result);
	}

	@Test
	public void testIsEven_Odd() {

		String value = "11";
		Pocket instance = new Pocket(value);

		boolean result = instance.isEven();
		assertFalse(result);
	}

	@Test
	public void testIsEven_HouseSpecial() {

		String value = "00";
		Pocket instance = new Pocket(value);

		boolean result = instance.isEven();
		assertTrue(result);
	}

	@Test
	public void testIsOdd_Odd() {

		String value = "11";
		Pocket instance = new Pocket(value);

		boolean result = instance.isOdd();
		assertTrue(result);
	}

	@Test
	public void testIsOdd_Even() {

		String value = "14";
		Pocket instance = new Pocket(value);

		boolean result = instance.isOdd();
		assertFalse(result);
	}

	@Test
	public void testIsOdd_HouseSpecial() {

		String value = "00";
		Pocket instance = new Pocket(value);

		boolean result = instance.isOdd();
		assertFalse(result);
	}
}

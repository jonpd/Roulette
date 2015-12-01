package roulette.impl;

import roulette.impl.Bet;
import org.junit.Before;
import org.junit.Test;
import roulette.IBet;
import roulette.IPocket;
import static org.junit.Assert.*;
import roulette.impl.BetType;
import roulette.impl.Pocket;

public class BetTest {

	private IBet bet;

	@Before
	public void setUp() {

	}

	@Test
	public void testGetValue() {

		int betValue = 10;
		IPocket pocket = new Pocket("25");
		bet = new Bet(10, pocket, BetType.ODD);
		int result = bet.getValue();
		assertEquals(betValue, result);
	}

	@Test
	public void testGetPocket() {

		IPocket pocket = new Pocket("25");
		bet = new Bet(10, pocket, BetType.ODD);
		IPocket result = bet.getPocket();
		assertEquals(pocket, result);
	}

}

package roulette.impl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import roulette.IBet;
import roulette.IBetJudge;
import roulette.IPocket;

public class BetJudgeTest {

	@Before
	public void setUp() {
	}

	@Test
	public void testGetInstance() {

		assertNotNull(BetJudge.getInstance());
	}

	@Test
	public void testIsWinner_WinningPocket() {

		IBet bet = new Bet(10, new Pocket("26"), BetType.POCKET);
		IPocket landedPocket = new Pocket("26");

		boolean result = BetJudge.getInstance().isWinner(bet, landedPocket);
		assertTrue(result);
	}

	@Test
	public void testIsWinner_WinningPocket_HouseSpecial() {

		IBet bet = new Bet(10, new Pocket("00"), BetType.POCKET);
		IPocket landedPocket = new Pocket("00");

		boolean result = BetJudge.getInstance().isWinner(bet, landedPocket);
		assertTrue(result);
	}

	@Test
	public void testIsWinner_LosingPocket() {

		IBet bet = new Bet(10, new Pocket("26"), BetType.POCKET);
		IPocket landedPocket = new Pocket("31");

		boolean result = BetJudge.getInstance().isWinner(bet, landedPocket);
		assertFalse(result);
	}

	@Test
	public void testIsWinner_EvenTrue() {

		IBet bet = new Bet(10, new Pocket("26"), BetType.EVEN);
		IPocket landedPocket = new Pocket("26");

		boolean result = BetJudge.getInstance().isWinner(bet, landedPocket);
		assertTrue(result);
	}

	@Test
	public void testIsWinner_EvenFalse() {

		IBet bet = new Bet(10, new Pocket("26"), BetType.EVEN);
		IPocket landedPocket = new Pocket("23");

		boolean result = BetJudge.getInstance().isWinner(bet, landedPocket);
		assertFalse(result);
	}

	@Test
	public void testIsWinner_OddTrue() {

		IBet bet = new Bet(10, new Pocket("13"), BetType.ODD);
		IPocket landedPocket = new Pocket("13");

		boolean result = BetJudge.getInstance().isWinner(bet, landedPocket);
		assertTrue(result);
	}

	@Test
	public void testIsWinner_OddFalse() {

		IBet bet = new Bet(10, new Pocket("13"), BetType.ODD);
		IPocket landedPocket = new Pocket("12");

		boolean result = BetJudge.getInstance().isWinner(bet, landedPocket);
		assertFalse(result);
	}

	@Test
	public void testIsWinner_OddOrEven() {

		IBet bet = new Bet(10, new Pocket("13"), BetType.ODD_OR_EVEN);
		IPocket landedPocket = new Pocket("12");

		boolean result = BetJudge.getInstance().isWinner(bet, landedPocket);
		assertTrue(result);
	}

	@Test
	public void testIsWinner_OddOrEven_HouseSpecial() {

		IBet bet = new Bet(10, new Pocket("13"), BetType.ODD_OR_EVEN);
		IPocket landedPocket = new Pocket("00");

		boolean result = BetJudge.getInstance().isWinner(bet, landedPocket);
		assertTrue(result);
	}
}

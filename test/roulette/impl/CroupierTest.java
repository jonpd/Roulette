package roulette.impl;

import org.junit.Before;
import org.junit.Test;
import roulette.IBet;
import roulette.ICroupier;
import roulette.ICustomer;
import roulette.IPocket;
import roulette.IWheel;
import static org.junit.Assert.*;
import roulette.impl.Bet;
import roulette.impl.BetType;
import roulette.impl.Croupier;
import roulette.impl.Customer;
import roulette.impl.Pocket;
import roulette.impl.RouletteGameException;
import roulette.mock.MockWheel;

public class CroupierTest {

	private final int pockets = 37;

	@Before
	public void setUp() {

	}

	// STAGE 1 (a)
	@Test
	public void testPlay_LosingPocket() {

		int winningPocket = 32;
		IWheel wheel = new MockWheel(winningPocket, pockets);
		ICroupier croupier = new Croupier(wheel);

		int startingBalance = 25;
		IPocket chosenPocket = new Pocket("26");
		int betValue = 10;
		ICustomer customer = new Customer(startingBalance);
		IBet bet = new Bet(betValue, chosenPocket, BetType.POCKET);
		customer.placeBet(bet);

		try {

			croupier.play(customer, bet);
			assertTrue(customer.getBalance() == startingBalance - betValue);
		}
		catch (RouletteGameException ex) {

			fail();
		}
	}

	// STAGE 1 (b)
	@Test
	public void testPlay_WinningPocket() {

		int winningPocket = 32;
		IWheel wheel = new MockWheel(winningPocket, pockets);
		ICroupier croupier = new Croupier(wheel);

		int startingBalance = 25;
		IPocket chosenPocket = new Pocket(String.valueOf(winningPocket));
		int betValue = 10;
		ICustomer customer = new Customer(startingBalance);
		IBet bet = new Bet(betValue, chosenPocket, BetType.POCKET);
		customer.placeBet(bet);

		try {

			croupier.play(customer, bet);
			assertTrue(customer.getBalance() == startingBalance + Croupier.WINNINGS_POCKET);
		}
		catch (RouletteGameException ex) {

			fail();
		}
	}

	// STAGE 2 (a)
	@Test(expected = RouletteGameException.class)
	public void testPlay_BetValueLessThan1() throws RouletteGameException {

		int winningPocket = 32;
		IWheel wheel = new MockWheel(winningPocket, pockets);
		ICroupier croupier = new Croupier(wheel);

		int startingBalance = 25;
		IPocket chosenPocket = new Pocket(String.valueOf(winningPocket));
		int betValue = -1;
		ICustomer customer = new Customer(startingBalance);
		IBet bet = new Bet(betValue, chosenPocket, BetType.POCKET);
		customer.placeBet(bet);

		croupier.play(customer, bet);
	}

	// STAGE 2 (b)
	@Test(expected = RouletteGameException.class)
	public void testPlay_InvalidPocket() throws RouletteGameException {

		int winningPocket = 32;
		IWheel wheel = new MockWheel(winningPocket, pockets);
		ICroupier croupier = new Croupier(wheel);

		int startingBalance = 25;
		int invalidPocketValue = pockets + 3;
		IPocket chosenPocket = new Pocket(String.valueOf(invalidPocketValue));
		int betValue = 10;
		ICustomer customer = new Customer(startingBalance);
		IBet bet = new Bet(betValue, chosenPocket, BetType.POCKET);
		customer.placeBet(bet);

		croupier.play(customer, bet);
	}

	// STAGE 3 (a)
	@Test
	public void testPlay_OddOrEvenBetFor10_Pocket0() throws RouletteGameException {

		int landedPocket = 0;
		IWheel wheel = new MockWheel(landedPocket, pockets);
		ICroupier croupier = new Croupier(wheel);

		int startingBalance = 25;
		IPocket chosenPocket = new Pocket("0");
		int betValue = 10;
		ICustomer customer = new Customer(startingBalance);
		IBet bet = new Bet(betValue, chosenPocket, BetType.ODD_OR_EVEN);
		customer.placeBet(bet);

		croupier.play(customer, bet);

		assertTrue(customer.getBalance() == startingBalance - betValue);
	}

	// STAGE 3 (b)
	@Test
	public void testPlay_EvenBetFor10_EvenPocket() throws RouletteGameException {

		int landedPocket = 12;
		IWheel wheel = new MockWheel(landedPocket, pockets);
		ICroupier croupier = new Croupier(wheel);

		int startingBalance = 25;
		IPocket chosenPocket = new Pocket("0");
		int betValue = 10;
		ICustomer customer = new Customer(startingBalance);
		IBet bet = new Bet(betValue, chosenPocket, BetType.EVEN);
		customer.placeBet(bet);

		croupier.play(customer, bet);

		assertTrue(customer.getBalance() == startingBalance + Croupier.WINNINGS_ODD_EVEN);
	}

	// STAGE 3 (c)
	@Test
	public void testPlay_EvenBetFor10_OddPocket() throws RouletteGameException {

		int landedPocket = 11;
		IWheel wheel = new MockWheel(landedPocket, pockets);
		ICroupier croupier = new Croupier(wheel);

		int startingBalance = 25;
		IPocket chosenPocket = new Pocket("0");
		int betValue = 10;
		ICustomer customer = new Customer(startingBalance);
		IBet bet = new Bet(betValue, chosenPocket, BetType.EVEN);
		customer.placeBet(bet);

		croupier.play(customer, bet);

		assertTrue(customer.getBalance() == startingBalance - bet.getValue());
	}

	// STAGE 3 (d)
	@Test
	public void testPlay_OddBetFor10_EvenPocket() throws RouletteGameException {

		int landedPocket = 14;
		IWheel wheel = new MockWheel(landedPocket, pockets);
		ICroupier croupier = new Croupier(wheel);

		int startingBalance = 25;
		IPocket chosenPocket = new Pocket("0");
		int betValue = 10;
		ICustomer customer = new Customer(startingBalance);
		IBet bet = new Bet(betValue, chosenPocket, BetType.ODD);
		customer.placeBet(bet);

		croupier.play(customer, bet);

		assertTrue(customer.getBalance() == startingBalance - bet.getValue());
	}

	// STAGE 3 (e)
	@Test
	public void testPlay_OddBetFor10_OddPocket() throws RouletteGameException {

		int landedPocket = 13;
		IWheel wheel = new MockWheel(landedPocket, pockets);
		ICroupier croupier = new Croupier(wheel);

		int startingBalance = 25;
		IPocket chosenPocket = new Pocket("0");
		int betValue = 10;
		ICustomer customer = new Customer(startingBalance);
		IBet bet = new Bet(betValue, chosenPocket, BetType.ODD);
		customer.placeBet(bet);

		croupier.play(customer, bet);

		assertTrue(customer.getBalance() == startingBalance + Croupier.WINNINGS_ODD_EVEN);
	}
}

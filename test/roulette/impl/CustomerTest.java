package roulette.impl;

import roulette.impl.Customer;
import roulette.impl.Bet;
import org.junit.Before;
import org.junit.Test;
import roulette.IBet;
import roulette.IPocket;
import static org.junit.Assert.*;
import roulette.impl.BetType;
import roulette.impl.Pocket;

public class CustomerTest {

	@Before
	public void setUp() {

	}

	@Test
	public void testPlaceBet() {

		int startingBalance = 15;
		int betValue = 10;
		IPocket chosenPocket = new Pocket("25");

		Customer customer = new Customer(startingBalance);
		IBet bet = new Bet(betValue, chosenPocket, BetType.EVEN);
		customer.placeBet(bet);

		assertTrue(customer.getBalance() == startingBalance - betValue);
	}

	@Test
	public void testAddWinnings() {

		int startBalance = 25;
		int winnings = 56;

		Customer customer = new Customer(startBalance);
		customer.addWinnings(winnings);

		assertEquals(startBalance + winnings, customer.getBalance());
	}

}

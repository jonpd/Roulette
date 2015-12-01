package roulette.game;

import java.util.Random;
import roulette.IBet;
import roulette.ICroupier;
import roulette.ICustomer;
import roulette.IPocket;
import roulette.IWheel;
import roulette.impl.Bet;
import roulette.impl.BetType;
import roulette.impl.Croupier;
import roulette.impl.Customer;
import roulette.impl.Pocket;
import roulette.impl.RouletteGameException;
import roulette.impl.Wheel;

public class PlayGame {

	public static void main(String[] args) {

		IWheel wheel = new Wheel(37);
		ICroupier croupier = new Croupier(wheel);

		ICustomer customer = new Customer(50);
		Random random = new Random();
		int randomPocketValue = random.nextInt(wheel.getPockets().size());
		IPocket chosenPocket = new Pocket(String.valueOf(randomPocketValue));
		IBet bet = new Bet(10, chosenPocket, BetType.POCKET);
		customer.placeBet(bet);

		try {

			croupier.play(customer, bet);
		}
		catch (RouletteGameException ex) {


		}
	}
}

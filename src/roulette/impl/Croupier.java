package roulette.impl;

import roulette.ICroupier;
import roulette.IBet;
import roulette.IBetJudge;
import roulette.ICustomer;
import roulette.IPocket;
import roulette.IWheel;

public class Croupier implements ICroupier {

	private final IWheel wheel;
	public static final int WINNINGS_POCKET = 360;
	public static final int WINNINGS_ODD_EVEN = 20;

	public Croupier(IWheel wheel) {

		this.wheel = wheel;
	}

	@Override
	public void play(ICustomer customer, IBet bet) throws RouletteGameException {

		System.out.println(bet.toString());

		if (bet.getValue() <= 0) {

			throw new RouletteGameException("Bet has insufficient value");
		}
		else if (!wheel.isValidPocket(bet.getPocket())) {

			throw new RouletteGameException("Bet pocket was not valid");
		}
		else {

			IPocket pocketLanded = wheel.spin();
			System.out.println("Pocket landed: " + pocketLanded.toString());

			if (BetJudge.getInstance().isWinner(bet, pocketLanded)) {

				System.out.println("Customer wins!");

				// customer won
				BetType betType = bet.getBetType();

				switch (betType) {

					case POCKET: {

						customer.addWinnings(Croupier.WINNINGS_POCKET + bet.getValue());
						break;
					}
					case EVEN: {

						customer.addWinnings(Croupier.WINNINGS_ODD_EVEN + bet.getValue());
						break;
					}
					case ODD: {

						customer.addWinnings(Croupier.WINNINGS_ODD_EVEN + bet.getValue());
						break;
					}
					case ODD_OR_EVEN: {

						// no winnings
						break;
					}
				}
			}
			else {

				System.out.println("Customer loses");
			}
		}
	}
}

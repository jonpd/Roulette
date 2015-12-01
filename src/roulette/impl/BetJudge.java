package roulette.impl;

import roulette.IBet;
import roulette.IBetJudge;
import roulette.IPocket;

public class BetJudge implements IBetJudge {

	private static IBetJudge instance;

	private BetJudge() {


	}

	public static IBetJudge getInstance() {

		if (instance == null) {

			instance = new BetJudge();
		}

		return instance;
	}

	@Override
	public boolean isWinner(IBet bet, IPocket landedPocket) {

		boolean isWinner = false;

		switch (bet.getBetType()) {

			case POCKET: {

				isWinner = landedPocket.equals(bet.getPocket());
				break;
			}
			case EVEN: {

				isWinner = landedPocket.isEven();
				break;
			}
			case ODD: {

				isWinner = landedPocket.isOdd();
				break;
			}
			case ODD_OR_EVEN: {

				isWinner = landedPocket.isEven() || landedPocket.isOdd();
				break;
			}
		}

		return isWinner;
	}
}

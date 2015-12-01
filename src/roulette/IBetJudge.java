package roulette;

import roulette.impl.Pocket;

public interface IBetJudge {

	boolean isWinner(IBet bet, IPocket landedPocket);
}

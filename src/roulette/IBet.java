package roulette;

import roulette.impl.BetType;
import roulette.impl.Pocket;

public interface IBet {

	IPocket getPocket();
	int getValue();
	BetType getBetType();
}

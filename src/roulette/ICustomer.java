package roulette;

import roulette.impl.Bet;
import roulette.impl.BetType;

public interface ICustomer {

	void placeBet(IBet bet);
	void addWinnings(int winnings);
	int getBalance();
}

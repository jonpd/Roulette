package roulette;

import roulette.impl.Customer;
import roulette.impl.RouletteGameException;

public interface ICroupier {

	void play(ICustomer customer, IBet bet) throws RouletteGameException;
}

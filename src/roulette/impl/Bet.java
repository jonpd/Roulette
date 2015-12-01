package roulette.impl;

import roulette.IBet;
import roulette.IPocket;

public class Bet implements IBet {

	private int value;
	private IPocket pocket;
	private BetType betType;

	public Bet(int value, IPocket pocket, BetType betType) {

		this.value = value;
		this.pocket = pocket;
		this.betType = betType;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public IPocket getPocket() {
		return pocket;
	}

	@Override
	public BetType getBetType() {

		return betType;
	}

	@Override
	public String toString() {
		return "Bet: " + "value = " + value + ", pocket = " + pocket.toString() + ", betType = " + betType;
	}
}
